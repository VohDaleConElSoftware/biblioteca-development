package common.dominios;

public class DatabaseTest {

	public static void main(String [] args) {
		Database db = new Database();
		String username = "user1";
		String password = "pass1";
		String firstName = "Susan";
		String lastName = "Jaicks";
		String email = "ak12ka@hotmail.com";
		
		FreeCuenta fa = new FreeCuenta(username,password,firstName,lastName,email);
		FreeCuenta fa1= new FreeCuenta("user2","pass2","David","Natta","1u3u32@hotmail.com");
		FreeCuenta fa2= new FreeCuenta("user3","pass3","Mark","Jue","dfads@hotmail.com");
		try {
			db.connect();
			//db.addFreeAccount(fa);
			db.addAccount(fa);
			db.addAccount(fa1);
			db.addAccount(fa2);
			db.displayDB();
			db.disconnect();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
