package view;

import common.dominios.Cuenta;
import controller.Controller;

import common.dominios.FreeCuenta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements LogInEventListener, FreeRegistrationEventListener, RequestAccountEventListener {

    private LoginDialog loginDialog;
    private Controller controller;

    public MainFrame(boolean view) {
        setVisible(true);
        controller = new Controller();
        connectDb();
        loginDialog = new LoginDialog(this);
        loginDialog.setLogInEventListener(this);
        loginDialog.setFreeRegEventListener(this);
        loginDialog.setRequestEventAccountListener(this);

        loginDialog.setVisible(true);

        setMinimumSize(new Dimension(500, 400));
        setSize(600, 500);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }

    public final void initUI() {

        createToolBars();

        setTitle("Biblioteca");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void createToolBars() {

        JToolBar toolbar1 = new JToolBar();
        JToolBar toolbar2 = new JToolBar();
        String a = "src/main/resources/img/";
        ImageIcon newIcon = new ImageIcon(a + "home.png");
        ImageIcon openIcon = new ImageIcon(a + "new-book.png");
        ImageIcon saveIcon = new ImageIcon(a + "gestion.png");
        ImageIcon exitIcon = new ImageIcon(a + "exit.png");

        JButton newBtn = new JButton(newIcon);
        JButton openBtn = new JButton(openIcon);
        JButton saveBtn = new JButton(saveIcon);
        saveBtn.addActionListener(ae -> new SecondFrame());
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        saveBtn.setSize(100, 100);
        saveBtn.setVisible(true);
        toolbar1.add(newBtn);
        toolbar1.add(openBtn);
        toolbar1.add(saveBtn);

        JButton exitBtn = new JButton(exitIcon);
        toolbar2.add(exitBtn);

        exitBtn.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        createLayout(toolbar1, toolbar2);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setHorizontalGroup(gl.createParallelGroup().addComponent(arg[0], GroupLayout.PREFERRED_SIZE,
            GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE).addComponent(arg[1], GroupLayout.PREFERRED_SIZE,
            GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
            .addComponent(arg[1])
        );
    }






    public void connectDb() {
        if (controller != null) {
            try {
                controller.connect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnectDb() {
        controller.disconnect();
    }

    @Override
    public void FreeRegistrationEventOccurred(FreeRegistrationEvent e) {
        String username = e.getUserName();
        String password = e.getPassword();
        boolean member = e.isMember();
        String fName = e.getfName();
        String lName = e.getlName();
        String email = e.getEmail();
        FreeCuenta fa = new FreeCuenta(username, password, fName, lName, email);
        controller.addAccount(fa);
    }


    @Override
    public void requestAccountEventOccurred(RequestAccountEvent e) {
        Cuenta cuenta = e.getCuenta();
        boolean b = controller.isExistingAccount(cuenta);
        loginDialog.isAccountTaken(b);
    }

    @Override
    public void loginEventOccurred(Cuenta cuenta) {
        if (controller.isValidLogin(cuenta)) {
            initUI();
            loginDialog.setVisible(false);
            loginDialog.isValidLogin(true);
        } else {
            initUI();
            loginDialog.isValidLogin(false);
        }
    }
}
