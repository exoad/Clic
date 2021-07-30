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
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.main.Runner;

public class Settings extends JPanel implements ActionListener, Runnable {
  private final JFrame frame;
  private JButton THEMEMODE;
  private final Runner tester;
  private final URL windowIMG = ClassLoader.getSystemResource("assets/settings_panel/settings_icon.png");
  private final URL checkedCheckBoxIMG = ClassLoader.getSystemResource("assets/settings_panel/selected_checkbox.png");
  private final URL uncheckCheckBoxIMG = ClassLoader.getSystemResource("assets/settings_panel/unselected_checkbox.png");
  private final URL nullCheckBoxIMG = ClassLoader.getSystemResource("assets/settings_panel/null_checkbox.png");

  private final ImageIcon window_frame_icon = new ImageIcon(windowIMG);
  private final Icon checkbox_checked = new ImageIcon(checkedCheckBoxIMG);
  private final Icon checkbox_unchecked = new ImageIcon(uncheckCheckBoxIMG);
  private final Icon checkbox_null = new ImageIcon(nullCheckBoxIMG);

  public Settings() {
    tester = new Runner();

    frame = new JFrame("Clic - Settings");
    frame.setIconImage(window_frame_icon.getImage());

    if(tester.getBackground() == new Color(40, 44, 52)) 
      THEMEMODE = new JButton("Light Mode", checkbox_unchecked);
    else
      THEMEMODE = new JButton("Dark Mode", checkbox_checked);
    THEMEMODE.setIcon(checkbox_unchecked);
    THEMEMODE.setSelectedIcon(checkbox_checked);
    THEMEMODE.setPressedIcon(checkbox_checked);
    THEMEMODE.setDisabledIcon(checkbox_null);
    THEMEMODE.setDisabledSelectedIcon(checkbox_null);
    THEMEMODE.setAlignmentX(Component.CENTER_ALIGNMENT);
    THEMEMODE.addActionListener(this);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(600, 600));
    add(THEMEMODE);

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
    /*
    //change the themes of the runner panel
    if(e.getSource() == THEMEMODE) {
      if (tester.getBackground() == new Color(40, 44, 52)) {
        THEMEMODE = new JButton("Light Mode", checkbox_unchecked);
        tester.setBackground(new Color(40, 44, 52));
      } else {
        THEMEMODE = new JButton("Dark Mode", checkbox_checked);
        tester.setBackground(new Color(40, 44, 52));
        tester.re
      }
      System.out.println("\nTheme changed");
    }
    */
  }
  
}
