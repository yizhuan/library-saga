package mobi.qubits.ex.library.api.requests;

/**
 * 
 * @author yizhuan
 *
 */
public class RegisterReaderRequest {

	private String name;

	public RegisterReaderRequest() {
		super();
	}
	
	

	public RegisterReaderRequest(String name) {
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
