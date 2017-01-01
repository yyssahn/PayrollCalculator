package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
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
		eiExemptLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		eiExemptLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(eiExemptLabel);
		eiExemptCheckBox = new JCheckBox();

		
		
		this.add(eiExemptCheckBox);
		
		
		
		cppExemptLabel = new JLabel("CPP EXEMPT?");
		cppExemptLabel.setPreferredSize(new Dimension(120,20));
		cppExemptLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		cppExemptLabel.setHorizontalAlignment(JLabel.LEFT);
		
		this.add(cppExemptLabel);
	}
	private void setListener(){
		
	}
}
