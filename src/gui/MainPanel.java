package gui;

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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import controller.ButtonListener;

import java.awt.Event;

public class MainPanel extends Panel {
	
	private JLabel mLabel1;
	private JButton mButton1;
	private JTextField mTextField1;
	private JRadioButton radio1, radio2, radio3, radio4;
	private JSlider slider;
	private JList list;
	DefaultListModel defList= new DefaultListModel();
	MainPanel(){
		setUI();
		setListener();
	}
	private void setUI(){
		
		
		mLabel1 = new JLabel("Tell me something");
		this.add(mLabel1);
		
		mButton1 = new JButton("Send");
		this.add(mButton1);
		
		
		mTextField1 = new JTextField("0.00",19);
		mTextField1.requestFocus();
		this.add(mTextField1);
		
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
		list.setFixedCellHeight(30);
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
