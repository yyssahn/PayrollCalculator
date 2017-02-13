package constants;

public enum ProvincialTaxConstants {
	ZERO(0,38898,0.0506,0),
	ONE(38898,77797,0.0770,1027),
	TWO(77797,89320,0.1050,3205),
	THREE(89320,108460,0.1229,4804),
	FOUR(108460,Integer.MAX_VALUE,0.1470,7418);
	
	int min;
	int max;
	double rate;
	double constant;
	
	ProvincialTaxConstants (int i, int j, double r, double c){
		min = i;
		max = j;
		rate = r;
		constant = c;
	}
	
	
	public int getMin(){
		return this.min;
	}
	public int getMax(){
		return this.max;
	}
	public double getRate(){
		return this.rate;
	}
	public double getConstant(){
		return this.constant;
	}
	
	public ProvincialTaxConstants updateConstant(double income){
		if (income >= 0 && income <=38898){
			return this.ZERO;
		}else if (income>38898 && income<=77797){
			return this.ONE;
		}else if (income>77797 && income<=89320){
			return this.TWO;
		}else if (income>89320 && income<=108460){
			return this.THREE;
		}else return this.FOUR;
		
		
	}
}
