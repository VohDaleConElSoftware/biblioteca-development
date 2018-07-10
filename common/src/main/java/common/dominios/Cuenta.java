package common.dominios;

public class Cuenta {
	private String usuario;
	private String clave;
	private boolean es_miembro;//true if account=clubmember false if Freeaccount
	private int id;
	
	public Cuenta(String usuario, String clave, boolean es_miembro) {
		this.usuario = usuario;
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public boolean isEs_miembro(){
		return es_miembro;
	}
	
	
}
