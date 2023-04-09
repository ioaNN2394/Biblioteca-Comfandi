/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conectar {
         
     Connection conectar=null;
public Connection conexion(){   
  try{
    Class.forName("org.gjt.mm.mysql.Driver");//.newInstance();
    conectar=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","123456");
    JOptionPane.showMessageDialog(null, "exito");


    
  }catch(SQLException ex) {
             JOptionPane.showMessageDialog(null, "A ocurrido un error inesperado, consulta el manual, o llama a nuestra linea de atencion +57 3148");
                                   }catch(ClassNotFoundException ex) {                                                                }
  return conectar;
}
}
