public class NotifcationService{

    public void sendBookingConfirmation(Student student, Booking booking) {
        System.out.println("Confirmation email sent to " + student.getEmail());
        System.out.println("Booking confirmed: " + booking);
    }

    public void sendBookingFailure(Student student, String message) {
        System.out.println("Booking failed for " + student.getEmail());
        System.out.println("Reason: " + message);
    }
}
