import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ====================================================================
 * CLASS - CancellationService
 * ====================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class is responsible for handling
 * booking cancellations.
 *
 * It ensures that:
 * - Cancelled room IDs are tracked
 * - Inventory is restored correctly
 * - Invalid cancellations are prevented
 *
 * A stack is used to model rollback behavior.
 *
 * @version 10.0
 */
public class CancellationService {

    /** * Stack that stores recently released room IDs. 
     * Follows LIFO (Last-In-First-Out) order. 
     */
    private Stack<String> releasedRoomIds;

    /** * Maps reservation ID to room type. 
     * Simulates a database lookup to know what to restore. 
     */
    private Map<String, String> reservationRoomTypeMap;

    /** Initializes cancellation tracking structures. */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking.
     *
     * This method simulates storing confirmation
     * data that will later be required for cancellation.
     *
     * @param reservationId confirmed reservation ID
     * @param roomType allocated room type
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels a confirmed booking and
     * restores inventory safely.
     *
     * @param reservationId reservation to cancel
     * @param inventory centralized room inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        // Validation: Ensure the booking actually exists
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation ID " + reservationId + " not found.");
            return;
        }

        // 1. Identify what needs to be rolled back
        String roomTypeToRestore = reservationRoomTypeMap.get(reservationId);

        // 2. Push the released Room ID onto the rollback stack
        releasedRoomIds.push(reservationId);

        // 3. Remove the record to prevent duplicate cancellations
        reservationRoomTypeMap.remove(reservationId);

        // 4. Restore Inventory State (Increment)
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();
        int restoredCount = currentAvailability.get(roomTypeToRestore) + 1;
        inventory.updateAvailability(roomTypeToRestore, restoredCount);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomTypeToRestore);
    }

    /**
     * Displays recently cancelled reservations.
     *
     * This method helps visualize rollback order.
     */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");

        if (releasedRoomIds.isEmpty()) {
            System.out.println("No recent cancellations.");
            return;
        }

        // Clone the stack to display it without emptying it
        Stack<String> tempStack = (Stack<String>) releasedRoomIds.clone();

        while (!tempStack.isEmpty()) {
            System.out.println("Released Reservation ID: " + tempStack.pop());
        }
    }
}