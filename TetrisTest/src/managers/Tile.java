package managers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {

    private BufferedImage image;
    private boolean isPassable;

    public Tile() {
        try {
            image = ImageIO.read(new File("src\\assets\\images\\base.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.isPassable = true;
    }

    public Tile(boolean isPassable) {
        try {
            image = ImageIO.read(new File("src\\assets\\images\\base.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.isPassable = isPassable;
    }

    public Tile(BufferedImage image, boolean isPassable) {
        this.image = image;
        this.isPassable = isPassable;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean getPassableInfo() {
        return isPassable;
    }
}
