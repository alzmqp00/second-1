package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class app19_8 extends Frame implements ActionListener {
    static app19_8 frm = new app19_8();
    static Dialog dlg = new Dialog(frm);
    static Button close = new Button("close");
    static Button canel = new Button("canel");
    static WinLis wlis = new WinLis();

    public static void main(String[] args) {
        // TODO 自動產生的方法 Stub
        frm.setTitle("app19_8");
        frm.setSize(200, 150);
        frm.setLayout(null);
        dlg.setTitle("sfjslkf");
        dlg.setSize(140, 100);
        dlg.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        dlg.add(close);
        dlg.add(canel);

        // btn.setBounds(20, 20, 60, 30);
        // btn2.setBounds(100, 20, 60, 30);
        close.addActionListener(frm);
        canel.addActionListener(frm);
        frm.addWindowListener(wlis);
        frm.setVisible(true);
    }

    static class WinLis extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            dlg.setLocation(80, 30);
            dlg.setVisible(true);
            // System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent e) {
        // TODO: Auto-generated method stub
        Button btn = (Button) e.getSource();
        if (btn == close) {
            dlg.dispose();
            frm.dispose();
        } else if (btn == canel) {
            dlg.setVisible(false);
        }
    }

}
