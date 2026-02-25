/**
 * Sends message as an email notification.
 * Implements the interface NotificationMedium, displaying a message to the user
 * that their notification is sent via email.
 * @author Whit
 * @version 1.0
 */
public class EmailService implements NotificationMedium {

    /**
     * Overrides the send(String message) method implemented from the
     * NotificationMedium interface to tell the user the message is sent as an
     * email notification.
     * 
     * @param message the message sent via email
     */
    @Override
    public void send(String message) {
        System.out.println("Email notification: " + message);
    }
}
