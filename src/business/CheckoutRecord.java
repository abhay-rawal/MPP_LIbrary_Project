package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
	public List<CheckoutRecordEntry> checkoutRecordEntry;
	public CheckoutRecord() {
		checkoutRecordEntry = new ArrayList<>();
	}
}
