package ase.en.sqt.models;

import ase.en.sqt.enums.RequestType;

public class Request {
    private String id;
    private String description;
    private RequestType type;

    public Request(String id, String description, RequestType type) {
        this.id = id;
        this.description = description;
        this.type = type;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}