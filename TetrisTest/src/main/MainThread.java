package main;

import blocks.Blocks;
import gui.GamePanel;
import managers.CollisionHandler;
import managers.KeyboardHandler;
import managers.MovementManager;
import managers.TileManager;

public class MainThread implements Runnable {

    private GamePanel panel;
    private MovementManager mm;
    private KeyboardHandler kh;
    private CollisionHandler colHandler;

    private static final double FPS = 60;
    private static double interval = 1000000000 / FPS;

    public MainThread(GamePanel panel) {
        this.panel = panel;
        mm = new MovementManager();
        kh = panel.getKeyHandler();
        colHandler = new CollisionHandler(panel);
    }

    @Override
    public void run() {

        double nextTime = System.nanoTime() + interval;

        while (this != null) {

            double remainingTime = nextTime - System.nanoTime();

            try {
                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) (remainingTime / 1000000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nextTime = System.nanoTime() + interval;
            update();
        }

    }

    public void update() {
        Blocks currentBlock = panel.getCurrentBlock();
        // ------------------------------------------------
        panel.repaint();

        mm.mover(currentBlock, !kh.getLeft() || !kh.getRight() || !kh.getDrop());

        colHandler.checkCol(panel.getTileMatrix());

        // currentBlock.horizontalMove(kh.getLeft(), kh.getRight());

    }

}
