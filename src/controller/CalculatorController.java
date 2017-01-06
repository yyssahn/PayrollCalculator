package controller;

import gui.ClaimPanel;
import gui.EiCppPanel;
import gui.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import constants.BCClaimCodes;
import constants.FederalClaimCodes;
import constants.FederalTaxConstants;
import constants.PaymentNumber;

public class CalculatorController implements ActionListener{
	MainPanel mainPanel;
	EiCppPanel eiCppPanel;
	ClaimPanel claimPanel;

	FederalClaimCodes federalCode;
	BCClaimCodes provincialCode;
	FederalTaxConstants federalTax;
	PaymentNumber numPayment;
	public CalculatorController(MainPanel main, EiCppPanel eicpp, ClaimPanel claim){
		mainPanel = main;
		eiCppPanel = eicpp;
		claimPanel = claim;

		federalCode = FederalClaimCodes.ZERO;
		provincialCode = BCClaimCodes.ZERO;
		numPayment = PaymentNumber.WEEKLY;
		federalTax = FederalTaxConstants.ZERO;
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
			double federalTax;
			federalTax = getFederalTax(getAnnualTaxableIncome(grossIncome)); 

		}
	}
	
	
	private double getTaxableIncome(){
		return 0.0;
	}
	private double getAnnualTaxableIncome(double income){
		return numPayment.getNumber() * income;
	}
	
	private double getFederalTax(double income){
		federalTax = federalTax.getConstant(income);
		double totalTax = (income * federalTax.getRate()) - federalTax.getConstant();
		
		
		
		return totalTax;
	}
	
	private double getEI(double income){
		double ei = 0.00;
		
		return ei;
	}
	
	private double getCPP(double income){
		double cpp = 0.00;
		
		return cpp;
	}
	
	
	
	
}
