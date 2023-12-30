package javaa.awt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class app23_1 extends JFrame implements ActionListener {
    static app23_1 frm = new app23_1();
    static Button btn = new Button("Click Me!");
    static Container cp = frm.getContentPane();

    public static void main(String args[]) {
        cp.add(btn);
        cp.setLayout(new FlowLayout());
        cp.setBackground(Color.pink);
        btn.addActionListener(frm);
        frm.setTitle("Jframe範例");
        frm.setSize(200, 150);
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (cp.getBackground() == Color.pink) {
            cp.setBackground(Color.yellow);
        } else {
            cp.setBackground(Color.pink);
        }
    }
}