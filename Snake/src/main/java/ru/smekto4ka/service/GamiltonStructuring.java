package ru.smekto4ka.service;

import ru.smekto4ka.ui.omponent.MyPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GamiltonStructuring implements Structuring {
    private ThreadLocalRandom rand = ThreadLocalRandom.current();

    private int lengthX;
    private int lengthY;
    private int size;
    private int currentSize;
    private MyPanel[][] myPanels;

    public boolean structuring(MyPanel[][] myPanels, MyPanel head) {
        System.out.println("start struct");
        this.myPanels = myPanels;
        lengthX = myPanels[0].length;
        lengthY = myPanels.length;
        size = lengthX * lengthY;
        currentSize = 0;
        head.setNumber(0);
        return search(head);
    }

    private boolean search(MyPanel panel) {
        panel.setPassed(true);
        currentSize++;
        panel.setNumber(currentSize);
        panel.removeAll();
        panel.add(new JLabel(Integer.toString(currentSize)));
        List<MyPanel> list = initList(panel);
        while (list.size() != 0) {
            MyPanel myPanel = list.remove(rand.nextInt(list.size()));
            if (myPanel.isPassed()) continue;
            if (search(myPanel)) {
                panel.setNextButton(myPanel);
                return true;
            } else {
                currentSize--;
            }
        }
        return check(panel);
    }

    private boolean check(MyPanel panel) {
        for (MyPanel myPanel : initList(panel)) {
            if (myPanel.getNumber() == 1 && currentSize == size) {
                panel.setNextButton(myPanel);
                return true;
            }
        }
        panel.setPassed(false);
        return false;
    }

    private List<MyPanel> initList(MyPanel panel) {
        List<MyPanel> list = new ArrayList<>();
        if (panel.getXPosition() - 1 >= 0) {
            list.add(myPanels[panel.getYPosition()][panel.getXPosition() - 1]);
        }
        if (panel.getXPosition() + 1 < lengthX) {
            list.add(myPanels[panel.getYPosition()][panel.getXPosition() + 1]);
        }
        if (panel.getYPosition() - 1 >= 0) {
            list.add(myPanels[panel.getYPosition() - 1][panel.getXPosition()]);
        }
        if (panel.getYPosition() + 1 < lengthY) {
            list.add(myPanels[panel.getYPosition() + 1][panel.getXPosition()]);
        }
        return list;
    }
}
