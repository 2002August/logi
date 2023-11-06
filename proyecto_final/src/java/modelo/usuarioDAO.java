/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author augus
 */
public class usuarioDAO implements validar{
    Connection conexionBD; 
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
@Override
    public int validar(usuario Usuario) {
      int r=0;
      //String sql="SELECT usuario, contraseña FROM empresas.usuarios;";
      String sql="SELECT * FROM usuarios  where usuario=? and  contraseña=?";
      try{
          conexionBD = cn.getConnection();
          ps=conexionBD.prepareStatement(sql);
          ps.setString(1, Usuario.getUsuario());
          ps.setString(2, Usuario.getContraseña());
          rs=ps.executeQuery();
          while(rs.next()){
              r = r + 1;
              Usuario.setUsuario(rs.getString("usuario"));
              Usuario.setContraseña(rs.getString("contraseña"));             
          }
          if(r==1){
              return 1;
          }else{
              return 0;
          }
      }catch (SQLException e){
             return 0;
          
          
      }   
    
    }
}
     
