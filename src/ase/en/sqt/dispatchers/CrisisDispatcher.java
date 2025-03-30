package ase.en.sqt.dispatchers;

import ase.en.sqt.requests.RequestType;

public class CrisisDispatcher extends AbstractDispatcher{
    public CrisisDispatcher(String id, String address) {
        super(id, address);
        this.requestType = RequestType.CRISIS;
    }
}
