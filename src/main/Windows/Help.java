package Extra.Windows;

/*
 * TODO: Add better help menu
 */
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Awaiting Packages
 * import java.io.*;
 * import java.util.*;
 * import java.awt.event.*;
 */

public class Help extends JPanel implements Runnable {
    private final JFrame frame;
    private final JLabel title;
    private final JButton readHelpAsTXT;

    public Help() {
        frame = new JFrame("Help Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        title = new JLabel("--Helpful Handbook--");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        readHelpAsTXT = new JButton("Read As TxT");
        readHelpAsTXT.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 100));

        add(title);
        add(readHelpAsTXT);

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
