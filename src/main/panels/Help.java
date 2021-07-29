/**
 * A simple Clicker game.
 * 
 * @author Jack Meng
 * @version 1.0z (EXP)
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
        PAGEPREVIOUS.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        PAGEPREVIOUS.setAlignmentX(Component.LEFT_ALIGNMENT);

        PAGENEXT = new JButton();
        PAGENEXT.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        PAGENEXT.setAlignmentX(Component.RIGHT_ALIGNMENT);


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
