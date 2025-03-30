package ase.en.sqt.sheriff;

import ase.en.sqt.requests.Request;
import ase.en.sqt.requests.RequestType;

import java.util.ArrayList;
import java.util.List;

public class Sheriff {
    private String name;
    private int tenure;
    private final List<Request> requestQueue;
    private final int maxQueueSize;

    public Sheriff(String name, int tenure, int maxQueueSize) {
        this.name = name;
        this.tenure = tenure;
        this.maxQueueSize = maxQueueSize;
        this.requestQueue = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTenure() {
        return tenure;
    }

    public void addRequest(Request request) {
        if (request.getType() == RequestType.REGULAR) {
            addRegularRequest(request);
        } else if (request.getType() == RequestType.EMERGENCY) {
            addEmergencyRequest(request);
        } else if (request.getType() == RequestType.CRISIS) {
            addCrisisRequest(request);
        }
    }

    private void addRegularRequest(Request request) {
        if (requestQueue.size() >= maxQueueSize) {
            System.out.println("Queue is full. Regular request dropped.");
            return;
        }
        requestQueue.add(request);
        System.out.println("Regular request added to the end of the queue.");
    }

    private void addEmergencyRequest(Request request) {
        if (requestQueue.size() >= maxQueueSize) {
            System.out.println("Queue is full. Emergency request dropped.");
            return;
        }

        int insertionIndex = 0;
        for (int i = 0; i < requestQueue.size(); i++) {
            if (requestQueue.get(i).getType() == RequestType.CRISIS) {
                insertionIndex = i + 1;
            }
        }
        requestQueue.add(insertionIndex, request);
        System.out.println("Emergency request added after the last crisis request.");
    }

    private void addCrisisRequest(Request request) {
        if (requestQueue.size() >= maxQueueSize) {
            requestQueue.remove(requestQueue.size() - 1);
            System.out.println("Queue was full. Last request dropped to accommodate crisis request.");
        }
        requestQueue.add(0, request);
        System.out.println("Crisis request added to the beginning of the queue.");
    }

    public void transformRequestType(int requestIndex, RequestType newType) {
        if (requestIndex < 0 || requestIndex >= requestQueue.size()) {
            System.out.println("Invalid request index.");
            return;
        }

        Request request = requestQueue.get(requestIndex);
        RequestType oldType = request.getType();
        request.setType(newType);
        requestQueue.remove(requestIndex);

        addRequest(request);

        System.out.println("Request transformed from " + oldType + " to " + newType);
    }

    public void solveRequest(int index) {
        if (index < 0 || index >= requestQueue.size()) {
            System.out.println("Invalid request index.");
            return;
        }

        Request solvedRequest = requestQueue.remove(index);
        System.out.println("Sheriff " + name + " solved request: " + solvedRequest);
    }

    public List<Request> getRequestQueue() {
        return new ArrayList<>(requestQueue);
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    @Override
    public String toString() {
        return "Sheriff{" +
                "name='" + name + '\'' +
                ", tenure=" + tenure +
                ", queueSize=" + requestQueue.size() +
                "/" + maxQueueSize +
                '}';
    }
}
