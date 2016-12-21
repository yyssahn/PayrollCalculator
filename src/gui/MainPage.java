package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

public class MainPage extends JFrame {
	
	
	 public MainPage(){
		 
		 initialize();  
	 }
	 
	 private void initialize(){
		 this.setSize(400,400);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
		 this.setTitle("2017 BC Payroll Calculator");
		 MainPanel mMainPanel = new MainPanel();
		 this.add(mMainPanel);

		 this.setVisible(true);
	 }
	 
	 private Toolkit makeToolkit(){
		 return Toolkit.getDefaultToolkit();		 
	 }
	 private Dimension getDimension(){
		 return makeToolkit().getScreenSize();
		 
	 }
}
