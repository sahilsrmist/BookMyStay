import java.util.*;
import java.util.Map;

/**
 * ====================================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ====================================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class demonstrates how system state
 * can be restored after an application restart.
 *
 * Inventory data is loaded from a file
 * before any booking operations occur.
 *
 * @version 12.0
 */
public class BookMyStay {
    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("System Recovery");

        String filePath = "inventory_state.txt";

        // Initialize Inventory (Defaults to 5, 3, 2 internally based on UC3)
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        // 1. Attempt to load previous state from the file
        persistenceService.loadInventory(inventory, filePath);

        // 2. Display the current state (either fresh or restored)
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();
        System.out.println("Current Inventory:");
        System.out.println("Single: " + currentAvailability.get("Single"));
        System.out.println("Double: " + currentAvailability.get("Double"));
        System.out.println("Suite: " + currentAvailability.get("Suite"));

        // Simulate some app activity here... (e.g., booking a room)
        // inventory.updateAvailability("Single", 4);

        // 3. Save the state back to the file before application termination
        System.out.println("\nSaving system state...");
        persistenceService.saveInventory(inventory, filePath);
        System.out.println("Inventory saved successfully.");
    }
}
