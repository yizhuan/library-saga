package mobi.qubits.ex.library.domain.events;


/**
 * 
 * @author yizhuan
 *
 */
public class BorrowEvent implements LibraryEvent{

	private final String libraryId;
	
	private final String borrowerId;//reader
	
	private final String bookId;

	public BorrowEvent(String libraryId, String bookId, String borrowerId) {
		super();
		this.libraryId = libraryId;
		this.borrowerId = borrowerId;
		this.bookId = bookId;
	}


	public String getLibraryId() {
		return libraryId;
	}


	public String getBorrowerId() {
		return borrowerId;
	}


	public String getBookId() {
		return bookId;
	}
	
}
