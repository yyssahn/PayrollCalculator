package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class ClaimPanel extends Panel {
	private JLabel federalClaimSpinnerLabel, provincialClaimSpinnerLabel;
	private JSpinner federalClaimSpinner, provincialClaimSpinner;
	
	public ClaimPanel(){
		
		this.setLayout(new FlowLayout());
		
		this.setPreferredSize(new Dimension(250,768));
		setUI();
		setListener();
	}
	
	private void setUI(){
		createFederalSpinner();
	}
	private void setListener(){
		
	}
	
	private void createFederalSpinner() {
		federalClaimSpinnerLabel = new JLabel("Federal Claim");
		federalClaimSpinnerLabel.setPreferredSize(new Dimension(230,20));
		federalClaimSpinnerLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		federalClaimSpinnerLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(federalClaimSpinnerLabel);
		
		String[] templist = {"52 Payments in year","26 Payments in year","12 Payments in year"};
		SpinnerListModel model = new SpinnerListModel(templist);
		
		federalClaimSpinner = new JSpinner(model);
		federalClaimSpinner.setPreferredSize(new Dimension(250,20));
		federalClaimSpinner.enableInputMethods(false);
		federalClaimSpinner.setEditor(new JSpinner.DefaultEditor(federalClaimSpinner));
		this.add(federalClaimSpinner);
	}
	
}
