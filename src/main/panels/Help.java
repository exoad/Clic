package src.main.panels;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.main.handler.ImageHandler;
/*
 * Awaiting Packages
 * import java.io.*;
 * import java.util.*;
 * import java.awt.event.*;
 */

public class Help extends JPanel implements Runnable {
    private final JFrame frame;
    private final JButton PAGEPREVIOUS, PAGENEXT;

    public Help() {
        frame = new JFrame("Help Menu");
        ImageIcon templar2 = new ImageIcon(ImageHandler.HLP_ICN.getVal());
        frame.setIconImage(templar2.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("--Helpful Handbook--");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        PAGEPREVIOUS = new JButton();
        PAGENEXT = new JButton();


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 100));

        add(title);

        frame.add(this);
    }
    @Override
    public void run() {
        frame.pack();
        frame.setVisible(true);
    }
    public void askRun() {
        new Help().run();
    }
    
}
