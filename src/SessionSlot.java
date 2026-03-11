import java.time.LocalDate;
import java.time.LocalTime;

public class SessionSlot {
    private int slotId;
    private Tutor tutor;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean available;

    public SessionSlot(int slotId, Tutor tutor, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.slotId = slotId;
        this.tutor = tutor;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.available = true;
    }

    public int getSlotId() {
        return slotId;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }

    @Override
    public String toString() {
        return "Slot ID: " + slotId +
               ", Tutor: " + tutor.getName() +
               ", Date: " + date +
               ", Time: " + startTime + " - " + endTime +
               ", Available: " + available;
    }
}