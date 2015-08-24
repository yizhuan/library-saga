package mobi.qubits.ex.library.api;

import java.util.List;

import javax.validation.Valid;

import mobi.qubits.ex.library.api.requests.BookRequest;
import mobi.qubits.ex.library.api.requests.RegisterLibraryRequest;
import mobi.qubits.ex.library.api.requests.RegisterReaderRequest;
import mobi.qubits.ex.library.domain.commands.BorrowCommand;
import mobi.qubits.ex.library.domain.commands.RegisterNewLibraryCommand;
import mobi.qubits.ex.library.domain.commands.RegisterNewReaderCommand;
import mobi.qubits.ex.library.domain.commands.ReturnCommand;
import mobi.qubits.ex.library.query.BookEntry;
import mobi.qubits.ex.library.query.BookEntryRepository;
import mobi.qubits.ex.library.query.ReaderEntry;
import mobi.qubits.ex.library.query.ReaderEntryRepository;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.domain.DefaultIdentifierFactory;
import org.axonframework.domain.IdentifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * @author yizhuan
 *
 */
@RestController
public class LibraryController {

	private final IdentifierFactory identifierFactory = new DefaultIdentifierFactory();

	@Autowired
	private BookEntryRepository bookEntryRepository;

	@Autowired
	private ReaderEntryRepository readerEntryRepository;

	@Autowired
	private CommandGateway cmdGateway;		
	
	@RequestMapping(value = "/api/libraries", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> registerNewLibrary(
			@RequestBody @Valid RegisterLibraryRequest req, UriComponentsBuilder b) {
		String id = identifierFactory.generateIdentifier();
		cmdGateway.send(new RegisterNewLibraryCommand(id, req.getName()));

		UriComponents uriComponents = b.path("/api/libraries/{id}")
				.buildAndExpand(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/libraries", method = RequestMethod.GET)
	public @ResponseBody List<ReaderEntry> findAllLibraries() {
		return readerEntryRepository.findAll();
	}	
	
	@RequestMapping(value = "/api/libraries/{id}", method = RequestMethod.GET)
	public @ResponseBody ReaderEntry findLibrary(@PathVariable String id) {
		return readerEntryRepository.findOne(id);
	}
	
	@RequestMapping(value = "/api/libraries/{libraryId}/books", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> registerNewBook(
			@RequestBody @Valid RegisterReaderRequest req, @PathVariable String libraryId,  UriComponentsBuilder b) {
		String id = identifierFactory.generateIdentifier();
		cmdGateway.send(new RegisterNewReaderCommand(libraryId, id, req.getName()));

		UriComponents uriComponents = b.path("/api/libraries/{libraryId}/books/{id}")
				.buildAndExpand(libraryId, id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/libraries/{libraryId}/books", method = RequestMethod.GET)
	public @ResponseBody List<ReaderEntry> findAllBooks() {
		return readerEntryRepository.findAll();
	}	
	
	@RequestMapping(value = "/api/libraries/{libraryId}/books/{bookId}", method = RequestMethod.GET)
	public @ResponseBody ReaderEntry findBook( @PathVariable String libraryId, @PathVariable String bookId) {
		return readerEntryRepository.findOne(bookId);
	}		
		
	@RequestMapping(value = "/api/libraries/{libraryId}/readers", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> registerNewReader(
			@RequestBody @Valid RegisterReaderRequest req, @PathVariable String libraryId, UriComponentsBuilder b) {
		String id = identifierFactory.generateIdentifier();
		cmdGateway.send(new RegisterNewReaderCommand(libraryId, id, req.getName()));

		UriComponents uriComponents = b.path("/api/libraries/{libraryId}/readers/{id}")
				.buildAndExpand(libraryId, id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/libraries/{libraryId}/readers", method = RequestMethod.GET)
	public @ResponseBody List<ReaderEntry> findAllReaders() {
		return readerEntryRepository.findAll();
	}	
	
	@RequestMapping(value = "/api/libraries/{libraryId}/readers/{readerId}", method = RequestMethod.GET)
	public @ResponseBody ReaderEntry findReader(@PathVariable String libraryId, @PathVariable String readerId) {
		return readerEntryRepository.findOne(readerId);
	}		
	
	
	@RequestMapping(value = "/api/libraries/{libraryId}/readers/{readerId}/borrow", method = RequestMethod.POST)
	public ResponseEntity<?> borrowBook(@RequestBody @Valid BookRequest req, @PathVariable String libraryId, @PathVariable String readerId) {
		
		BookEntry book = bookEntryRepository.findOne(req.getBookId());
		if (book.isBorrowed()){
			return errorResponse("This book is not available. It has been taken by another reader.", 
					req.getBookId(), HttpStatus.BAD_REQUEST);
		}
		
		ReaderEntry reader = readerEntryRepository.findOne(readerId);
		if (reader.hasBook(req.getBookId()) ){
			return errorResponse("You are borrowing the same book you've laready borrowed.", 
					req.getBookId(), HttpStatus.BAD_REQUEST);
		}
		
		if (reader.getNumberOdBooksBorrowed()>=3){
			return errorResponse("Each reader can only borrow up to 3 books.", 
					req.getBookId(), HttpStatus.BAD_REQUEST);
		}
				
		cmdGateway.send(new BorrowCommand(libraryId, req.getBookId(), readerId));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);			
				
	}
	
	@RequestMapping(value = "/api/libraries/{libraryId}/readers/{readerId}/return", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void returnBook(@RequestBody @Valid BookRequest req,@PathVariable String libraryId, @PathVariable String readerId) {
		cmdGateway.send(new ReturnCommand(libraryId, req.getBookId(), readerId));
	}	

	
	private ResponseEntity<String> errorResponse(String errMsg, String bookId, HttpStatus httpStatus){
		String err = "{"
				+"\"error\":\""+errMsg + "\""
				+ (bookId ==null ? "":", \"bookId\":\""+bookId+"\"")
				+"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(err, headers, httpStatus);			
	}
}
