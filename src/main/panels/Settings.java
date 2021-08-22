/**
 * A simple Clicker game.
 * 
 * @author Jack Meng
 * @version 1.2 (EXP) (EXP)
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

package main.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.schedulers.ActionLogger;

public class Settings extends JPanel implements ActionListener, Runnable {
  private final JFrame frame;
  private final JButton WIPELOGS, HELPMENU, RESETDATA, SAVEDATA;


  public Settings() {
    URL windowIMG = ClassLoader.getSystemResource("assets/settings_panel/settings_icon.png");
    URL resetIMG = ClassLoader.getSystemResource("assets/runner_panel/reset_save_click_button.png");
    URL saveIMG = ClassLoader.getSystemResource("assets/runner_panel/save_click_button.png");

    ImageIcon window_frame_icon = new ImageIcon(windowIMG);
    Icon resetIcon = new ImageIcon(resetIMG);
    Icon saveIcon = new ImageIcon(saveIMG);

    frame = new JFrame("Clic - Settings");
    WIPELOGS = new JButton("Destroy logs");
    RESETDATA = new JButton("Reset Save", resetIcon);
    HELPMENU = new JButton("Help");
    
    frame.setIconImage(window_frame_icon.getImage());

    frame.setResizable(false);
    
    WIPELOGS.addActionListener(this);
    RESETDATA.addActionListener(this);
    HELPMENU.addActionListener(this);

    WIPELOGS.setAlignmentX(Component.CENTER_ALIGNMENT);
    HELPMENU.setAlignmentX(Component.CENTER_ALIGNMENT);
    RESETDATA.setAlignmentX(Component.CENTER_ALIGNMENT);

    WIPELOGS.setBackground(Color.blue);
    HELPMENU.setBackground(Color.orange);
    RESETDATA.setBackground(Color.red);
    
    SAVEDATA = new JButton("Save", saveIcon);
    SAVEDATA.setBackground(Color.blue);
    SAVEDATA.setAlignmentX(Component.CENTER_ALIGNMENT);
    SAVEDATA.addActionListener(this);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(300, 150));
    add(WIPELOGS);
    add(HELPMENU);
    add(RESETDATA);
    add(SAVEDATA);

    add(SAVEDATA);

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
  /**
   * @param e : The Action being either sent by `this` panel or the panel outside, ig Runner panel
   */
  public void actionPerformed(ActionEvent e) {
    /**
     * @exoad : delete code that is unnn
     */
    if (e.getSource() == WIPELOGS) {
      try {
        new ActionLogger().wipeLogs();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    } else if(e.getSource() == HELPMENU) {
      new main.panels.Help().askRun();
    } else if(e.getSource() == SAVEDATA) {
      System.out.println("idk");
    }
    /*else if(e.getSource() == RESETDATA) {
      mainLabel = 0;
      multX = 1;
      multCost = 100;
      objNum = 50;
      gotUpgrade = 0;
      display.setText("Current Count: " + mainLabel);
      multiplier.setText("Current Upgrade: " + multX);
      nextMultX.setText("Upgrade Cost: " + multCost);
      objec.setText("Current Objective: " + objNum);
      new src.main.panels.Help().askRun();
    } else if(e.getSource() == RESETDATA) {
      float newMainx = 0;
      float newMult = 1;
      float newObjNum = 50;
      float newMultCost = 100;
      rr.display.setText("Current Count: " + newMainx);
      rr.multiplier.setText("Current Upgrade: " + newMult);
      rr.nextMultX.setText("Upgrade Cost: " + newMultCost);
      rr.objec.setText("Current Objective: " + newObjNum);

      if (fsr.resetData())
        System.out.println("\nALL DATA RESET");
      else
        System.out.println("\nError Encountered while reseting");
    }
    */

  }
}
