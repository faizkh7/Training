import java.time.LocalDateTime;

public class MainApp {
    public static void main(String[] args) {
        // Initialize PhoneBook
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Faiz", "1234567890");
        phoneBook.addContact("Reza", "9876543210");
        phoneBook.addContact("Sahil", "1112223333");
        phoneBook.printContacts();

        // Initialize PhoneLogger
        PhoneLogger logger = new PhoneLogger();
        logger.saveLog(new PhoneLog(phoneBook.findContact("Faiz"), "Dialed", LocalDateTime.of(2025, 9, 10, 10, 0)));
        logger.saveLog(new PhoneLog(phoneBook.findContact("Reza"), "Missed", LocalDateTime.of(2025, 9, 10, 12, 30)));
        logger.printLogs();

        // Initialize CalendarSystem
        CalendarSystem calendar = new CalendarSystem();
        calendar.addMeeting(new Meeting(phoneBook.findContact("Faiz"), LocalDateTime.of(2025, 9, 11, 9, 0)));
        calendar.addMeeting(new Meeting(phoneBook.findContact("Sahil"), LocalDateTime.of(2025, 9, 11, 14, 30)));
        calendar.addMeeting(new Meeting(phoneBook.findContact("Faiz"), LocalDateTime.of(2025, 9, 11, 9, 0))); // duplicate test
        calendar.printMeetings();
    }
}
