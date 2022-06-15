/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistema.conexion.conexion;
import sistema.modelo.modPaciente;
import sistema.modelo.modPais;


/**
 *
 * @author Administrator
 */
    public class consultaPais extends conexion {


    public boolean registrar(modPais tpais) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO pruebaverdadera2.pais (idPais, Descripcion) VALUES(?,?)";
         try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tpais.getIdPais());
            ps.setString(2, tpais.getDescripcion());
            
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean buscar(modPais tpais) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM pruebaverdadera2.pais WHERE idPais = ? ";
        try {
            ps = con.prepareStatement(sql);
      
            ps.setInt(1, tpais.getIdPais());
            rs = ps.executeQuery();
            if (rs.next()) {
                tpais.setDescripcion(rs.getString("Descripcion"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(modPais tpais) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM pruebaverdadera2.pais WHERE idPais = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tpais.getIdPais());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(modPais tpais) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE pruebaverdadera2.pais SET Descripcion=? WHERE idPais=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tpais.getDescripcion());
            ps.setInt(2, tpais.getIdPais());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    
    public Vector<modPais> mostrarPais() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConexion();

        Vector<modPais> datos = new Vector<modPais>();
        modPais dat = null;
        try {

            String sql = "SELECT * FROM pruebaverdadera2.pais";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new modPais();
            dat.setIdPais(0);
            dat.setDescripcion("Selecciona pais");
            datos.add(dat);

            while (rs.next()) {
                
                dat = new modPais();
                dat.setIdPais(rs.getInt("idPais"));
                dat.setDescripcion(rs.getString("Descripcion"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
