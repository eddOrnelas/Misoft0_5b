package usuario;


import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import misoft.VistaVentanaPrincipal;




/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NOE
 */
public class ControlUsuario {
    
 
    
    public Integer realizarAltaUsuario(String nombre, String apPaterno, String apMaterno, String usuario, String password, String permisos)
    {
      Usuario UsuarioAlta = new Usuario(true);
      Integer statusOperacion = null;
      
      UsuarioAlta.setNombre(nombre);
      UsuarioAlta.setApPaterno(apPaterno);
      UsuarioAlta.setApMaterno(apMaterno);
      UsuarioAlta.setUsuario(usuario);
      UsuarioAlta.setPassword(password);
      UsuarioAlta.setTipoPermiso(permisos);
      UsuarioAlta.setActivo(Boolean.TRUE);
      
        
      statusOperacion = UsuarioAlta.registrarBD();
      

       
      if(statusOperacion==1)
      {
          statusOperacion=1;
      }
      else
      {
          statusOperacion=0;
      }
          return statusOperacion;     
    }
    
    
    public String validarDatosAltaUsuario(String nombre, String apPaterno, String apMaterno, String usuario, String password,String permisos)
    
     {
          
         String errorLog ="";
         
        Usuario resultadoBusqueda = new Usuario(true);
        Object[] resultado = null;
        
        Object[][] opciones = new Object[][] {{"usuario","=",usuario}};
        
        resultado = resultadoBusqueda.buscarBD("all", opciones);     
   
         if(resultado.length>0)
         
         
                 errorLog += "¡ El nombre de usuario ya existe, favor de utilizar otro !\n";
         
           // return errorLog;
            if(nombre.trim().length()<=0)
            {
                errorLog +="¡ El campo Nombre no debe quedar vacío !\n";
            }
            if(apPaterno.trim().length()<=0)
            {
                errorLog +="¡ El campo Apellido Paterno no  debe quedar vacío !\n";
            }
            if(apMaterno.trim().length()<=0)
            {
                errorLog +="¡ El campo Apellido Materno no debe quedar vacío !\n";
            }
            if(usuario.trim().length()<=0)
            {
                errorLog +="¡ El campo Nombre de Usuario no debe quedar vacío !\n";
            }
            if(password.trim().length()<=0)
            {
                errorLog +="¡ El campo Password no debe quedar vacío !\n";
            }
            
           if(password.trim().length()<=5 ||password.length()>=13)
           {
                    errorLog += "¡ El password debe contener entre 6 y 12 caracteres !\n";
            }
            if(permisos.trim().length()<=0)
            {
                errorLog +="¡ El campo Permisos no debe quedar vacío !\n";
            }
                  
            return errorLog;
          }
    
    
    
public Integer realizarEdicionUsuario(String nombre, String apPaterno, String apMaterno,String usuario, String password, String tipoPermiso)
{    
            
            Usuario busuario = new Usuario(true);
           
        Object[][] opciones=new Object[][]{{"usuario","=",usuario}};
        Object[] resultado = busuario.buscarBD("all", opciones);
        Long idUsuario = ((Usuario)resultado[0]).getIdUsuario();
        busuario.setIdUsuario(idUsuario);
        busuario.buscarBD();
        
            
            String tmpNombre = nombre;
            String tmpApPaterno = apPaterno;
            String tmpApMaterno = apMaterno;
            String tmpUsuario = usuario;
            String tmpPassword = password;
            String tmpTipoPermiso = tipoPermiso;
            Integer statusOperation = 0;
            
            
            
            String extras = "";
         
    
    //Llenamos el objeto para poder actualizarlo
    busuario.setNombre(tmpNombre);
    busuario.setApPaterno(tmpApPaterno);
    busuario.setApMaterno(tmpApMaterno);
    busuario.setPassword(tmpPassword);
    busuario.setTipoPermiso(tmpTipoPermiso);
    
    
    Boolean result = busuario.acualizarBD();
    
    
    if(result)
    statusOperation = 1;
    else
        statusOperation = 0;
  
    return statusOperation;
    
    

}
    
    
public Boolean realizarLogin(String usuario, String password)
  {
         
      Usuario tipoUsuario= new Usuario(true);
      
      
      Object[][] options = new Object[][]{{"usuario", "=", usuario },
                                           {"password", "=", password}};      
      
      Object[] resultado=tipoUsuario.buscarBD("all", options);
      
     if(resultado.length <=0){
      
          
          return false;}
     else 
      return true;
         
      
     
  }
          public String validarDatosLogin(String usuario, String password){
              
//               Usuario tipoUsuario= new Usuario(true);
//      
//      
//      Object[][] options = new Object[][]{{"usuario", "=", usuario },
//                                           {"password", "=", password}};      
//      
//      Object[] resultado=tipoUsuario.buscarBD("all", options);
              
              
              
              
               String errorLog ="";
               
              if(usuario.length()<=0)
              {
                  errorLog +="¡ Favor de introducir tu Usuario !\n";
              }

              if(password.length()<=0)
              {
                  errorLog +="¡ Favor de introducir tu Password !\n";
              } 
              
                  return errorLog;
              }             
          

          public Boolean validaDatosEdicionUsuario(String txNombre,String txApPaterno,String txApMaterno,String txPassword)
          {
            
               if(txNombre.length()<=0 || txApPaterno.length()<=0 || txApMaterno.length()<=0 || txPassword.length()<=0)
                  return false;
              else 
                  return true;
          }
          
          
          
    //Metodos de busqueda de usuario

    Object[] obtenerListaCompletaUsuarios() {
    
    Usuario usuario;
        usuario = new Usuario(true);
    
    Object[] usuarios = usuario.buscarBD("all",new Object[0][0]);
    
        
    return usuarios;
    
    }

    Object[] buscarPorIDUsuario(Long idUsuario) {
    
        Usuario resultadoBusqueda = new Usuario(true);
        Object[] resultado = null;
        
        Object[][] opciones = new Object[][] {{"idUsuario","=",idUsuario}, {"activo", "=", 1}};
        
        resultado = resultadoBusqueda.buscarBD("all", opciones);
        
        return resultado;
  
    }
      Object[] buscarPorNombreUsuario(String nombre) {
        Usuario usuarioBusqueda = new Usuario(true);
        Object[] resultado = null;
        
        Object[][] opciones = new Object[][] {{"nombre","LIKE",nombre}, {"activo", "=", 1}};
        
        resultado = usuarioBusqueda.buscarBD("all", opciones);
        
        return resultado;
    }

            
    Boolean realizarEliminacionUsuario(String usr) {
     
        Usuario usuario = new Usuario(true);
        Object[][] opciones=new Object[][]{{"usuario","=",usr}};
        Object[] resultado = usuario.buscarBD("all", opciones);
        Long idUsuario = ((Usuario)resultado[0]).getIdUsuario();
        usuario.setIdUsuario(idUsuario);
        usuario.buscarBD();
        usuario.setActivo(false);
        
       Boolean operacion = usuario.acualizarBD();
      
    
        return operacion;  
    
    }
          
      
     public Long obtenerUsuarioActual(Container padre)
      {
        Container estePadre =  obtenerPadre(padre);
        
        return ((VistaVentanaPrincipal)estePadre).getIdUsuario();
        
      }
      
      
      public Container obtenerPadre(Container padr)
    {
        //System.out.println("pad: "+padr.getClass());
        if(padr.getParent()!=null)
            return obtenerPadre(padr.getParent());
        else
            
       return padr;
        
    }
      
      
      public Boolean autorizarOperacion(Long idUsuario)
      {
          Usuario usuario = new Usuario(true);
          String password = "";
          
          JPasswordField pf = new JPasswordField();
            int okCxl = JOptionPane.showConfirmDialog(null, pf, "Introdusca Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            //JOptionPane.showco
            if (okCxl == JOptionPane.OK_OPTION) {
              password = new String(pf.getPassword());
 
}
          
          
          Object[][] options = new Object[][] {{"idUsuario","=",idUsuario},{"password","=",password}};
          
          if(usuario.buscarBD("all", options).length<=0)
              return false;
          else
              return true;
          
      }
      
      
  public ControlUsuario()
  { 
  }


}

