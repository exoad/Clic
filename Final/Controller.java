package Final;
/*
 * package FinalProject;
 * 
 * Author: Jack Meng
 * Class: Intro to Programming & Java
 * Purpose: To create a clicker game that uses the Swing packages, Buffered, and File packages to demonstrate storing data to a .TXT file.
 */

//import all relevant packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Controller extends JPanel implements ActionListener {
    // init values
    private final JButton MAINX, UPGRADEA, SAVX, CHANGECOLOUR, RESETDATA;
    private JLabel display, otherInfo, news, multiplier, objec, nextMultX;
    private int mainLabel, multX, objNum, multCost;
    private BufferedReader br;
    private String mainText, li, toFile, displayStartText;
    private File filX;
    private Random rd = new Random();
    private FileWriter fw;

    public Controller() {
        // settings all the variables and components
        mainLabel = readMain();
        multX = readMult();
        objNum = readObj();
        multCost = readMultCost();
        if (mainLabel != 0)
            displayStartText = "Current Count: " + mainLabel;
        else
            displayStartText = "Click the button";

        mainText = "Click Me!";

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

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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

        setPreferredSize(new Dimension(500, 500));

    }

    // Action Listener for much of the program's functions
    @Override
    public void actionPerformed(ActionEvent ex) {
        // main clicking of the button
        if (ex.getSource() == MAINX) {
            news.setText(randomNews());
            comparator(mainLabel + multX, true);

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
            storeMain();
            storeMult();
            storeMultCost();
            storeObj();

            otherInfo.setText("Saved.");

        } else if (ex.getSource() == CHANGECOLOUR) {
            // changes the color randomly of the buttons when pressed
            MAINX.setBackground(
                    new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
            if (UPGRADEA.isVisible())
                UPGRADEA.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256),
                        (int) (Math.random() * 256)));
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
            File w = new File("USERMULT.txt");
            File x = new File("USERSAVE.txt");
            File y = new File("USERMULTCOST.txt");
            File z = new File("USEROBJ.txt");
            if (w.exists() || x.exists() || y.exists() || z.exists()) {
                if (w.delete())
                    System.out.printf("DELETED USERMULT.txt %n");
                if (x.delete())
                    System.out.printf("DELETED USERSAVE.txt %n");
                if (y.delete())
                    System.out.printf("DELETED USERMULTCOST.txt %n");
                if (z.delete())
                    System.out.printf("DELETED USEROBJ.txt %n");
                otherInfo.setText("Reset Success.");
            } else {
                otherInfo.setText("No Data Found.");
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

    private int readMain() {
        try {
            String str;
            if (!new File("USERSAVE.txt").exists()) {
                return 0;
            }
            br = new BufferedReader(new FileReader("USERSAVE.txt"));

            while ((str = br.readLine()) != null) {
                return Integer.parseInt(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int readMult() {
        try {
            String str;
            if (!new File("USERMULT.txt").exists() || br.readLine() == null) {
                return 1;
            }
            br = new BufferedReader(new FileReader("USERMULT.txt"));

            while ((str = br.readLine()) != null) {
                return Integer.parseInt(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    private int readMultCost() {
        try {
            String str;
            if (!new File("USERMULTCOST.txt").exists() || br.readLine() == null) {
                return 100;
            }
            br = new BufferedReader(new FileReader("USERMULTCOST.txt"));

            while ((str = br.readLine()) != null) {
                return Integer.parseInt(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 100;
    }

    private int readObj() {
        try {
            String str;
            if (!new File("USEROBJ.txt").exists() || br.readLine() == null) {
                return 50;
            }
            br = new BufferedReader(new FileReader("USEROBJ.txt"));

            while ((str = br.readLine()) != null) {
                return Integer.parseInt(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 50;
    }

    private int comparator(int n, boolean isit) {
        if (isit == true) {
            if (n >= multCost) {
                UPGRADEA.setVisible(true);
                display.setText("Upgrade Avaliable. Cost: " + multCost);
                return 1;
            } else {
                display.setText("Insufficient Clicks");
            }
        } else {
            return 2;
        }
        return 0;
    }

    // this void method stores the mainlabel value currently into a txt file
    private void storeMain() {
        String userDat = Integer.toString(mainLabel);
        String oldDat = "";
        filX = new File("USERSAVE.txt");
        try {
            if (!filX.exists())
                filX.createNewFile();
            br = new BufferedReader(new FileReader(filX));
            li = br.readLine();
            while (li != null) {
                oldDat = oldDat + li + System.lineSeparator();
                li = br.readLine();
            }
            toFile = oldDat.replaceAll(oldDat, userDat);
            fw = new FileWriter(filX);
            fw.write(toFile);
        } catch (IOException ev) {
            ev.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }

    // this is a void method and when called stores the current value of multX
    private void storeMult() {
        news.setText(randomNews());
        String userDat = Integer.toString(multX);
        String oldDat = "";
        filX = new File("USERMULT.txt");
        try {
            if (!filX.exists())
                filX.createNewFile();
            br = new BufferedReader(new FileReader(filX));
            li = br.readLine();
            while (li != null) {
                oldDat = oldDat + li + System.lineSeparator();
                li = br.readLine();
            }
            toFile = oldDat.replaceAll(oldDat, userDat);
            fw = new FileWriter(filX);
            fw.write(toFile);
        } catch (IOException ev) {
            ev.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }

    // this void method stores the multcost var into a txt file of name USERMULTCOST
    private void storeMultCost() {
        news.setText(randomNews());
        String userDat = Integer.toString(multCost);
        String oldDat = "";
        filX = new File("USERMULTCOST.txt");
        try {
            if (!filX.exists())
                filX.createNewFile();
            br = new BufferedReader(new FileReader(filX));
            li = br.readLine();
            while (li != null) {
                oldDat = oldDat + li + System.lineSeparator();
                li = br.readLine();
            }
            toFile = oldDat.replaceAll(oldDat, userDat);
            fw = new FileWriter(filX);
            fw.write(toFile);
        } catch (IOException ev) {
            ev.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }

    // this method stores info on the objective cases to a text file
    private void storeObj() {
        news.setText(randomNews());
        String userDat = Integer.toString(objNum);
        String oldDat = "";
        filX = new File("USEROBJ.txt");
        try {
            if (!filX.exists())
                filX.createNewFile();
            br = new BufferedReader(new FileReader(filX));
            li = br.readLine();
            while (li != null) {
                oldDat = oldDat + li + System.lineSeparator();
                li = br.readLine();
            }
            toFile = oldDat.replaceAll(oldDat, userDat);
            fw = new FileWriter(filX);
            fw.write(toFile);
        } catch (IOException ev) {
            ev.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }

}
