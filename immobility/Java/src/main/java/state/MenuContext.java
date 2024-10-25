package state;

public class MenuContext {
    private MenuState state;

    public void setState(MenuState state) {
        this.state = state;
    }

    public void handle() {
        if (state != null) {
            state.handle();
        } else {
            System.out.println("No main.java.state set!");
        }
    }
}
