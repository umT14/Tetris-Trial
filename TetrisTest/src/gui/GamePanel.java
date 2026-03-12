package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import blocks.Blocks;
import main.MainThread;
import managers.KeyboardHandler;
import managers.TileManager;

public class GamePanel extends JPanel {

    private Blocks currentBlock;
    private KeyboardHandler kh;
    private TileManager tm;

    private static final int BOUND_X = 100;
    private static final int BOUND_Y = 100;
    private static final int BOUND_W = 240;
    private static final int BOUND_H = 420;

    public GamePanel() {
        super();
        // -----------------------------------
        // currentBlock = new Blocks();
        // currentBlock = new StraightBlock();

        kh = new KeyboardHandler();
        tm = new TileManager();

        kh.setBlock(currentBlock);
        // -----------------------------------

        setPreferredSize(new Dimension(BOUND_W, BOUND_H));
        // setBounds(BOUND_X, BOUND_Y, BOUND_W, BOUND_H);
        addKeyListener(kh);
        setFocusable(true);

        createThread();
    }

    private void createThread() {
        Thread playerThread = new Thread(new MainThread(this));
        playerThread.start();
    }

    public Blocks getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(Blocks newBlock) {
        currentBlock = newBlock;
        kh.setBlock(currentBlock);
    }

    public KeyboardHandler getKeyHandler() {
        return kh;
    }

    public int[][] getTileMatrix() {
        return tm.getMatrix();
    }

    public void deleteRow() {
        tm.deleteFullRow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tm.paintTiles(g2);
        //tm.deleteFullRow();

        Rectangle[] arr = currentBlock.getRecs();
        for (int i = 0; i < 4; i++) {
            g2.setColor(Color.DARK_GRAY);
            g2.fill(arr[i]);
            g2.setColor(Color.PINK);
            g2.fillOval((int) arr[i].getX(), (int) arr[i].getY(), 2, 2);

        }
        // g2.fill(currentBlock.rec);

    }
}

