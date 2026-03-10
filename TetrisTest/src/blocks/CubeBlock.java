package blocks;

import java.awt.Point;
import java.awt.Rectangle;

public class CubeBlock extends Blocks {

    public CubeBlock() {
        super(BlockType.CUBE);
        setRectangles();
        setRotationRec(1);
    }

    @Override
    protected void setRectangles() {
        rectangles[0] = new Rectangle(coordinates, dim);
        rectangles[1] = new Rectangle(new Point((int) (getX() + 20), (int) getY()), dim);
        rectangles[2] = new Rectangle(new Point((int) (getX()), (int) getY() + 20), dim);
        rectangles[3] = new Rectangle(new Point((int) (getX() + 20), (int) getY() + 20), dim);
    }

    @Override
    public void arrangeRotation() {
        // EMPTY ---- No rotation needed
    }

}
