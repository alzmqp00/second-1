package javaa.aawt;

import java.awt.*;
import java.awt.event.*;

public class Cal extends Frame implements ActionListener {
    static Cal frm = new Cal();
    static Label lab = new Label("DSG Calculator");
    static Label lab1 = new Label("0", Label.RIGHT);
    static Panel pan1 = new Panel(new GridLayout(3, 3));
    static Panel pan2 = new Panel(new GridLayout(4, 1));
    static Panel pan3 = new Panel(new GridLayout(2, 1, 0, 5));
    static Button num[] = new Button[9];
    static Button sign[] = new Button[4];
    static Button dot = new Button(".");
    static Button zero = new Button("0");
    static Button eq = new Button("=");
    static Button clea = new Button("Clear");

    static String strNum1 = "";
    static String strNum2 = "";
    static String strSign = "";

    static Double res = 0.0;

    public static void main(String agrs[]) {
        frm.setTitle("DSG Calculator");
        frm.setLayout(null);
        frm.setSize(600, 400);
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        lab1.setBounds(50, 60, 350, 60);
        lab.setBounds(450, 60, 150, 60);

        lab1.setBackground(new Color(240, 220, 190));
        lab1.setForeground(Color.black);

        lab1.setFont(new Font("Serief", Font.BOLD, 18));
        lab.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 16));

        frm.add(lab1);
        frm.add(lab);

        for (int i = 1; i <= 9; i++) {
            num[i - 1] = new Button(Integer.toString(i));
            num[i - 1].addActionListener(frm);
            pan1.add(num[i - 1]);
        }
        pan1.setFont(new Font("Serief", Font.BOLD, 18));
        pan2.setFont(new Font("Serief", Font.BOLD, 18));
        pan3.setFont(new Font("Serief", Font.BOLD, 18));
        zero.setFont(new Font("Serief", Font.BOLD, 18));
        dot.setFont(new Font("Serief", Font.BOLD, 18));

        sign[0] = new Button("+");
        sign[1] = new Button("-");
        sign[2] = new Button("*");
        sign[3] = new Button("/");
        for (int i = 0; i < 4; i++) {
            sign[i].addActionListener(frm);
            pan2.add(sign[i]);
        }
        pan3.add(eq);
        pan3.add(clea);
        eq.addActionListener(frm);
        clea.addActionListener(frm);

        frm.add(pan1);
        frm.add(pan2);
        frm.add(pan3);
        pan1.setBounds(50, 150, 250, 150);
        pan2.setBounds(325, 150, 75, 200);
        pan3.setBounds(425, 150, 150, 200);
        zero.setBounds(50, 300, 250 * 2 / 3, 50);
        dot.setBounds(250 * 2 / 3 + 50, 300, 250 / 3, 50);

        dot.addActionListener(frm);
        zero.addActionListener(frm);

        frm.add(dot);
        frm.add(zero);
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button btn = (Button) e.getSource();
        String str = btn.getLabel();
        if (str.equals("Clear")) {
            lab1.setText("0");
            strNum1 = "";
            strNum2 = "";
            strSign = "";

        } else if (str.equals("=")) {
            if (strSign.equals("+")) {
                res = Double.parseDouble(strNum1) + Double.parseDouble(strNum2);
            } else if (strSign.equals("-")) {
                res = Double.parseDouble(strNum1) - Double.parseDouble(strNum2);
            } else if (strSign.equals("*")) {
                res = Double.parseDouble(strNum1) * Double.parseDouble(strNum2);
            } else if (strSign.equals("/")) {
                res = Double.parseDouble(strNum1) / Double.parseDouble(strNum2);
            } else {
                res = Double.parseDouble(strNum1);
            }

            strNum1 = Double.toString(res);
            strNum2 = "";
            strSign = "";
            lab1.setText(String.valueOf(res));

            // lab1.setText(Double.toString(res));
            lab1.setText(String.valueOf(res));
        } else {

            if (str.equals("+")) {
                strSign = "+";
            } else if (str.equals("/")) {
                strSign = "/";
            } else if (str.equals("*")) {
                strSign = "*";
            } else if (str.equals("-")) {
                if (strNum1.equals(""))
                    strNum1 += "-";
                else if (strSign.equals("")) {
                    strSign = "-";
                } else if (strNum2.equals("")) {
                    strNum2 += "-";
                }
            } else {
                if (strSign.equals(""))
                    strNum1 += str;
                else
                    strNum2 += str;
            }
            if (strNum2.equals("")) {
                lab1.setText(strNum1);
            } else {
                lab1.setText(strNum2);
            }
        }
    }
}