package blocks;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Blocks {

    protected Point coordinates;
    protected Dimension dim;
    public Rectangle rec;

    protected Rectangle[] rectangles;
    private BlockType type;

    private Rectangle rotationRec;
    private int rotationIndex;

    private boolean canMoveL;
    private boolean canMoveR;

    public Blocks(BlockType type) {
        coordinates = new Point(100, 0);
        dim = new Dimension(20, 20);
        rec = new Rectangle(coordinates, dim);
        rectangles = new Rectangle[4];

        canMoveL = true;
        canMoveR = true;
        this.type = type;
    }

    public Blocks(Image image) {
        coordinates = new Point(100, 0);
    }

    public void horizontalMove(boolean toLeft, boolean isRight) {
        int x = (int) coordinates.getX();
        int y = (int) coordinates.getY();
        if (toLeft) {
            coordinates.setLocation(x - 15, y);
        } else if (isRight) {
            coordinates.setLocation(x + 15, y);
        }
        rec.setLocation(coordinates);

        for (int i = 0; i < 4; i++) {
            x = (int) rectangles[i].getLocation().getX();
            y = (int) rectangles[i].getLocation().getY();

            if (toLeft) {
                coordinates.setLocation(x - 15, y);
            } else if (isRight) {
                coordinates.setLocation(x + 15, y);
            }
            // coordinates.setLocation(x, y);
            rectangles[i].setLocation(coordinates);
        }
    }

    public void moveLeft() {

        if (canMoveL) {
            int x = (int) coordinates.getX();
            int y = (int) coordinates.getY();

            coordinates.setLocation(x - 20, y);

            rec.setLocation(coordinates);

            for (int i = 0; i < 4; i++) {
                x = (int) rectangles[i].getLocation().getX();
                y = (int) rectangles[i].getLocation().getY();
                coordinates.setLocation(x - 20, y);
                rectangles[i].setLocation(coordinates);
            }
        }

    }

    public void moveRight() {
        if (canMoveR) {
            int x = (int) coordinates.getX();
            int y = (int) coordinates.getY();

            coordinates.setLocation(x + 20, y);

            rec.setLocation(coordinates);

            for (int i = 0; i < 4; i++) {
                x = (int) rectangles[i].getLocation().getX();
                y = (int) rectangles[i].getLocation().getY();
                coordinates.setLocation(x + 20, y);
                rectangles[i].setLocation(coordinates);
            }
        }

    }

    public void verticalMove() {
        int x = (int) coordinates.getX();
        int y = (int) coordinates.getY();
        coordinates.setLocation(x, y + 20);
        rec.setLocation(coordinates);

        for (int i = 0; i < 4; i++) {
            x = (int) rectangles[i].getLocation().getX();
            y = (int) rectangles[i].getLocation().getY();
            coordinates.setLocation(x, y + 20);
            rectangles[i].setLocation(coordinates);
        }
    }

    public void verticalMove(int value) {
        int x = (int) coordinates.getX();
        int y = (int) coordinates.getY();
        coordinates.setLocation(x, y + value);

        rec.setLocation(coordinates);

        for (int i = 0; i < 4; i++) {
            x = (int) rectangles[i].getLocation().getX();
            y = (int) rectangles[i].getLocation().getY();
            coordinates.setLocation(x, y + value);
            rectangles[i].setLocation(coordinates);
        }
    }

    public double getX() {
        return coordinates.getX();
    }

    public double getY() {
        return coordinates.getY();
    }

    public Rectangle[] getRecs() {
        return rectangles;
    }

    public void setRotationRec(int index) {
        rotationRec = rectangles[index];
        rotationIndex = index;
    }

    public void setCanMoveL(boolean value) {
        canMoveL = value;
    }

    public void setCanMoveR(boolean value) {
        canMoveR = value;
    }

    protected abstract void setRectangles();

    public void arrangeRotation(int index) {
        int axisX = (int) rectangles[index].getX();
        int axisY = (int) rectangles[index].getY();
        System.out.println("Entered");

        for (int i = 0; i < 4; i++) {

            if (i != index) {
                double distanceX = rectangles[i].getX() - axisX;
                double distanceY = rectangles[i].getY() - axisY;

                double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));

                System.out.println(
                        (distanceY / distanceX) + "-------" + Math.toDegrees(Math.atan2(distanceY, distanceX)));

                double degree = (Math.atan2(distanceY, distanceX) + Math.toRadians(90)) % Math.toRadians(360);

                int newX = (int) (distance * Math.cos(degree));
                int newY = (int) (distance * Math.sin(degree));
                System.out.println(newX + "---------" + newY);
                System.out.println();

                rectangles[i].setLocation(new Point((int) (newX + axisX), (int) (newY + axisY)));
            }

        }
    }

    public void arrangeRotation() {
        int axisX = (int) rotationRec.getX();
        int axisY = (int) rotationRec.getY();
        System.out.println("Entered");

        for (int i = 0; i < 4; i++) {

            if (i != rotationIndex) {
                double distanceX = rectangles[i].getX() - axisX;
                double distanceY = rectangles[i].getY() - axisY;

                double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));

                System.out.println(
                        (distanceY / distanceX) + "-------" + Math.toDegrees(Math.atan2(distanceY, distanceX)));

                double degree = (Math.atan2(distanceY, distanceX) + Math.toRadians(90)) % Math.toRadians(360);

                int newX = (int) (distance * Math.cos(degree)) + axisX;
                int newY = (int) (distance * Math.sin(degree)) + axisY;
                System.out.println(newX + "---------" + newY);
                System.out.println();

                rectangles[i].setLocation(new Point(newX, newY));

            }

        }

        for (int i = 0; i < 4; i++) {
            if (rectangles[i].getX() / 20 >= 11) {
                moveLeft();
            } else if (rectangles[i].getX() / 20 <= 0) {
                moveRight();
            }
        }
    }

}
