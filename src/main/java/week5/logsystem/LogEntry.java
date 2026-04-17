package week5.logsystem;

public class LogEntry {
    String timestamp;
    String level;
    String message;

    public LogEntry(String timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    @Override
    public String toString() {
        return this.timestamp + " " + this.level + " " + this.message;
    }
}