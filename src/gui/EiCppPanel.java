package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import controller.EIStateListener;

public class EiCppPanel extends Panel{

	
	private JLabel eiExemptLabel, cppExemptLabel, eiMaxLabel, cppMaxLabel, eiTextFieldLabel, cppTextFieldLabel;
	private JCheckBox eiExemptCheckBox, eiMaxCheckBox, cppExemptCheckBox, cppMaxCheckBox;
	private JFormattedTextField eiTextField, cppTextField;

	
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
		eiExemptCheckBox.setPreferredSize(new Dimension(120,20));
		eiExemptCheckBox.addItemListener(new EIStateListener(this));
		this.add(eiExemptCheckBox);
		
		eiMaxLabel = new JLabel("EI max reached?");
		eiMaxLabel.setPreferredSize(new Dimension(120,20));
		eiMaxLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		eiMaxLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(eiMaxLabel);
		eiMaxCheckBox = new JCheckBox();
		eiMaxCheckBox.addItemListener(new EIStateListener(this));
		eiMaxCheckBox.setPreferredSize(new Dimension(120,20));
		this.add(eiMaxCheckBox);
		
		eiTextFieldLabel = new JLabel("EI paid so far");
		eiTextFieldLabel.setPreferredSize(new Dimension(120,20));
		eiTextFieldLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		eiTextFieldLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(eiTextFieldLabel);
		
		eiTextField = getCurrencyTextField();
		eiTextField.setPreferredSize(new Dimension(120,20));
		eiTextField.setValue(0.00);
		this.add(eiTextField);
		
		
		
		cppExemptLabel = new JLabel("CPP EXEMPT?");
		cppExemptLabel.setPreferredSize(new Dimension(120,20));
		cppExemptLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		cppExemptLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(cppExemptLabel);
		cppExemptCheckBox = new JCheckBox();
		cppExemptCheckBox.setPreferredSize(new Dimension(120,20));
		cppExemptCheckBox.addItemListener(new EIStateListener(this));
		this.add(cppExemptCheckBox);
		
		cppMaxLabel = new JLabel("CPP max reached?");
		cppMaxLabel.setPreferredSize(new Dimension(120,20));
		cppMaxLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		cppMaxLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(cppMaxLabel);
		cppMaxCheckBox = new JCheckBox();
		cppMaxCheckBox.addItemListener(new EIStateListener(this));
		cppMaxCheckBox.setPreferredSize(new Dimension(120,20));
		this.add(cppMaxCheckBox);
		
		cppTextFieldLabel = new JLabel("CPP paid so far");
		cppTextFieldLabel.setPreferredSize(new Dimension(120,20));
		cppTextFieldLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		cppTextFieldLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(cppTextFieldLabel);
		
		cppTextField = getCurrencyTextField();
		cppTextField.setPreferredSize(new Dimension(120,20));
		cppTextField.setValue(0.00);
		this.add(cppTextField);
	}
	private void setListener(){
		
	}

	

	public JCheckBox getEiExemptCheckBox() {
		return eiExemptCheckBox;
	}

	public void disableEiExemptCheckBox() {
		eiExemptCheckBox.setSelected(false);
		eiExemptCheckBox.setEnabled(false);
	}
	public void enableEiExemptCheckBox(){
		eiExemptCheckBox.setSelected(false);
		eiExemptCheckBox.setEnabled(true);
	}

	public JCheckBox getEiMaxCheckBox() {
		return eiMaxCheckBox;
	}
	public void disableEiMaxCheckBox() {
		eiMaxCheckBox.setSelected(false);
		eiMaxCheckBox.setEnabled(false);
	}
	public void enableEiMaxCheckBox(){
		eiMaxCheckBox.setSelected(false);
		eiMaxCheckBox.setEnabled(true);
	}
	public JCheckBox getCppExemptCheckBox() {
		return cppExemptCheckBox;
	}
	public JFormattedTextField getEiTextField() {
		return eiTextField;
	}
	public void disableEiTextField() {
		eiTextField.setValue(0.00);
		eiTextField.setEnabled(false);
	}
	public void enableEiTextField(){
		eiTextField.setValue(0.00);
		eiTextField.setEnabled(true);
	}
	
	public void disableCppExemptCheckBox() {
		cppExemptCheckBox.setSelected(false);
		cppExemptCheckBox.setEnabled(false);
	}
	public void enableCppExemptCheckBox(){
		cppExemptCheckBox.setSelected(false);
		cppExemptCheckBox.setEnabled(true);
	}

	public void disableCppMaxCheckBox() {
		cppMaxCheckBox.setSelected(false);
		cppMaxCheckBox.setEnabled(false);
	}
	public void enableCppMaxCheckBox(){
		cppMaxCheckBox.setSelected(false);
		cppMaxCheckBox.setEnabled(true);
	}
	public JCheckBox getCppMaxCheckBox() {
		return cppMaxCheckBox;
	}
	
	public void disableCppTextField() {
		cppTextField.setValue(0.00);
		cppTextField.setEnabled(false);
	}
	public void enableCppTextField(){
		cppTextField.setValue(0.00);
		cppTextField.setEnabled(true);
	}

	public JFormattedTextField getCppTextField() {
		return cppTextField;
	}

	public void setCppTextField(JFormattedTextField cppTextField) {
		this.cppTextField = cppTextField;
	}

	private JFormattedTextField getCurrencyTextField(){
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(2);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.00);
		formatter.setMaximum(10000000.00);
		formatter.setAllowsInvalid(false);
		return new JFormattedTextField(formatter);
	}

}
