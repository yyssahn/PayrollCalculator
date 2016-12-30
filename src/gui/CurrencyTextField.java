package gui;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

public class CurrencyTextField extends JFormattedTextField{

	

	public CurrencyTextField(){
		
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(2);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.00);
		formatter.setMaximum(10000000.00);
		formatter.setAllowsInvalid(false);
		this.setFormatter(formatter);
		super.setFormatter(formatter);
	}
}
