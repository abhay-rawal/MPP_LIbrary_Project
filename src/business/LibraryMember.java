package business;

public class LibraryMember extends Person{
 private String memberID;

public LibraryMember(String memberID) {
	super();
	this.memberID = memberID;
}

public String getMemberID() {
	return memberID;
}

public void setMemberID(String memberID) {
	this.memberID = memberID;
}
 
}
