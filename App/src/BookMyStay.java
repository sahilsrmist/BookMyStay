import java.util.*;
import java.util.Map;

/**
 * ====================================================================
 * MAIN CLASS - UseCase11ConcurrentBookingSimulation
 * ====================================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * This class simulates multiple users
 * attempting to book rooms at the same time.
 *
 * It highlights race conditions and
 * demonstrates how synchronization
 * prevents inconsistent allocations.
 *
 * @version 11.0
 */
public class BookMyStay {
    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Concurrent Booking Simulation");

        // Initialize shared resources
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Populate queue with concurrent requests
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Double"));
        bookingQueue.addRequest(new Reservation("Kural", "Suite"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));

        // Create booking processor tasks (passing the exact same shared objects)
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        // Start concurrent processing
        t1.start();
        t2.start();

        // Wait for both threads to finish before printing the final inventory
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Display remaining inventory after concurrent allocation
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + currentAvailability.get("Single"));
        System.out.println("Double: " + currentAvailability.get("Double"));
        System.out.println("Suite: " + currentAvailability.get("Suite"));
    }
}
