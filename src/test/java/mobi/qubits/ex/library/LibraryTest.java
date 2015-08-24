package mobi.qubits.ex.library;

import mobi.qubits.ex.library.domain.Library;
import mobi.qubits.ex.library.domain.commands.RegisterNewLibraryCommand;
import mobi.qubits.ex.library.domain.events.NewLibraryRegisteredEvent;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author yizhuan
 *
 */
public class LibraryTest {

	private FixtureConfiguration<Library> fixture;

	@Before
	public void setUp() {
		fixture = Fixtures.newGivenWhenThenFixture(Library.class);
	}

	@Test
	public void testRegisterLibrary() {

		fixture.given()
				.when(new RegisterNewLibraryCommand("1", "Library1"))
				.expectEvents(
						new NewLibraryRegisteredEvent("1", "Library1"));

	}


	
	
}
