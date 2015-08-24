package mobi.qubits.ex.library.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * 
 * @author yizhuan
 *
 */
public class ReaderEntry {

	@Id
	private String id;
	
	private String libraryId;

	private String name;
	
	private List<String> borrowedBookIds = new ArrayList<String>();

	public ReaderEntry() {
		super();
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getBorrowedBookIds() {
		return borrowedBookIds;
	}

	public void setBorrowedBookIds(List<String> bookIds) {
		this.borrowedBookIds = bookIds;
	}

	public void addBorrowedBook(String bookId){
		if (borrowedBookIds==null)
			borrowedBookIds = new ArrayList<String>();
		this.borrowedBookIds.add(bookId);
	}
	
	public void removeBorrowedBook(String bookId){
		if (borrowedBookIds==null)
			return;
		this.borrowedBookIds.remove(bookId);
	}
	
	public boolean hasBook(String bookId){
		return borrowedBookIds.contains(bookId);
	}	
	
	public int getNumberOdBooksBorrowed(){
		return borrowedBookIds.size();
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((libraryId == null) ? 0 : libraryId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReaderEntry other = (ReaderEntry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libraryId == null) {
			if (other.libraryId != null)
				return false;
		} else if (!libraryId.equals(other.libraryId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
