package mobi.qubits.ex.library.domain.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * A reader borrows a book.
 * 
 * @author yizhuan
 *
 */
public class BorrowCommand implements LibraryCommand{

	@TargetAggregateIdentifier
	private final String libraryId;
	
	private String bookId;
	
	private String borrowerId;

	
	
	public BorrowCommand(String libraryId, String bookId, String borrowerId) {
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
