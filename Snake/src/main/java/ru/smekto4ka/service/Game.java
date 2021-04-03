/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smekto4ka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import ru.smekto4ka.data.Subject;
import ru.smekto4ka.ui.omponent.MyPanel;

/**
 * @author �
 */
public class Game {
    private List<MyPanel> list = new ArrayList();
    private int size;
    private int currentSize = 1;
    private ThreadLocalRandom random;

    public Game(MyPanel head, int size) {
        this.size = size;
        list.add(head);
        head.setSubjexct(Subject.SNAKE);
        random = ThreadLocalRandom.current();
        createApple(head);
    }

    public boolean update() {
        if (size == currentSize) {
            return true;
        }

        MyPanel nextPanel = list.get(0).getNextButton();
        if (nextPanel.getSubject() == Subject.FOOD) {
            currentSize++;
            if (size == currentSize) {
                return true;
            }
            System.out.println("new head" + nextPanel.getNumber());
            createApple(nextPanel);

        } else {
            list.remove(currentSize - 1).setSubjexct(Subject.NONE);
        }
        nextPanel.setSubjexct(Subject.SNAKE);
        list.add(0, nextPanel);
        return false;
    }

    private void createApple(MyPanel  panel) {
        System.out.println(size + "*****" + currentSize);
        int num = random.nextInt(1,size - currentSize+1);

        for (int i =0; i < num; i++) {
           panel=panel.getNextButton();
        }
        System.out.println("ctavim = " + panel.getNumber());
        panel.setSubjexct(Subject.FOOD);
    }
}
