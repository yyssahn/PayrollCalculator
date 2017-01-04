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
	FederalClaimCodes federalCode;
	BCClaimCodes provincialCode;
	public CalculatorController(MainPanel main, EiCppPanel eicpp, ClaimPanel claim){
		mainPanel = main;
		eiCppPanel = eicpp;
		claimPanel = claim;
		federalCode = FederalClaimCodes.ZERO;
		provincialCode = BCClaimCodes.ZERO;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == mainPanel.getCalculateButton()){
			System.out.printLn()
		}
	}

}
