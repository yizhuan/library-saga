package mobi.qubits.ex.library.domain.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * 
 * @author yizhuan
 *
 */
public class ReturnCommand  implements LibraryCommand{

	@TargetAggregateIdentifier
	private final String libraryId;
	
	private String bookId;
	private String borrowerId;
	
	public ReturnCommand(String libraryId, String bookId, String borrowerId) {
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
