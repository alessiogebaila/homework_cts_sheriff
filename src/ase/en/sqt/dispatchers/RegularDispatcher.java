package ase.en.sqt.dispatchers;

import ase.en.sqt.requests.RequestType;

public class RegularDispatcher extends AbstractDispatcher{
    public RegularDispatcher(String id, String address) {
        super(id, address);
        this.requestType = RequestType.REGULAR;
    }

}
