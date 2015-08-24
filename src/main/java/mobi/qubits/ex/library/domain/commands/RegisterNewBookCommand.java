package mobi.qubits.ex.library.domain.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * 
 * @author yizhuan
 *
 */
public class RegisterNewBookCommand  implements LibraryCommand{
	
	@TargetAggregateIdentifier
	private final String libraryId;
	
	private String bookId;
	
	private String title;
	private String author;
	
	public RegisterNewBookCommand(String libraryId, String bookId,
			String title, String author) {
		super();
		this.libraryId = libraryId;
		this.bookId = bookId;
		this.title = title;
		this.author = author;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public String getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	

}
