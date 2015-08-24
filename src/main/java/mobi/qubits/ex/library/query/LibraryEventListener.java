package mobi.qubits.ex.library.query;

import mobi.qubits.ex.library.domain.events.NewLibraryRegisteredEvent;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author yizhuan
 *
 */
@Component
public class LibraryEventListener {

	@Autowired
	private LibraryEntryRepository libraryEntryRepository;

	@EventHandler
	void on(NewLibraryRegisteredEvent event) {
		LibraryEntry entry = new LibraryEntry(event.getLibraryId(),event.getName());
		libraryEntryRepository.save(entry);
	}

}
