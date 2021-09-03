package com.mycompany.app.modelo.usuario;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

import org.junit.rules.TestName;

/**
 *
 * @author LEONARDO
 */
public class Basico {

    public @Rule
    TestName nombre = new TestName();

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando pruebas");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Pruebas terminadas");
    }

    @Before
    public void setUp() {
        System.out.println("===========");
        System.out.println("Ejecutando " + nombre.getMethodName());
    }
        
    @After

    public void tearDown() {
        System.out.println("===========");
        System.out.println("Terminado " + nombre.getMethodName());
    }

}
