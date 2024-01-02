package javaa.aawt;

import java.awt.*;
import java.awt.event.*;

public class Calculator {
    static Frame frm = new Frame("DSG Calculator"); // 建立視窗frm
    static Panel pnl = new Panel(new GridLayout(3, 3)); // 建立面板pn1
    static Label lab = new Label("0. ", Label.RIGHT); // 建立標筆1ab

    public static void main(String[] args) {
        // TODO 自動產生的方法 Stub

        frm.setLayout(null); // 取消視窗的版面設定
        frm.setSize(300, 150);
        frm.setResizable(false); // 將視窗設定為固定大小

        lab.setBounds(20, 30, 120, 20);
        lab.setBackground(new Color(240, 220, 190)); // 設定標的顏色
        pnl.setBounds(20, 60, 120, 80); // 設定pl置於視窗內的位置
        for (int i = 1; i <= 9; i++)
            pnl.add(new Button(Integer.toString(i))); // 加入接钮

        frm.add(lab); // 將1ab放進視窗中
        frm.add(pnl); // 將面板放進視窗中
        frm.setVisible(true);

        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
