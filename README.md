AlertSystem App
    A modular alert system app that notifies the user with a message via a 
    changeable NotificationMedium interface. Messages are saved in a log.

Architectural Overview
    Interface: NotificationMedium defines the contract for the delivery medium.
    Services: handle implementation details of each service.
    AlertSystem runs each instance and stores the messages log.

CLI Execution Instructions
This program is designed to be compiled and run via the CLI.
    1. Compiling:
       Run the following command from the src directory:
        `javac -d bin app/*.java services/*.java`
    2. Run the application:
        `java -cp bin app.AlertSystem`
    3. Generate Javadocs:
        `javadoc -d docs -author -sourcepath . -subpackages app:services`

Maintenance
To add a new service:
    - Create a new class/file in the `services` folder
    - Implement the new service from the `NotificationMedium` interface
    - Pass the new class into `AlertSystem.setMedium()`

Author: Whit

Date: February 2026
