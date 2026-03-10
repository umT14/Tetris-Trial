package managers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class TileManager {

    Tile border;
    Tile main;

    private int[][] matrix;
    private int[] arr;
    private int[] zeroArray;

    public TileManager() {
        setTiles();
        matrix = new int[21][12]; // row--col
        arr = new int[20];
        zeroArray = new int[12];

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 12; j++) {

                if (j == 0 || j == 11 || i == 20) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < 11; i++) {
            zeroArray[i] = 0;
        }
        zeroArray[0] = 1;
        zeroArray[11] = 1;
    }

    public void setTiles() {
        try {
            main = new Tile();
            // ---------------------
            BufferedImage borderImage = ImageIO.read(new File("src\\assets\\images\\wall.png"));
            border = new Tile(borderImage, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintTiles(Graphics2D g) {

        for (int i = 0; i < matrix.length; i++) { // 21
            for (int j = 0; j < matrix[0].length; j++) { // 12
                BufferedImage image;
                if (matrix[i][j] == 1) {
                    image = border.getImage();
                } else {
                    image = main.getImage();
                }

                g.drawImage(image, j * 20, i * 20, 20, 20, null);

            }
        }
    }

    public void deleteFullRow() {
        for (int i = 19; i >= 0; i--) {
            boolean hasOne = false;
            boolean hasZero = false;
            for (int j = 1; j < 11; j++) {
                if (matrix[i][j] == 0) {
                    hasZero = true;
                } else {
                    hasOne = true;
                }
            }

            if (hasOne == false) {
                arr[i] = 0;
                break;
            } else if (hasZero == false) {
                arr[i] = 1;

                for (int j = i; j >= 1; j--) {
                    matrix[j] = matrix[j - 1];
                }

                matrix[0] = Arrays.copyOf(zeroArray, 12);
            }
        }

        /*
         * int shiftAmount = 0;
         * 
         * 
         * for (int i = 19; i >= 0; i--) {
         * if (arr[0] == 1) {
         * shiftAmount++;
         * } else {
         * 
         * }
         * }
         */

    }

    public int[][] getMatrix() {
        return matrix;
    }

}
