package ase.en.sqt.requests;

public class Request {
    private String description;
    private RequestType type;
    private String dispatcherId;

    public Request(String description, RequestType type, String dispatcherId) {
        this.description = description;
        this.type = type;
        this.dispatcherId = dispatcherId;
    }

    public String getDescription() {
        return description;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getDispatcherId() {
        return dispatcherId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "description='" + description + '\'' +
                ", type=" + type +
                ", dispatcherId='" + dispatcherId + '\'' +
                '}';
    }
}