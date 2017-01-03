package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClaimPanel extends Panel {
	private JLabel federalClaimSpinnerLabel, provincialClaimSpinnerLabel;
	private JSpinner federalClaimSpinner, provincialClaimSpinner;
	private int federalIndex = 0;
	private int provincialIndex = 0;
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
		federalClaimSpinnerLabel = new JLabel("<html>Total claim amount from<br/>employee's federal Form TD1</html>");
		federalClaimSpinnerLabel.setPreferredSize(new Dimension(250,40));
		federalClaimSpinnerLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		federalClaimSpinnerLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(federalClaimSpinnerLabel);
		
		String[] templist = {"No Claim amount(Claim Code 0","Minimum - 11,635.00 (Claim code 1)","11,635.01 - 13,858.00 (Claim code 2)","13,858.01 - 16,081.00 (Claim code 3)",
				"16,081.01 - 18,304.00 (Claim code 4)","18,304.01 - 20,527.00 (Claim code 5)","20,527.01 - 22,750.00 (Claim code 6)","22,750.01 - 24,973.00 (Claim code 7)","24,973.01 - 27,196.00 (Claim code 8)"
				, "27,196.01 - 29,419.00 (Claim code 9)","29,419.01 - 31,642.00 (Claim code 10)","No tax (Claim code E)"};
		SpinnerListModel model = new SpinnerListModel(templist);
		
		federalClaimSpinner = new JSpinner(model);
		federalClaimSpinner.setPreferredSize(new Dimension(250,20));
		federalClaimSpinner.enableInputMethods(false);
		federalClaimSpinner.setEditor(new JSpinner.DefaultEditor(federalClaimSpinner));
		this.add(federalClaimSpinner);
		
		provincialClaimSpinnerLabel = new JLabel("<html>Total Claim amount from<br/>employee's Provincial Form TD1</html>");
		provincialClaimSpinnerLabel.setPreferredSize(new Dimension(250,40));
		provincialClaimSpinnerLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		provincialClaimSpinnerLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(provincialClaimSpinnerLabel);
		
		String[] provincialList = {"No claim amount (Claim code 0)","Minimum - 10,208.00 (Claim Code 1)","10,208.01 - 12,505.00 (Claim Code 2)","12,505.01 - 14,802.00 (Claim Code 3)",
				"14,802.01 - 17,099.00 (Claim Code 4)","17,099.01 - 19,396.00 (Claim Code 5)","19,396.01 - 21,693.00 (Claim Code 6)","21,693.01 - 23,990.00 (Claim Code 7)","23,990.01 - 26,287.00 (Claim Code 8)",
				"26,287.01 - 28,584.00 (Claim Code 9)","28,584.01 - 30,881.00 (Claim Code 10)","No tax (Claim code E)"};
		SpinnerListModel provincialModel = new SpinnerListModel(provincialList);
		
		provincialClaimSpinner = new JSpinner(provincialModel);
		provincialClaimSpinner.setPreferredSize(new Dimension(250,20));
		provincialClaimSpinner.enableInputMethods(false);
		provincialClaimSpinner.setEditor(new JSpinner.DefaultEditor(provincialClaimSpinner));
		provincialClaimSpinner.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(provincialModel.getValue());
				int index= 0;
				for(Object o : provincialModel.getList()){
					if (o.equals(provincialClaimSpinner.getValue())){
						
						break;
					}
					index++;
				}
				federalIndex = index;
				System.out.println(federalIndex);
			}
		});
		this.add(provincialClaimSpinner);
		
		
	}
	
}
