package src.main;

import javax.swing.*;
import java.awt.event.*;

import src.main.Runner;

public class LaunchMenu extends JDialog {
    private JPanel contentPane;
    private JButton answerYES;
    private JButton buttonNO;

    public LaunchMenu() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(answerYES);

        answerYES.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonNO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        Runner r = new Runner();
        r.run();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        System.exit(1);
        dispose();
    }

    public static void main(String[] args) {
        LaunchMenu dialog = new LaunchMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
