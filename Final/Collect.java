package Final;
/*
 * package FinalProject;
 * 
 * Author: Jack Meng Class: Intro to Programming & Java Purpose: To create a
 * clicker game that uses the Swing packages, Buffered, and File packages to
 * demonstrate storing data to a .TXT file.
 * 
 * For extra information check the documentations
 */

import javax.swing.*;

public class Collect {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            //init the program
            JFrame frame = new JFrame("Clicking Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Controller userX = new Controller();
            frame.getContentPane().add(userX);

            frame.pack();
            frame.setVisible(true);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
