package mobi.qubits.ex.library.domain.events;

import java.io.Serializable;

/**
 * 
 * @author yizhuan
 *
 */
public class NewReaderRegisteredEvent implements LibraryEvent{

	private final String libraryId;
	
	private final String readerId;
	
	private String name;

	public NewReaderRegisteredEvent(String libraryId, String readerId,
			String name) {
		super();
		this.libraryId = libraryId;
		this.readerId = readerId;
		this.name = name;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public String getReaderId() {
		return readerId;
	}

	public String getName() {
		return name;
	}


	
}
