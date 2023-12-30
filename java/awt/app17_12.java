package javaa.awt;

import java.awt.*;
import javax.swing.*;

public class app17_12 extends JFrame {
    static Frame frm = new Frame("文字區域");
    static TextField txt1 = new TextField("不可編輯");
    static TextField txt2 = new TextField("可編輯");
    static TextField txt3 = new TextField("qwesad");
    static TextArea tA = new TextArea("sda", 1200, 2000, TextArea.SCROLLBARS_VERTICAL_ONLY);

    public static void main(String[] args) {
        // 設定視窗大小
        frm.setLayout(null);
        frm.setSize(200, 150);
        // 設定視窗標題
        frm.setTitle("TextField Demo");
        // 不顯示視窗邊框
        frm.setBackground(Color.yellow);

        txt1.setBounds(20, 40, 120, 20);

        // 將文字輸入方塊加入視窗
        frm.add(txt1);
        // 設定文字輸入方塊是否可編輯
        txt1.setEditable(false);
        // 設定文字輸入方塊的回顯字元
        txt3.setEchoChar('*');

        // 設定文字輸入方塊大小
        txt2.setBounds(20, 70, 120, 20);
        // 將文字輸入方塊加入視窗
        frm.add(txt2);

        // 設定文字輸入方塊大小
        txt3.setBounds(20, 100, 120, 20);
        // 將文字輸入方塊加入視窗
        frm.add(txt3);
        // 取得文字輸入方塊的文字
        String text1 = txt1.getText();
        // 印出文字輸入方塊的文字
        System.out.println(text1);
        // 取得文字輸入方塊的文字
        String text2 = txt2.getText();
        // 印出文字輸入方塊的文字
        System.out.println(text2);
        // 取得文字輸入方塊的文字
        String text3 = txt3.getText();
        // 印出文字輸入方塊的文字
        System.out.println(text3);
        // 顯示視窗
        tA.setBounds(20, 130, 120, 40);
        frm.add(tA);
        frm.setVisible(true);
    }
}
