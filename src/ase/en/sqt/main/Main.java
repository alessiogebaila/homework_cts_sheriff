package ase.en.sqt.main;

import ase.en.sqt.cli.CliManager;
import ase.en.sqt.manager.DispatcherManager;
import ase.en.sqt.sheriff.Sheriff;

public class Main {
    public static void main(String[] args) {
        Sheriff sheriff = null;
        DispatcherManager dispatcherManager = new DispatcherManager();
        CliManager cliManager = new CliManager(sheriff, dispatcherManager);

        cliManager.start();
    }
}
