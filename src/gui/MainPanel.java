package gui;

import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Event;

public class MainPanel extends Panel {
	
	private JLabel mLabel1;
	private JButton mButton1;
	private JTextField mTextField1;
	MainPanel(){
		setUI();
	}
	private void setUI(){
		
		
		mLabel1 = new JLabel("Tell me something");
		this.add(mLabel1);
		
		mButton1 = new JButton("Send");
		this.add(mButton1);
		
		
		mTextField1 = new JTextField("ddd",19);
		mTextField1.requestFocus();
		
		this.add(mTextField1);
		
	}
}
