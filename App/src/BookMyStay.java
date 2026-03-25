import java.util.*;
/**
 * ====================================================================
 * MAIN CLASS - UseCase6RoomAllocation
 * ====================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * It consumes booking requests in FIFO
 * order and updates inventory immediately.
 *
 * @version 6.0
 */
public class BookMyStay {
    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing\n");

        // 1. Initialize System State (Inventory & Allocation Service)
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // 2. Initialize Queue and simulate incoming requests
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Note: Based on the screenshot output, Subha changed from Double to Single
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // 3. Process the queue (FIFO) and allocate rooms safely
        while (bookingQueue.hasPendingRequests()) {
            Reservation currentRequest = bookingQueue.getNextRequest();

            // Atomic logical operation: Allocate and update inventory together
            allocationService.allocateRoom(currentRequest, inventory);
        }

        // Optional: Prove the inventory was decremented
        // System.out.println("\nRemaining Single Rooms: " + inventory.getRoomAvailability().get("Single"));
    }
}
