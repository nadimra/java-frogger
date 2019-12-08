package model;

import javafx.scene.input.KeyCode;

public interface Command {
    public void execute(String img); 
    public KeyCode getKey();
}
