package com.mycompany.app;

import com.mycompany.app.controlador.login.ControladorLogin;
import com.mycompany.app.modelo.usuario.ModeloUsuario;
import com.mycompany.app.vista.Login;


/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        ModeloUsuario mu = new ModeloUsuario().cargar();
        Login login = new Login();
        ControladorLogin cl = new ControladorLogin();
        mu.setVista(login);
        cl.setModelo(mu).setVista(login);
        login.setControlador(cl).setModelo(mu);
        login.mostrar();
    }
}
