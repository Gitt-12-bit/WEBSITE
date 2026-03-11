public class Booking {
    private int bookingId;
    private Student student;
    private Tutor tutor;
    private SessionSlot slot;
    private String status;

    public Booking(int bookingId, Student student, Tutor tutor, SessionSlot slot, String status) {
        this.bookingId = bookingId;
        this.student = student;
        this.tutor = tutor;
        this.slot = slot;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Student getStudent() {
        return student;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public SessionSlot getSlot() {
        return slot;
    }

    public String getStatus() {
        return status;
    }

    public void confirmBooking() {
        status = "CONFIRMED";
    }

    public void cancelBooking() {
        status = "CANCELLED";
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
               ", Student: " + student.getName() +
               ", Tutor: " + tutor.getName() +
               ", Slot ID: " + slot.getSlotId() +
               ", Status: " + status;
    }
}