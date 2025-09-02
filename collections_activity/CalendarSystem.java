import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;
import java.util.Comparator;

public class CalendarSystem {
    private TreeSet<Meeting> meetings;

    public CalendarSystem() {
        // Sorted automatically by meeting time
        meetings = new TreeSet<>(Comparator.comparing(Meeting::getTime));
    }

    public void addMeeting(Meeting meeting) {
        if (!meetings.add(meeting)) {
            System.out.println("A meeting already exists at this time: " + meeting);
        } else {
            System.out.println("Meeting added: " + meeting);
        }
    }

    public void printMeetings() {
        System.out.println("\nScheduled Meetings:");
        for (Meeting m : meetings) {
            System.out.println(m);
        }
    }
}

// Simple Meeting class
class Meeting {
    private Contact contact;
    private LocalDateTime time;

    public Meeting(Contact contact, LocalDateTime time) {
        this.contact = contact;
        this.time = time;
    }

    public LocalDateTime getTime() { return time; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        return "Meeting with " + contact.getName() + " (" + contact.getPhoneNumber() + ") at " + time.format(formatter);
    }
}
