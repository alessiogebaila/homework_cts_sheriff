package ase.en.sqt.cli;

import ase.en.sqt.requests.Request;
import ase.en.sqt.requests.RequestType;

import java.util.List;

public class RequestMenuHandler {
    private final CliManager cliManager;

    public RequestMenuHandler(CliManager cliManager) {
        this.cliManager = cliManager;
    }

    public void displayMenu() {
        System.out.println("\n===== REQUEST MANAGEMENT =====");
        System.out.println("1. View All Requests");
        System.out.println("2. Solve Request");
        System.out.println("3. Transform Request Type");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                viewRequests();
                break;
            case 2:
                solveRequest();
                break;
            case 3:
                transformRequest();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void viewRequests() {
        List<Request> requests = cliManager.getSheriff().getRequestQueue();

        if (requests.isEmpty()) {
            System.out.println("No requests in the queue.");
            return;
        }

        System.out.println("\n===== CURRENT REQUESTS =====");
        for (int i = 0; i < requests.size(); i++) {
            System.out.println(i + ": " + requests.get(i));
        }
    }

    private void solveRequest() {
        List<Request> requests = cliManager.getSheriff().getRequestQueue();

        if (requests.isEmpty()) {
            System.out.println("No requests in the queue to solve.");
            return;
        }

        viewRequests();
        System.out.print("Enter the index of the request to solve: ");
        int index = cliManager.getIntInput();

        cliManager.getSheriff().solveRequest(index);
    }

    private void transformRequest() {
        List<Request> requests = cliManager.getSheriff().getRequestQueue();

        if (requests.isEmpty()) {
            System.out.println("No requests in the queue to transform.");
            return;
        }

        viewRequests();
        System.out.print("Enter the index of the request to transform: ");
        int index = cliManager.getIntInput();

        if (index < 0 || index >= requests.size()) {
            System.out.println("Invalid request index.");
            return;
        }

        System.out.println("Select new request type:");
        System.out.println("1. Regular");
        System.out.println("2. Emergency");
        System.out.println("3. Crisis");
        System.out.print("Enter your choice: ");

        int choice = cliManager.getIntInput();
        RequestType newType = null;

        switch (choice) {
            case 1:
                newType = RequestType.REGULAR;
                break;
            case 2:
                newType = RequestType.EMERGENCY;
                break;
            case 3:
                newType = RequestType.CRISIS;
                break;
            default:
                System.out.println("Invalid choice. Request not transformed.");
                return;
        }

        cliManager.getSheriff().transformRequestType(index, newType);
    }
}
