/**
 * Establishes the notification delivery. 
 * Classes implementing this interface override the send(String message) method 
 * to display a relevant message.
 * @author Whit
 * @version 1.0
 */
public interface NotificationMedium {
    /**
     * Sends a notification message.
     * @param message the message to display for the user
     */
    void send(String message);
}
