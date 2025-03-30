package ase.en.sqt.dispatchers;

import ase.en.sqt.requests.RequestType;

public class EmergencyDispatcher extends AbstractDispatcher{
    public EmergencyDispatcher(String id, String address) {
        super(id, address);
        this.requestType = RequestType.EMERGENCY;
    }
}
