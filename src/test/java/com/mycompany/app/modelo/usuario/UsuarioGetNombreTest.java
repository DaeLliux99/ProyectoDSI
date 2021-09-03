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
public class UsuarioGetNombreTest extends Basico {
          
    /**
     * Test of getNombreUsuario method, of class Usuario.
     */
    @Test
    public void testGetNombreUsuarioCadenasVacias() {
        System.out.println("getNombreUsuario");
        Usuario instance = new Usuario("","","");
        String expResult = "";
        String result = instance.getNombreUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetNombreUsuarioNulls() {
        System.out.println("getNombreUsuario");
        Usuario instance = new Usuario();
        String expResult = null;
        String result = instance.getNombreUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetNombreUsuarioCadenasLleas() {
        System.out.println("getNombreUsuario");
        Usuario instance = new Usuario("ABC","123","123ABC");
        String expResult = "ABC";
        String result = instance.getNombreUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
