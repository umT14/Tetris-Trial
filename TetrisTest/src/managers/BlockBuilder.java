package managers;

import java.util.Random;

import blocks.Blocks;
import blocks.BlueLBlock;
import blocks.CubeBlock;
import blocks.GreenSBlock;
import blocks.OrangeLBlock;
import blocks.RedSBlock;
import blocks.StraightBlock;
import blocks.TriangleBlock;

public class BlockBuilder {

    Blocks nextBlock;
    Blocks curBlock;
    Blocks[] types;

    public BlockBuilder() {
        types = new Blocks[2];
        // curBlock = spawnBlock();
        nextBlock = spawnBlock();
        setBlockTypes();
    }

    private void setBlockTypes() {

    }

    public Blocks spawnBlock() {
        Random random = new Random();

        int number = random.nextInt(14);
        System.out.println(number);
        if (number >= 0 && number < 2) {
            return new CubeBlock();
        } else if (number >= 2 && number < 4) {
            return new StraightBlock();
        } else if (number >= 4 && number < 6) {
            return new BlueLBlock();
        } else if (number >= 6 && number < 8) {
            return new OrangeLBlock();
        } else if (number >= 8 && number < 10) {
            return new GreenSBlock();
        } else if (number >= 10 && number < 12) {
            return new RedSBlock();
        } else {
            return new TriangleBlock();
        }
    }

    public Blocks getNextBlock() {
        curBlock = nextBlock;
        nextBlock = spawnBlock();
        return curBlock;
    }

}
