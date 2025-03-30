package ase.en.sqt.models;

import ase.en.sqt.enums.RequestType;

public abstract class Dispatcher {
    protected String id;
    protected String address;
    protected RequestType dispatcherType;

    public Dispatcher(String id, String address) {
        this.id = id;
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RequestType getDispatcherType() {
        return dispatcherType;
    }

    @Override
    public String toString() {
        return "Dispatcher{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", type=" + dispatcherType +
                '}';
    }
}
