package mobi.qubits.ex.library.domain.events;


/**
 * 
 * @author yizhuan
 *
 */
public class NewLibraryRegisteredEvent implements LibraryEvent{

	private final String libraryId;
	
	
	private String name;

	public NewLibraryRegisteredEvent(String libraryId, 
			String name) {
		super();
		this.libraryId = libraryId;
		
		this.name = name;
	}

	public String getLibraryId() {
		return libraryId;
	}


	public String getName() {
		return name;
	}


	
}
