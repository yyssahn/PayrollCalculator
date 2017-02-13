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
import constants.ProvincialTaxConstants;

public class CalculatorController implements ActionListener{
	private MainPanel mainPanel;
	private EiCppPanel eiCppPanel;
	private ClaimPanel claimPanel;

	private FederalClaimCodes federalCode;
	private BCClaimCodes provincialCode;
	private FederalTaxConstants federalTaxConstant;
	private ProvincialTaxConstants provincialTaxConstant;
	private PaymentNumber numPayment;
	private boolean eiMax;
	private boolean eiExempt;
	private boolean cppMax;
	private boolean cppExempt;
	private double cpp, ei, eiSoFar, cppSoFar; 
	private double taxableIncome, grossIncome,deductable,annualTaxableIncome, federalTax, provincialTax;
	public CalculatorController(MainPanel main, EiCppPanel eicpp, ClaimPanel claim){
		mainPanel = main;
		eiCppPanel = eicpp;
		claimPanel = claim;

		federalCode = FederalClaimCodes.ZERO;
		provincialCode = BCClaimCodes.ZERO;
		numPayment = PaymentNumber.WEEKLY;
		federalTaxConstant = FederalTaxConstants.ZERO;
		provincialTaxConstant = ProvincialTaxConstants.ZERO;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == mainPanel.getCalculateButton()){
			updateConstants();
			calculateIncome();
			calculateEI();
			calculateCPP();
			calculateFederalTax(); 
			calculateProvincialTax();
			showResult();
		}
	}
	private void showResult() {
		JOptionPane.showMessageDialog(mainPanel, "Income during time period : " + grossIncome+
				"\nTaxable Income for time period" + taxableIncome + 
				"\nFederal Tax Deduction : " + federalTax + 
				"\nProvincial Tax Deduction : " + provincialTax + 
				"\nCPP deduction : " + cpp + 
				"\nEI deduction : " + ei + 
				"\nNet Amount : " + roundCurrency(taxableIncome - federalTax - provincialTax - cpp - ei)				
				,"Result", JOptionPane.PLAIN_MESSAGE);
	}
	private void calculateProvincialTax() {
		provincialTaxConstant = provincialTaxConstant.updateConstant(annualTaxableIncome);
		provincialTax = getProvincialTax(annualTaxableIncome, provincialCode, cpp, ei);
	}
	private void calculateFederalTax() {
		federalTaxConstant = federalTaxConstant.updateConstant(annualTaxableIncome);
		federalTax = getFederalTax(annualTaxableIncome, federalCode, cpp, ei);
	}
	private void calculateCPP() {
		if (cppMax){
			cppSoFar =2564.10;
			cpp = getCPP(grossIncome,cppSoFar, numPayment.getNumber());
		}else if(cppExempt){
			cpp = 0.0;
		}
		else{
			cppSoFar = eiCppPanel.getCpp();
			cpp = getCPP(grossIncome, cppSoFar, numPayment.getNumber());
		}
	}
	private void calculateEI() {
		if (eiMax){
			eiSoFar = 836.19;
			ei = getEI(grossIncome, eiSoFar);
		} else if(eiExempt){
			ei = 0;
		}else {
			eiSoFar = eiCppPanel.getEi();
			ei = getEI(grossIncome, eiSoFar);
		}
	}
	private void calculateIncome() {
		grossIncome = mainPanel.getGrossPay();
		deductable = mainPanel.getDeductables();
		annualTaxableIncome = getAnnualTaxableIncome(grossIncome, deductable);
		taxableIncome = roundCurrency(annualTaxableIncome/ numPayment.getNumber());
	}
	private void updateConstants() {
		federalCode = federalCode.getCode(claimPanel.getFederalIndex());
		provincialCode = provincialCode.getCode(claimPanel.getProvincialIndex());
		numPayment = numPayment.getPaymentNumber(mainPanel.getPaymentIndex());
		eiMax = eiCppPanel.getEiMaxCheckBox().isSelected();
		eiExempt = eiCppPanel.getEiExemptCheckBox().isSelected();
		cppMax = eiCppPanel.getCppMaxCheckBox().isSelected();
		cppExempt = eiCppPanel.getCppExemptCheckBox().isSelected();
	}
	
	
	private double getProvincialTax(double annualTaxableIncome, BCClaimCodes provincialCode, double cpp, double ei) {
		// TODO Auto-generated method stub
		double provincialTax, totalProvincialTax;
		double k1P = 0.0506 * provincialCode.getTC();
		double k2P, k2PCpp, k2PEi;
		if (cppMax){
			k2PCpp =roundCurrency(2564.1 *0.0506);
		}else if(cppExempt){
			k2PCpp = 0.0;
		}else{
			k2PCpp = roundCurrency(0.0506*Math.min((numPayment.getNumber()*cpp), 2564.10));
		}
		if  (eiMax){
			k2PEi = roundCurrency(836.19 *0.0506);
		}else if (eiExempt){
			k2PEi = 0.0;
		}else{
			k2PEi = roundCurrency(0.0506*Math.min((numPayment.getNumber()*ei), 836.19));
		}
		k2P = k2PCpp+ k2PEi;

		totalProvincialTax =  (annualTaxableIncome * provincialTaxConstant.getRate()) - provincialTaxConstant.getConstant() - k1P - k2P;
		provincialTax = roundCurrency(totalProvincialTax / numPayment.getNumber());
		return provincialTax;
		
		
	}
	private double getTaxableIncome(){
		return 0.0;
	}
	private double getAnnualTaxableIncome(double income, double deductable){
		double ret = numPayment.getNumber() * (income-deductable);
		return roundCurrency(ret);
	}
	
	private double getFederalTax(double income, FederalClaimCodes TC, double cpp, double ei){
		double totalTax = (income * federalTaxConstant.getRate()) - federalTaxConstant.getConstant();
		
		double k1 = TC.getTC() *0.15;
		double k2;
		double k2Cpp;
		double k2Ei;
		if (cppMax){
			k2Cpp =roundCurrency(2564.1 *0.15);
		}else if(cppExempt){
			k2Cpp = 0.0;
		}else{
			k2Cpp = roundCurrency(0.15*Math.min((numPayment.getNumber()*cpp), 2564.10));
		}
		if  (eiMax){
			k2Ei = roundCurrency(836.19 *0.15);
		}else if (eiExempt){
			k2Ei = 0.0;
		}else{
			k2Ei = roundCurrency(0.15*Math.min((numPayment.getNumber()*ei), 836.19));
		}
		k2 = k2Cpp+ k2Ei;
		double k4 =  Math.min(0.15* income, 0.15*1178.0);
		double basicFederalTax =roundCurrency( (totalTax - k1 - k2 - k4)/numPayment.getNumber());
		return basicFederalTax;
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
