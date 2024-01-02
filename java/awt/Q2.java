// Q2.java
package javaa.aawt;

import java.awt.*;
import java.awt.event.*;

public class Q2 {

	// frame
	static Frame frm = new Frame("DSG Calculator");

	// label
	static Label labTitle = new Label("DSG Calculator");
	static Label labIndicate = new Label("0", Label.RIGHT);

	// panel
	static Panel pnl1 = new Panel(new GridLayout(3, 3));
	static Panel pnl2 = new Panel(new GridLayout(4, 1));
	static Panel pnl3 = new Panel(new GridLayout(2, 1, 0, 10));

	// button
	static Button[] btNum = new Button[9];
	static Button btZero = new Button("0");
	static Button btDot = new Button(".");
	static Button[] btSign = new Button[4];
	static Button btEquals = new Button("=");
	static Button btClear = new Button("Clear");

	static String strNum1 = "";
	static String strNum2 = "";
	static String strSign = "";

	public static void main(String[] args) {
		frm.setLayout(null);
		frm.setSize(600, 400);
		frm.setResizable(false);
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frm.setLocation(250, 150);
		// set label bound
		labIndicate.setBounds(50, 60, 350, 50);
		labTitle.setBounds(450, 60, 150, 50);

		// set label color
		labIndicate.setBackground(new Color(240, 220, 190));

		// set label font
		labIndicate.setFont(new Font("Serial", Font.BOLD, 20));
		labTitle.setFont(new Font("Serial", Font.ITALIC, 18));

		// add label
		frm.add(labIndicate);
		frm.add(labTitle);

		// set panel bounds
		pnl1.setBounds(50, 150, 250, 150);
		pnl2.setBounds(325, 150, 75, 200);
		pnl3.setBounds(425, 150, 150, 200);

		// add button and set ActionListener
		for (int i = 0; i < 9; i++) {
			btNum[i] = new Button("" + (i + 1));
			btNum[i].addActionListener(new ActLis());
			pnl1.add(btNum[i]);
		}
		btSign[0] = new Button("+");
		btSign[1] = new Button("-");
		btSign[2] = new Button("x");
		btSign[3] = new Button("/");

		for (int i = 0; i < 4; i++) {
			btSign[i].addActionListener(new ActLis());
		}

		btZero.addActionListener(new ActLis());
		btDot.addActionListener(new ActLis());
		btEquals.addActionListener(new ActLis());
		btClear.addActionListener(new ActLis());

		pnl2.add(btSign[0]);
		pnl2.add(btSign[1]);
		pnl2.add(btSign[2]);
		pnl2.add(btSign[3]);
		pnl3.add(btEquals);
		pnl3.add(btClear);

		// set panel font
		pnl1.setFont(new Font("Serial", Font.BOLD, 18));
		pnl2.setFont(new Font("Serial", Font.BOLD, 18));
		pnl3.setFont(new Font("Serial", Font.BOLD, 24));

		// add panel
		frm.add(pnl1);
		frm.add(pnl2);
		frm.add(pnl3);

		// set button bounds
		btZero.setBounds(50, 300, 166, 50);
		btDot.setBounds(216, 300, 83, 50);

		// set button font
		btZero.setFont(new Font("Serial", Font.BOLD, 18));
		btDot.setFont(new Font("Serial", Font.BOLD, 18));

		// add button
		frm.add(btZero);
		frm.add(btDot);

		frm.setVisible(true);
	}

	static class ActLis implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// get pressed button
			Button btn = (Button) e.getSource();

			// the following code is to manage the button event

			// distinguish buttons
			if (btn == btClear) { // clear button ，reset the equation
				strNum1 = "";
				strNum2 = "";
				strSign = "";
				labIndicate.setText("0");
			} else if (btn == btEquals) { // equal button ， calculate the equation
				double ans;
				double firstNum = Double.parseDouble(strNum1);
				double secondNum = Double.parseDouble(strNum2);
				if (strSign.equals("+")) {
					ans = firstNum + secondNum;
				} else if (strSign.equals("-")) {
					ans = firstNum - secondNum;
				} else if (strSign.equals("x")) {
					ans = firstNum * secondNum;
				} else if (strSign.equals("/")) {
					ans = firstNum / secondNum;
				} else {
					ans = firstNum;
				}

				labIndicate.setText(String.valueOf(ans));

			} else {
				if (btn == btSign[0]) { // "+"
					strSign = "+";
				} else if (btn == btSign[1]) { // "-"
					if (strNum1.equals("")) {
						strNum1 += "-";
					} else if (strSign.equals("")) {
						strSign = "-";
					} else if (strNum2.equals("")) {
						strNum2 += "-";
					}
				} else if (btn == btSign[2]) { // "x"
					strSign = "x";
				} else if (btn == btSign[3]) { // "/"
					strSign = "/";
				} else if (btn == btDot) { // "."
					if (strSign.equals("")) {
						if (strNum1.contains(".") || strNum1.equals("-")) {
							return;
						} else {
							if (strNum1.equals("")) {
								strNum1 += "0";
							}
							strNum1 += ".";
						}
					} else {
						if (strNum2.contains(".") || strNum2.equals("-") || strNum2.equals("")) {
							return;
						} else {
							strNum2 += ".";
						}
					}
				} else { // others
					if (strSign.equals("")) {
						if (strNum1.equals("0"))
							strNum1 = btn.getLabel();
						else
							strNum1 += btn.getLabel();
					} else {
						if (strNum2.equals("0"))
							strNum2 = btn.getLabel();
						else
							strNum2 += btn.getLabel();
					}
				}
				if (strNum2.equals("")) {
					labIndicate.setText(strNum1);
				} else {
					labIndicate.setText(strNum2);
				}
			}
		}
	}
}
