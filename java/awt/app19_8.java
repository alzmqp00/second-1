package javaa.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * 這個類別代表一個帶有對話框的 AWT 應用程式。
 */
public class app19_8 extends Frame implements ActionListener {
    static app19_8 frm = new app19_8(); // 建立 app19_8 類別的實例 (Frame)
    static Dialog dlg = new Dialog(frm); // 建立與框架關聯的對話框
    static Button close = new Button("關閉"); // 建立對話框的 "關閉" 按鈕
    static Button cancel = new Button("取消"); // 建立對話框的 "取消" 按鈕
    static WinLis wlis = new WinLis(); // 建立 WinLis 類別的實例 (WindowAdapter)

    public static void main(String[] args) {
        frm.setTitle("app19_8"); // 設定框架的標題
        frm.setSize(200, 150); // 設定框架的大小
        frm.setLayout(null); // 設定佈局管理器為 null (絕對定位)

        dlg.setTitle("sfjslkf"); // 設定對話框的標題
        dlg.setSize(140, 100); // 設定對話框的大小
        dlg.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10)); // 設定對話框的佈局管理器
        dlg.add(close); // 將 "關閉" 按鈕添加到對話框
        dlg.add(cancel); // 將 "取消" 按鈕添加到對話框

        close.addActionListener(frm); // 將動作監聽器添加到 "關閉" 按鈕
        cancel.addActionListener(frm); // 將動作監聽器添加到 "取消" 按鈕
        frm.addWindowListener(wlis); // 將窗口監聽器添加到框架
        frm.setVisible(true); // 設定框架為可見
    }

    static class WinLis extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            dlg.setLocation(80, 30); // 設定對話框的位置
            dlg.setVisible(true); // 設定對話框為可見
        }
    }

    public void actionPerformed(ActionEvent e) {
        Button btn = (Button) e.getSource(); // 獲取動作事件的源頭

        if (btn == close) {
            dlg.dispose(); // 關閉對話框
            frm.dispose(); // 關閉框架
        } else if (btn == cancel) {
            dlg.setVisible(false); // 隱藏對話框
        }
    }
}
