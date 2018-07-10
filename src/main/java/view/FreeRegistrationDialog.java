package view;



import common.dominios.Cuenta;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FreeRegistrationDialog extends JDialog {
	private JPasswordField passwordField;
	private JPanel buttonPane;
	private JTextField userNameField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private FreeRegistrationEventListener listener;
	private final JLabel lblError;
	private RequestAccountEventListener reqlistener;
	private boolean accountTaken;
	/**
	 * Create the dialog.
	 */
	public FreeRegistrationDialog(JDialog parent) {
		super(parent,true);
		setTitle("Registrarse");
		
		setBounds(100, 100, 418, 457);
		
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
				JButton okButton = new JButton("Guardar");
				okButton.setActionCommand("Guardar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						clearAllFields();
						setVisible(false);						
					}
				});
				lblError = new JLabel("");
				
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ValidateRequiredField(userNameField.getText(),passwordField_1.getPassword(),passwordField_2.getPassword())){
					if (ValidateName(firstNameField.getText(),lastNameField.getText())){
						if (ValidateEmail(emailField.getText())){
							String username = userNameField.getText();
							String password =new String(passwordField_1.getPassword());
							String fName = firstNameField.getText();
							String lName = lastNameField.getText();
							String email = emailField.getText();
							if (fName == null) fName = "";
							if (lName == null) lName = "";
							if (email == null) email = "";
							FreeRegistrationEvent ev = new FreeRegistrationEvent(this, username, password,fName,lName,email);
							System.out.println(ev);
							if (listener != null){
							//	System.out.println("in FreeRegDialog, free reg event occured notifying observers");
								JOptionPane.showMessageDialog(null, "Registrado!");
								listener.FreeRegistrationEventOccurred(ev);
							}else{System.out.println("listener is null");}
							clearAllFields();
							setVisible(false);
						}
					}
				}
			}

			private boolean ValidateEmail(String email) {
				if (email.equals("")){System.out.println("El correo es nulo"); return true;}
				final String EMAIL_PATTERN = 
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				Pattern pattern = Pattern.compile(EMAIL_PATTERN);
				Matcher matcher = pattern.matcher(email);
				
				if (matcher.matches()) return true;
				lblError.setText("El correo no es valido");
				return false;
			}

			private boolean ValidateName(String fName, String lName) {
				if (fName.equals("") || lName.equals("")){ System.out.println("nombre o apellido nulo");return true;}
				final String NAME_PATTERN = "\\w+";
				Pattern pattern = Pattern.compile(NAME_PATTERN);
				Matcher matcher = pattern.matcher(fName);
				Matcher matcher1 = pattern.matcher(lName);
				if (matcher.matches()&&matcher1.matches())return true;
				lblError.setText("Nombre contiene caracteres invalidos");
				return false;
			}

			private boolean ValidateRequiredField(String name,char[] pass, char[] cpass) { //validate username, pass, confirm pass
				if (reqlistener== null){
					System.out.println("uh oh reqlistener is null");
					return false;
				}else{
					Cuenta cuenta = new Cuenta(name, new String(pass),false);
					reqlistener.requestAccountEventOccurred(new RequestAccountEvent(this, cuenta));
					if (accountTaken){
						JOptionPane.showMessageDialog(null, "nombre is taken");
						clearAllFields();
						return false;
					}
				}
				
				Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,15}$"); //pattern for username
				Matcher matcher = pattern.matcher(name);
				if (matcher.matches() == true){
					String password = new String(pass);String cPassword = new String (cpass);
					Pattern pattern1 = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})"); 
					/*  (?=.*\d)		#   must contains one digit from 0-9
					 *  (?=.*[a-z])		#   must contains one lowercase characters
					    (?=.*[A-Z])		#   must contains one uppercase characters
					     .				#   match anything with previous condition checking
					     {6,20}			#   length at least 6 characters and maximum of 20	
					 */
					Matcher matcher1 = pattern1.matcher(password);
					if (matcher1.matches()&&password.equals(cPassword)){
						return true;
					}
					lblError.setText("Clave Invalida");
					JOptionPane.showMessageDialog(null, "\n" +
							"la Clave debe contener un dígito de 0-9, debe contener un carácter en minúscula, debe contener un carácter en mayúscula, una longitud de al menos 6-20");
					return false;
				}
				lblError.setText("Usuario invalido");
				return false;
			}
		});
		
		
		
		JLabel lblNewLabel = new JLabel("Usuario*");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Clave*");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2 = new JLabel("Confirmar Clave*");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		userNameField = new JTextField();
		userNameField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		
		passwordField_2 = new JPasswordField();
		
		
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Source Sans Pro", Font.PLAIN, 11));
		
		JLabel lblFieldsRequired = new JLabel("* datos requeridos");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2)
										.addComponent(lblError)
										.addComponent(lblNewLabel))
									.addGap(48)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(passwordField_2)
											.addComponent(passwordField_1)
											.addComponent(userNameField))
										.addComponent(lblFieldsRequired))))))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblError)
						.addComponent(lblFieldsRequired))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		
		JLabel lblNewLabel_5 = new JLabel("Apellidos");
		
		firstNameField = new JTextField();
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Correo");
		
		emailField = new JTextField();
		emailField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}

	private void clearAllFields() {
		userNameField.setText("");
		passwordField_1.setText("");
		passwordField_2.setText("");
		firstNameField.setText("");
		lastNameField.setText("");
		emailField.setText("");
	}
	public boolean isAccountTaken(boolean b){
		accountTaken = b;
		return accountTaken;
	}

	public void setFreeRegistrationEventOberservers(FreeRegistrationEventListener listener){
		this.listener = listener;
	}

	public void setRequestAccountEventListener(RequestAccountEventListener listener) {
		
		this.reqlistener = listener;
		System.out.println("when is this being called");
		if (this.reqlistener== null)System.out.println("is this being set?");
	}

}
