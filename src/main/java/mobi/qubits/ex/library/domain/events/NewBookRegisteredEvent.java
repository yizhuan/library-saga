package mobi.qubits.ex.library.domain.events;

import java.io.Serializable;

/**
 * 
 * @author yizhuan
 *
 */
public class NewBookRegisteredEvent implements LibraryEvent{
	
	private final String libraryId;
	
	private final String bookId;
	
	private String title;
	private String author;
	
	public NewBookRegisteredEvent(String libraryId, String bookId,
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
