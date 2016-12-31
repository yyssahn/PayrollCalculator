package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class EiCppPanel extends Panel{

	
	private JLabel eiExemptLabel, cppExemptLabel;
	private JCheckBox eiExemptCheckBox, cppexemptCheckBox;

	
	public EiCppPanel(){
		
		this.setLayout(new FlowLayout());
		
		this.setPreferredSize(new Dimension(250,768));
		setUI();
		setListener();
	}
	
	private void setUI(){
		eiExemptLabel = new JLabel("EI EXEMPT?");
		eiExemptLabel.setPreferredSize(new Dimension(120,20));
		this.add(eiExemptLabel);
		
		cppExemptLabel = new JLabel("CPP EXEMPT?");
		cppExemptLabel.setPreferredSize(new Dimension(120,20));
		this.add(cppExemptLabel);
	}
	private void setListener(){
		
	}
}
