import java.util.Map;

/**
 * ====================================================================
 * CLASS - ReservationValidator
 * ====================================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class is responsible for validating
 * booking requests before they are processed.
 *
 * All validation rules are centralized
 * to avoid duplication and inconsistency.
 *
 * @version 9.0
 */
public class ReservationValidator {

    /**
     * Validates booking input provided by the user.
     *
     * @param guestName name of the guest
     * @param roomType requested room type
     * @param inventory centralized inventory
     * @throws InvalidBookingException if validation fails
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        // Rule 1: Guest name cannot be empty
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        Map<String, Integer> availableRooms = inventory.getRoomAvailability();

        // Rule 2: Room type must exist in the system (Case-sensitive check based on UC3 setup)
        // Notice in the screenshot, user typed "single" instead of "Single", causing the failure.
        if (!availableRooms.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Rule 3: Room must have availability > 0
        if (availableRooms.get(roomType) <= 0) {
            throw new InvalidBookingException("No availability for the selected room type.");
        }
    }
}