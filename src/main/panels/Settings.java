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

package src.main.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.main.Runner;
import src.main.schedulers.ActionLogger;
import src.main.elements.RndColor;

public class Settings extends JPanel implements Runnable {
  private final JFrame frame;
  private final JButton WIPELOGS, CHANGECOLOUR;
  private final Runner tester;

  public Settings() {
    tester = new Runner();

    frame = new JFrame("Clic - Settings");
    URL windowIMG = ClassLoader.getSystemResource("assets/settings_panel/settings_icon.png");
    ImageIcon window_frame_icon = new ImageIcon(windowIMG);
    frame.setIconImage(window_frame_icon.getImage());

    URL RND_CLICK = ClassLoader.getSystemResource("assets/runner_panel/random_color_click_button.png");
    Icon RND_CLICK_IMG = new ImageIcon(RND_CLICK);

    CHANGECOLOUR = new JButton("Random Color", RND_CLICK_IMG);
    CHANGECOLOUR.setBackground(Color.WHITE);
    CHANGECOLOUR.setForeground(Color.BLACK);
    CHANGECOLOUR.addActionListener(new SettingsListener());
    CHANGECOLOUR.setAlignmentX(Component.CENTER_ALIGNMENT);

    WIPELOGS = new JButton("Destroy logs");
    WIPELOGS.addActionListener(new SettingsListener());
    WIPELOGS.setAlignmentX(Component.CENTER_ALIGNMENT);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(600, 600));
    add(WIPELOGS);
    add(CHANGECOLOUR);

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

  private class SettingsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      RndColor rd = new RndColor();
      if (e.getSource() == WIPELOGS) {
        try {
          new ActionLogger().wipeLogs();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      } else if (e.getSource() == CHANGECOLOUR) {
        new src.main.panels.Help().setBackground(rd.returnRND());
        tester.UPGRADEA.setBackground(rd.returnRND());
        tester.RESETDATA.setBackground(rd.returnRND());
        tester.MAINX.setBackground(rd.returnRND());
        tester.SAVX.setBackground(rd.returnRND());
        tester.SETTINGS.setBackground(rd.returnRND());
        tester.EXP.setBackground(rd.returnRND());

        tester.frame.getContentPane().setBackground(rd.returnRND());
      }
    }
  }
}
