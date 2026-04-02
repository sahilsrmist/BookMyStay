import java.util.*;
import java.util.Scanner;

/**
 * ====================================================================
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * ====================================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class demonstrates how user input
 * is validated before booking is processed.
 *
 * The system:
 * - Accepts user input
 * - Validates input centrally
 * - Handles errors gracefully
 *
 * @version 9.0
 */
public class BookMyStay {
    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Display application header
        System.out.println("Booking Validation\n");

        Scanner scanner = new Scanner(System.in);

        // Initialize required components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            // Accept user input
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validate the input using fail-fast design
            validator.validate(guestName, roomType, inventory);

            // If validation passes, create request and queue it
            Reservation request = new Reservation(guestName, roomType);
            bookingQueue.addRequest(request);

            System.out.println("Booking requested successfully.");

        } catch (InvalidBookingException e) {
            // Handle domain-specific validation errors gracefully
            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            // Always clean up resources
            scanner.close();
        }
    }
}
