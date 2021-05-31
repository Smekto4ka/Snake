package ru.smekto4ka.image.service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.*;
import java.util.List;

public class ImageService {

    public BufferedImage css(List<BufferedImage> imgs) {
        imgs.sort(new SortWidthImage());
        int widthMax = imgs.get(0).getWidth() * 3;

        imgs.sort(new SortHeightImage());
        List<Integer> heightLevel = new ArrayList<>();
        heightLevel.add(0);
        List<Integer> balanceWidth = new ArrayList<>();

        int maxLevel = 0;
        Map<BufferedImage, List<Integer>> coordinates = new HashMap<>();
        BufferedImage godImage = new BufferedImage(widthMax, imgs.get(0).getHeight(), BufferedImage.TYPE_INT_RGB);
        boolean flag = true;
        newImage:
        for (BufferedImage image : imgs) {
            if (flag) {
                godImage.getGraphics().drawImage(image, 0, 0,null);
                // coordinates.put(image , new ArrayList<>());
                heightLevel.add(image.getHeight());
                balanceWidth.add( image.getWidth());
                flag = false;
                continue;
            }
            for (int i = 0; i <= maxLevel; i++) {
                int widthLevel = balanceWidth.get(i);
                if ((widthMax - widthLevel) >= image.getWidth()) {
                    godImage.getGraphics().drawImage(image, widthLevel, heightLevel.get(i), null);
                    balanceWidth.set(i, widthLevel + image.getWidth());
                    continue newImage;
                }
            }

            BufferedImage im = new BufferedImage(widthMax, godImage.getHeight() + image.getHeight(), BufferedImage.TYPE_INT_RGB);
            im.getGraphics().drawImage(godImage, 0, 0, null);
            heightLevel.add(im.getHeight());
            im.getGraphics().drawImage(image, 0, godImage.getHeight(), null);
            balanceWidth.add(image.getWidth());
            godImage = im;
            maxLevel++;
        }
        return godImage;
    }

}

class SortHeightImage implements Comparator<BufferedImage> {
    @Override
    public int compare(BufferedImage o1, BufferedImage o2) {
        return o2.getHeight() - o1.getHeight();
    }
}

class SortWidthImage implements Comparator<BufferedImage> {
    @Override
    public int compare(BufferedImage o1, BufferedImage o2) {
        return o2.getWidth() - o1.getWidth();
    }
}
