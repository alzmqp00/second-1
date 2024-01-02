// Q1.java
package javaa.aawt;

import java.awt.*;
import java.awt.event.*;

public class Q1 {
	// frame
	static Frame frm = new Frame("BMI");

	// label
	static Label lab1 = new Label("名字");
	static Label lab2 = new Label("體重");
	static Label lab3 = new Label("身高");
	static Label lab4 = new Label("性別");
	static Label lab5 = new Label("年齡");
	static Label lab6 = new Label("(公斤)");
	static Label lab7 = new Label("(公分)");
	static Label labOutput1 = new Label();
	static Label labOutput2 = new Label();

	// textfield
	static TextField txfName = new TextField();
	static TextField txfWeight = new TextField();
	static TextField txfHeight = new TextField();

	// Checkbox
	static Checkbox ckbMale = new Checkbox("男生");
	static Checkbox ckbFemale = new Checkbox("女生");

	// Button
	static Button btCal = new Button("Compute BMI");
	static Button btExit = new Button("Exit");

	// Choice
	static Choice chcAge = new Choice();

	public static void main(String args[]) {
		frm.setLayout(null);
		frm.setSize(400, 500);
		frm.setLocation(250, 150);
		frm.setResizable(false);
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// set label bounds
		lab1.setBounds(50, 50, 30, 20);
		lab2.setBounds(50, 90, 30, 20);
		lab3.setBounds(50, 130, 30, 20);
		lab4.setBounds(50, 170, 30, 20);
		lab5.setBounds(50, 210, 30, 20);
		lab6.setBounds(250, 90, 50, 20);
		lab7.setBounds(250, 130, 50, 20);
		labOutput1.setBounds(120, 300, 300, 50);
		labOutput2.setBounds(70, 350, 300, 50);

		// set label font
		lab1.setFont(new Font("Serief", Font.BOLD, 12));
		lab2.setFont(new Font("Serief", Font.BOLD, 12));
		lab3.setFont(new Font("Serief", Font.BOLD, 12));
		lab4.setFont(new Font("Serief", Font.BOLD, 12));
		lab5.setFont(new Font("Serief", Font.BOLD, 12));
		lab6.setFont(new Font("Serief", Font.BOLD, 12));
		lab7.setFont(new Font("Serief", Font.BOLD, 12));
		labOutput1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		labOutput2.setFont(new Font("Serief", Font.BOLD, 12));

		// add label
		frm.add(lab1);
		frm.add(lab2);
		frm.add(lab3);
		frm.add(lab4);
		frm.add(lab5);
		frm.add(lab6);
		frm.add(lab7);
		frm.add(labOutput1);
		frm.add(labOutput2);

		// set textfield bounds
		txfName.setBounds(100, 50, 140, 20);
		txfWeight.setBounds(100, 90, 140, 20);
		txfHeight.setBounds(100, 130, 140, 20);

		// add textfield
		frm.add(txfName);
		frm.add(txfWeight);
		frm.add(txfHeight);

		// checkboxgroup
		CheckboxGroup grp = new CheckboxGroup();

		// set checkbox
		ckbMale.setCheckboxGroup(grp);
		ckbFemale.setCheckboxGroup(grp);

		// default
		ckbMale.setState(true);

		// set checkbox
		ckbMale.setBounds(100, 170, 50, 20);
		ckbFemale.setBounds(160, 170, 50, 20);

		// add checkbox
		frm.add(ckbMale);
		frm.add(ckbFemale);

		// set choice
		for (int i = 1; i < 121; i++) {
			chcAge.add("" + i);
		}

		// set choice bounds
		chcAge.setBounds(100, 210, 50, 20);

		// add choice
		frm.add(chcAge);

		// set actionListener
		btCal.addActionListener(new ActLis());
		btExit.addActionListener(new ActLis());

		// set button bound
		btCal.setBounds(50, 450, 140, 20);
		btExit.setBounds(250, 450, 100, 20);

		// add button
		frm.add(btCal);
		frm.add(btExit);

		frm.setVisible(true);
	}

	static class ActLis implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Button btn = (Button) e.getSource();

			// click the btCal
			if (btn == btCal) {

				// get the information
				String name = txfName.getText();
				double weight = Double.parseDouble(txfWeight.getText());
				double height = Double.parseDouble(txfHeight.getText());

				if (!name.isEmpty() && weight > 0 && height > 0) {

					// calculate the BMI
					double BMI = weight / (Math.pow((height / 100), 2));
					String suggestion;

					// determine the output text through the rules
					if (BMI < 18.5) {
						labOutput1.setText("Under weight");
						suggestion = "Eat more !";
					} else if (BMI <= 23.9) {
						labOutput1.setText("Normal weight");
						suggestion = "Great!";
					} else if (BMI < 26.9) {
						labOutput1.setText("Over weight");
						suggestion = "Remember to do exercise!";
					} else {
						labOutput1.setText("Obesity");
						suggestion = "Go on diet, now!";
					}

					// distinguish sex from the checkbox
					if (ckbMale.getState()) {
						labOutput2.setText(name + "(" + chcAge.getSelectedItem()
								+ "歲, 男生):" + suggestion);
					} else {
						labOutput2.setText(name + "(");
						labOutput2.setText(name + "(" + chcAge.getSelectedItem()
								+ "歲, 女生):" + suggestion);
					}
				} else {
					labOutput1.setText("輸入錯誤資訊");
					labOutput2.setText("請重新輸入");
				}
			} else { // Click the btExit
				System.exit(0);
			}
		}
	}
}
