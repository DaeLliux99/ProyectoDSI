/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.vista;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.controlador.egresos.ControladorEgreso;
import com.mycompany.app.controlador.ingresos.ControladorIngreso;
import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.modelo.ModeloEgreso;
import com.mycompany.app.modelo.paquete.Paquete;
import com.mycompany.app.modelo.producto.Producto;
import com.mycompany.app.vista.tablas.TablaFactory;
import com.mycompany.app.vista.tablas.TablaItems;
import java.util.List;
import com.mycompany.app.vista.tablas.TablaPaquetes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.*;
/**
 *
 * @author LEONARDO
 */
public class VistaEgreso extends javax.swing.JFrame implements Vista{

    /**
     * Creates new form Ventana_Egreso
     */
    public VistaEgreso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonAgregar = new javax.swing.JButton();
        botonVerificarPedido = new javax.swing.JButton();
        botonCancelarPedido = new javax.swing.JButton();
        textoCantidad = new javax.swing.JTextField();
        botonCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoNombreProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaItems = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonGenerarReporte = new javax.swing.JButton();
        textoCodigo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAgregar.setText("AGREGAR");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 90, 30));

        botonVerificarPedido.setText("VERIFICAR PEDIDO");
        botonVerificarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerificarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(botonVerificarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 150, 40));

        botonCancelarPedido.setText("CANCERLA PEDIDO");
        botonCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, -1, 40));

        textoCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 190, -1));

        botonCerrarSesion.setText("CERRAR SESION");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(botonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 130, 40));

        jLabel1.setText("C??digo del producto:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        textoNombreProducto.setEditable(false);
        textoNombreProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 180, -1));

        jLabel3.setText("Cantidad del producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        tablaItems.setModel(TablaFactory.crearTabla("items"));
        jScrollPane2.setViewportView(tablaItems);
        if (tablaItems.getColumnModel().getColumnCount() > 0) {
            tablaItems.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 760, 250));

        jLabel4.setText("Nombre del producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel5.setText("Producto disponible");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        botonGenerarReporte.setText("GENERAR REPORTE");
        botonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarReporteActionPerformed(evt);
            }
        });
        jPanel1.add(botonGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 150, 40));

        textoCodigo.setEditable(true);
        textoCodigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                textoCodigoItemStateChanged(evt);
            }
        });
        jPanel1.add(textoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        controladorEgreso.agregarItem();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonVerificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerificarPedidoActionPerformed
        controladorEgreso.guardarPedido();
        controladorEgreso.reiniciarAtributos();
    }//GEN-LAST:event_botonVerificarPedidoActionPerformed

    private void botonCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarPedidoActionPerformed
        controladorEgreso.reiniciarAtributos();
        this.listaItemCambiada();
    }//GEN-LAST:event_botonCancelarPedidoActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        controladorEgreso.cerrarSesion();
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarReporteActionPerformed
        controladorEgreso.generarReporte();
    }//GEN-LAST:event_botonGenerarReporteActionPerformed

    private void textoCodigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_textoCodigoItemStateChanged
        controladorEgreso.consultarNombreProducto();
    }//GEN-LAST:event_textoCodigoItemStateChanged

    @Override
    public Vista setModelo(Modelo modelo) {
        this.modeloEgreso = (ModeloEgreso) modelo;
        this.listaItemCambiada();
        this.cargarNombreAutocompletado();
        return this;
    }

    @Override
    public Vista setControlador(Controlador controlador) {
        this.controladorEgreso = (ControladorEgreso) controlador;
        return this;
    }

    @Override
    public void aviso(String aviso) {
        JOptionPane.showMessageDialog(rootPane, aviso);
    }
    
    public void listaItemCambiada() {
        this.textoCantidad.setText("");
        this.textoCantidad.setText("");
        tablaItems.setModel(TablaFactory.crearTabla("items", modeloEgreso.getItems()));
    }
    
    public void mostrar() {
        this.setVisible(true);
    }
    
    public String obtenerCantidadItem(){
        return this.textoCantidad.getText();
    }
    
    public String obtenerCodigoProducto() {
        return (String) this.textoCodigo.getSelectedItem();
    }
    
    public String obtenerNombreProducto() {
        return this.textoNombreProducto.getText();
    }
    
    public void establecerNombre(String nombre) {
        this.textoNombreProducto.setText(nombre);
    }
    
    public void cargarNombreAutocompletado() {
        for (Producto p: modeloEgreso.obtenerProductos()) {
            this.textoCodigo.addItem(p.getCodigo());
        }
        AutoCompleteDecorator.decorate(textoCodigo);
    } 
    
    private ModeloEgreso modeloEgreso;
    private ControladorEgreso controladorEgreso;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonCancelarPedido;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonGenerarReporte;
    private javax.swing.JButton botonVerificarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaItems;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JComboBox<String> textoCodigo;
    private javax.swing.JTextField textoNombreProducto;
    // End of variables declaration//GEN-END:variables
}
