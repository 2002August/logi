<%-- 
    Document   : puesto
    Created on : 30/10/2023, 23:31:22
    Author     : augus
--%>
<%@page import="modelo.puesto"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Puestos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <h1>Formulario Puesto!</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_puesto" onclick="limpiar()">Nuevo Puesto</button>
        
        <div class="container">
            <div class="modal fade" id="modal_puesto" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
         
            <form action="sr_puesto" method="post" class="form-group">
                <label for="lbl_id_puesto"><b>ID_Puesto</b></label>
                 <input type="text" name="txt_id_puesto" id="txt_id_puesto"class="form-control" value ="0" readonly >
                <label for="lbl_puesto"><b>Puesto:</b></label>
                 <input type="text" name="txt_puesto" id="txt_puesto"class="form-control" placeholder="Ejemplo: programador" required>
                 
                  <br>
                  <button name="btn_agregar" id="btn_agregar" value= "agregar"class="btn btn-primary btn-lg">Agregar</button>
                   <button name="btn_modificar" id="btn_modificar" value= "modificar"class="btn btn-secondary btn-lg">modificar</button>
                    <button name="btn_eliminar" id="btn_eliminar" value= "eliminar"class="btn btn-success btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">eliminar</button>
                    <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
            </form>
        </div>
       
      </div>
      
    </div>
  </div>
  
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Id_puesto</th>
        <th>Puesto</th>
      </tr>
    </thead>
    <tbody id="tbl_puesto">
        <%
         puesto Puesto = new puesto();
         DefaultTableModel tabla = new DefaultTableModel();
         tabla = Puesto.leer(); 
         for (int t=0;t<tabla.getRowCount();t++){
         out.println("<tr data-id_puesto=" + tabla.getValueAt(t,0) +  ">");

         out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
         out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
         out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
         out.println("</tr>");
         
            }
            %>
        
    </tbody>
  </table>
</div>
            
        

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        
       
       <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
       <script type="text/javascript">
          function limpiar(){
             $("#txt_id_puesto").val(0);
            $("#txt_puesto").val('');

          }
    
            $('#tbl_puesto').on('click','tr td',function(evt){
            var target,id_puesto,puesto;
            target = $(event.target);
            id_puesto = target.parent().data('id_puesto');
            puesto = target.parent("tr").find("td").eq(0).html();
            $("#txt_id_puesto").val(id_puesto);
            $("#txt_puesto").val(puesto);
            $("#modal_puesto").modal('show');
               
           });
       </script>
       </body>
    
</html>