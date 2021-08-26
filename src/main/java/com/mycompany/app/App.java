package com.mycompany.app;

import com.mycompany.app.controlador.login.ControladorLogin;
import com.mycompany.app.modelo.ModeloLogin;
import com.mycompany.app.vista.VistaLogin;


/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        
        ModeloLogin mu = new ModeloLogin().cargar();
        VistaLogin login = new VistaLogin();
        ControladorLogin cl = new ControladorLogin();
        mu.setVista(login);
        cl.setModelo(mu).setVista(login);
        login.setControlador(cl).setModelo(mu);
        login.mostrar();
        
        
    }
}
