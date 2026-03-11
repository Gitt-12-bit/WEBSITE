import java.util.ArrayList;

public class Student extends User {
    private String studentNumber;
    private ArrayList<Booking> bookings;

    public Student(int userId, String name, String email, String password, String studentNumber) {
        super(userId, name, email, password);
        this.studentNumber = studentNumber;
        this.bookings = new ArrayList<>();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println(name + " has no bookings.");
            return;
        }

        System.out.println("Bookings for " + name + ":");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}