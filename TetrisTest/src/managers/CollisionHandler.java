package managers;

import java.awt.Rectangle;

import blocks.Blocks;
import gui.GamePanel;

public class CollisionHandler {

    private GamePanel panel;
    private Blocks curBlock;
    private Rectangle[] rectangles;

    private Rectangle leftMost;
    private Rectangle rightMost;

    private BlockBuilder bb;

    public CollisionHandler(GamePanel panel) {
        this.panel = panel;
        bb = new BlockBuilder();

        curBlock = bb.getNextBlock();
        panel.setCurrentBlock(curBlock);
        rectangles = curBlock.getRecs();

        getMostRectangle();
    }

    public void checkCol(int[][] matrix) {
        checkSideCol(matrix);
        checkBottomCol(matrix);
    }

    public void checkBottomCol(int[][] matrix) {
        // int indexX = (int) (curBlock.getX() / 20);
        // int indexY = (int) (curBlock.getY() / 20);

        for (int i = 0; i < 4; i++) {
            int indexX = (int) (rectangles[i].getX() / 20);
            int indexY = (int) (rectangles[i].getY() / 20);

            if (indexX >= 0 && indexY >= 0 && matrix[indexY + 1][indexX] == 1) {
                panel.setCurrentBlock(bb.getNextBlock());

                for (int j = 0; j < 4; j++) {
                    indexX = (int) (rectangles[j].getX() / 20);
                    indexY = (int) (rectangles[j].getY() / 20);
                    if (indexX >= 0 && indexY >= 0) {
                        matrix[indexY][indexX] = 1;
                    }

                }
                curBlock = panel.getCurrentBlock();
                rectangles = curBlock.getRecs();
                getMostRectangle();
                break;
            }
        }

    }

    public void checkSideCol(int[][] matrix) {
        getMostRectangle();
        int indexXL = (int) (leftMost.getX() / 20);
        int indexYL = (int) (leftMost.getY() / 20);

        int indexXR = (int) (rightMost.getX() / 20);
        int indexYR = (int) (rightMost.getY() / 20);

        /*
         * if ((matrix[indexX][indexY] == 1)) {
         * if (indexX + 1 >= matrix.length) {
         * curBlock.moveLeft();
         * } else if (indexX - 1 <= 0) {
         * curBlock.moveRight();
         * }
         * }
         */
        if (indexXL >= 1 && indexYL >= 0 && (matrix[indexYL][indexXL - 1] == 1)) {
            curBlock.setCanMoveL(false);
            // curBlock.setRotationRec(2);
            // curBlock.moveRight();
        } else {
            curBlock.setCanMoveL(true);
            // curBlock.setRotationRec(1);

        }
        if (indexXR <= 10 && indexYR >= 0 && (matrix[indexYR][indexXR + 1] == 1)) {
            curBlock.setCanMoveR(false);
            // curBlock.setRotationRec(1);

            // curBlock.moveLeft();
        } else {
            curBlock.setCanMoveR(true);
            // curBlock.setRotationRec(1);

        }

    }

    public void getMostRectangle() {
        Rectangle lft = new Rectangle();
        Rectangle rgt = new Rectangle();
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                lft = rectangles[i];
                rgt = rectangles[i];
            } else {
                if (rectangles[i].getX() < lft.getX()) {
                    lft = rectangles[i];
                }

                if (rectangles[i].getX() > rgt.getX()) {
                    rgt = rectangles[i];
                }
            }
        }

        leftMost = lft;
        rightMost = rgt;
    }

}
