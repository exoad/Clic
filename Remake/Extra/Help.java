package Remake.Extra;

/*
 * TODO: Add better help menu
 */

import java.awt.*;
import javax.swing.*;

/*
 * Awaiting Packages
 * import java.io.*;
 * import java.util.*;
 * import java.awt.event.*;
 */

public class Help extends JPanel implements Runnable {
    private final JFrame frame;
    private final JLabel dis;

    public static void main(String[] args) {
        new Help();
    }
    public Help() {
        frame = new JFrame("Help Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
