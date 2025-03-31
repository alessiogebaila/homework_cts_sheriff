package ase.en.sqt.cli;
import ase.en.sqt.manager.DispatcherManager;
import ase.en.sqt.sheriff.Sheriff;
import java.util.Scanner;

public class CliManager {
    private final Scanner scanner;
    private Sheriff sheriff;
    private final DispatcherManager dispatcherManager;
    private final MainMenuHandler mainMenuHandler;
    private final DispatcherMenuHandler dispatcherMenuHandler;
    private final RequestMenuHandler requestMenuHandler;

    public CliManager(Sheriff sheriff, DispatcherManager dispatcherManager) {
        this.sheriff = sheriff;
        this.dispatcherManager = dispatcherManager;
        this.scanner = new Scanner(System.in);

        this.mainMenuHandler = new MainMenuHandler(this);
        this.dispatcherMenuHandler = new DispatcherMenuHandler(this);
        this.requestMenuHandler = new RequestMenuHandler(this);
    }

    public void start() {
        boolean running = true;

        while (running) {
            mainMenuHandler.displayMenu();
            int choice = getIntInput();

            if (choice == 0) {
                running = false;
                System.out.println("Exiting the system.");
            } else {
                mainMenuHandler.handleChoice(choice);
            }
        }

        scanner.close();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Sheriff getSheriff() {
        return sheriff;
    }

    public void setSheriff(Sheriff sheriff) {
        this.sheriff = sheriff;
    }

    public DispatcherManager getDispatcherManager() {
        return dispatcherManager;
    }

    public MainMenuHandler getMainMenuHandler() {
        return mainMenuHandler;
    }

    public DispatcherMenuHandler getDispatcherMenuHandler() {
        return dispatcherMenuHandler;
    }

    public RequestMenuHandler getRequestMenuHandler() {
        return requestMenuHandler;
    }

    public int getIntInput() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public boolean hasSheriff() {
        return sheriff != null;
    }
}
