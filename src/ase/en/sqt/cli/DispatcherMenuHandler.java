package ase.en.sqt.cli;

import ase.en.sqt.dispatchers.CrisisDispatcher;
import ase.en.sqt.dispatchers.EmergencyDispatcher;
import ase.en.sqt.dispatchers.RegularDispatcher;
import ase.en.sqt.interfaces.Dispatcher;

import java.util.Map;

public class DispatcherMenuHandler {
    private final CliManager cliManager;

    public DispatcherMenuHandler(CliManager cliManager) {
        this.cliManager = cliManager;
    }

    public void displayMenu() {
        System.out.println("\n===== DISPATCHER MANAGEMENT =====");
        System.out.println("1. Create Dispatcher");
        System.out.println("2. List All Dispatchers");
        System.out.println("3. Update Dispatcher Address");
        System.out.println("4. Delete Dispatcher");
        System.out.println("5. Send Request from Dispatcher");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                createDispatcher();
                break;
            case 2:
                listDispatchers();
                break;
            case 3:
                updateDispatcherAddress();
                break;
            case 4:
                deleteDispatcher();
                break;
            case 5:
                sendRequest();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void createDispatcher() {
        System.out.print("Enter Dispatcher ID: ");
        String id = cliManager.getStringInput();

        System.out.print("Enter Dispatcher address: ");
        String address = cliManager.getStringInput();

        System.out.println("Select Dispatcher type:");
        System.out.println("1. Regular Dispatcher");
        System.out.println("2. Emergency Dispatcher");
        System.out.println("3. Crisis Dispatcher");
        System.out.print("Enter your choice: ");

        int choice = cliManager.getIntInput();
        Dispatcher dispatcher = null;

        switch (choice) {
            case 1:
                dispatcher = new RegularDispatcher(id, address);
                break;
            case 2:
                dispatcher = new EmergencyDispatcher(id, address);
                break;
            case 3:
                dispatcher = new CrisisDispatcher(id, address);
                break;
            default:
                System.out.println("Invalid choice. Dispatcher not created.");
                return;
        }

        cliManager.getDispatcherManager().addDispatcher(dispatcher);
        System.out.println("Dispatcher created successfully: " + dispatcher);
    }

    private void listDispatchers() {
        Map<String, Dispatcher> dispatchers = cliManager.getDispatcherManager().getAllDispatchers();

        if (dispatchers.isEmpty()) {
            System.out.println("No dispatchers found.");
            return;
        }

        System.out.println("\n===== ALL DISPATCHERS =====");
        for (Dispatcher dispatcher : dispatchers.values()) {
            System.out.println(dispatcher);
        }
    }

    private void updateDispatcherAddress() {
        System.out.print("Enter Dispatcher ID to update: ");
        String id = cliManager.getStringInput();

        Dispatcher dispatcher = cliManager.getDispatcherManager().getDispatcher(id);
        if (dispatcher == null) {
            System.out.println("Dispatcher not found with ID: " + id);
            return;
        }

        System.out.print("Enter new address: ");
        String newAddress = cliManager.getStringInput();

        cliManager.getDispatcherManager().updateDispatcherAddress(id, newAddress);
        System.out.println("Dispatcher address updated successfully.");
    }

    private void deleteDispatcher() {
        System.out.print("Enter Dispatcher ID to delete: ");
        String id = cliManager.getStringInput();

        Dispatcher dispatcher = cliManager.getDispatcherManager().getDispatcher(id);
        if (dispatcher == null) {
            System.out.println("Dispatcher not found with ID: " + id);
            return;
        }

        cliManager.getDispatcherManager().removeDispatcher(id);
        System.out.println("Dispatcher deleted successfully.");
    }

    private void sendRequest() {
        System.out.print("Enter Dispatcher ID to send request from: ");
        String id = cliManager.getStringInput();

        Dispatcher dispatcher = cliManager.getDispatcherManager().getDispatcher(id);
        if (dispatcher == null) {
            System.out.println("Dispatcher not found with ID: " + id);
            return;
        }

        System.out.print("Enter request description: ");
        String description = cliManager.getStringInput();

        dispatcher.sendRequest(cliManager.getSheriff(), description);
    }
}
