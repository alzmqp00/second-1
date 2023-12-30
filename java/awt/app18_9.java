package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class app18_9 extends Frame implements MouseListener {
    static app18_9 frm = new app18_9();
    static Button btn = new Button("Click Me!!");
    static TextArea txa = new TextArea("", 2, 5, TextArea.SCROLLBARS_NONE);

    public static void main(String args[]) {
        BorderLayout br = new BorderLayout(2, 5);
        frm.setLayout(br);
        frm.setSize(200, 150);
        frm.setTitle("Mouse Event");
        txa.setEditable(false);
        // frm.add(btn, br.WEST);
        // frm.add(txa, br.CENTER);
        btn.addMouseListener(frm); // 設定 frm 為 btn 的監聽者
        frm.add(btn, br.WEST);
        frm.add(txa, br.CENTER);
        frm.setVisible(true);
    }

    public void mouseEntered(MouseEvent e) { // 滑鼠的指標進入 btn 上方
        txa.setText("Mouse entered\n");
    }

    public void mouseClicked(MouseEvent e) { // 按下並放開滑鼠鍵
        txa.append("Mouse clicked\n");
    }

    public void mouseExited(MouseEvent e) { // 滑鼠的指標離開 btn 上方
        txa.append("Mouse exited\n");
    }

    public void mousePressed(MouseEvent e) { // 按下滑鼠鍵
        txa.append("Mouse pressed\n");
    }

    public void mouseReleased(MouseEvent e) { // 放開滑鼠鍵
        txa.append("Mouse released\n");
    }
}