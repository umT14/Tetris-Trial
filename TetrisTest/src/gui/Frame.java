package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

    private static final int BOUND_X = 100;
    private static final int BOUND_Y = 100;
    private static final int BOUND_W = 200;
    private static final int BOUND_H = 500;

    private JPanel gamePanel;

    public Frame() {
        super();
        gamePanel = new GamePanel();
        gamePanel.setBackground(Color.CYAN);

        getContentPane().setLayout(new BorderLayout(20, 20));

        // setBounds(BOUND_X, BOUND_Y, BOUND_W, BOUND_H);
        // setSize(BOUND_W, BOUND_H);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(gamePanel, BorderLayout.CENTER);
        pack();

        setVisible(true);
    }
}
