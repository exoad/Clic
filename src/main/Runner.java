package src.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import src.main.schedulers.RunScheduler;
import src.main.panels.Help;
import src.main.schedulers.FileScheduler;
import src.main.handler.InputChoiceHandler;

public class Runner extends JPanel implements ActionListener, Runnable {
  // init values
  private final JFrame frame;
  private final JButton MAINX, UPGRADEA, SAVX, CHANGECOLOUR, RESETDATA, EXP;
  private final JLabel display, otherInfo, news, multiplier, objec, nextMultX;
  private int mainLabel, multX, objNum, multCost;
  private String mainText, displayStartText, save_dir;
  private File filX;
  private Random rd = new Random();
  private final FileScheduler fsr = new FileScheduler();

  public Runner() {
    // settings all the variables and components
    mainLabel = fsr.readMain();
    multX = fsr.readMult();
    objNum = fsr.readObj();
    multCost = fsr.readMultCost();

    save_dir = "click_game/";

    if (mainLabel != 0)
      displayStartText = "Current Count: " + mainLabel;
    else
      displayStartText = "Click the button";

    mainText = "Click Me!";

    frame = new JFrame("Clicker Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // settings values for JComponents
    objec = new JLabel("Current Click Objective:" + objNum);
    objec.setAlignmentX(Component.CENTER_ALIGNMENT);

    multiplier = new JLabel("Current Upgrade: " + multX);
    multiplier.setAlignmentX(Component.CENTER_ALIGNMENT);

    nextMultX = new JLabel("Next Upgrade Cost: " + multCost);
    nextMultX.setAlignmentX(Component.CENTER_ALIGNMENT);

    display = new JLabel(displayStartText);
    display.setAlignmentX(Component.CENTER_ALIGNMENT);

    news = new JLabel(randomNews());
    news.setAlignmentX(Component.CENTER_ALIGNMENT);

    otherInfo = new JLabel(" ");
    otherInfo.setVisible(true);
    otherInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

    UPGRADEA = new JButton("Upgrade (+1/click) Cost: " + multCost);
    UPGRADEA.setVisible(false);
    UPGRADEA.setBackground(Color.GREEN);
    UPGRADEA.addActionListener(this);
    UPGRADEA.setAlignmentX(Component.CENTER_ALIGNMENT);

    SAVX = new JButton("Save Content");
    SAVX.setBackground(Color.red);
    SAVX.addActionListener(this);
    SAVX.setAlignmentX(Component.CENTER_ALIGNMENT);

    MAINX = new JButton(mainText);
    MAINX.setBackground(Color.BLUE);
    MAINX.addActionListener(this);
    MAINX.setSize(new Dimension(100, 100));
    MAINX.setAlignmentX(Component.CENTER_ALIGNMENT);

    RESETDATA = new JButton("Reset");
    RESETDATA.setBackground(Color.LIGHT_GRAY);
    RESETDATA.addActionListener(this);
    RESETDATA.setAlignmentX(Component.CENTER_ALIGNMENT);

    CHANGECOLOUR = new JButton("Random Color");
    CHANGECOLOUR.setBackground(Color.WHITE);
    CHANGECOLOUR.setForeground(Color.BLACK);
    CHANGECOLOUR.addActionListener(this);
    CHANGECOLOUR.setAlignmentX(Component.CENTER_ALIGNMENT);

    EXP = new JButton("Exp");
    EXP.setBackground(Color.orange);
    EXP.addActionListener(this);
    EXP.setAlignmentX(Component.CENTER_ALIGNMENT);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(500, 500));

    add(MAINX);
    add(SAVX);
    add(UPGRADEA);
    add(CHANGECOLOUR);
    add(RESETDATA);
    add(news);
    add(display);
    add(multiplier);
    add(nextMultX);
    add(objec);
    add(otherInfo);
    add(EXP);

    frame.add(this);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.addWindowListener(new WindowListener() {
      @Override
      public void windowClosing(WindowEvent e) {
        JFrame frame = (JFrame)e.getSource();

        int options = JOptionPane.showConfirmDialog(frame, "You are about leave Click Game? Are you sure?", "ATTENTION", JOptionPane.YES_NO_OPTION);
        if(options == JOptionPane.YES_OPTION)
          System.out.print("Exited the Program");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      @Override
      public void windowOpened(WindowEvent e) {}
      @Override
      public void windowClosed(WindowEvent e) {}

      @Override
      public void windowIconified(WindowEvent e) {}

      @Override
      public void windowDeiconified(WindowEvent e) {}

      @Override
      public void windowActivated(WindowEvent e) {}

      @Override
      public void windowDeactivated(WindowEvent e) {}

    });
  }


  public static void main(String[] args) throws Exception {
    InputChoiceHandler sr = new InputChoiceHandler();
    Scanner sc = new Scanner(System.in);
    String s;
    do {
      System.out.print("\nLaunch? (y/n): ");
      s = sc.nextLine();
      if(sr.checkYN(s) == 0)
        new RunScheduler().RunnerCall();
        System.out.print("\nThe Program is now launched.");
        break;
    } while (sr.checkYN(s) != -1);
  }

  // Action Listener for much of the program's functions
  @Override
  public void actionPerformed(ActionEvent ex) {
    // main clicking of the button
    if (ex.getSource() == MAINX) {
      news.setText(randomNews());
      comparator(mainLabel + multX);

      if ((mainLabel + multX) >= objNum) {
        // setting the objectives
        objNum = objectives(objNum);
        mainLabel = mainLabel + (objNum / 5);
        objec.setText("New Click Objective: " + objNum);
      }

      mainLabel = mainLabel + multX;
      display.setText("Current Count: " + mainLabel);

    } else if (ex.getSource() == UPGRADEA) {
      // get an upgrade with a cost of multCost
      if (mainLabel >= multCost) {
        multX = multX + 1;
        mainLabel = mainLabel - multCost;
        multCost = multCost + (multCost);
        display.setText("Current Count: " + mainLabel);
        multiplier.setText("Current Upgrade: " + multX);
        nextMultX.setText("Upgrade Cost: " + multCost);
        otherInfo.setText("Purchased Upgrade");
      } else {
        otherInfo.setText("Invalid Count");
      }

    } else if (ex.getSource() == SAVX) {
      // call each method to store the values
      initGameFolder();
      fsr.storeMain(mainLabel);
      fsr.storeMult(multX);
      fsr.storeMultCost(multCost);
      fsr.storeObj(objNum);

      otherInfo.setText("Saved.");

    } else if (ex.getSource() == CHANGECOLOUR) {
      // changes the color randomly of the buttons when pressed
      MAINX.setBackground(
          new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
      if (UPGRADEA.isVisible())
        UPGRADEA.setBackground(
            new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
      SAVX.setBackground(
          new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
      RESETDATA.setBackground(
          new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));

    } else if (ex.getSource() == RESETDATA) {
      // this method reset all the data and deletes all files with data
      mainLabel = 0;
      multX = 1;
      objNum = 50;
      multCost = 100;
      File w = new File(save_dir + "mult.txt");
      File x = new File(save_dir + "clicks.txt");
      File y = new File(save_dir + "mult_cost.txt");
      File z = new File(save_dir + "objs.txt");
      if (w.exists() || x.exists() || y.exists() || z.exists()) {
        if (w.delete())
          System.out.printf("DELETED mult.txt %n");
        if (x.delete())
          System.out.printf("DELETED clicks.txt %n");
        if (y.delete())
          System.out.printf("DELETED mult_cost.txt %n");
        if (z.delete())
          System.out.printf("DELETED objs.txt %n");
        otherInfo.setText("Reset Success.");
      } else {
        otherInfo.setText("No Data Found.");
      }

    } else if (ex.getSource() == EXP) {
      try {
        Help h = new Help();
        h.askRun();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {

      news.setText(randomNews());
      UPGRADEA.setVisible(false);

    }
  }

  private String randomNews() {
    // this method returns a random text
    String[] allNews = { "That is a lot of Clicks!", "Keep Clicking!", "Is there an end?", "Never stop clicking",
        "Clicking...Clicking...", "Click Click Click" };
    int i = rd.nextInt(allNews.length);
    return allNews[i];
  }

  private int objectives(int o) {
    o = o * 2;
    return o;
  }

  private void comparator(int n) {
    if (n >= multCost) {
      UPGRADEA.setVisible(true);
      display.setText("Upgrade Avaliable. Cost: " + multCost);
    } else {
      display.setText("Insufficient Clicks");
    }
  }

  public void initGameFolder() {
    filX = new File("click_game");
    if (!filX.isDirectory())
      filX.mkdir();
  }

  @Override
  public void run() {
    frame.pack();
    frame.setVisible(true);
  }

}