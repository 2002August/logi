/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.HashMap;
/**
 *
 * @author augus
 */
public class puesto {
    private int idpuesto;
    private String puesto;
    private Conexion cn;
    public puesto (){}
    public puesto(int idpuesto, String puesto) {
        this.idpuesto = idpuesto;
        this.puesto = puesto;
        
        
    }

    public int getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(int idpuesto) {
        this.idpuesto = idpuesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public DefaultTableModel leer(){
    DefaultTableModel  tabla = new DefaultTableModel();
    try{
      cn = new Conexion();
      cn.abrir_conexion();
        String query;
        query = "SELECT id_puesto as id, puesto FROM empresas.puestos;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id_puesto","puesto"};
      tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String[3];
      while (consulta.next()){
          datos[0] = consulta.getString("id_puesto");
          datos[1] = consulta.getString("puesto");
        
          tabla.addRow(datos);
          
      }
      cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        
    }
      return tabla;
}
    
    
   //se creo la funcion agregar
    public int agregar(){
        int retorno  =0;
     try {
         PreparedStatement parametro;
         cn = new Conexion();
         String query="INSERT INTO empresas.puestos(id_puesto,puesto)VALUES(?,?);";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1, getIdpuesto());
          parametro.setString(2, getPuesto());
        
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   
}

    
    public int modificar(){
         int retorno  =0;
     try {
         PreparedStatement parametro;
         cn = new Conexion();
         String query="UPDATE empresas.puestos SET id_puesto = ?,puesto = ? WHERE id_puesto = ?;" ;   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getIdpuesto());         
         parametro.setString(2, getPuesto());
         parametro.setInt(3, getIdpuesto());
          
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   
}
    
    
    //se creo la funcion eliminar
 public int eliminar (){
     int retorno  =0;
     try {
         PreparedStatement parametro;
         cn = new Conexion();
         String query="delete from puestos where id_puesto = ?;";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1,getIdpuesto());
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   
}   
 
 public HashMap drop_sangre(){
         HashMap<String,String> drop = new HashMap();
         try{
             cn = new Conexion();
             //SELECT idPuestos,puestos FROM puestos;
             String query= "SELECT id_puesto as id, puesto FROM puestos;";
             cn.abrir_conexion();
             ResultSet consulta =  cn.conexionBD.createStatement().executeQuery(query);
             while (consulta.next()){
                 drop.put(consulta.getString("id_puesto"), consulta.getString("puestos"));
             }
             
             cn.cerrar_conexion();
             
         
         }catch (SQLException ex){
                 System.out.println(ex.getMessage());
         }
         return drop;
    }
 
 
}
    
    
    
 

