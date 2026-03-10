package managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import blocks.Blocks;

public class KeyboardHandler implements KeyListener {

    private boolean toLeft;
    private boolean toRight;

    private boolean drop;

    private Blocks block;

    public KeyboardHandler() {
        toLeft = false;
        toRight = false;
        drop = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /*
         * int k = e.getKeyCode();
         * 
         * if (k == KeyEvent.VK_LEFT) {
         * System.out.println("HELLO");
         * block.moveLeft();
         * } else if (k == KeyEvent.VK_RIGHT) {
         * block.moveRight();
         * } else if (k == KeyEvent.VK_ENTER) {
         * entered = true;
         * }
         */
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int k = e.getKeyCode();

        if (k == KeyEvent.VK_LEFT) {
            toLeft = true;
            block.moveLeft();

        } else if (k == KeyEvent.VK_RIGHT) {
            toRight = true;
            block.moveRight();
            // System.out.println(block.getX() + "------" + block.getY());
        } else if (k == KeyEvent.VK_DOWN) {
            drop = true;
            block.verticalMove();
        } else if (k == KeyEvent.VK_UP) {
            block.arrangeRotation();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int k = e.getKeyCode();

        if (k == KeyEvent.VK_LEFT) {
            toLeft = false;
        } else if (k == KeyEvent.VK_RIGHT) {
            toRight = false;
        } else if (k == KeyEvent.VK_DOWN) {
            drop = false;
        }

    }

    public boolean getRight() {
        return toRight;
    }

    public boolean getLeft() {
        return toLeft;
    }

    public boolean getDrop() {
        return drop;
    }

    public void setBlock(Blocks block) {
        this.block = block;
    }

}
