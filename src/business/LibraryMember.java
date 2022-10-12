package business;

public class LibraryMember extends Person{
 private String memberId;


public LibraryMember(String memberId, String firstName, String lastName, String PhoneNumber, Address address ) {
	super(firstName,lastName,address,PhoneNumber);
	this.memberId = memberId;
}

public String getMemberId() {
	return memberId;
}

public void setMemberID(String memberID) {
	this.memberId = memberID;
}
 
}
