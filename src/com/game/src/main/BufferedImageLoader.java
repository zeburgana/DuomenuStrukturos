package com.game.src.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class BufferedImageLoader {

    private BufferedImage image = null;
    public BufferedImage loadImage(String path) throws IOException{
        image = ImageIO.read(new File(path));
        return image;
    }
}
