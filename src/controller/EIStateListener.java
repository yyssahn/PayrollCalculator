package controller;

import gui.EiCppPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;


public class EIStateListener implements ItemListener {
	
	EiCppPanel mPanel;
	
	public EIStateListener(EiCppPanel panel){
		 mPanel = panel;		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox source =(JCheckBox) e.getItemSelectable();
		// TODO Auto-generated method stub
		if (source == mPanel.geteiCheckBox()){
			System.out.println(source.isSelected());
		}
		if (source == mPanel.getCPPCheckBox()){
			System.out.println(source.isSelected());
		}
	}

}
