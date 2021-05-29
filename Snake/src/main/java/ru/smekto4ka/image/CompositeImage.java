package ru.smekto4ka.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CompositeImage {

    public static void mergeImage(String fileStr1, String fileStr2, String fileStr3, String path)
            throws IOException {
        File file1 = new File(path, fileStr1);
        File file2 = new File(path, fileStr2);

         BufferedImage image1 = ImageIO.read(file1);
         BufferedImage image2 = ImageIO.read(file2);

       // BufferedImage image1 = ImgCompress(file1);
       // BufferedImage image2 = ImgCompress(file2);

        BufferedImage combined = new BufferedImage(image1.getWidth(), image1.getHeight() * 2,
                BufferedImage.TYPE_INT_RGB);

        // paint both images, preserving the alpha channels
        Graphics g = combined.getGraphics();
        try {
            g.drawImage(image1, 0, 0, null);
            g.drawImage(image2, 0, image1.getHeight(), null);

            // Save as new image
            ImageIO.write(combined, "JPG", new File(path, fileStr3));
        } finally {
            if (g != null) {
                g.dispose();
            }
        }
    }

    // Обработка сжатия изображения

    private static Image img;
    private static int width;
    private static int height;

    public static BufferedImage ImgCompress(File file) throws IOException {
        img = ImageIO.read (file); // Создать объект изображения
        width = img.getWidth (null); // Получаем ширину исходного изображения
        height = img.getHeight (null); // Получаем длину исходного изображения

//    return resizeFix(400, 492);
        return resizeFix(600, 692);
    }

    /**
     * Сжать по ширине или высоте
     *
     * @param w
     * int максимальная ширина
     * @param h
     * int максимальная высота
     */
    public static BufferedImage resizeFix(int w, int h) throws IOException {
        if (width / height > w / h) {
            return resizeByWidth(w);
        } else {
            return resizeByHeight(h);
        }
    }

    /**
     * В зависимости от ширины изображение масштабируется в равных пропорциях.
     *
     * @param w
     * int новая ширина
     */
    public static BufferedImage resizeByWidth(int w) throws IOException {
        int h = (int) (height * w / width);
        return resize(w, h);
    }

    /**
     * Возьмите высоту в качестве ориентира, масштабируйте изображение в равной пропорции
     *
     * @param h
     * int новая высота
     */
    public static BufferedImage resizeByHeight(int h) throws IOException {
        int w = (int) (width * h / height);
        return resize(w, h);
    }

    /**
     * Принудительное сжатие / увеличение изображений до фиксированного размера
     *
     * @param w
     * int новая ширина
     * @param h
     * int новая высота
     */
    public static BufferedImage resize(int w, int h) throws IOException {
        // алгоритм сокращения SCALE_SMOOTH, гладкость сгенерированных эскизов имеет более высокий приоритет, чем скорость, и качество сгенерированных изображений лучше, но скорость медленная
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        try {
            g.drawImage (img, 0, 0, w, h, null); // Рисуем уменьшенное изображение
        } finally {
            if (g != null) {
                g.dispose();
            }
        }
        return image;
        // File destFile = new File("C:\\temp\\456.jpg");
        // FileOutputStream out = new FileOutputStream (destFile); // Вывод в файловый поток
        // // Обычно можно конвертировать BMP, PNG, GIF в JPG
        // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        // encoder.encode (image); // Кодировка JPEG
        // out.close();
    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\Games\\GitHub\\Snake\\Snake\\src\\main\\resources\\";
        String fileStr1 = "pizza.jpg";
        String fileStr2 = "css.jpg";
        String fileStr3 = "test.jpg";
        mergeImage(fileStr1, fileStr2, fileStr3, path);
    }


}
