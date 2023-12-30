package javaa.awt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class app_23_Jframe {
    static JFrame frm = new JFrame("JInternalFrame");
    static JButton btn = new JButton("New Frame"); // 建立 Jbutton 物件
    static Container cp = frm.getContentPane(); // 取得內容窗格
    static JDesktopPane jdp = new JDesktopPane(); // 建立桌面物件

    public static void main(String args[]) {
        cp.setLayout(new BorderLayout());
        cp.add(btn, BorderLayout.SOUTH); // 將按鈕加入容器中
        cp.add(jdp);// 將桌面加入容器中
        btn.addActionListener(new ActLis());
        frm.setSize(400, 300);
        frm.setVisible(true);
    }

    static public class ActLis implements ActionListener {
        static int i = 0;

        public void actionPerformed(ActionEvent e) {
            JInternalFrame jif = new JInternalFrame("Frame " + i++, true, true, true, true);
            Container cp = jif.getContentPane();
            JButton btn = new JButton("Click Me!");
            cp.add(btn, BorderLayout.SOUTH);
            jdp.add(jif);
            jif.setSize(300, 200);
            jif.setVisible(true);
        }
    }
}