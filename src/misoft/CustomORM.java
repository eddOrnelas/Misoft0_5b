package misoft;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Eddie
 */
public class CustomORM {

Connection connectionDB = null;

ConfigFile configFile;


protected String useTable;
protected String keyField;
protected String[][] belongsTo;
protected String[][] hasMany;
protected String[][] hasOne;
protected String[] recursive;

private Object thisObject;
private Class thisClass;


private String[][] classFields;
private String[][] dbFields;


public CustomORM()
{
    
}


public void init(Object ob)
{
    configFile = new ConfigFile();
    //initClassFields(ob);
    
    thisObject = ob;
    thisClass = thisObject.getClass();
    
    classFields = initAbstractClassFields(thisObject);
    initDbFields();
    
}

private void initClassFields(Object ob)
{

    try {
        
        thisObject = ob;
     
     thisClass = thisObject.getClass();
            //this.get
     Field fieldlist[] = thisClass.getDeclaredFields();
     int x=0; // to use on for(:fields)
        //System.out.println("nes: "+fieldlist.length);
     classFields = new String[fieldlist.length][2];
     
     for (Field aFieldlist : fieldlist) {
        // aFieldlist.setAccessible(true);
         classFields[x][0] = aFieldlist.getName();
         System.out.println(aFieldlist.getType().toString());
         classFields[x][1] = aFieldlist.getType().toString().split(" ")[1].toString();
         x++;

         
         
         }
     
     
    } catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Excepcion de seguridad");
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Excepcion de argumentos");
    }
    
    
}


private String[][] initAbstractClassFields(Object ob)
{

    String[][] absFileds = null;
    Object absObj;
    Class absClass;
    
    
    try {
        
        absObj = ob;
     
     absClass = absObj.getClass();
            //this.get
     Field fieldlist[] = absClass.getDeclaredFields();
     int x=0; // to use on for(:fields)
        //System.out.println("nes: "+fieldlist.length);
     absFileds = new String[fieldlist.length][2];
     
     for (Field aFieldlist : fieldlist) {
         
         System.out.println("clas: "+aFieldlist.getType().toString());
        // aFieldlist.setAccessible(true);
         absFileds[x][0] = aFieldlist.getName();
         System.out.println(aFieldlist.getType().toString());
         absFileds[x][1] = aFieldlist.getType().toString().split(" ")[1].toString();
         x++;

         }
     
     
    } catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Excepcion de seguridad");
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Excepcion de argumentos");
    }
    
    return absFileds;
}



private void initDbFields()
{
    
    connectDB();
    
    DatabaseMetaData metadata;
    ResultSet resultSet;
    ResultSetMetaData rsmetadata;
    PreparedStatement ps ;
    
    try {
        
        ps= connectionDB.prepareStatement("Desc "+useTable);
        
        resultSet = ps.executeQuery();
        
       //resultSet.
        
        Integer x=0;
        resultSet.last(); //Get to las row
        dbFields = new String[resultSet.getRow()][6]; //Get number of rows
        resultSet.beforeFirst();//return to first row
  
        while (resultSet.next()) {
            

            dbFields[x][0] = resultSet.getString("Field");
            dbFields[x][1] = resultSet.getString("Type");
            dbFields[x][2] =  resultSet.getString("Null");
            dbFields[x][3] =  resultSet.getString("Key");
            dbFields[x][4] =  resultSet.getString("Default");
            System.out.println(resultSet.getString("Default"));
            dbFields[x][5] =  resultSet.getString("Extra");
               
             x++;

            
                
                
	    }
        
        String[][] tempF = new String[x+1][2];
        tempF = dbFields;
        dbFields = new String[x+1][2];
        dbFields = tempF;
        
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
   // System.out.println("Se quedo: "+dbFields[0][0]);
    
    
    
    
}

private void createMethods()
{
    
    //Cla
    
    
    
}

private boolean connectDB()
{

 try {      
   connectionDB =  (Connection) DriverManager.getConnection(configFile.driverType+":"+configFile.dbType+"://"+configFile.serverName+"/"+configFile.databaseName,configFile.userdb, configFile.password);
        System.out.println ("Conexion Correcta!");
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println ("Error en la conexion");
        return false;
    }
 
}

private boolean closeConnectDB()
{
    try {
        connectionDB.close();
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Conexion Terminada");
        return false;
    }
    
    return true;
}


public Boolean buscarBD()
{
    String qry;
    Object result = null;
    PreparedStatement ps;
    ResultSet rs;
    
    connectDB();
    //if(type=="")
    qry = "SELECT ";
    
    int y = 0;
    for(String[] aField : dbFields)
    {
        //System.out.println(aField[0]);
    
    try {
        //thisClass.getField(aField[0]).set(thisObject, 1 /* sqlobjectField */);
        if(y==0)
        {qry += " "+aField[0];
        y++;
        }
        else
            if(aField[0]!=null)
            qry += ", "+aField[0];
        
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 

    }//End for
    
    qry +=" FROM"+" "+useTable+ " WHERE "+keyField+" = ? LIMIT 1";
    
    try {
        //thisClass.getDeclaredField(keyField)
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 
    try {
        
        System.out.println(qry); //Debug query
        
        ps = connectionDB.prepareStatement(qry);
        
        
        Field f = thisClass.getDeclaredField(keyField); //NoSuchFieldException
        f.setAccessible(true);
        
        ps.setObject(1, f.get(thisObject));
        rs = ps.executeQuery();
        
        setValuesToClass(rs);
       
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchFieldException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    closeConnectDB();
return true;
}


public Integer registrarBD()
{
    String qry;
    String qry2;
    Object result = null;
    PreparedStatement ps;
    ResultSet rs;
    Integer statusOperation = null;
    
    connectDB();
    
    qry = "INSERT INTO "+useTable+" (";
    qry2 =" ) VALUES (";
    int y = 0;
    
    for(String[] aField : dbFields)
    {
        
    
    try {
        
        //if(!"auto_increment".equals(aField[5]))
        if(y==0)
        {qry += " "+aField[0];
        if("auto_increment".equals(aField[5]) || "CURRENT_TIMESTAMP".equals(aField[4]))
        qry2 += " null";
        else
        qry2 += " ?";
        y++;
        }
        else
            if(aField[0]!=null)
            { qry += ", "+aField[0];
            if("auto_increment".equals(aField[5]) || "CURRENT_TIMESTAMP".equals(aField[4]))
              qry2+= ", null";
            else
               qry2+= ", ?"; 
            }
            
        
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 

    }//End for
    qry+=qry2;
    qry += " )";
   // qry +=" FROM"+" "+useTable+ " WHERE "+keyField+" = ? LIMIT 1";
    System.out.println(qry);//Debug qyr
    try {
        //thisClass.getDeclaredField(keyField)
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 
    try {
        
        //System.out.println(qry);
        
        ps = connectionDB.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
        
        int z = 1;
        for(String[] aField : dbFields )
        {
            //if(!"auto_increment".equals(aField[5]))
            if(aField[0]!=null)
            {
            String fl = aField[0];
        Field f = thisClass.getDeclaredField(fl); //NoSuchFieldException
        f.setAccessible(true);
        
        if("auto_increment".equals(aField[5]) || "CURRENT_TIMESTAMP".equals(aField[4]))
                    System.out.println("AUTOINC/TimeStamp");
            else
        if(f.get(thisObject)!=null)
        {ps.setObject(z, f.get(thisObject));
        z++;
        }
        else
        {ps.setObject(z, aField[4]);
        z++;
        }
            
        
        
        
        
        
        
            }
            
        }
        
        
        ps.executeUpdate();
        
        ResultSet resKey = ps.getGeneratedKeys();
        
        while(resKey.next())
        {
            Field f = thisClass.getDeclaredField(keyField);
            f.setAccessible(true);
            f.set(thisObject,resKey.getObject(1));
        }
       
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchFieldException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    closeConnectDB();
    statusOperation = 1;
return statusOperation;
}



public Boolean acualizarBD()
{
    String qry;
    String qry2;
    Object result = null;
    PreparedStatement ps;
    ResultSet rs;
    
    connectDB();
    
    qry = "UPDATE "+useTable+" SET";
    
    int y = 0;
    
    for(String[] aField : dbFields)
    {
        
    
    try {
        
        if(!"auto_increment".equals(aField[5]))
        if(y==0)
        {qry += " "+aField[0]+" = ?";
        
        y++;
        }
        else
            if(aField[0]!=null)
            { qry += ", "+aField[0]+" = ?";
             
            }
            
        
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 

    }//End for
    
    
    
    qry += "WHERE "+keyField+" = ?";
   // qry +=" FROM"+" "+useTable+ " WHERE "+keyField+" = ? LIMIT 1";
    System.out.println(qry);//Debug qyr
    try {
        //thisClass.getDeclaredField(keyField)
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 
    try {
        
        //System.out.println(qry);
        
        ps = connectionDB.prepareStatement(qry);
        
        int z = 1;
        for(String[] aField : dbFields )
        {
            if(!"auto_increment".equals(aField[5]))
            if(aField[0]!=null)
            {
            String fl = aField[0];
        Field f = thisClass.getDeclaredField(fl); //NoSuchFieldException
        f.setAccessible(true);
        
        if(f.get(thisObject)!=null)
        ps.setObject(z, f.get(thisObject));
        else
            ps.setObject(z, aField[4]);
            z++;
            }
            
        }
        
        Field f = thisClass.getDeclaredField(keyField);
        f.setAccessible(true);
        
        ps.setObject(z, f.get(thisObject));
        System.out.println("Query: "+qry);
        ps.executeUpdate();

       
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchFieldException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    closeConnectDB();
return true;
}


public Boolean eliminarBD()
{
    String qry;
    String qry2;
    Object result = null;
    PreparedStatement ps;
    ResultSet rs;
    
    connectDB();
    
    qry = "DELETE FROM "+useTable+" WHERE"+" "+keyField+" = ?";
    
    int y = 0;

   // qry +=" FROM"+" "+useTable+ " WHERE "+keyField+" = ? LIMIT 1";
    System.out.println(qry);//Debug qyr
    try {
        //thisClass.getDeclaredField(keyField)
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 
    try {
        
        
        ps = connectionDB.prepareStatement(qry);
        
        
        Field f = thisClass.getDeclaredField(keyField);
        f.setAccessible(true);
        
        ps.setObject(1, f.get(thisObject));
        
        ps.executeUpdate();

       
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        
    } catch (NoSuchFieldException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        
    }  catch (IllegalAccessException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    
    closeConnectDB();
return true;
}


public void setValuesToClass(ResultSet rs)
{
    try {
        while (rs.next()) 
    { 
        
        
        for(String[] aField : classFields)
        {
        
            Field f =  thisClass.getDeclaredField(aField[0]);
            f.setAccessible(true);
            
            
            String ff = aField[1];
            
            System.out.println("el tipo es: "+ff);
            
            switch(aField[1])
                    {
                case "java.lang.String":
                                        
                                        f.set(thisObject, rs.getString(aField[0]));
                                        //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                case "java.lang.Integer":
                                        
                                        f.set(thisObject, rs.getInt(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                case "java.lang.Float":
                                       
                                        f.set(thisObject, rs.getFloat(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                    
                case "java.lang.Boolean":
                                       
                                        f.set(thisObject, rs.getBoolean(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                    
                case "java.lang.Date":
                                       
                                        f.set(thisObject, rs.getDate(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                case "java.lang.Double":
                                       
                                        f.set(thisObject, rs.getDouble(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                case "java.lang.Long":
                                       
                                        f.set(thisObject, rs.getLong(aField[0]));
                                         System.out.println("un long "+rs.getString(aField[0]));
                                        break;
            
            }
            
            
            //f.set(thisObject, rs.getObject(aField[0]));
        
        }
        
    
    
    }
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchFieldException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
}



public Object[] setValuesToObjects(ResultSet rs)
{
    Object[] objects = null;
    Integer numbofrows = 0;
    Class myClass = null;
    
    Object tmpOb = null;
    
    
    
    //myClass = new Class();
    
    //Object o = myClass.forName("myclass").newInstance(); 
    
    try {
        
        rs.last();
        numbofrows = rs.getRow();//Get number of rows, we need this to init objects and return them
        rs.beforeFirst();
        objects = new Object[numbofrows];
        Integer x =0;
        
        while (rs.next())
    {
        
        myClass.forName(thisObject.getClass().getName());
        //thisObject.getClass().newInstance()
        tmpOb =  thisObject.getClass().newInstance();
        
        String[][] tmpFields;
        tmpFields = initAbstractClassFields(tmpOb);
        
        for(String[] aField : tmpFields)
        {
        
            Field f =  tmpOb.getClass().getDeclaredField(aField[0]);
            f.setAccessible(true);
            
            
            String ff = aField[1];
            System.out.println("el tipo es: "+ff);
            switch(aField[1])
                    {
                case "java.lang.String":
                                        
                                        f.set(tmpOb, rs.getString(aField[0]));
                                        //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                case "java.lang.Integer":
                                        
                                        f.set(tmpOb, rs.getInt(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                case "java.lang.Float":
                                       
                                        f.set(tmpOb, rs.getFloat(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                    
                case "java.lang.Boolean":
                                       
                                        f.set(tmpOb, rs.getBoolean(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                    
                case "java.lang.Date":
                                       
                                        f.set(tmpOb, rs.getDate(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                case "java.lang.Double":
                                       
                                        f.set(tmpOb, rs.getDouble(aField[0]));
                                         //System.out.println("nana "+rs.getString(aField[0]));
                                        break;
                case "java.lang.Long":
                                       
                                        f.set(tmpOb, rs.getLong(aField[0]));
                                         System.out.println("un long "+rs.getString(aField[0]));
                                        break;
            
            }
            
            
            //f.set(thisObject, rs.getObject(aField[0]));
        
        }
        
    objects[x] = tmpOb;
    x++;
    }
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchFieldException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 
    
    return objects;
}




public Object[] buscarBD(String type, Object options[][])
{
    String qry = "";
    Object[] objects = null;
    String conditions = "";
    Object result = null;
    PreparedStatement ps;
    ResultSet rs;
    
    connectDB();
    
    if("all".equals(type) || "todos".equals(type) || "primero".equals(type) || "first".equals(type))
    qry = "SELECT ";
    
    int y = 0; // Flag to set first element without ','
    
    //set fields on query
    for(String[] aField : dbFields)
    {
        //System.out.println(aField[0]);
    
    try {
        //thisClass.getField(aField[0]).set(thisObject, 1 /* sqlobjectField */);
        if(y==0)
        {qry += " "+aField[0];
        y++;
        }
        else
            if(aField[0]!=null)
            qry += ", "+aField[0];
        
    }  catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } 

    }//End for
    
    //Set table
    qry +=" FROM"+" "+useTable;
    
    
    //Set conditions on query
    y = 0;
    for(Object[] condition : options)
    {
        
        System.out.println("INDEX: "+y+" N0: "+condition[0]+" N1: "+condition[1]+" N2: "+condition[2]);
        if(condition[0]!=null && condition[1] != null && condition[2]!=null)
        {
            
            
            if(y==0)
        {
            
            conditions += " WHERE "+condition[0].toString().replaceAll("\\s","")+" "+condition[1].toString().replaceAll("\\s","")+" ?";
        
            
            y++;
        
        }
        else
                
           conditions += " AND "+condition[0].toString().replaceAll("\\s","")+" "+condition[1].toString().replaceAll("\\s","")+" ?";  
        
        }
        
    }//End For
        

    try {
        
        //Add conditions to main query
        qry+=conditions;
        
        if("primero".equals(type) || "first".equals(type))
        qry+=" LIMIT 1";
        
        
        System.out.println(qry); //Debug query
        
        ps = connectionDB.prepareStatement(qry);//Prepare statemate using constructed query
        
        //Set values to statement
        y=1;
        for(Object[] condition : options)
        {
            if(condition[0]!=null && condition[1] != null && condition[2]!=null)
            {
                if("LIKE".equals(condition[1].toString().replaceAll("\\s","")))
                    ps.setString(y, "%"+condition[2].toString()+"%");
                        else
                 ps.setObject(y, condition[2]);
                 
                 
                 y++;
            }
        
    }//End For
        
        rs = ps.executeQuery();
        
      objects =  setValuesToObjects(rs);
        
        //setValuesToClass(rs);
       
    } catch (SQLException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (SecurityException ex) {
        Logger.getLogger(CustomORM.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    closeConnectDB();
return objects;
}



}