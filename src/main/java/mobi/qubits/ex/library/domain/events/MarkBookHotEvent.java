package mobi.qubits.ex.library.domain.events;

import java.io.Serializable;

/**
 * 
 * @author yizhuan
 *
 */
public class MarkBookHotEvent implements LibraryEvent{

	private final String libraryId;
	
	private final String id;

	public MarkBookHotEvent(String libraryId, String id) {
		super();
		this.libraryId = libraryId;
		this.id = id;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public String getId() {
		return id;
	}

	

	
}
