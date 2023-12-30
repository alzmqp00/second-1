	package awt;
	
	import java.awt.*;
	import java.awt.event.*;
	
	public class Event{
	    /**
		 * 
		 */
		//private static final long serialVersionUID = -9068329770989969581L;
		static Button btn = new Button("Click Me");
	    static Frame frm=new Frame();
	    public static void main(String args[]) {
	        frm.setLayout(new FlowLayout()); // 设置 frm 的布局
	      //  btn.addActionListener(frm);
	        btn.addActionListener(new ActLis());// 为 btn 添加事件监听器
	        frm.setTitle("Action Event");
	        frm.add(btn);// 设置 frm 的标题
	        frm.setSize(200,150);
	        frm.setVisible(true);
	    }
	   /* public void actionPerformed(ActionEvent e) {
	    	frm.setBackground(Color.yellow);
	    }*/
	    static class ActLis implements ActionListener{
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		frm.setBackground(Color.yellow);
	    		
	    	}
	    }
	}
	
