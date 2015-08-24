package mobi.qubits.ex.library.query;

import mobi.qubits.ex.library.domain.events.BorrowEvent;
import mobi.qubits.ex.library.domain.events.MarkBookHotEvent;
import mobi.qubits.ex.library.domain.events.NewBookRegisteredEvent;
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
public class BookEventListener {

	@Autowired
	private BookEntryRepository bookEntryRepository;

	@EventHandler
	void on(NewBookRegisteredEvent event) {
		BookEntry book = new BookEntry();
		book.setId(event.getBookId());
		book.setLibraryId(event.getLibraryId());
		book.setTitle(event.getTitle());
		book.setAuthor(event.getAuthor());
		book.setBorrowerId(null);
		bookEntryRepository.save(book);
	}
	
	@EventHandler
	void on(MarkBookHotEvent event) {
		BookEntry book = bookEntryRepository.findOne(event.getId());
		book.setIsHot(true);
		bookEntryRepository.save(book);
	}
	
	@EventHandler
	void on(BorrowEvent event) {

		BookEntry book = bookEntryRepository.findOne(event.getBookId());
		
		book.setBorrowerId(event.getBorrowerId());
		book.setBorrowed(true);		
		bookEntryRepository.save(book);
	
	}
	
	
	@EventHandler
	void on(ReturnEvent event) {
		
		BookEntry book = bookEntryRepository.findOne(event.getBookId());
		
		book.setBorrowed(false);
		book.setBorrowerId(null);				
		bookEntryRepository.save(book);
				
	}
		
	

}
