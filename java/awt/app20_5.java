// app20_5, RGB color 函數的使用
package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class app20_5 extends Frame implements AdjustmentListener {
    static app20_5 frm = new app20_5();
    static Scrollbar scr1 = new Scrollbar(Scrollbar.VERTICAL);
    static Scrollbar scr2 = new Scrollbar(Scrollbar.HORIZONTAL);
    static Scrollbar scr3 = new Scrollbar(Scrollbar.VERTICAL);

    public static void main(String args[]) {
        BorderLayout br = new BorderLayout(5, 5);
        frm.setLayout(br);
        frm.setTitle("display colors");
        frm.setSize(200, 150);
        frm.add(scr1, BorderLayout.WEST); // scr1控制項，用來控制紅色
        frm.add(scr2, BorderLayout.SOUTH); // scr2控制項，用來控制綠色
        frm.add(scr3, BorderLayout.EAST); // scr3控制項，用來控制藍色
        scr1.setValues(255, 45, 0, 300); // 設定 scr1的初始值
        scr2.setValues(255, 45, 0, 300);// 設定 scr2的初始值
        scr3.setValues(140, 45, 0, 300); // 設定 scr3的初始值
        scr1.addAdjustmentListener(frm);
        scr2.addAdjustmentListener(frm);
        scr3.addAdjustmentListener(frm);
        frm.setVisible(true);
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        Graphics g = getGraphics();
        paint(g);
    }

    public void paint(Graphics g) {
        int red = scr1.getValue(); // 取得控制項 scr1的值
        int green = scr2.getValue(); // 取得控制項 scr2的值
        int blue = scr3.getValue(); // 取得控制項 scr3的值
        String str = "Color(" + red + ", " + green + ", " + blue + ")"; // 組合圖形顏色
        g.setColor(new Color(red, green, blue)); // 設定圖形顏色
        g.fillRect(0, 0, getWidth(), getHeight()); // 設定圖形區域為白色
        g.setColor(Color.black);
        g.drawString(str, 45, 80); // 於(45,80)處顯示目前設定的顏色
    }
}