import java.util.ArrayList;

public class Tutor extends User {
    private String specialization;
    private ArrayList<SessionSlot> publishedSlots;

    public Tutor(int userId, String name, String email, String password, String specialization) {
        super(userId, name, email, password);
        this.specialization = specialization;
        this.publishedSlots = new ArrayList<>();
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<SessionSlot> getPublishedSlots() {
        return publishedSlots;
    }

    public void publishSlot(SessionSlot slot) {
        publishedSlots.add(slot);
    }

    public void viewPublishedSlots() {
        if (publishedSlots.isEmpty()) {
            System.out.println(name + " has no published slots.");
            return;
        }

        System.out.println("Published slots for Tutor " + name + ":");
        for (SessionSlot slot : publishedSlots) {
            System.out.println(slot);
        }
    }
}