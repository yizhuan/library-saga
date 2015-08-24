package mobi.qubits.ex.library.api.requests;


/**
 * 
 * @author yizhuan
 *
 */
public class BookRequest {

	private String bookId;

	public BookRequest(){
		
	}

	public BookRequest(String bookId) {
		super();
		
		this.bookId = bookId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	
}
