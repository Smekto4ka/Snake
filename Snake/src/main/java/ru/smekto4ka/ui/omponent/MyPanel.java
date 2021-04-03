package ru.smekto4ka.ui.omponent;

import ru.smekto4ka.data.Subject;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;


public class MyPanel extends JPanel {
    private  int xPositions;
    private  int yPositions;
    private Subject subject = Subject.NONE;
    private MyPanel nextButton;
    private List<MyPanel> reduction = new ArrayList<MyPanel>();
    private boolean passed = false;
    private int number;

    public MyPanel(int xPositions, int yPositions) {
        super();
        this.xPositions = xPositions;
        this.yPositions = yPositions;
    }


    public int getXPosition() {
        return xPositions;
    }


    public int getYPosition() {
        return yPositions;
    }

    public Subject getSubject() {
        return subject;
    }
    
    public void setSubjexct(Subject subject){
        this.subject = subject;
        this.setBackground(subject.getColor());
    }
    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public MyPanel getNextButton() {
        return nextButton;
    }

    public void setNextButton(MyPanel nextButton) {
        this.nextButton = nextButton;
    }

    public List<MyPanel> getReduction() {
        return reduction;
    }

    public void setReduction(List<MyPanel> reduction) {
        this.reduction = reduction;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
