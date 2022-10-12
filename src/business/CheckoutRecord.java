package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
	private String memberId;
	public List<CheckoutRecordEntry> checkoutRecordEntries;

	public CheckoutRecord(String memberId) {
		checkoutRecordEntries = new ArrayList<>();
		this.setMemberId(memberId);
	}

	

	public void addCheckoutEntry(BookCopy bookCopy) {

		LocalDate today = LocalDate.now();
		int maxCheckoutLength = bookCopy.getBook().getMaxCheckoutLength();
		LocalDate dueDate = today.plusDays(maxCheckoutLength);
		CheckoutRecordEntry checkoutEntry = new CheckoutRecordEntry(this, today, dueDate);
		checkoutRecordEntries.add(checkoutEntry);

	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



}
