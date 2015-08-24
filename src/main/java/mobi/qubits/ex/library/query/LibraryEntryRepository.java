package mobi.qubits.ex.library.query;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author yizhuan
 *
 */

public interface LibraryEntryRepository extends MongoRepository<LibraryEntry, String> {
		
}

