package javaa.awt;

// app17_18,使用Panel類別
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class awt {
    static Frame frm = new Frame("Panel class");
    static Panel pnl = new Panel(new GridLayout(3, 3));
    static Label lab = new Label("0. ", Label.RIGHT);

    public static void main(String args[]) {
        FlowLayout f = new FlowLayout(FlowLayout.CENTER, 5, 10);
        frm.setLayout(f);
        // frm.setLayout(null);

        frm.setSize(200, 150);
        frm.setResizable(false);
        lab.setBounds(20, 30, 120, 20);
        lab.setBackground(new Color(240, 220, 190)); // 設定標籤的顏色
        pnl.setBounds(20, 60, 120, 80);
        // 設定pnl置於視窗內的位置
        for (int i = 1; i <= 9; i++)
            pnl.add(new Button(Integer.toString(i))); // 0f

        frm.add(lab);
        frm.add(pnl);
        frm.setVisible(true);
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}