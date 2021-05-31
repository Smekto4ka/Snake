package ru.smekto4ka.image;

import ru.smekto4ka.image.service.ImageService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().css();

    }

    // Main.class.getResource("/test.jpg").getPath()
    public void css() {
        try {

            List<BufferedImage> list = new ArrayList<>();
            BufferedImage im = ImageIO.read(new File("C:\\Games\\GitHub\\Snake\\Snake\\src\\main\\resources\\pizza.jpg"));
            list.add(im);
            int height = im.getHeight();
            int width = im.getWidth();
            int length = 30;
            int vich_h = height / (length + 10);
            int vich_w = width / (length + 10);

            for (int i = 0; i < length; i++) {
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                Graphics g = image.getGraphics();
                g.drawImage(ImageIO.read(new File("C:\\Games\\GitHub\\Snake\\Snake\\src\\main\\resources\\pizza.jpg"))
                        , 0, 0, width, height, null);
                list.add(image);

                height -= vich_h;
                width -= vich_w;
            }


            BufferedImage bf = new ImageService().css(list);
            File file = new File("C:\\Games\\GitHub\\Snake\\Snake\\src\\main\\resources\\test.jpg");
            ImageIO.write(bf, "JPG", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
