package mobi.qubits.ex.library.domain.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * 
 * @author yizhuan
 *
 */
public class RegisterNewReaderCommand  implements LibraryCommand{

	@TargetAggregateIdentifier
	private final String libraryId;
	
	private String readerId;
	private String name;

	public RegisterNewReaderCommand(String libraryId, String readerId, String name) {
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
