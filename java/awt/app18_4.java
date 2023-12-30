package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class app18_4 extends Frame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = -5636750555572673920L;
    static app18_4 frm = new app18_4();
    static Button btn1 = new Button("Yellow");
    static Button btn2 = new Button("Green");
    static Button btn3 = new Button("Exit");

    public static void main(String args[]) {
        frm.setTitle("123");
        frm.setLayout(new FlowLayout(FlowLayout.CENTER));
        frm.setSize(200, 150);
        frm.add(btn1);
        frm.add(btn2);
        frm.add(btn3);

        btn1.addActionListener(frm); // 把事件處理器註冊到 btn1 按鈕
        btn2.addActionListener(frm);
        btn3.addActionListener(frm);// 把事件處理器
        frm.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        Button btn = (Button) e.getSource();

        if (btn == btn1) {
            frm.setBackground(Color.yellow);
        } else if (btn == btn2) {
            frm.setBackground(Color.blue);

        } else {
            System.exit(0);
        }
    }
}
