import java.util.*;

/**
 * ====================================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ====================================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class demonstrates how guests
 * can view available rooms without
 * modifying inventory data.
 *
 * The system enforces read-only access
 * by design and usage discipline.
 *
 * @version 4.0
 */
public class BookMyStay {
    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Room Search\n");

        // 1. Initialize domain objects (from UC2)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // 2. Initialize centralized inventory (from UC3)
        RoomInventory inventory = new RoomInventory();

        // 3. Initialize the Search Service (UC4)
        RoomSearchService searchService = new RoomSearchService();

        // 4. Perform the read-only search operation
        searchService.searchAvailableRooms(inventory, singleRoom, doubleRoom, suiteRoom);
    }
}
