/**
 *           _____                    _____            _____                    _____          
 *          /\    \                  /\    \          /\    \                  /\    \         
 *         /::\    \                /::\____\        /::\    \                /::\    \        
 *        /::::\    \              /:::/    /        \:::\    \              /::::\    \       
 *       /::::::\    \            /:::/    /          \:::\    \            /::::::\    \      
 *      /:::/\:::\    \          /:::/    /            \:::\    \          /:::/\:::\    \     
 *     /:::/  \:::\    \        /:::/    /              \:::\    \        /:::/  \:::\    \    
 *    /:::/    \:::\    \      /:::/    /               /::::\    \      /:::/    \:::\    \   
 *   /:::/    / \:::\    \    /:::/    /       ____    /::::::\    \    /:::/    / \:::\    \  
 *  /:::/    /   \:::\    \  /:::/    /       /\   \  /:::/\:::\    \  /:::/    /   \:::\    \ 
 * /:::/____/     \:::\____\/:::/____/       /::\   \/:::/  \:::\____\/:::/____/     \:::\____\
 * \:::\    \      \::/    /\:::\    \       \:::\  /:::/    \::/    /\:::\    \      \::/    /
 *  \:::\    \      \/____/  \:::\    \       \:::\/:::/    / \/____/  \:::\    \      \/____/ 
 *   \:::\    \               \:::\    \       \::::::/    /            \:::\    \             
 *    \:::\    \               \:::\    \       \::::/____/              \:::\    \            
 *     \:::\    \               \:::\    \       \:::\    \               \:::\    \           
 *      \:::\    \               \:::\    \       \:::\    \               \:::\    \          
 *       \:::\    \               \:::\    \       \:::\    \               \:::\    \         
 *        \:::\____\               \:::\____\       \:::\____\               \:::\____\        
 *         \::/    /                \::/    /        \::/    /                \::/    /        
 *          \/____/                  \/____/          \/____/                  \/____/       
 * A simple Clicker game.
 *
 * @author Jack Meng
 * @version 1.2 (EXP)
 *
 * BSD 3-Clause License
 *
 * Copyright (c) 2021, Jack Meng
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 */
package src.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import src.main.elements.InfoBox;
import src.main.handler.InputChoiceHandler;
import src.main.panels.Help;
import src.main.panels.Settings;
import src.main.schedulers.ActionLogger;
import src.main.schedulers.FileScheduler;
import src.main.schedulers.RunScheduler;

public class Runner extends JPanel implements ActionListener, Runnable {
  public JFrame frame;
  public JButton MAINX, UPGRADEA, SAVX, RESETDATA, EXP, SETTINGS;
  public JLabel display;
  public static JLabel otherInfo;
  public static JLabel news;
  public JLabel multiplier;
  public JLabel objec;
  public JLabel nextMultX;
  private static int mainLabel;
  private static int multX;
  private static int objNum;
  private static int multCost;
  private static int gotUpgrade;
  private final static FileScheduler fsr = new FileScheduler();

  /**
   * @Test Runner main
   */
  public Runner() {
    URL MAIN_CLICK = ClassLoader.getSystemResource("assets/runner_panel/main_click_button.png");
    URL UPD_CLICK = ClassLoader.getSystemResource("assets/runner_panel/upgrade_click_button.png");
    Icon MAIN_CLICK_IMG = new ImageIcon(MAIN_CLICK);
    Icon UPD_CLICK_IMG = new ImageIcon(UPD_CLICK);
    UPGRADEA = new JButton("Upgrade (+1/click) Cost: " + multCost, UPD_CLICK_IMG);
    if(Integer.parseInt(fsr.readLineNumber(4)) == 1) {
      UPGRADEA.setVisible(true);
      gotUpgrade = 1;
    } else {
      UPGRADEA.setVisible(false);
      gotUpgrade = 0;
    }
    UPGRADEA.setBackground(Color.GREEN);
    UPGRADEA.addActionListener(this);
    UPGRADEA.setAlignmentX(Component.CENTER_ALIGNMENT);

    // settings all the variables and components
    if (Integer.parseInt(fsr.readLineNumber(0)) != 0 && Integer.parseInt(fsr.readLineNumber(1)) != 0
        && Integer.parseInt(fsr.readLineNumber(2)) != 0 && Integer.parseInt(fsr.readLineNumber(3)) != 0) {
      mainLabel = Integer.parseInt(fsr.readLineNumber(0));
      if (mainLabel >= 100)
        UPGRADEA.setVisible(true);
      multX = Integer.parseInt(fsr.readLineNumber(1));
      objNum = Integer.parseInt(fsr.readLineNumber(2));
      multCost = Integer.parseInt(fsr.readLineNumber(3));
    } else {
      mainLabel = 0;
      multX = 1;
      objNum = 50;
      multCost = 100;
    }

    String displayStartText;
    if (mainLabel != 0)
      displayStartText = "Current Count: " + mainLabel;
    else
      displayStartText = "Click the button";

    String mainText = "Click Me!";
    URL frTem = ClassLoader.getSystemResource("assets/runner_panel/mainframe_icon.png");
    ImageIcon Templar1 = new ImageIcon(frTem);
    frame = new JFrame("Clic 1.2EXP");
    frame.setIconImage(Templar1.getImage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // settings values for JComponents
    objec = new JLabel("Current Click Objective: " + objNum);
    objec.setAlignmentX(Component.CENTER_ALIGNMENT);

    multiplier = new JLabel("Current Upgrade: " + multX);
    multiplier.setAlignmentX(Component.CENTER_ALIGNMENT);

    nextMultX = new JLabel("Next Upgrade Cost: " + multCost);
    nextMultX.setAlignmentX(Component.CENTER_ALIGNMENT);

    display = new JLabel(displayStartText);
    display.setAlignmentX(Component.CENTER_ALIGNMENT);

    news = new JLabel(new InfoBox().randomNews());
    news.setAlignmentX(Component.CENTER_ALIGNMENT);

    otherInfo = new JLabel(" ");
    otherInfo.setVisible(true);
    otherInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

    URL SAVE_CLICK = ClassLoader.getSystemResource("assets/runner_panel/save_click_button.png");
    Icon SAVE_CLICK_IMG = new ImageIcon(SAVE_CLICK);

    SAVX = new JButton("Save", SAVE_CLICK_IMG);
    SAVX.setBackground(Color.red);
    SAVX.addActionListener(this);
    SAVX.setAlignmentX(Component.CENTER_ALIGNMENT);

    MAINX = new JButton(mainText, MAIN_CLICK_IMG);
    MAINX.setBackground(Color.BLUE);
    MAINX.addActionListener(this);
    MAINX.setSize(new Dimension(100, 100));
    MAINX.setAlignmentX(Component.CENTER_ALIGNMENT);

    URL RST_CLICK = ClassLoader.getSystemResource("assets/runner_panel/reset_save_click_button.png");
    Icon RSTSAV_CLICK_IMG = new ImageIcon(RST_CLICK);

    RESETDATA = new JButton("Reset", RSTSAV_CLICK_IMG);
    RESETDATA.setBackground(Color.LIGHT_GRAY);
    RESETDATA.addActionListener(this);
    RESETDATA.setAlignmentX(Component.CENTER_ALIGNMENT);



    EXP = new JButton("Help Menu");
    EXP.setBackground(Color.orange);
    EXP.addActionListener(this);
    EXP.setAlignmentX(Component.CENTER_ALIGNMENT);

    SETTINGS = new JButton("Settings Menu");
    SETTINGS.setBackground(Color.gray);
    SETTINGS.addActionListener(this);
    SETTINGS.setAlignmentX(Component.CENTER_ALIGNMENT);

    SETTINGS.setOpaque(true);
    EXP.setOpaque(true);
    MAINX.setOpaque(true);
    UPGRADEA.setOpaque(true);
    RESETDATA.setOpaque(true);
    SAVX.setOpaque(true);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(500, 500));

    add(MAINX);
    add(SAVX);
    add(UPGRADEA);
    add(RESETDATA);
    add(news);
    add(display);
    add(multiplier);
    add(nextMultX);
    add(objec);
    add(otherInfo);
    add(EXP);
    add(SETTINGS);

    frame.add(this);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.addWindowListener(new WindowListener() {
      @Override
      public void windowClosing(WindowEvent e) {
        JFrame frame = (JFrame) e.getSource();

        int options = JOptionPane.showConfirmDialog(frame,
            "Are you sure you want to leave Click Game?\nYour progress is currently saved to the last time you pressed SAVE",
            "ATTENTION", JOptionPane.YES_NO_OPTION);
        if (options == JOptionPane.YES_OPTION)
          System.out.print("Exited the Program");
          try {
            new ActionLogger().Log("Exited the program");
          } catch (IOException e1) {
            e1.printStackTrace();
          }
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      @Override
      public void windowOpened(WindowEvent e) {
      }

      @Override
      public void windowClosed(WindowEvent e) {
      }

      @Override
      public void windowIconified(WindowEvent e) {
      }

      @Override
      public void windowDeiconified(WindowEvent e) {
      }

      @Override
      public void windowActivated(WindowEvent e) {
      }

      @Override
      public void windowDeactivated(WindowEvent e) {
      }

    });
  }

  public static void main(String[] args) throws Exception {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e2) {
      e2.printStackTrace();
    }
    new ActionLogger().Log("Program Started");
    FileScheduler fsb = new FileScheduler();
    fsb.createNoticeFile();
    initGameFolder();
    InputChoiceHandler sr = new InputChoiceHandler();
    Scanner sc = new Scanner(System.in);
    String s;
    do {
      System.out.print("\nLaunch? (y/n): ");
      s = sc.nextLine();
      if (sr.checkYN(s) == 0)
        new RunScheduler().RunnerCall();
      System.out.print("\nThe Program is now launched.");
      break;
    } while (sr.checkYN(s) != -1);
    sc.close();

    // constants
    while (true) {
      Thread.sleep(4000);
      news.setText(new InfoBox().randomNews());
      fsr.write(mainLabel, multX, multCost, objNum, gotUpgrade);
      otherInfo.setText("Auto saved.");
      Thread.sleep(1000);
      otherInfo.setText(null);

    }
  }

  /**
   * @param ex event recieved from this class
   */
  @Override
  public void actionPerformed(ActionEvent ex) {
    try {
      new ActionLogger().Log(ex.toString());
      // main clicking of the button
      if (ex.getSource() == MAINX) {
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
          gotUpgrade = 1;
          multX = multX + 1;
          mainLabel = mainLabel - multCost;
          multCost = multCost + (multCost);
          display.setText("Current Count: " + mainLabel);
          multiplier.setText("Current Upgrade: " + multX);
          nextMultX.setText("Upgrade Cost: " + multCost);
          otherInfo.setText("Purchased Upgrade");
          UPGRADEA.setText("Upgrade (+1/click) Cost: " + multCost);
        } else {
          gotUpgrade = 0;
          otherInfo.setText("Invalid Count");
        }

      } else if (ex.getSource() == SAVX) {
        try {
          otherInfo.setText("Manually Saving...");
          fsr.write(mainLabel, multX, multCost, objNum, gotUpgrade);
          Thread.sleep(2000);
          otherInfo.setText("Manual Save Done.");
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
        }

        otherInfo.setText("Saved.");

      } else if (ex.getSource() == RESETDATA) {
        // this method reset all the data and deletes all files with data
        mainLabel = 0;
        multX = 1;
        objNum = 50;
        multCost = 100;
        display.setText("Current Count: " + mainLabel);
        multiplier.setText("Current Upgrade: " + multX);
        nextMultX.setText("Upgrade Cost: " + multCost);
        objec.setText("Current Objective: " + objNum);

        if (fsr.resetData())
          System.out.println("\nALL DATA RESET");
        else
          System.out.println("\nError Encountered while reseting");

      } else if (ex.getSource() == EXP) {
        try {
          new Help().askRun();
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else if (ex.getSource() == SETTINGS) {
        try {
          new Settings().askRun();
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        UPGRADEA.setVisible(false);
      }
    } catch (IOException e) {
      try {
        new ActionLogger().Log(e.toString());
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
  }

  private int objectives(int o) {
    return o * 2;
  }

  private void comparator(int n) {
    if (n >= multCost) {
      gotUpgrade = 1;
      UPGRADEA.setVisible(true);
      display.setText("Upgrade Avaliable. Cost: " + multCost);
    } else {
      gotUpgrade = 0;
      display.setText("Insufficient Clicks");
    }
  }

  public static void initGameFolder() throws IOException {
    
    File filXB = new File("click_game/program_assets/");
    File fileyB = new File("click_game/program_properties");
    File filezB = new File("click_game/logs");
    if (!filXB.isDirectory())
      filXB.mkdirs();
      fileyB.mkdirs();
      filezB.mkdirs();
      new ActionLogger().Log(filXB.toString() + "," + fileyB.toString() + "," + filezB.toString() + " Created");
  }

  @Override
  public void run() {
    frame.pack();
    frame.setVisible(true);
  }


}
