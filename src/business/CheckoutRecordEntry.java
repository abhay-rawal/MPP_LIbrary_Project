package business;

import java.time.LocalDate;

public class CheckoutRecordEntry {
	private CheckoutRecord checkoutRecord;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	public CheckoutRecordEntry(CheckoutRecord checkoutRecord, LocalDate checkoutDate, LocalDate dueDate) {
		this.checkoutRecord = checkoutRecord;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}
	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
}
