package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class app20_12 extends Frame implements MouseMotionListener, MouseListener {
    static app20_12 frm = new app20_12();
    int x1, x2, y1, y2;

    public static void main(String args[]) {
        frm.setTitle("Free drawing");
        frm.setSize(200, 150);
        frm.addMouseMotionListener(frm); // 設定MouseListener
        frm.addMouseListener(frm); // 設定MouseMotionListener
        frm.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        x1 = e.getX(); // 取得滑鼠按下時x座標（繪圖起始點的x座標）
        y1 = e.getY(); // 取得滑鼠按下時y座標（繪圖起始點的y座標）
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        x2 = e.getX();
        y2 = e.getY();
        g.drawLine(x1, y1, x2, y2);
        x1 = x2;
        y1 = y2;
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}