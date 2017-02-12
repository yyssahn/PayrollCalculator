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
			System.out.println("The gross Income is " + grossIncome);
			System.out.println("the deductable is " + deductable);
			double annualTaxableIncome = getAnnualTaxableIncome(grossIncome, deductable);
			System.out.println("The Annual Taxable income is " + annualTaxableIncome);
			double federalTax;
			double eiSoFar = eiCppPanel.getEi();
			double cppSoFar = eiCppPanel.getCpp();
			
			federalTax = getFederalTax(annualTaxableIncome); 
			System.out.println("the cpp is " + getCPP(grossIncome, 0.00, numPayment.getNumber()));
			System.out.println("the ei is " + getEI(2000,0));
		}
	}
	
	
	private double getTaxableIncome(){
		return 0.0;
	}
	private double getAnnualTaxableIncome(double income, double deductable){
		double ret = numPayment.getNumber() * (income-deductable);
		return roundCurrency(ret);
	}
	
	private double getFederalTax(double income){
		federalTax = federalTax.getConstant(income);
		double totalTax = (income * federalTax.getRate()) - federalTax.getConstant();
		
		
		
		return totalTax;
	}
	
	private double getEI(double income, double paidSoFar){
		double ei;
		double  a= 0.0163 * income;
		double b = 836.19 - paidSoFar;
		ei = (Math.min(a, b) > 0) ? Math.min(a, b):0;
		
		return roundCurrency(ei);
	}
	
	public double getCPP(double income, double paidSoFar, double PayPeriods){
		double a = 2564.10 - paidSoFar;
		double b = 0.0495 * (income - (3500.0 / PayPeriods));
		double cpp = Math.min(a, b);
		cpp = (cpp > 0)? cpp: 0;
		return roundCurrency(cpp);
	}
	
	
	public double roundCurrency(double currency){
		return (Math.round(currency * 100.0) / 100.0);

	}
	
}
