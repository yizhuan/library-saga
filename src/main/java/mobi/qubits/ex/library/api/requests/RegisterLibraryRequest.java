package mobi.qubits.ex.library.api.requests;

/**
 * 
 * @author yizhuan
 *
 */
public class RegisterLibraryRequest {

	private String name;

	public RegisterLibraryRequest() {
		super();
	}
	
	

	public RegisterLibraryRequest(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
	
}
