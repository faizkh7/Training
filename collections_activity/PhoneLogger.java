import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PhoneLogger {
    private ArrayList<PhoneLog> logs = new ArrayList<>();

    public void saveLog(PhoneLog log) {
        logs.add(log);
    }

    public void printLogs() {
        System.out.println("\nPhone Logs:");
        for (PhoneLog log : logs) {
            System.out.println(log);
        }
    }
}

// PhoneLog class inside same file
class PhoneLog {
    private Contact contact;
    private String logType;
    private LocalDateTime time;

    public PhoneLog(Contact contact, String logType, LocalDateTime time) {
        this.contact = contact;
        this.logType = logType;
        this.time = time;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        return logType + " call from " + contact.getName() +
                " (" + contact.getPhoneNumber() + ") at " + time.format(formatter);
    }
}
