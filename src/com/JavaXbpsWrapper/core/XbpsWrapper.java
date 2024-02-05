package com.JavaXbpsWrapper.core;

import com.JavaXbpsWrapper.commands.InstallCommand;
import com.JavaXbpsWrapper.commands.RemoveCommand;
import com.JavaXbpsWrapper.commands.SearchCommand;
import com.JavaXbpsWrapper.commands.UpdateCommand;
public class XbpsWrapper {
    // Implementation for coordinating package manager commands
    private InstallCommand installCommand;
    private RemoveCommand removeCommand;
    private SearchCommand searchCommand;
    private UpdateCommand updateCommand;

    public XbpsWrapper() {
        this.installCommand = new InstallCommand();
        this.removeCommand = new RemoveCommand();
        this.searchCommand = new SearchCommand();
        this.updateCommand = new UpdateCommand();
    }

    public void install(String packageName) {
        installCommand.execute(packageName);
    }

    public void remove(String packageName) {
        removeCommand.execute(packageName);
    }

    public void search(String query) {
        searchCommand.execute(query);
    }

    public void update() {
        updateCommand.execute();
    }
}
