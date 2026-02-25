/**
 * Gen AI prompt:
 * "Write a new WhatsAppService class that implements the NotificationMedium 
 * interface, based on the existing EmailService.java, including Javadocs."
 * I did not have to make any changes, it was a pretty straightforward, simple 
 * implementation.
 * 
 * Sends message as a WhatsApp notification.
 * Implements the interface NotificationMedium, displaying a message to the user
 * that their notification is sent via WhatsApp.
 * @author Whit
 * @version 1.0
 */
package services;

public class WhatsAppService implements NotificationMedium {

    /**
     * Overrides the send(String message) method implemented from the
     * NotificationMedium interface to tell the user the message is sent as a
     * WhatsApp notification.
     * 
     * @param message the message sent via WhatsApp
     */
    @Override
    public void send(String message) {
        System.out.println("[WhatsApp] Sending message: " + message);
    }
}
