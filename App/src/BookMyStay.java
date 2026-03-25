/**
 * ====================================================================
 * MAIN CLASS - BookMyStay
 * ====================================================================
 *
 * Use Case 1: Application Entry & Welcome Message
 *
 * Description:
 * This class represents the entry point of the
 * Hotel Booking Management System.
 *
 * At this stage, the application:
 * - Starts execution from the main() method
 * - Displays a welcome message to the user
 * - Confirms that the system has started successfully
 *
 * No business logic, data structures, or user input
 * is implemented in this use case.
 *
 * The goal is to establish a clear and predictable
 * application startup point.
 *
 * @author Developer
 * @version 1.0
 */
public class BookMyStay {

    /**
     * Application entry point.
     *
     * This method is the first method executed
     * when the program is launched by the JVM.
     *
     * @param args Command-line arguments passed during execution
     */
    public static void main(String[] args) {
        // Linear Execution Flow: Top to bottom execution of statements

        // Using System.out.println() and String Literals for Console Output
        System.out.println("*************************************************");
        System.out.println("* *");
        System.out.println("* Welcome to BookMyStay!              *");
        System.out.println("* Hotel Booking Management System v1.0      *");
        System.out.println("* *");
        System.out.println("*************************************************");

        System.out.println("\nSystem started successfully. Ready for operations.");

        // Application terminates gracefully after the last statement
    }
}