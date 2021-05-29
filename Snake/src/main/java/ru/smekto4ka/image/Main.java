package ru.smekto4ka.image;

import ru.smekto4ka.image.service.ImageService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        new Main().css();

    }
// Main.class.getResource("/test.jpg").getPath()
    public void css() {
        try {

            BufferedImage im = ImageIO.read(new File("C:\\Games\\GitHub\\Snake\\Snake\\src\\main\\resources\\pizza.jpg"));
            List<BufferedImage> images = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                images.add(im);
            }
            BufferedImage bf = new ImageService().css(images);
            File file =  new File("C:\\Games\\GitHub\\Snake\\Snake\\src\\main\\resources\\test.jpg");
            ImageIO.write(bf, "JPG",file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void svg(){
        //Step -1: We read the input SVG document into Transcoder Input
        //We use Java NIO for this purpose
        String svg_URI_input = Paths.get("chessboard.svg").toUri().toURL().toString();
        TranscoderInput input_svg_image = new TranscoderInput(svg_URI_input);
        //Step-2: Define OutputStream to PNG Image and attach to TranscoderOutput
        OutputStream png_ostream = new FileOutputStream("chessboard.png");
        TranscoderOutput output_png_image = new TranscoderOutput(png_ostream);
        // Step-3: Create PNGTranscoder and define hints if required
        PNGTranscoder my_converter = new PNGTranscoder();
        // Step-4: Convert and Write output
        my_converter.transcode(input_svg_image, output_png_image);
        // Step 5- close / flush Output Stream
        png_ostream.flush();
        png_ostream.close();
    }
}
