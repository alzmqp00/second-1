package javaa.awt;

import java.awt.*;

public class app17_11 {

    static Frame frm = new Frame("CheckBox class");

    static Checkbox chkb1 = new Checkbox("Epson 5900T", true);
    static Checkbox chkb2 = new Checkbox("HP LaserJet 4P", true);
    static Checkbox chkb3 = new Checkbox("other printer");
    static Checkbox chkb4 = new Checkbox("black & white printer");
    static Checkbox chkb5 = new Checkbox("color printer");

    public static void main(String args[]) {
        CheckboxGroup grp = new CheckboxGroup();
        frm.setLayout(new BorderLayout());
        frm.setSize(400, 150);

        frm.setBackground(Color.yellow);

        chkb1.setBounds(20, 40, 140, 20);
        chkb2.setBounds(20, 60, 140, 20);
        chkb3.setBounds(20, 80, 140, 20);
        chkb4.setBounds(20, 100, 140, 20);
        chkb5.setBounds(20, 120, 140, 20);

        chkb4.setCheckboxGroup(grp);
        chkb5.setCheckboxGroup(grp);

        chkb4.setState(true);// 將chkb4設定為選取

        frm.add(chkb1, BorderLayout.SOUTH);
        frm.add(chkb2, BorderLayout.WEST);
        /*
         * Container.add(Component comp, int index) 方法和
         * Container.add(Component comp, Object constraints)
         * 方法都是用於將元件添加到容器中，但它們的使用情境和參數有所不同。
         * 
         * Container.add(Component comp, int index) 方法允許你指定元件在容器中的位置。
         * index 參數是你想要插入元件的位置，如果 index 為 -1，則會將元件添加到容器的末尾。
         * 這個方法返回被添加的元件。
         * 
         * 與此相反，Container.add(Component comp, Object constraints) 方法允許你指定元件的布局約束。
         * constraints 參數是一個表示布局約束的對象，例如 BorderLayout.SOUTH。這個方法不返回任何值。
         * 
         * 兩個方法都會改變與布局相關的資訊，並使元件層次結構失效。如果容器已經被顯示出來，
         * 那麼必須在顯示添加的元件之前驗證層次結構。
         * 
         * 如果 comp 為 null，兩個方法都會拋出 NullPointerException。
         * 如果 index 無效，Container.add(Component comp, int index) 方法會拋出
         * IllegalArgumentException。
         */
        frm.add(chkb3);
        frm.add(chkb4);
        frm.add(chkb5);

        frm.setVisible(true);
    }
}