/**
 * Sends the message as an SMS notification.
 * Implements the interface NotificationMedium, displaying a message to the user
 * that their notification is sent via SMS.
 * @author Whit
 * @version 1.0
 */
public class SMSService implements NotificationMedium {

    /**
     * Overrides the send(String message) method implemented from the
     * NotificationMedium interface to tell the user the message is sent as an
     * SMS notification.
     * @param message the message sent via SMS.
     */
    @Override
    public void send(String message) {
        System.out.println("SMS notification: " + message);
    }
}
