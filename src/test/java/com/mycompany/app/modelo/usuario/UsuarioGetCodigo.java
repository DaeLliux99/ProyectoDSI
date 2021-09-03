/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.usuario;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LEONARDO
 */
public class UsuarioGetCodigo extends Basico{

    
    @Test(timeout = 10)
    public void testGetContraseñaCadenasVacias() {
        System.out.println("getCodigoUsuario");
        Usuario instance = new Usuario("", "", "");
        String expResult = "";
        String result = instance.getContraseña();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetContraseñaNulls() {
        System.out.println("getCodigoUsuario");
        Usuario instance = new Usuario();
        String expResult = null;
        String result = instance.getContraseña();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetContraseñaCadenasLleas() {
        System.out.println("getCodigoUsuario");
        Usuario instance = new Usuario("ABC","123","123ABC");
        String expResult = "123";
        String result = instance.getContraseña();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
