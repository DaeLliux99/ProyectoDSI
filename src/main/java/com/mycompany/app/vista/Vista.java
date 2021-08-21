package com.mycompany.app.vista;

import javax.swing.*;
import java.awt.*;

public class Vista {
  public Vista() {
  }
  
  public void vista() {
    SwingUtilities.invokeLater(this::gui);
  }

  public void gui() {
    JFrame ventana = new JFrame("ProyectoDSI");
    ventana.setVisible(true);
  }
}
