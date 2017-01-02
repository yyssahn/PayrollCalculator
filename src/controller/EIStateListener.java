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
		if (source == mPanel.getEiExemptCheckBox()){
			if (source.isSelected()){
				mPanel.disableEiMaxCheckBox();
				mPanel.disableEiTextField();
			}else{
				mPanel.enableEiMaxCheckBox();
				mPanel.enableEiTextField();
			}
		
		}
		if (source == mPanel.getCppExemptCheckBox()){
			System.out.println(source.isSelected());
		}
	}

}
