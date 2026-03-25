import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ====================================================================
 * CLASS - RoomAllocationService
 * ====================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class is responsible for confirming
 * booking requests and assigning rooms.
 *
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @version 6.0
 */
public class RoomAllocationService {

    /**
     * Stores all allocated room IDs to
     * prevent duplicate assignments.
     */
    private Set<String> allocatedRoomIds;

    /**
     * Stores assigned room IDs by room type.
     *
     * Key   -> Room type
     * Value -> Set of assigned room IDs
     */
    private Map<String, Set<String>> assignedRoomsByType;

    /**
     * Initializes allocation tracking structures.
     */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning
     * a unique room ID and updating inventory.
     *
     * @param reservation booking request
     * @param inventory   centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();

        // 1. Check if the requested room type has availability
        if (currentAvailability.get(roomType) != null && currentAvailability.get(roomType) > 0) {

            // 2. Generate a unique Room ID
            String roomId = generateRoomId(roomType);

            // 3. Store the allocated ID to prevent double-booking
            allocatedRoomIds.add(roomId);

            // 4. Track the assignment by room type
            assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
            assignedRoomsByType.get(roomType).add(roomId);

            // 5. Decrement inventory safely
            int newCount = currentAvailability.get(roomType) - 1;
            inventory.updateAvailability(roomType, newCount);

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                    ", Room ID: " + roomId);
        } else {
            System.out.println("Sorry, " + reservation.getGuestName() +
                    ". No " + roomType + " rooms available.");
        }
    }

    /**
     * Generates a unique room ID
     * for the given room type.
     * * Note: In a real system, this might use UUIDs or query a DB.
     * Here, we use the size of the set to create sequential IDs.
     *
     * @param roomType type of room
     * @return unique room ID
     */
    private String generateRoomId(String roomType) {
        // Calculate the next ID number based on how many have been assigned
        int nextIdNumber = 1;
        if (assignedRoomsByType.containsKey(roomType)) {
            nextIdNumber = asssignedRoomsByType.get(roomType).size() + 1;
        }
        return roomType + "-" + nextIdNumber;
    }
}