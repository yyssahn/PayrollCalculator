package constants;

public enum FederalClaimCodes {
	ZERO(0.00,0.00),
	ONE(11635.00,1745.25),
	TWO(12746.50,1911.98),
	THREE(14969.50,2245.43),
	FOUR(17192.50,2578.88),
	FIVE(19415.50,2912.33),
	SIX(21638.50,3245.78),
	SEVEN(23861.50,3579.23),
	EIGHT(26084.50,3912.68),
	NINE(28307.50,4246.13),
	TEN(30530.50,4579.58);
	
	
	private final double tcamount;
	private final double k1amount;
	FederalClaimCodes(double tc, double k1){
		this.tcamount = tc;
		this.k1amount = k1;
		
	}
	
	public double getTC(){
		return this.tcamount;
	}
	public double getK1(){
		return this.k1amount;
	}
	
	public FederalClaimCodes getCode(int index){
		switch(index){
		case 0:	return ZERO;
		case 1: return ONE;
		case 2: return TWO;
		case 3: return THREE;
		case 4: return FOUR;
		case 5: return FIVE;
		case 6: return SIX;
		case 7: return SEVEN;
		case 8: return EIGHT;
		case 9: return NINE;
		case 10: return TEN;
		
		
		}
		return FederalClaimCodes.ZERO;
		
	}
}
