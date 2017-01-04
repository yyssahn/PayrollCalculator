package controller;

import gui.ClaimPanel;
import gui.EiCppPanel;
import gui.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import constants.BCClaimCodes;
import constants.FederalClaimCodes;

public class CalculatorController implements ActionListener{
	MainPanel mainPanel;
	EiCppPanel eiCppPanel;
	ClaimPanel claimPanel;
	BCClaimCodes provincialCode;
	FederalClaimCodes federalCode;
	public CalculatorController(MainPanel main, EiCppPanel eicpp, ClaimPanel claim){
		mainPanel = main;
		eiCppPanel = eicpp;
		claimPanel = claim;
		provincialCode = BCClaimCodes.ZERO;
		
		federalCode = FederalClaimCodes.ZERO;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == mainPanel.getCalculateButton()){
			federalCode = federalCode.getCode(claimPanel.getFederalIndex());
			provincialCode = provincialCode.getCode(claimPanel.getProvincialIndex());
			
			System.out.println(federalCode.getK1());
			System.out.println(provincialCode.getK1());
			
			
		}
	}

	
}
