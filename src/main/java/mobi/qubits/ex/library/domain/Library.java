package mobi.qubits.ex.library.domain;

import mobi.qubits.ex.library.domain.commands.BorrowCommand;
import mobi.qubits.ex.library.domain.commands.MarkBookHotCommand;
import mobi.qubits.ex.library.domain.commands.RegisterNewBookCommand;
import mobi.qubits.ex.library.domain.commands.RegisterNewLibraryCommand;
import mobi.qubits.ex.library.domain.commands.RegisterNewReaderCommand;
import mobi.qubits.ex.library.domain.commands.ReturnCommand;
import mobi.qubits.ex.library.domain.events.BorrowEvent;
import mobi.qubits.ex.library.domain.events.MarkBookHotEvent;
import mobi.qubits.ex.library.domain.events.NewBookRegisteredEvent;
import mobi.qubits.ex.library.domain.events.NewLibraryRegisteredEvent;
import mobi.qubits.ex.library.domain.events.NewReaderRegisteredEvent;
import mobi.qubits.ex.library.domain.events.ReturnEvent;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

/**
 * 
 * @author yizhuan
 *
 */
public class Library extends AbstractAnnotatedAggregateRoot<String> {

	private static final long serialVersionUID = 4245371056740478404L;

	@AggregateIdentifier
	private String id;

	Library() {

	}
	
	@CommandHandler
	public Library(RegisterNewLibraryCommand cmd) {
		apply(new NewLibraryRegisteredEvent(cmd.getLibraryId(), cmd.getName()));
	}	
	
	@CommandHandler
	public void on(RegisterNewBookCommand cmd) {
		apply(new NewBookRegisteredEvent(cmd.getLibraryId(), cmd.getBookId(), cmd.getTitle(),
				cmd.getAuthor()));
	}			
		
	@CommandHandler
	public void on(MarkBookHotCommand cmd) {
		apply(new MarkBookHotEvent(cmd.getLibraryId(), cmd.getBookId()));
	}	
	
	
	@CommandHandler
	public void on(RegisterNewReaderCommand cmd) {
		apply(new NewReaderRegisteredEvent(cmd.getLibraryId(), cmd.getReaderId(), cmd.getName()));
	}	
	
	@CommandHandler
	public void on(BorrowCommand cmd){ 			
		apply(new BorrowEvent(cmd.getLibraryId(), cmd.getBookId(), cmd.getBorrowerId()));
	}
		
	
	@CommandHandler
	public void on(ReturnCommand cmd){
		apply(new ReturnEvent(cmd.getLibraryId(), cmd.getBookId(), cmd.getBorrowerId()));
	}		
	
	
	
	@EventSourcingHandler
	void on(NewLibraryRegisteredEvent event) {
		this.id = event.getLibraryId();
	}
	
	
	@EventSourcingHandler
	void on(NewBookRegisteredEvent event) {
		
	}

	@EventSourcingHandler
	void on(MarkBookHotEvent event) {

	}		
		
	@EventSourcingHandler
	void on(NewReaderRegisteredEvent event) {
		
	}	
		
	@EventSourcingHandler
	void on(BorrowEvent event) {
	}	

	@EventSourcingHandler
	void on(ReturnEvent event) {
	}
	
	
	
}
