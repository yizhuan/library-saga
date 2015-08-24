package mobi.qubits.ex.library.query;

import org.springframework.data.annotation.Id;

public class LibraryEntry {
	
	@Id
	private String id;
	
	private String name;

	
	
	public LibraryEntry() {
		super();
	}

	public LibraryEntry(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
