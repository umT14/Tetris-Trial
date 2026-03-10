package main;

import gui.GamePanel;
import managers.MovementManager;

public class OtherThread implements Runnable {

    private GamePanel panel;
    private MovementManager mm;

    public OtherThread(GamePanel panel) {
        this.panel = panel;
        mm = new MovementManager();
    }

    @Override
    public void run() {

    }

}
