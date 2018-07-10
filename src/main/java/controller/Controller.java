package controller;


import common.dominios.Cuenta;
import common.dominios.Database;

import java.sql.SQLException;

public class Controller {

    private Database db = new Database();

    public Controller() {

    }


    public void connect() throws Exception {
        db.connect();
    }

    public void disconnect() {
        db.disconnect();
    }

    public boolean isExistingAccount(Cuenta cuenta) {
        boolean w = db.isAccountTaken(cuenta);
        System.out.println("isExistingAccount =" + w);
        return w;
    }

    public boolean isValidLogin(Cuenta cuenta) {
        boolean w = db.isValidLogin(cuenta);
        System.out.println("isValidLogin =" + w);
        return w;

    }

    public void addAccount(Cuenta cuenta) {
        try {
            db.addAccount(cuenta);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
