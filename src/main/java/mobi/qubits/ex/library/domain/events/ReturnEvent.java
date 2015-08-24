package mobi.qubits.ex.library.domain.events;

/**
 * 
 * @author yizhuan
 *
 */
public class ReturnEvent implements LibraryEvent{

	private final String libraryId;
	
	
	private final String bookId;
	
	private final String borrowerId;

	public ReturnEvent(String libraryId, String bookId, String borrowerId) {
		super();
		this.libraryId = libraryId;
		this.bookId = bookId;
		this.borrowerId = borrowerId;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public String getBookId() {
		return bookId;
	}

	public String getBorrowerId() {
		return borrowerId;
	}
	


}
