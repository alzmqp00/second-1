package javaa.awt;

// app20_6, brighter()函數darker()的使用
import java.awt.*;
import java.awt.event.*;

class app20_6 extends Frame implements ActionListener {
    static app20_6 frm = new app20_6();
    static Button btn1 = new Button("Brighter"); // Brighter按鈕
    static Button btn2 = new Button("Darker"); // Darker按鈕
    Color co = new Color(255, 255, 255); // 設定顏色的初始值

    public static void main(String args[]) {
        frm.setTitle("Brighter & Darker");
        frm.setLayout(new FlowLayout());
        frm.setSize(200, 150);
        frm.add(btn1);
        frm.add(btn2);

        btn1.addActionListener(frm); // Brighter按鈕監聽器
        btn2.addActionListener(frm); // Darker按鈕監聽器
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) // 按下「Brighter」按鈕
        {
            co = co.brighter(); // 使顏色變亮
            frm.setBackground(co); // 設定背景顏色
        } else if (e.getSource() == btn2) // 按下「Darker」按鈕
        {
            co = co.darker(); // 使顏色變暗
            frm.setBackground(co); // 設定背景顏色
        }
        // Graphics g = getGraphics();
        // paint(g);
    }

    /*
     * public void paint(Graphics g) {
     * g.setColor(co);
     * g.fillRect(0, 0, getWidth(), getHeight());
     * }
     */
}
