package ase.en.sqt.cli;

import ase.en.sqt.manager.DispatcherManager;
import ase.en.sqt.sheriff.Sheriff;

import java.util.Scanner;

public class MainMenuHandler {
    private final CliManager cliManager;

    public MainMenuHandler(CliManager cliManager) {
        this.cliManager = cliManager;
    }

    public void displayMenu() {
        System.out.println("\n===== SHERIFF SYSTEM MENU =====");
        if (cliManager.hasSheriff()) {
            System.out.println("Current Sheriff: " + cliManager.getSheriff());
        } else {
            System.out.println("No Sheriff created yet!");
        }
        System.out.println("1. Create Sheriff");
        System.out.println("2. Dispatcher Management");
        System.out.println("3. Request Management");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                createSheriff();
                break;
            case 2:
                if (cliManager.hasSheriff()) {
                    runDispatcherMenu();
                } else {
                    System.out.println("Please create a Sheriff first!");
                }
                break;
            case 3:
                if (cliManager.hasSheriff()) {
                    runRequestMenu();
                } else {
                    System.out.println("Please create a Sheriff first!");
                }
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void createSheriff() {
        System.out.print("Enter Sheriff's name: ");
        String name = cliManager.getStringInput();

        System.out.print("Enter Sheriff's tenure (years): ");
        int tenure = cliManager.getIntInput();

        System.out.print("Enter maximum queue size: ");
        int maxQueueSize = cliManager.getIntInput();

        Sheriff sheriff = new Sheriff(name, tenure, maxQueueSize);
        cliManager.setSheriff(sheriff);
        System.out.println("Sheriff created successfully: " + sheriff);
    }

    private void runDispatcherMenu() {
        boolean submenuRunning = true;

        while (submenuRunning) {
            cliManager.getDispatcherMenuHandler().displayMenu();
            int choice = cliManager.getIntInput();

            if (choice == 0) {
                submenuRunning = false;
            } else {
                cliManager.getDispatcherMenuHandler().handleChoice(choice);
            }
        }
    }

    private void runRequestMenu() {
        boolean submenuRunning = true;

        while (submenuRunning) {
            cliManager.getRequestMenuHandler().displayMenu();
            int choice = cliManager.getIntInput();

            if (choice == 0) {
                submenuRunning = false;
            } else {
                cliManager.getRequestMenuHandler().handleChoice(choice);
            }
        }
    }
}
