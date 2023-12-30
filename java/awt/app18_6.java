//app186, Textevent類別的使範例
package javaa.awt;

import java.awt.*;
import java.awt.event.*;

public class app18_6 extends Frame implements TextListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8377347410243153944L;
	static app18_6 frm = new app18_6();
	static TextArea txa1;
	static TextArea txa2;

	public static void main(String args[]) {
		txa1 = new TextArea("", 6, 10, TextArea.SCROLLBARS_NONE);
		txa2 = new TextArea("", 6, 10, TextArea.SCROLLBARS_NONE);
		// 布局管理器會自動決定元件的大小和位置
		frm.setSize(400, 300);
		frm.setTitle("Text Event");
		frm.setLayout(new FlowLayout(FlowLayout.CENTER));
		txa1.addTextListener(frm); // 將frm設為txa1的傾聽者
		txa2.setEditable(false); // 將txa2設定為不可輯
		frm.add(txa1);
		frm.add(txa2);
		frm.setVisible(true);
		// 當txa1 物件裡的文字改變時,執行下列的程式碼
	}

	public void textValueChanged(TextEvent e) {
		txa2.setText(txa1.getText());
	}
}
