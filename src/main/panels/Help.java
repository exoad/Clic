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
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help extends JPanel implements Runnable, ActionListener {
    private final JFrame frame;
    private final JButton VIEWMENU;

    public Help() {
        frame = new JFrame("Help Menu");
        frame.setResizable(false);
        URL vM = ClassLoader.getSystemResource("assets/help_panel/browser_click_button.png");
        Icon VMENU = new ImageIcon(vM);

        URL templar2 = ClassLoader.getSystemResource("assets/help_panel/help_icon.png");
        ImageIcon temp2 = new ImageIcon(templar2);
        frame.setIconImage(temp2.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("--View Menu In Your Default Browser--");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        VIEWMENU = new JButton("View Help", VMENU);
        VIEWMENU.setAlignmentX(Component.CENTER_ALIGNMENT);
        VIEWMENU.setBackground(Color.ORANGE);
        VIEWMENU.addActionListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 100));

        add(title);
        add(VIEWMENU);

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

    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ex) {
        // open the help menu in the client's default browser
        if (ex.getSource() == VIEWMENU) {
            try {
                openWebpage(new URL("https://github.com/exoad/ClickGame/wiki"));
            } catch (MalformedURLException e) {
                System.out.println(
                        "Something went horribly wrong when trying to open the Help Menu in your default browser!\n\n\n");
                e.printStackTrace();
            }
        }

    }

}
