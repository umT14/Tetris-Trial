package blocks;

import java.awt.Point;
import java.awt.Rectangle;

public class TriangleBlock extends Blocks {

    public TriangleBlock() {
        super(BlockType.GREEN_S);
        setRectangles();
        setRotationRec(1);
    }

    @Override
    protected void setRectangles() {
        rectangles[0] = new Rectangle(coordinates, dim);
        rectangles[1] = new Rectangle(new Point((int) (getX() + 20), (int) getY()), dim);
        rectangles[2] = new Rectangle(new Point((int) (getX() + 20), (int) getY() - 20), dim);
        rectangles[3] = new Rectangle(new Point((int) (getX() + 40), (int) getY()), dim);
    }

}
