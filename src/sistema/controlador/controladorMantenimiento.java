/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionListener;
import sistema.consulta.consultaCiudad;
import sistema.consulta.consultaPais;
import sistema.modelo.modCiudad;
import sistema.modelo.modPais;
import sistema.vista.frmCiudad;
import sistema.vista.frmMantenimiento;
import sistema.vista.frmPais;

/**
 *
 * @author Administrator
 */
public class controladorMantenimiento  {
    
    private final modPais tpais;
    private final modCiudad ciudad;
    private final consultaPais cPais;
    private final consultaCiudad cCiudad;
        private final frmMantenimiento frmMan;

    public controladorMantenimiento(modPais tpais, modCiudad ciudad, consultaPais cPais, consultaCiudad cCiudad, frmMantenimiento frmMan) {
        this.tpais = tpais;
        this.ciudad = ciudad;
        this.cPais = cPais;
        this.cCiudad = cCiudad;
        this.frmMan = frmMan;
    }
   

    
    
    public void iniciar() {
        frmMan.setTitle("Mantenimiento");
        frmMan.setLocationRelativeTo(null);
    }
    
}
