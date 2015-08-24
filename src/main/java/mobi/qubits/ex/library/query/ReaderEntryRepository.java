package mobi.qubits.ex.library.query;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author yizhuan
 *
 */

public interface ReaderEntryRepository extends
		MongoRepository<ReaderEntry, String> {

}
