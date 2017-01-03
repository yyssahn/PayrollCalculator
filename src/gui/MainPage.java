package gui;

import java.awt.BorderLayout;
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
		 this.setSize(1024,768);
		 this.setLayout(new  BorderLayout());
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
		 this.setTitle("2017 BC Payroll Calculator");
		 
		 MainPanel mMainPanel = new MainPanel();
		 this.add(mMainPanel,BorderLayout.CENTER);
		 
		 ClaimPanel ClaimPanel = new ClaimPanel();
		 this.add(ClaimPanel, BorderLayout.LINE_START);
		 

		 EiCppPanel ClaimPanel2 = new EiCppPanel();
		 this.add(ClaimPanel2, BorderLayout.LINE_END);
		 mMainPanel.setListener(mMainPanel, ClaimPanel2, ClaimPanel);
		 this.setVisible(true);
	 }
	 
	 private Toolkit makeToolkit(){
		 return Toolkit.getDefaultToolkit();		 
	 }
	 private Dimension getDimension(){
		 return makeToolkit().getScreenSize();
		 
	 }
}
