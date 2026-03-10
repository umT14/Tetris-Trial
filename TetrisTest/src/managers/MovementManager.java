package managers;

import blocks.Blocks;

public class MovementManager {

    private Blocks block;

    private static final double FPS = 0.75;
    private static double interval = 1000000000 / FPS;

    private double remainingTime;
    private double nextTime;

    public MovementManager() {
        block = null;
        nextTime = System.nanoTime() + interval;
    }

    private void setBlock(Blocks new_block) {
        block = new_block;
    }

    private void blockDeleted() {
        block = null;
    }

    public void mover(Blocks b, boolean canMove) {

        if (!b.equals(block)) {
            setBlock(b);
        }

        if (block != null && canMove) {
            remainingTime = nextTime - System.nanoTime();

            if (remainingTime <= 0) {
                block.verticalMove();
                nextTime = System.nanoTime() + interval;
            }

        }
    }
}
