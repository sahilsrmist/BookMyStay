import java.util.*;
/**
 * ====================================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ====================================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class demonstrates how optional
 * services can be attached to a confirmed
 * booking.
 *
 * Services are added after room allocation
 * and do not affect inventory.
 *
 * @version 7.0
 */
public class BookMyStay {
    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection\n");

        // 1. Initialize the Service Manager
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // 2. Define available Add-On Services
        AddOnService breakfast = new AddOnService("Breakfast Buffet", 500.0);
        AddOnService spa = new AddOnService("Spa Treatment", 1500.0);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 1000.0);

        // 3. Simulate a confirmed reservation ID (e.g., from UC6)
        String reservationId = "Single-1"; // Assume this was assigned to "Abhi" in UC6

        // 4. Attach services to the reservation
        System.out.println("Attaching services to " + reservationId + ":");
        serviceManager.addService(reservationId, breakfast);
        serviceManager.addService(reservationId, airportPickup);

        // 5. Calculate and display the total cost of add-ons
        double totalAddOnCost = serviceManager.calculateTotalServiceCost(reservationId);
        System.out.println("\nTotal Add-On Cost for " + reservationId + ": " + totalAddOnCost);
    }
}
