package javaa.awt;

import java.awt.*;

public class tesr {
    static Frame frm = new Frame();
    static Label lab = new Label("Hello World");

    public static void main(String[] args) {
        frm.setLayout(new FlowLayout());
        frm.setTitle("tesr");
        frm.setSize(200, 150);
        frm.setBackground(Color.yellow);
        lab.setBackground(Color.red);
        lab.setAlignment(Label.CENTER);
        frm.add(lab);
        frm.setVisible(true);
    }
}
