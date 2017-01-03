package constants;

public enum BCClaimCodes {
	ZERO(0.00,0.00),
	ONE(10208.00,512.52),
	TWO(11356.50,574.64),
	THREE(13653.50,690.87),
	FOUR(15950.50,807.10),
	FIVE(18247.50,923.32),
	SIX(20544.50,1039.55),
	SEVEN(22841.50,1155.78),
	EIGHT(25138.50,1272.01),
	NINE(27435.50,1388.24),
	TEN(29732.50,1504.46);
	
	
	private final double tcamount;
	private final double k1amount;
	BCClaimCodes(double tc, double k1){
		this.tcamount = tc;
		this.k1amount = k1;
		
	}
	
	public double getTC(){
		return this.tcamount;
	}
	public double getK1(){
		return this.k1amount;
	}
	
	public BCClaimCodes getCode(double amount){
		for (BCClaimCodes code : BCClaimCodes.values()){
			
		}
		return BCClaimCodes.EIGHT;
	}
}
