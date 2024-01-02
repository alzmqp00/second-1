package javaa.aawt;

import java.awt.*;
import java.awt.event.*;

public class paintDraw extends Frame implements ActionListener, MouseListener, MouseMotionListener {
    static paintDraw frm = new paintDraw();
    static MenuBar bar = new MenuBar();
    static Menu m1 = new Menu("draw"); // 繪圖選單
    static Menu m2 = new Menu("other"); // 其他選單
    static MenuItem item1 = new MenuItem("line"); // 直線選項
    static MenuItem item2 = new MenuItem("rectangle"); // 矩形選項
    static MenuItem item3 = new MenuItem("oral"); // 橢圓形選項
    static MenuItem item4 = new MenuItem("move"); // 移動選項
    static int state, beforestate = 0;
    static int x1, x2, y1, y2, posx, posy;
    static boolean CanMove = false;

    public static void main(String args[]) {
        // frm.setLayout(new BorderLayout());
        frm.setTitle("繪圖程式");
        frm.setSize(800, 600);
        // frm.add(btn, BorderLayout.SOUTH);
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 設立介面
        bar.add(m1);
        bar.add(m2);
        m1.add(item1);
        m1.add(item2);
        m1.add(item3);
        m2.add(item4);
        frm.setMenuBar(bar);
        frm.addMouseListener(frm);
        frm.addMouseMotionListener(frm);

        item1.addActionListener(frm);
        item2.addActionListener(frm);
        item3.addActionListener(frm);
        item4.addActionListener(frm);
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // g.drawRect(100, 50, 70, 55);
        // 讓後面的程式知道選取的是哪一個選項
        MenuItem item = (MenuItem) e.getSource();
        if (state != 4)
            beforestate = state;
        if (item == item1)
            state = 1;
        else if (item == item2)
            state = 2;
        else if (item == item3)
            state = 3;
        else if (item == item4) {
            state = 4;
        }

    }

    public void paint(Graphics g) {
        // g.clearRect(0, 0, getWidth(), getHeight());

        if (state == 1) {
            // 繪製直線
            g.setColor(Color.black);
            g.drawLine(x1, y1, x2, y2);
        } else if (state == 2) {
            // 繪製矩形
            g.setColor(Color.yellow);
            g.fillRect(x1, y1, x2 - x1, y2 - y1);
        } else if (state == 3) {
            // 繪製橢圓形
            g.setColor(Color.red);
            g.fillOval(x1, y1, x2 - x1, y2 - y1);
        }
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        if (state == 4) {
            if (CanMove) {
                state = beforestate;// 紀錄按下move之前畫得圖形
                x1 += e.getX() - posx;
                x2 += e.getX() - posx;
                y1 += e.getY() - posy;
                y2 += e.getY() - posy;
                posx = e.getX();
                posy = e.getY();
                // 調整座標後重繪
                update(g);
                state = 4;
            }
            return;// 不要讓它動到x2y2
        }
        update(g);
        x2 = e.getX();
        y2 = e.getY();

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        CanMove = false;
        if (state == 4) {
            if (e.getX() > x1 && e.getX() < x2 && e.getY() > y1 && e.getY() < y2) {
                CanMove = true;
                posx = e.getX();
                posy = e.getY();
                // 繪製虛線框
                Graphics2D g2d = (Graphics2D) getGraphics();
                float[] dashPattern = { 10, 10 };
                g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));
                g2d.setColor(Color.black);
                g2d.drawRect(x1, y1, x2 - x1, y2 - y1);
            }
            return;// 不要讓它動到x1y1
        }

        x1 = e.getX();
        y1 = e.getY();
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