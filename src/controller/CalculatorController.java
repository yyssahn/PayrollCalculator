package controller;

import gui.ClaimPanel;
import gui.EiCppPanel;
import gui.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import constants.BCClaimCodes;
import constants.FederalClaimCodes;
import constants.PaymentNumber;

public class CalculatorController implements ActionListener{
	MainPanel mainPanel;
	EiCppPanel eiCppPanel;
	ClaimPanel claimPanel;

	FederalClaimCodes federalCode;
	BCClaimCodes provincialCode;
	
	PaymentNumber numPayment;
	public CalculatorController(MainPanel main, EiCppPanel eicpp, ClaimPanel claim){
		mainPanel = main;
		eiCppPanel = eicpp;
		claimPanel = claim;

		federalCode = FederalClaimCodes.ZERO;
		provincialCode = BCClaimCodes.ZERO;
		numPayment = PaymentNumber.WEEKLY;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == mainPanel.getCalculateButton()){
			federalCode = federalCode.getCode(claimPanel.getFederalIndex());
			provincialCode = provincialCode.getCode(claimPanel.getProvincialIndex());
			numPayment = numPayment.getPaymentNumber(mainPanel.getPaymentIndex());
			double grossIncome = mainPanel.getGrossPay();
			double deductable = mainPanel.getDeductables();
			System.out.println(deductable);

		}
	}
	
	
	private double getTaxableIncome(){
		return 0.0;
	}
	private double getAnnualTaxableIncome(double income){
		return numPayment.getNumber() * income;
	}
}
