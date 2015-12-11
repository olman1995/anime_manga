/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author olman castillo
 */
public class conexion {
   private String bd="anime_manga";
    private String url="jdbc:mysql://127.0.0.1/"+bd;
    private String user="root";
    private String pass="";

    public conexion() {
    }
    
    public Connection conectar(){
        Connection link=null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(this.url,this.user,this.pass);
        }
        catch(Exception e){
            System.out.println("error 0: "+e);
        }
        return link;
    } 
}
