package common.dominios;



public class FreeCuenta extends Cuenta {

	private String fName;
	private String lName;
	private String email;
	
	public FreeCuenta(String username, String password, String fName,
                      String lName, String email) {
		super(username, password,false);
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getEmail() {
		return email;
	}
	
	public String getUsuario(){
		return super.getUsuario();
	}
	public String getClave(){
		return super.getClave();
	}
	public void setUsuario(String username){
		super.setUsuario(username);
	}
	public void setClave(String password){
		super.setClave(password);
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
