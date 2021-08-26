/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.paquete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class PaqueteDAO {
    String data;
    
    public PaqueteDAO() {
        data = "paquetes.bin";
    }
    
    public List <Paquete> obtenerPaquetes() {
        List <Paquete> paquetes;
        try {
            FileInputStream fis = new FileInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(fis);
            paquetes = (ArrayList<Paquete>) ois.readObject();
            ois.close();
            System.out.println("Datos cargados con exito");
            return paquetes;
        } catch (FileNotFoundException fnde) {
            System.out.println("No se ha encontrado el fichero de usuarios");
            paquetes = new ArrayList<>();
            //productos.add(new Paquete());
            //productos.add(new Paquete());
            try {
                FileOutputStream fos = new FileOutputStream(data);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(paquetes);
                oos.close();
                System.out.println("Datos guardados con éxito");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return paquetes;
        } catch (IOException ioe) {
            System.out.println("Error de entrada/salida al cargar los datos");
        } catch (ClassNotFoundException ex) {
            System.out.println("El fichero contiene datos erroneos");
        }
        return null;
    }
    
    public void guardar(List <Paquete> paquetes) {
        try {
            FileOutputStream fos = new FileOutputStream(data);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(paquetes);
            oos.close();
            System.out.println("Datos guardados con éxito");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
