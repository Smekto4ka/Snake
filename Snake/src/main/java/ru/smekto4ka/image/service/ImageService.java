package ru.smekto4ka.image.service;

import java.awt.image.BufferedImage;
import java.util.List;

public class ImageService {

    public BufferedImage css(List<BufferedImage> imgs) {
        int width = imgs.get(0).getWidth();
        int height = imgs.get(0).getHeight();

        BufferedImage im = new BufferedImage(imgs.size() * width, height, BufferedImage.TYPE_BYTE_INDEXED);
        int i = 0;
        for (BufferedImage image : imgs) {
            im.getGraphics().drawImage(image, i, 0, null);
            i += width;
        }

return im;
    }

}
