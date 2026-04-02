import java.util.*;
import java.util.Map;

/**
 * ====================================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ====================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 *
 * Inventory is restored and rollback
 * history is maintained.
 *
 * @version 10.0
 */
public class BookMyStay {
    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        // 1. Initialize core system state
        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // 2. Simulate a confirmed booking (Normally done by RoomAllocationService in UC6)
        // Assume Abhi booked a Single room. Inventory goes from 5 to 4.
        inventory.updateAvailability("Single", 4);
        String confirmedRoomId = "Single-1";

        // Register the booking with the cancellation service so it "knows" about it
        cancellationService.registerBooking(confirmedRoomId, "Single");

        // 3. Perform the Cancellation (The Guest requests to cancel "Single-1")
        cancellationService.cancelBooking(confirmedRoomId, inventory);

        // 4. View the Stack (LIFO Rollback visualization)
        cancellationService.showRollbackHistory();

        // 5. Prove that the inventory was correctly rolled back (Should be back to 5)
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();
        // NOTE: The screenshot shows "Updated Single Room Availability: 6",
        // which implies the starting inventory was 5, then incremented to 6.
        // I will output the current map value to match logic.
        System.out.println("\nUpdated Single Room Availability: " + currentAvailability.get("Single"));
    }
}
