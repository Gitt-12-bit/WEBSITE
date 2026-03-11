public class BookingService {
    private NotificationService notificationService;
    private int bookingCounter;

    public BookingService() {
        this.notificationService = new NotificationService();
        this.bookingCounter = 1;
    }

    public boolean checkConflict(Student student, SessionSlot slot) {
        for (Booking booking : student.getBookings()) {
            SessionSlot bookedSlot = booking.getSlot();

            boolean sameDate = bookedSlot.getDate().equals(slot.getDate());

            boolean timeOverlap =
                    slot.getStartTime().isBefore(bookedSlot.getEndTime()) &&
                    slot.getEndTime().isAfter(bookedSlot.getStartTime());

            if (sameDate && timeOverlap && booking.getStatus().equals("CONFIRMED")) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyAvailability(SessionSlot slot) {
        return slot.isAvailable();
    }

    public Booking bookSession(Student student, SessionSlot slot) {
        if (!student.isLoggedIn()) {
            notificationService.sendBookingFailure(student, "Student must be logged in.");
            return null;
        }

        if (checkConflict(student, slot)) {
            notificationService.sendBookingFailure(student, "Schedule conflict detected.");
            return null;
        }

        if (!verifyAvailability(slot)) {
            notificationService.sendBookingFailure(student, "Selected slot is unavailable.");
            return null;
        }

        Booking booking = new Booking(
                bookingCounter++,
                student,
                slot.getTutor(),
                slot,
                "CONFIRMED"
        );

        slot.markUnavailable();
        student.addBooking(booking);
        notificationService.sendBookingConfirmation(student, booking);

        return booking;
    }
}