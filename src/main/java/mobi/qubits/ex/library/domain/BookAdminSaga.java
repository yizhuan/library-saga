package mobi.qubits.ex.library.domain;

import mobi.qubits.ex.library.domain.commands.MarkBookHotCommand;
import mobi.qubits.ex.library.domain.events.BorrowEvent;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author yizhuan
 *
 */
public class BookAdminSaga extends AbstractAnnotatedSaga {

	private static final long serialVersionUID = -5929174026616232734L;

	private int popularityCount = 0;

	@Autowired
	private transient CommandGateway cmdGateway;	
		
	@StartSaga
	@SagaEventHandler(associationProperty = "bookId")
	public void handle(BorrowEvent event) {
		popularityCount++;
		if (popularityCount == 5) {
			cmdGateway.send(new MarkBookHotCommand(event.getLibraryId(), event.getBookId()));
			end();
		}
	}

}
