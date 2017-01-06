package constants;

public enum FederalTaxConstants {
	ZERO(0,45916,0.150,0),
	ONE(45916,91831,0.205,2525),
	TWO(91831,142353,0.260,7576),
	THREE(142353,202800,0.290,11847),
	FOUR(202800,Integer.MAX_VALUE,0.330,19959);
	
	int min;
	int max;
	double rate;
	double constant;
	
	FederalTaxConstants (int i, int j, double r, double c){
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
	
	public FederalTaxConstants getConstant(double income){
		
		if (income <= 0 && income <=45916){
		return this.ZERO;
		}else if (income<45916 && income<=91831){
			return this.ONE;
		}else if (income<91831 && income<=142353){
			return this.TWO;
		}else if (income<142353 && income<=202800){
			return this.THREE;
		}else return this.FOUR;
		
		
	}
}
