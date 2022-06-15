/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistema.conexion.conexion;
import sistema.consulta.consultaCiudad;
import sistema.modelo.modCiudad;
import sistema.modelo.modPaciente;
import sistema.modelo.modPais;
import sistema.vista.frmCiudad;
import sistema.vista.frmPaciente;

/**
 *
 * @author Administrator
 */
public class controladorCiudad implements ActionListener{
    
    private final modCiudad ciudad;
    private final consultaCiudad cCiudad;
    private final frmCiudad frmCiu;

    public controladorCiudad(modCiudad ciudad, consultaCiudad cCiudad, frmCiudad frmP) {
        this.ciudad = ciudad;
        this.cCiudad = cCiudad;
        this.frmCiu = frmP;
        this.frmCiu.btnInsertar.addActionListener(this);
        this.frmCiu.btnModificar.addActionListener(this);
        this.frmCiu.btnEliminar.addActionListener(this);
        this.frmCiu.btnBuscar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
           
        
        if (e.getSource() == frmCiu.btnInsertar) {
               
            ciudad.setIdPais(frmCiu.comboPais.getSelectedIndex());
            ciudad.setDescripcion(frmCiu.txtCiudad.getText());

            if (cCiudad.registrar(ciudad)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frmCiu.btnBuscar) {
            ciudad.setIdPais(frmCiu.comboPais.getSelectedIndex());
            ciudad.setDescripcion(frmCiu.txtCiudad.getText());
            

            if (cCiudad.buscar(ciudad)) {

                JOptionPane.showMessageDialog(null, "Registro Encontrado");
                buscar();

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if (e.getSource() == frmCiu.btnEliminar) {
            ciudad.setIdPais(frmCiu.comboPais.getSelectedIndex());
            ciudad.setDescripcion(frmCiu.txtCiudad.getText());
  
            if (cCiudad.eliminar(ciudad)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
         if (e.getSource() == frmCiu.btnModificar) {
               ciudad.setIdPais(frmCiu.comboPais.getSelectedIndex());
               ciudad.setDescripcion(frmCiu.txtCiudad.getText());
                         
            if (cCiudad.modificar(ciudad)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
         
      }
        
        private void buscar(){
            ciudad.setIdPais(frmCiu.comboPais.getSelectedIndex());
            ciudad.setDescripcion(frmCiu.txtCiudad.getText());
        if(cCiudad.buscar(ciudad)){
            JOptionPane.showMessageDialog(null, "Registro encontrado");
            
        }else{
            JOptionPane.showMessageDialog(null, "No hay registro");
        }
      }
    

    private void limpiar(){
            frmCiu.comboPais.setSelectedItem(null);
            frmCiu.txtCiudad.setText("");
        }
    
    public void iniciar() {
        frmCiu.setTitle("Registro de ciudad");
        frmCiu.setLocationRelativeTo(null);
    }

   
}
