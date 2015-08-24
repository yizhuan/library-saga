package mobi.qubits.ex.library;

import mobi.qubits.ex.library.domain.Library;

import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.mongo.DefaultMongoTemplate;
import org.axonframework.eventstore.mongo.MongoEventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * @author yizhuan
 *
 */
@Configuration
@Import(AxonConfiguration.class)
public class LibraryConfiguration {
	@Autowired
	AxonConfiguration axonconf;

	
	@Bean
	public EventSourcingRepository<Library> libraryRepository() {

		DefaultMongoTemplate template = new DefaultMongoTemplate(axonconf.mongo);
		MongoEventStore eventStore = new MongoEventStore(template
				);
		EventSourcingRepository<Library> repository = new EventSourcingRepository<Library>(
				Library.class, eventStore);
		repository.setEventBus(axonconf.eventBus());
		return repository;
	}	

	@Bean
	public AggregateAnnotationCommandHandler<Library> libraryCommandHandler() {
		AggregateAnnotationCommandHandler<Library> commandHandler = AggregateAnnotationCommandHandler
				.subscribe(Library.class, libraryRepository(), axonconf.commandBus());
		return commandHandler;
	}
		
	
}
