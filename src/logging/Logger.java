package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
public class Logger {
    private static final String LOG_FILE = "resources/logs.txt";
    public static void log(String message) {
        String timeStampedMessage = LocalDateTime.now() + ": " + message;
        System.out.println(timeStampedMessage);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(timeStampedMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logTicketOperation(String operation, String ticketId){
        String message = String.format("Ticket Id: %s,  Operation: %s", ticketId, operation);
        System.out.println(message);
        log(message);
    }
}
