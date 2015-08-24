package mobi.qubits.ex.library.domain.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * 
 * @author yizhuan
 *
 */
public class MarkBookHotCommand implements LibraryCommand{

	@TargetAggregateIdentifier
	private final String libraryId;
	
	private String bookId;

	public MarkBookHotCommand(String libraryId, String bookId) {
		super();
		this.libraryId = libraryId;
		this.bookId = bookId;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public String getBookId() {
		return bookId;
	}

	
}
