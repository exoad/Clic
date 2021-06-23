package Remake.Extra;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Help extends JPanel implements Runnable {
    private final JFrame frame;
    private final JLabel dis;

    public static void main(String[] args) {
        new Help().run();

    }
    public Help() {
        frame = new JFrame("Help Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dis = new JLabel("Work in Progress");
        dis.setAlignmentX(Component.CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(500, 500));

        add(dis);

        frame.add(this);
    }
    @Override
    public void run() {
        frame.pack();
        frame.setVisible(true);
    }

    
}
