package entities;

import java.util.ArrayList;

public class User {
  private String name;
  private String address;
  private String dateofbirth;
  private boolean creditstatus;
  private ArrayList<account> list=new ArrayList<account>();

public User(String name,String address,String dateofbirth,boolean creditstatus) {
	this.name=name;
	this.address=address;
	this.dateofbirth=dateofbirth;
	this.creditstatus=creditstatus;
	
	
	
}  
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public boolean getCreditstatus() {
	return creditstatus;
}
public void setCreditstatus(boolean creditstatus) {
	this.creditstatus = creditstatus;
}
/*public account Openaccount() {
	return new Saveraccount();
}
*/
}
