package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntry implements Serializable{
	private static final long serialVersionUID = -9000891200460765128L;
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
	
	@Override
	public String toString()
	{
		return "checkoutDate:"+checkoutDate+" dueDate"+dueDate;
	}
	
//	public void addCheckoutEntry()
//	{
//		
//	}
}
