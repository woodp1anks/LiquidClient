package woodp1anks.liquidclient.mod;

public class Mod {
    private final String name;
    private final Category category;
    private boolean enabled;
    private int key;

    public Mod(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void draw() {

    }

    public void render() {

    }

    public void update() {

    }

    public void onKeyPressed(int key) {

    }
}
