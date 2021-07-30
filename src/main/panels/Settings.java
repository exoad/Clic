package src.main.panels;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class Settings extends JPanel implements ActionListener, Runnable {
  private final JFrame frame;
  private final JCheckBox test;

  public Settings() {
    URL windowIMG = ClassLoader.getSystemResource("assets/settings_panel/settings_icon.png");
    ImageIcon window_frame_icon = new ImageIcon(windowIMG);

    frame = new JFrame("Clic - Settings");
    frame.setIconImage(window_frame_icon.getImage());
    test = new JCheckBox("Test CheckBox", false);
    test.setAlignmentX(Component.CENTER_ALIGNMENT);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(600, 600));
    add(test);

    frame.add(this);
    frame.setAlwaysOnTop(true);
  }


  @Override
  public void run() {
    frame.pack();
    frame.setVisible(true);
  }

  public void askRun() {
    new Settings().run();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
   
    
  }
  
}
