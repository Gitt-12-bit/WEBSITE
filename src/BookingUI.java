import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class BookingUI {
    private Scanner scanner;
    private BookingService bookingService;

    public BookingUI() {
        scanner = new Scanner(System.in);
        bookingService = new BookingService();
    }

    public void start() {
        System.out.println("=== Tutoring Session Booking System ===");

        System.out.println("\nCreate Tutor");
        System.out.print("Enter tutor ID: ");
        int tutorId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter tutor name: ");
        String tutorName = scanner.nextLine();

        System.out.print("Enter tutor email: ");
        String tutorEmail = scanner.nextLine();

        System.out.print("Enter tutor password: ");
        String tutorPassword = scanner.nextLine();

        System.out.print("Enter tutor specialization: ");
        String specialization = scanner.nextLine();

        Tutor tutor = new Tutor(tutorId, tutorName, tutorEmail, tutorPassword, specialization);

        System.out.println("\nCreate Student");
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter student email: ");
        String studentEmail = scanner.nextLine();

        System.out.print("Enter student password: ");
        String studentPassword = scanner.nextLine();

        System.out.print("Enter student number: ");
        String studentNumber = scanner.nextLine();

        Student student = new Student(studentId, studentName, studentEmail, studentPassword, studentNumber);

        System.out.println("\nPublish Session Slot");
        System.out.print("Enter slot ID: ");
        int slotId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter session date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter start time (HH:MM): ");
        LocalTime startTime = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter end time (HH:MM): ");
        LocalTime endTime = LocalTime.parse(scanner.nextLine());

        SessionSlot slot = new SessionSlot(slotId, tutor, date, startTime, endTime);
        tutor.publishSlot(slot);

        System.out.println("\n=== Published Slots ===");
        tutor.viewPublishedSlots();

        System.out.println("\nStudent Login");
        System.out.print("Enter login email: ");
        String loginEmail = scanner.nextLine();

        System.out.print("Enter login password: ");
        String loginPassword = scanner.nextLine();

        boolean loginSuccess = student.login(loginEmail, loginPassword);

        if (loginSuccess) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
            return;
        }

        System.out.println("\nBook Session");
        System.out.println("Student selects the available slot and requests booking...");
        Booking booking = bookingService.bookSession(student, slot);

        if (booking != null) {
            System.out.println("\nBooking completed successfully.");
        } else {
            System.out.println("\nBooking was not completed.");
        }

        System.out.println("\n=== Student Bookings ===");
        student.viewBookings();

        System.out.println("\n=== Updated Slot List ===");
        tutor.viewPublishedSlots();
    }
}