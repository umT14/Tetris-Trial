package blocks;

import java.awt.Point;
import java.awt.Rectangle;

public class StraightBlock extends Blocks {

    public StraightBlock() {
        super(BlockType.LINEAR);
        setRectangles();
        setRotationRec(1);
    }

    @Override
    protected void setRectangles() {
        rectangles[0] = new Rectangle(coordinates, dim);
        rectangles[1] = new Rectangle(new Point((int) (getX() + 20), (int) getY()), dim);
        rectangles[2] = new Rectangle(new Point((int) (getX() + 40), (int) getY()), dim);
        rectangles[3] = new Rectangle(new Point((int) (getX() + 60), (int) getY()), dim);
    }

}
