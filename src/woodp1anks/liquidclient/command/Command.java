package woodp1anks.liquidclient.command;

public abstract class Command {

    private final String name;
    private final String[] key;
    private final String description;
    private final String[] argNames;

    public Command(String name, String[] key, String description, String[] argNames) {
        this.name = name;
        this.key = key;
        this.description = description;
        this.argNames = argNames;
    }

    public abstract void run(String[] args);

    public String getName() {
        return name;
    }

    public String[] getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public String[] getArgNames() {
        return argNames;
    }
}
