package javaa.aawt;

import java.awt.*;
import java.awt.event.*;

public class BMI extends Frame implements ActionListener {
    static BMI frm = new BMI();
    static Label lab1 = new Label("名字");
    static Label lab2 = new Label("體重");
    static Label lab3 = new Label("身高");
    static Label lab4 = new Label("性別");
    static Label lab5 = new Label("年齡");
    static Label lab6 = new Label("cm");
    static Label lab7 = new Label("kg");
    static Label labBMI = new Label();
    static TextField txt1 = new TextField();
    static TextField txt2 = new TextField("55");
    static TextField txt3 = new TextField("170");
    static Button btn1 = new Button("計算");
    static Button btn2 = new Button("離開");
    static CheckboxGroup cbg = new CheckboxGroup();
    static Checkbox cb1 = new Checkbox("男", cbg, true);
    static Checkbox cb2 = new Checkbox("女", cbg, false);
    static Choice ch = new Choice();
    static int bmi = 0;

    public static void main(String args[]) {
        frm.setTitle("BMI計算");
        frm.setLayout(null);
        frm.setSize(400, 500);
        lab1.setBounds(50, 50, 30, 20);
        lab2.setBounds(50, 90, 30, 20);
        lab3.setBounds(50, 130, 30, 20);
        lab4.setBounds(50, 170, 30, 20);
        lab5.setBounds(50, 210, 30, 20);
        frm.add(lab1);
        frm.add(lab2);
        frm.add(lab3);
        frm.add(lab4);
        frm.add(lab5);
        frm.add(lab6);
        frm.add(lab7);

        frm.add(txt1);
        frm.add(txt2);
        frm.add(txt3);

        txt1.setBounds(100, 50, 140, 20);
        txt2.setBounds(100, 90, 140, 20);
        txt3.setBounds(100, 130, 140, 20);

        cb1.setBounds(100, 170, 30, 20);
        cb2.setBounds(200, 170, 30, 20);
        frm.add(cb1);
        frm.add(cb2);

        ch.setBounds(100, 210, 100, 20);
        for (int i = 1; i <= 100; i++)
            ch.add(Integer.toString(i));
        frm.add(ch);
        btn1.setBounds(50, 250, 150, 30);
        btn2.setBounds(250, 250, 100, 30);
        frm.add(btn1);
        frm.add(btn2);
        btn1.addActionListener(frm);
        labBMI.setBounds(50, 300, 300, 50);
        labBMI.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
        frm.add(labBMI);
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO 自動產生的方法 Stub
        bmi = Integer.parseInt(txt2.getText()) * 10000 / (Integer.parseInt(txt3.getText()))
                / (Integer.parseInt(txt3.getText()));
        labBMI.setText("你的BMI是" + Integer.toString(bmi));
    }
}
