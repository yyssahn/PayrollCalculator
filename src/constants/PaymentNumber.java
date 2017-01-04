package constants;

public enum PaymentNumber {
	WEEKLY(52),
	BIWEEKLY(26),
	MONTHLY(12);
	int number;
	PaymentNumber(int num){
		this.number= num;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public PaymentNumber getPaymentNumber(int index){
		switch(index){
			case 0:
				return this.WEEKLY;
			case 1:
				return this.BIWEEKLY;
			case 2:
				return this.MONTHLY;
			default:
				return this.WEEKLY;
		}
		
	}
}
