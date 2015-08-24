package mobi.qubits.ex.library.domain.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * 
 * @author yizhuan
 *
 */
public class RegisterNewLibraryCommand  implements LibraryCommand{
	
	@TargetAggregateIdentifier
	private final String libraryId;
	
	private final String name;

	public RegisterNewLibraryCommand(String libraryId, String name) {
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
