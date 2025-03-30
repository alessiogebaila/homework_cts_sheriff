package ase.en.sqt.interfaces;

import ase.en.sqt.sheriff.Sheriff;

public interface Dispatcher {
    String getId();
    String getAddress();
    void setAddress(String address);
    void sendRequest(Sheriff sheriff, String description);
}