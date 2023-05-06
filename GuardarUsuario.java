package prueba;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author holij
 */
public class GuardarUsuario {
    
    int resultado;
        
        
        public int guardar (String Nombre,String Apellido,String CorreoElectronico, String Contraseña){
            conectar cc=new conectar();
    Connection cn=cc.conexion();
            
            try{
                PreparedStatement pst=cn.prepareStatement("INSERT INTO  aliados(Nombre, Correo, Apellido, Contraseña)VALUES(?,?,?,?)");

                pst.setString(1,Nombre);
                pst.setString(2,CorreoElectronico);
                pst.setString(3,Apellido);
                pst.setString(4,Contraseña);
                
                resultado = pst.executeUpdate();
            }catch(Exception e){
                System.out.println(e);
            }
            return resultado;
        }
        public static String buscarnombre(String correo) {
    conectar cc = new conectar();
    Connection cn = cc.conexion();
    String busqueda_nombre = null;
    try {
        PreparedStatement pst = cn.prepareStatement("SELECT Nombre, Apellido FROM aliados WHERE Correo = ?");
        pst.setString(1, correo);

        ResultSet resultado = pst.executeQuery();
        if (resultado.next()) {
            String nombre = resultado.getString("Nombre");
            String apellidos = resultado.getString("Apellido");
            busqueda_nombre = nombre;
        }
    } catch (SQLException e) {
        System.out.println(e);
    } finally {
        try {
            cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    return busqueda_nombre;
}

        public static String buscarUsuarioRegistrado(String correo, String contraseña) {
    conectar cc = new conectar();
    Connection cn = cc.conexion();
        String busqueda_usuario = null;

    try {
        PreparedStatement pst = cn.prepareStatement("SELECT Nombre, Correo, Contraseña FROM aliados WHERE Correo = ? && Contraseña = ?");
        pst.setString(1, correo);
        pst.setString(2, contraseña);
        ResultSet resultado = pst.executeQuery();
        if(resultado.next()) {
            busqueda_usuario = "usuario encontrado";
        } else {
            busqueda_usuario = "usuario no encontrado";
        }
    } catch(Exception e) {
        System.out.println(e);
    }
        return busqueda_usuario;

}
}


