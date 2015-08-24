package mobi.qubits.ex.library.query;

import mobi.qubits.ex.library.domain.events.BorrowEvent;
import mobi.qubits.ex.library.domain.events.NewReaderRegisteredEvent;
import mobi.qubits.ex.library.domain.events.ReturnEvent;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author yizhuan
 *
 */
@Component
public class ReaderEventListener {
	
	@Autowired
	private ReaderEntryRepository readerRepository;

	@EventHandler
	void on(NewReaderRegisteredEvent event) {
		
		ReaderEntry reader = new ReaderEntry();
		reader.setId(event.getReaderId());
		reader.setLibraryId(event.getLibraryId());
		reader.setName(event.getName());
		readerRepository.save(reader);
	}	
	
	@EventHandler
	void on(BorrowEvent event) {
		ReaderEntry reader = readerRepository.findOne(event.getBorrowerId());		
		reader.addBorrowedBook(event.getBorrowerId());		
		readerRepository.save(reader);
	}
	
	
	@EventHandler
	void on(ReturnEvent event) {		
		ReaderEntry reader = readerRepository.findOne(event.getBorrowerId());
		reader.removeBorrowedBook(event.getBookId());		
		readerRepository.save(reader);							
	}
	

}
