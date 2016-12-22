package controller;

import gui.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener{
	MainPanel mPanel;
	
	public ButtonListener(MainPanel panel){
		mPanel = panel;		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("button is pressed");
		if (event.getSource() == mPanel.getButton()){
			JOptionPane.showMessageDialog(mPanel, "kill me","title", JOptionPane.ERROR_MESSAGE);
		}
	}

}
