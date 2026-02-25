package app;

import services.*;
import java.util.ArrayList;

/**
 * An alert system that notifies the user with a message via a changeable
 * NotificationMedium interface.
 * Messages are saved in an ArrayList log.
 * @author Whit
 * @version 1.0
 */
public class AlertSystem {

    // has a NotificationMedium object as a field
    /** The current notification medium (email, SMS, etc.). */
    private NotificationMedium medium;

    // Use an ArrayList<String> within your AlertSystem to keep a "log" of all 
    // messages sent during that session.
    /** The log of sent messages. */
    private ArrayList<String> messageLog;

    /** Constructor.
     * Initializes medium as NULL and empty messageLog as ArrayList.  
     */
    public AlertSystem() {
        this.medium = null;
        this.messageLog = new ArrayList<String>();
    }

    /**
     * Sets the active notification medium.
     * @param medium the NotificationMedium to use for messages (email, SMS, etc.)
     */
    public void setMedium(NotificationMedium medium) {
        this.medium = medium;
    }

    /**
     * Calls the send(message) method of whichever medium is currently active 
     * and stores the message in the messageLog.
     * @param message the message to display for the user
     */
    public void notifyUser(String message) {
        medium.send(message);
        messageLog.add(message);
    }

    /** Returns the messageLog. 
     * @return an ArrayList of all sent messages as strings
    */
    public ArrayList<String> getMessageLog() {
        return messageLog;
    }

    /** Main method entry point for the alert system.
     * 
     * Compile and run from CLI: 
     *     javac AlertSystem.java
     *     java AlertSystem
     * 
     * GenAI DOCUMENTATION:
     * Query: "Write a main method in Java for the following alert system code.
     * Display examples for setting and changing the notification medium, and 
     * print the message log {copied and pasted interface and classes code}."
     * 
     * The code provided by the AI was structured well, creating some imaginary
     * examples of order confirmation and verification code messages. 
     * It also had a more detailed print string for the log, putting 
     * `(i+1) + "."` to number each message.
     * 
     * I removed some of the suggested messages, and simplified to one 
     * implementation of each medium, with messages that reflect what the 
     * program should be doing. I thought it was more interesting as a direct 
     * practical example, showing what exactly was being changed, and how the 
     * messages were added to the log.
     * 
     * @param args command line arguments, not used
     */
    public static void main(String[] args) {
        AlertSystem alertSystem = new AlertSystem();

        // email
        alertSystem.setMedium(new EmailService());
        alertSystem.notifyUser(
            "This EMAIL notification medium should be FIRST in the log.");

        // swap to SMS
        alertSystem.setMedium(new SMSService());
        alertSystem.notifyUser(
            "This SMS notification medium should be SECOND in the log.");

        // swap to WhatsApp
        alertSystem.setMedium(new WhatsAppService());
        alertSystem.notifyUser(
            "This WhatsApp notification medium should be THIRD in the log.");

        // print the messageLog
        System.out.println("Message Log: ");
        ArrayList<String> log = alertSystem.getMessageLog();
        for (int i = 0; i < log.size(); i++) {
            System.out.println((log.get(i)));
        }
    }
}
