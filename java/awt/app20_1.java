
package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class app20_1 extends Frame implements ActionListener {
    static app20_1 frm = new app20_1();
    static Button btn = new Button("Draw");
    boolean clicked = false;

    public static void main(String args[]) {
        frm.setLayout(new BorderLayout());
        frm.setTitle("Drawing Example");
        frm.setSize(200, 150);
        frm.add(btn, BorderLayout.SOUTH);
        btn.addActionListener(frm);
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        clicked = true;
        Graphics g = getGraphics();
        // g.drawRect(100, 50, 70, 55);
        paint(g);

    }

    public void paint(Graphics g) {
        if (clicked)
            g.drawRect(100, 50, 70, 55);
    }
}