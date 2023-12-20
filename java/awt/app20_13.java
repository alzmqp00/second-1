package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class app20_13 extends Frame implements MouseMotionListener, MouseListener {
    static app20_13 frm = new app20_13();
    int x = 70, y = 60, posx = 0, posy = 0, dx, dy;

    public static void main(String args[]) {
        frm.setTitle("拖曳圓形"); // 設定視窗標題
        frm.setSize(200, 150); // 設定視窗大小
        frm.addMouseMotionListener(frm); // 加入滑鼠移動監聽器
        frm.addMouseListener(frm); // 加入滑鼠點擊監聽器
        frm.setVisible(true); // 顯示視窗
    }

    public void mousePressed(MouseEvent e) {
        dx = e.getX() - posx; // 計算滑鼠點擊位置與圓形位置的差值
        dy = e.getY() - posy; // 計算滑鼠點擊位置與圓形位置的差值
    }

    public void mouseDragged(MouseEvent e) {
        x = e.getX() - dx; // 計算圓形新的x座標
        y = e.getY() - dy; // 計算圓形新的y座標
        if (dx > 0 && dx < 50 && dy > 0 && dy < 50) { // 確認滑鼠點擊位置在圓形(正方形)範圍內
            Graphics g = getGraphics();
            update(g);// 清空畫面為背景顏色再呼叫paint()方法
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.pink);
        g.fillOval(x, y, 50, 50); // 繪製圓形
        posx = x; // 更新圓形位置
        posy = y; // 更新圓形位置
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