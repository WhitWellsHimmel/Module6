package tests;

import app.AlertSystem;
import services.EmailService;
import services.SMSService;
import services.WhatsAppService;

/**
 * Coded with GenAI, prompted to create a test of message log functionality
 * between notification mediums.
 * 
 * Manual unit tests for AlertSystem.
 * No external libraries required.
 * 
 * Compile from root directory:
 *     javac -d bin tests/*.java
 * Run:
 *     java -cp bin tests.AlertSystemTest
 */
public class AlertSystemTest {

    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;

        // Test 1: message log starts empty
        AlertSystem system = new AlertSystem();
        if (system.getMessageLog().isEmpty()) {
            System.out.println("PASS: message log starts empty");
            passed++;
        } else {
            System.out.println("FAIL: message log should start empty");
            failed++;
        }

        // Test 2: message is added to log after notifyUser
        system.setMedium(new EmailService());
        system.notifyUser("Hello");
        if (system.getMessageLog().size() == 1 && system.getMessageLog().get(0).equals("Hello")) {
            System.out.println("PASS: message added to log");
            passed++;
        } else {
            System.out.println("FAIL: message not added to log correctly");
            failed++;
        }

        // Test 3: multiple messages logged in order across medium swaps
        AlertSystem system2 = new AlertSystem();
        system2.setMedium(new EmailService());
        system2.notifyUser("First");
        system2.setMedium(new SMSService());
        system2.notifyUser("Second");
        system2.setMedium(new WhatsAppService());
        system2.notifyUser("Third");
        if (system2.getMessageLog().size() == 3
                && system2.getMessageLog().get(0).equals("First")
                && system2.getMessageLog().get(1).equals("Second")
                && system2.getMessageLog().get(2).equals("Third")) {
            System.out.println("PASS: multiple messages logged in order");
            passed++;
        } else {
            System.out.println("FAIL: messages not logged in correct order");
            failed++;
        }

        System.out.println("\n" + passed + " passed, " + failed + " failed");
    }
}