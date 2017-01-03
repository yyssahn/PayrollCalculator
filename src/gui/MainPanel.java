package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;

import controller.CalculatorController;

import java.awt.Event;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainPanel extends Panel {
	
	private JLabel mLabel1,paymentSpinnerLabel, grossPayLabel, bonusPayLabel, rrspPayLabel, rppPayLabel, prppPayLabel, unionPayLabel, otherPayLabel, alimonyPayLabel;
	private JButton calculateButton;
	private JTextField mTextField1;
	private JFormattedTextField grossPay, bonusPay, rrspPay, rppPay, prppPay, unionPay, otherPay, alimonyPay;
	private JRadioButton radio1, radio2, radio3, radio4;
	private JSlider slider;
	private JList list;
	private JSpinner paymentSpinner;
	DefaultListModel defList= new DefaultListModel();
	
	public MainPanel(){
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(700,350));
		setUI();
		//setListener();
	}
	private void setUI(){
		
		
		/*
		 * TODO: plus bonus / taxable benefit / rrsp / tax exempt
		 * minus union due / other deduction approved by tax service / alimony 
		 * prescribed zone 
		 * plus DONE: bonus
		 * minus DONE:employee's rrsp, rpp, prpp / 
		 */
		createPaymentSpinner();
		
		createGrossPay();
		
		bonusPayLabel = new JLabel("Bonus");
		bonusPayLabel.setPreferredSize(new Dimension(280,20));
		bonusPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		bonusPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(bonusPayLabel);
		
		bonusPay = getCurrencyTextField();
		bonusPay.setValue(0.00);
		bonusPay.setPreferredSize(new Dimension(280,20));
		this.add(bonusPay);
	
		
		
		createrrsp();
		
		rppPayLabel = new JLabel("RPP Pay");
		rppPayLabel.setPreferredSize(new Dimension(280,20));
		rppPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		rppPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(rppPayLabel);
		
		rppPay = getCurrencyTextField();
		rppPay.setValue(0.00);
		rppPay.setPreferredSize(new Dimension(280,20));
		this.add(rppPay);
	
		prppPayLabel = new JLabel("PRPP Pay");
		prppPayLabel.setPreferredSize(new Dimension(280,20));
		prppPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		prppPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(prppPayLabel);
		
		prppPay = getCurrencyTextField();
		prppPay.setValue(0.00);
		prppPay.setPreferredSize(new Dimension(280,20));
		this.add(prppPay);
		
		
		prppPayLabel = new JLabel("PRPP Pay");
		prppPayLabel.setPreferredSize(new Dimension(280,20));
		prppPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		prppPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(prppPayLabel);
		
		prppPay = getCurrencyTextField();
		prppPay.setValue(0.00);
		prppPay.setPreferredSize(new Dimension(280,20));
		this.add(prppPay);


		unionPayLabel = new JLabel("Union Pay");
		unionPayLabel.setPreferredSize(new Dimension(280,20));
		unionPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		unionPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(unionPayLabel);
		
		unionPay = getCurrencyTextField();
		unionPay.setValue(0.00);
		unionPay.setPreferredSize(new Dimension(280,20));
		this.add(unionPay);

		otherPayLabel = new JLabel("Other Deduction Pay");
		otherPayLabel.setPreferredSize(new Dimension(280,20));
		otherPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		otherPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(otherPayLabel);
		
		otherPay = getCurrencyTextField();
		otherPay.setValue(0.00);
		otherPay.setPreferredSize(new Dimension(280,20));
		this.add(otherPay);

		alimonyPayLabel = new JLabel("Alimony Pay");
		alimonyPayLabel.setPreferredSize(new Dimension(280,20));
		alimonyPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		alimonyPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(alimonyPayLabel);
		
		alimonyPay = getCurrencyTextField();
		alimonyPay.setValue(0.00);
		alimonyPay.setPreferredSize(new Dimension(280,20));
		this.add(alimonyPay);
		
		
		calculateButton = new JButton("Calculate Payroll");
		calculateButton.setPreferredSize(new Dimension(250,20));
		this.add(calculateButton);
		
		
		/*
		mLabel1 = new JLabel("Tell me something");
				
		this.add(mLabel1);
		
		mButton1 = new JButton("Kill me");
		
		this.add(mButton1);
		
		
		mTextField1 = new JTextField("0.00",19);
		this.add(mTextField1);
		
		mTextField1.requestFocus();
		
		radio1 = new JRadioButton("1");
		radio2 = new JRadioButton("2");
		radio3 = new JRadioButton("3");
		radio4 = new JRadioButton("4");
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		group.add(radio4);
		this.add(radio1);
		this.add(radio2);
		this.add(radio3);
		this.add(radio4);
		
		
		Border openborder = BorderFactory.createTitledBorder("slider");
		slider = new JSlider(0,99,1);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBorder(openborder);
		this.add(slider);
		
		
		String[] iList = {"aaa","bbbb","Ccc","ddd"};
		list = new JList(iList);
		list.setFixedCellHeight(0);
		list.setFixedCellWidth(250);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setVisibleRowCount(3);;
		JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	     // All the methods for lists
		        
		         * getSelectedIndex(): returns the index for the first selected item
		         * getSelectedIndexes(): returns every selection in a list
		         * getSelectedValue(): returns the value of the first selected
		         * getSelectedValues(): returns an array of all values
		         * isSelectedIndex(): returns true if index is selected
		         
		
		this.add(list);
		this.add(scroller);
		*/
		
		
		
		
	}
	private void createrrsp() {
		rrspPayLabel = new JLabel("RRSP Pay");
		rrspPayLabel.setPreferredSize(new Dimension(280,20));
		rrspPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		rrspPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(rrspPayLabel);
		
		
		rrspPay = getCurrencyTextField();
		rrspPay.setValue(0.00);
		rrspPay.setPreferredSize(new Dimension(280,20));
		this.add(rrspPay);
	}
	private void createGrossPay() {
		grossPayLabel = new JLabel("Gross Pay");
		grossPayLabel.setPreferredSize(new Dimension(280,20));
		grossPayLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		grossPayLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(grossPayLabel);
			
		grossPay = getCurrencyTextField();
		grossPay.setValue(0.00);
		grossPay.setPreferredSize(new Dimension(280,20));
		this.add(grossPay);
	}
	private void createPaymentSpinner() {
		paymentSpinnerLabel = new JLabel("Number of Payments in a year");
		paymentSpinnerLabel.setPreferredSize(new Dimension(280,20));
		paymentSpinnerLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		paymentSpinnerLabel.setHorizontalAlignment(JLabel.LEFT);
		this.add(paymentSpinnerLabel);
		
		String[] templist = {"52 Payments in year","26 Payments in year","12 Payments in year"};
		SpinnerListModel model = new SpinnerListModel(templist);
		
		paymentSpinner = new JSpinner(model);
		paymentSpinner.setPreferredSize(new Dimension(280,20));
		paymentSpinner.enableInputMethods(false);
		paymentSpinner.setEditor(new JSpinner.DefaultEditor(paymentSpinner));
		this.add(paymentSpinner);
	}
/*	
	private void setListener(){
		ButtonListener buttonListener = new ButtonListener(this);
		mButton1.addActionListener(buttonListener);
	}
	
	public JButton getButton(){
		return mButton1;
	
	}
*/	
	private JFormattedTextField getCurrencyTextField(){
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(2);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.00);
		formatter.setMaximum(10000000.00);
		formatter.setAllowsInvalid(false);
		return new JFormattedTextField(formatter);
	}

	public void setListener(MainPanel main, EiCppPanel eicpp, ClaimPanel claim){
		CalculatorController controller = new CalculatorController(main, eicpp, claim);
		
		calculateButton.addActionListener(controller);
	}
	
}
