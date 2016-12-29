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

import controller.ButtonListener;

import java.awt.Event;
import java.util.ArrayList;

public class MainPanel extends Panel {
	
	private JLabel mLabel1,paymentSpinnerLabel;
	private JButton mButton1;
	private JTextField mTextField1;
	private JRadioButton radio1, radio2, radio3, radio4;
	private JSlider slider;
	private JList list;
	private JSpinner paymentSpinner;
	DefaultListModel defList= new DefaultListModel();
	
	public MainPanel(){
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(700,350));
		setUI();
		setListener();
	}
	private void setUI(){
		
		paymentSpinnerLabel = new JLabel("Number of Payments in a year");
		this.add(paymentSpinnerLabel);
		
		String[] templist = {"52 Payments in year","26 Payments in year","12 Payments in year"};
		SpinnerListModel model = new SpinnerListModel(templist);
		paymentSpinner = new JSpinner(model);
		paymentSpinner.enableInputMethods(false);
		paymentSpinner.setEditor(new JSpinner.DefaultEditor(paymentSpinner));
		this.add(paymentSpinner);
		
		
		mLabel1 = new JLabel("Tell me something");
		System.out.println(mLabel1.getHeight());
		this.add(mLabel1);
		
		mButton1 = new JButton("Kill me");
		mButton1.setPreferredSize(new Dimension(300,300));
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
		        /*
		         * getSelectedIndex(): returns the index for the first selected item
		         * getSelectedIndexes(): returns every selection in a list
		         * getSelectedValue(): returns the value of the first selected
		         * getSelectedValues(): returns an array of all values
		         * isSelectedIndex(): returns true if index is selected
		         */

		this.add(list);
		this.add(scroller);
		
		
	}
	
	private void setListener(){
		ButtonListener buttonListener = new ButtonListener(this);
		mButton1.addActionListener(buttonListener);
	}
	
	public JButton getButton(){
		return mButton1;
	
	}
	
}
