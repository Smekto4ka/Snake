package ru.smekto4ka.ui.omponent;

import ru.smekto4ka.service.Game;
import ru.smekto4ka.service.GamiltonStructuring;
import ru.smekto4ka.service.Structuring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements ActionListener {

    private MyPanel[][] margin;
    private Structuring structuring = new GamiltonStructuring();
    private Game game;
    private boolean enabled = true;
    private Timer timer;

    public GamePanel(int x, int y, int size) {
        init();
        initPanel(x, y, size);
    }

    private void init() {
        this.setBackground(new java.awt.Color(255, 194, 194));
        this.setLayout(new java.awt.GridBagLayout());
        this.setMinimumSize(new Dimension(400,400));
    }

    private void initPanel(int x, int y, int size) {
        System.out.println(x + "---" + y);
        java.awt.GridBagConstraints gridBagConstraints;
        margin = new MyPanel[y][x];
        System.out.println(size);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                gridBagConstraints = new java.awt.GridBagConstraints();
                MyPanel myPanel = new MyPanel(j, i);
                myPanel.setEnabled(false);
                myPanel.setBackground(myPanel.getSubject().getColor());
                myPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                myPanel.setMinimumSize(new Dimension(size, size));
                myPanel.setPreferredSize(new Dimension(size, size));
                myPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (enabled) {
                            MyPanel button = (MyPanel) e.getSource();
                            click(button);
                        }
                    }
                });

                margin[i][j] = myPanel;
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i;
                this.add(myPanel, gridBagConstraints);
            }
        }
        this.repaint();
        this.revalidate();
        enabled = true;
        System.out.println("initClose");

    }


    private void click(MyPanel button) {
        enabled = false;
        this.repaint();
        this.revalidate();
        if (!structuring.structuring(margin, button)){
            JOptionPane.showMessageDialog(null , "выберите другой размер");
            return;
        }
        final MyPanel myPanel = button;
        game = new Game(myPanel, margin.length * margin[0].length);
        timer = new Timer(300 , this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(game.update()){
            timer.stop();
            JOptionPane.showMessageDialog(null , "Конец игры");
        }
    }
}
