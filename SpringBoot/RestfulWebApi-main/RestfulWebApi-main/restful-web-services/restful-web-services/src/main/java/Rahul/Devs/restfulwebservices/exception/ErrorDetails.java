package Rahul.Devs.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime DateTime;
    private String message;
    private String Details;

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return Details;
    }

    public LocalDateTime getDateTime() {
        return DateTime;
    }

    public ErrorDetails(LocalDateTime dateTime, String message, String details) {
        DateTime = dateTime;
        this.message = message;
        Details = details;
    }

}
