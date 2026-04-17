package week5.logsystem;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2026-01-01 10:00:00 ERROR User123 failed login
//
//Structure details:
//
//    timestamp → yyyy-MM-dd HH:mm:ss
//    level → one of: INFO, WARNING, ERROR
//    message → free text
//        Contains username in the format: User[alphanumeric] like User123

public class Log {
    static void main(String[] args) throws IOException {
//        Path file = Path.of( "system.log");
        File file = new File("src/main/java/week5/logsystem/system.log");
        BufferedReader br = new BufferedReader(new FileReader(file));

        Pattern pattern = Pattern.compile("\\d{4}-(0[1-9]|1[0-2])-([012][0-9]|3[01])\\s[0-2][0-3]:[0-5][0-9]:[0-5][0-9]\\s(ERROR|INFO|WARNING)\\sUser\\w{3}\\s\\w+\\s?.+");

        Set<String> cleanLines = new HashSet<>();

        for (String line: br.readAllLines()) {
            Matcher matcher = pattern.matcher(line);
            while(matcher.find()) {
                cleanLines.add(matcher.group());
            }
        }

//        System.out.println(cleanLines);
//  \d{4}-(0[1-9]|1[0-2])-([012][0-9]|3[01])\s[0-2][0-3]:[0-5][0-9]:[0-5][0-9]
        Pattern timePattern = Pattern.compile("\\d{4}-(0[1-9]|1[0-2])-([012][0-9]|3[01])\\s[0-2][0-3]:[0-5][0-9]:[0-5][0-9]");
        Pattern levelPattern = Pattern.compile("ERROR|INFO|WARNING");
        Pattern messagePattern = Pattern.compile("User\\w{3}\\s\\w+\\s?.+");

        List<LogEntry> logEntries = new ArrayList<>();

        for (String line: cleanLines) {
            Matcher timeMatcher = timePattern.matcher(line);
            Matcher levelMatcher = levelPattern.matcher(line);
            Matcher messageMatcher = messagePattern.matcher(line);

            while(timeMatcher.find() & levelMatcher.find() & messageMatcher.find()) {
//                System.out.println(timeMatcher.group() + " " + levelMatcher.group() + " " + messageMatcher.group());
                logEntries.add(new LogEntry(timeMatcher.group(),levelMatcher.group(), messageMatcher.group()));
            }
        }

        System.out.println(logEntries);
    }
}
