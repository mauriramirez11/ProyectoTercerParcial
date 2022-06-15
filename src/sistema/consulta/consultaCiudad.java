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
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistema.conexion.conexion;
import sistema.modelo.modCiudad;
import sistema.modelo.modPais;

/**
 *
 * @author Administrator
 */
public class consultaCiudad {
    
    conexion metodoconexion = new conexion();
    
    public boolean registrar(modCiudad ciudad) {
        PreparedStatement ps = null;
        Connection con = metodoconexion.getConexion();
        String sql = "INSERT INTO pruebaverdadera2.ciudad (idPais, Descripcion) VALUES(?,?)";
         try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciudad.getIdPais());
            ps.setString(2, ciudad.getDescripcion());
            
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
    public boolean buscar(modCiudad ciudad) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = metodoconexion.getConexion();
        String sql = "SELECT * FROM pruebaverdadera2.ciudad WHERE idPais = ? and Descripcion=? ";
        try {
            ps = con.prepareStatement(sql);
      
            ps.setInt(1, ciudad.getIdPais());
            ps.setString(2, ciudad.getDescripcion());
            rs = ps.executeQuery();
            if (rs.next()) {
                ciudad.setDescripcion(rs.getString("Descripcion"));
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
    
    public boolean eliminar(modCiudad ciudad) {
        PreparedStatement ps = null;
        Connection con = metodoconexion.getConexion();

        String sql = "DELETE FROM pruebaverdadera2.ciudad WHERE idPais = ? and Descripcion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciudad.getIdPais());
            ps.setString(2, ciudad.getDescripcion());
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
    
    public boolean modificar(modCiudad ciudad) {
        PreparedStatement ps = null;
        Connection con = metodoconexion.getConexion();
        String sql = "UPDATE pruebaverdadera2.ciudad SET Descripcion=? WHERE idPais=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ciudad.getDescripcion());
            ps.setInt(2, ciudad.getIdPais());
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
    
    
    
    
    
    
    public void consultar_ciudad(JComboBox combociudad) {

        // objeto del tipo Connection
        java.sql.Connection con = null;

        //creamos la consulta SQL
        String SQL = "SELECT * FROM pruebabasetercerparcial2.ciudad";

        //establecemos el bloque de try-catch-finally
        try {
            //establecer conexion con la bd
            con = metodoconexion.getConexion();
            //preparamos la consulta sql
            PreparedStatement pst = con.prepareStatement(SQL);
            //ejecutamos la consulta
            ResultSet resultado = pst.executeQuery();

            //llenamos nuestro combo
            combociudad.addItem("Seleccione una opcion");
            
            while (resultado.next()) {
                
                combociudad.addItem(resultado.getString("Descripcion"));
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        } finally {
            
            if (con != null) {
                
                try {
                    con.close();
                } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }
       
    
}