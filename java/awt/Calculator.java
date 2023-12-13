package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class Calculator {
    static Frame frm = new Frame("DSG Calculator"); // 建立視窗frm
    static Label lab = new Label("0", Label.RIGHT); // 建立標筆1ab
    static Label lab2 = new Label("DSG Calculator", Label.CENTER);
    static Panel num_pnl = new Panel(new GridLayout(3, 3, 0, 0)); // number panel, 0,0為邊際寬度
    static Panel op1_pnl = new Panel(new GridLayout(4, 1, 0, 0)); // operator1 panel
    static Panel op2_pnl = new Panel(new GridLayout(2, 1, 0, 10)); // operator2 panel
    static Button button0 = new Button("0");
    static Button button_dot = new Button(".");
    static String str = "";
    static int randstack[] = new int[10];
    static int randtop = -1;
    static char operatorstack[] = new char[20];
    static int operatortop = -1;

    static class ActLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Button button = (Button) e.getSource();
            String Labe = button.getLabel();
            if (Labe.equals(".")) {
                str = str + Labe;
                lab.setText(str);
            } else if (Labe.equals("Clear")) {
                str = "";
                lab.setText("0");
            } else if (Labe.equals("=")) {
                randstack[++randtop] = Integer.valueOf(str);
                // 未完成
                str = "";
                lab.setText("0");
            } else if (Labe == "+") {
                randstack[++randtop] = Integer.valueOf(str);
                operatorstack[++operatortop] = '+';
            } else if (Labe == "-") {
                randstack[++randtop] = Integer.valueOf(str);
                operatorstack[++operatortop] = '-';
            } else if (Labe == "X") {
                randstack[++randtop] = Integer.valueOf(str);
                operatorstack[++operatortop] = 'X';
            } else if (Labe == "/") {
                randstack[++randtop] = Integer.valueOf(str);
                operatorstack[++operatortop] = '/';
            } else {
                for (int i = 0; i < 10; i++) {
                    if (Integer.valueOf(Labe) == i) {
                        str = str + Labe;
                        lab.setText(str);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO 自動產生的方法 Stub

        frm.setLayout(null); // 取消視窗的版面設定
        frm.setSize(450, 300);
        frm.setResizable(false); // 將視窗設定為固定大小

        lab.setBounds(20, 50, 285, 45);
        lab.setBackground(new Color(240, 220, 190)); // 設定標的顏色
        lab.setFont(new Font("Serief", Font.BOLD, 18));

        lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 12));
        lab2.setBounds(330, 70, 100, 20);
        frm.add(lab2);
        num_pnl.setBounds(20, 100, 200, 120); // 設定pl置於視窗內的位置
        num_pnl.setFont(new Font("Serief", Font.BOLD, 18));
        for (int i = 1; i <= 9; i++) {
            Button button = new Button(Integer.toString(i));
            num_pnl.add(button);
            button.addActionListener(new ActLis());
        }
        frm.add(num_pnl);
        button0.setBounds(20, 220, 400 / 3 + 1, 40);
        button0.setFont(new Font("Serief", Font.BOLD, 18));
        button0.addActionListener(new ActLis());
        frm.add(button0);

        button_dot.setBounds(150, 220, 200 / 3 + 1, 40);
        button_dot.setFont(new Font("Serief", Font.BOLD, 18));
        button_dot.addActionListener(new ActLis());
        frm.add(button_dot);

        frm.add(lab); // 將1ab放進視窗中
        frm.add(num_pnl); // 將面板放進視窗中

        op1_pnl.setFont(new Font("Serief", Font.BOLD, 18));
        op1_pnl.setBounds(240, 100, 200 / 3 + 1, 160);
        op1_pnl.setForeground(Color.BLUE);
        Button buttontemp = new Button("+");
        op1_pnl.add(buttontemp);
        buttontemp.addActionListener(new ActLis());

        op1_pnl.add(buttontemp = new Button("-"));
        buttontemp.addActionListener(new ActLis());
        op1_pnl.add(buttontemp = new Button("X"));
        buttontemp.addActionListener(new ActLis());
        op1_pnl.add(buttontemp = new Button("/"));
        buttontemp.addActionListener(new ActLis());
        frm.add(op1_pnl);
        op2_pnl.setForeground(Color.RED);
        op2_pnl.setFont(new Font("Serief", Font.BOLD, 18));
        op2_pnl.setBounds(350, 100, 75, 150);

        buttontemp = new Button("=");

        op2_pnl.add(buttontemp);

        buttontemp.addActionListener(new ActLis());

        buttontemp = new Button("Clear");
        op2_pnl.add(buttontemp);

        buttontemp.addActionListener(new ActLis());
        frm.add(op2_pnl);

        frm.setVisible(true);

        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
