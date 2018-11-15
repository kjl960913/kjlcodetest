package entities;

public class Currentaccount implements account {
	 private int balance;
	 private int Unclearfunds;
	 private String Accountnumber;
	 private String PIN;
	 private int overdraft;
		
	 public Currentaccount(int balance,int overdraft,int Unclearfunds,String Accountnumber,String PIN) {
			this.balance=balance;
			this.overdraft=overdraft;
			this.Unclearfunds=Unclearfunds;
			this.Accountnumber=Accountnumber;
			this.PIN=PIN;
			
		}
	 
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUnclearfunds() {
		return Unclearfunds;
	}

	public void setUnclearfunds(int unclearfunds) {
		Unclearfunds = unclearfunds;
	}

	public String getAccountnumber() {
		return Accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		Accountnumber = accountnumber;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public int getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public int Depositfunds() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Clearfunds() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Withdrawfunds() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Suspendaccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Restate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Closeaccount() {
		// TODO Auto-generated method stub

	}

}
