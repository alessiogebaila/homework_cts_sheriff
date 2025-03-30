package ase.en.sqt.dispatchers;

import ase.en.sqt.interfaces.Dispatcher;
import ase.en.sqt.requests.Request;
import ase.en.sqt.requests.RequestType;
import ase.en.sqt.sheriff.Sheriff;

public abstract class AbstractDispatcher implements Dispatcher {
    private String id;
    private String address;
    protected RequestType requestType;

    public AbstractDispatcher(String id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void sendRequest(Sheriff sheriff, String description) {
        Request request = new Request(description, requestType, id);
        sheriff.addRequest(request);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
