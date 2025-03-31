package ase.en.sqt.manager;

import ase.en.sqt.interfaces.Dispatcher;
import java.util.HashMap;
import java.util.Map;

public class DispatcherManager {
    private final Map<String, Dispatcher> dispatchers = new HashMap<>();

    public void addDispatcher(Dispatcher dispatcher) {
        dispatchers.put(dispatcher.getId(), dispatcher);
    }

    public void removeDispatcher(String dispatcherId) {
        dispatchers.remove(dispatcherId);
    }

    public Dispatcher getDispatcher(String dispatcherId) {
        return dispatchers.get(dispatcherId);
    }

    public Map<String, Dispatcher> getAllDispatchers() {
        return new HashMap<>(dispatchers);
    }

    public void updateDispatcherAddress(String dispatcherId, String newAddress) {
        Dispatcher dispatcher = dispatchers.get(dispatcherId);
        if (dispatcher != null) {
            dispatcher.setAddress(newAddress);
        }
    }
}