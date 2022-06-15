/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import sistema.consulta.consultaPais;
import sistema.modelo.modPais;
import sistema.vista.frmPais;

/**
 *
 * @author Administrator
 */
public class controladorPais implements ActionListener {
    
    private final modPais tpais;
    private final consultaPais cPais;
    private final frmPais formuPais;

    public controladorPais(modPais tpais, consultaPais cPais, frmPais formuPais) {
        this.tpais = tpais;
        this.cPais = cPais;
        this.formuPais = formuPais;
        this.formuPais.btnInsertar.addActionListener(this);
        this.formuPais.btnModificar.addActionListener(this);
        this.formuPais.btnEliminar.addActionListener(this);
        this.formuPais.btnBuscar.addActionListener(this);
        this.formuPais.btnInsertar.addMouseListener(habilitar);
        
    }

    
    public void iniciar() {
        formuPais.setTitle("Registro de paises");
        formuPais.setLocationRelativeTo(null);
    }

    MouseListener habilitar = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
    
        }

        @Override
        public void mousePressed(MouseEvent e) {
     
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == formuPais.btnInsertar ) {
                deshabilitar_id();
                formuPais.txtIdPais.setText("Deshabilitado");
            } 
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == formuPais.btnInsertar ) {
               habilitar_id();
               formuPais.txtIdPais.setText("");
            } 
        } 
    };
        public void actionPerformed(ActionEvent e) {
           
        
        if (e.getSource() == formuPais.btnInsertar) {
               
            
            tpais.setDescripcion(formuPais.txtPaisDescripcion.getText());

            if (cPais.registrar(tpais)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == formuPais.btnBuscar) {
            tpais.setIdPais(Integer.parseInt(formuPais.txtIdPais.getText()));

            if (cPais.buscar(tpais)) {

                JOptionPane.showMessageDialog(null, "Registro Encontrado");
                buscar();

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if (e.getSource() == formuPais.btnEliminar) {
            tpais.setIdPais(Integer.parseInt(formuPais.txtIdPais.getText()));
  
            if (cPais.eliminar(tpais)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
         if (e.getSource() == formuPais.btnModificar) {
               tpais.setIdPais(Integer.parseInt(formuPais.txtIdPais.getText()));
               tpais.setDescripcion(formuPais.txtPaisDescripcion.getText());
                         
            if (cPais.modificar(tpais)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
         
      }
        
        private void buscar(){
        tpais.setIdPais(Integer.parseInt(formuPais.txtIdPais.getText()));
        if(cPais.buscar(tpais)){
            formuPais.txtPaisDescripcion.setText(tpais.getDescripcion());
        }
      }
    public void deshabilitar_id(){
          formuPais.txtIdPais.setEnabled(false);
      } 
       public void habilitar_id(){
          formuPais.txtIdPais.setEnabled(true);
      } 
       private void limpiar(){
            formuPais.txtIdPais.setText("");
            formuPais.txtPaisDescripcion.setText("");
        }
}