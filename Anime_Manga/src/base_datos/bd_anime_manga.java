/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.anime_manga;

/**
 *
 * @author olman castillo
 */
public class bd_anime_manga extends bd{
    @Override
    public  DefaultTableModel mostrar(Object buscar){
        String busca=(String)buscar;
        DefaultTableModel modelo;
        String[] titulos={"Nombre anime-manga","Tipo","Generos","Visto","Fecha emicion"};
        String[] registros=new String[5];
        
        modelo=new DefaultTableModel(null,titulos);
        totalRegistros=0;
        sSQL="select * from anime/manga where Nombre like '%"+busca+"%'order by Nombre";
        
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros[0]=rs.getString("Nombre");
                registros[1]=rs.getString("Tipo");
                registros[2]=rs.getString("Generos");
                registros[3]=rs.getString("Visto");
                registros[4]=rs.getString("Fecha");


                
                totalRegistros++;
                modelo.addRow(registros);
            }
            return modelo;
        }catch(Exception e){
            String nl = System.getProperty("line.separator");

            JOptionPane.showMessageDialog(null,"Error tabla anime_manga "+nl+e);
            System.out.println("error 1: "+e);
            return null;
        }
    }
    @Override
    public  DefaultTableModel mostrarTodo(){
     
        DefaultTableModel modelo;
        String[] titulos={"Nombre anime-manga","Tipo","Generos","Visto","Fecha emicion"};
        String[] registros=new String[5];
        
        modelo=new DefaultTableModel(null,titulos);
        totalRegistros=0;
        sSQL="select * from anime/manga where Nombre";
        
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros[0]=rs.getString("Nombre");
                registros[1]=rs.getString("Tipo");
                registros[2]=rs.getString("Generos");
                registros[3]=rs.getString("Visto");
                registros[4]=rs.getString("Fecha");


                
                totalRegistros++;
                modelo.addRow(registros);
            }
            return modelo;
        }catch(Exception e){
            String nl = System.getProperty("line.separator");

            JOptionPane.showMessageDialog(null,"Error tabla anime_manga "+nl+e);
            System.out.println("error 1: "+e);
            return null;
        }
    }
    @Override
    public  boolean insertar(Object datos){
        anime_manga dato=(anime_manga)datos;
        sSQL="insert into anime/manga (Nombre,Tipo,Generos,Descrision,Visto,Fecha,Imagen)"+
                "values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dato.getNombre());
            pst.setString(2,dato.getTipo());
            pst.setString(3,dato.getGeneros());
            pst.setString(4,dato.getDescrision());
            pst.setBoolean(5,dato.isVisto());
            
            pst.setInt(6,dato.getFecha());
            pst.setString(7,dato.getImagen());

            
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            String nl = System.getProperty("line.separator");

            JOptionPane.showMessageDialog(null,"Error tabla anime_manga "+nl+e);
            System.out.println("error 2: "+e);
            return false;
            
    }
    }
    @Override
    public  boolean editar(Object datos){
        anime_manga dato=(anime_manga)datos;
        sSQL="update anime/manga set Tipo=?,Generos=?,Descrision=?,Visto=?,Fecha=?,Imagen=?"+
                " where Nombre=?";
        try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
           
            pst.setString(1,dato.getNombre());
            pst.setString(2,dato.getTipo());
            pst.setString(3,dato.getGeneros());
            pst.setString(4,dato.getDescrision());
            pst.setBoolean(5,dato.isVisto());
            
            pst.setInt(6,dato.getFecha());
            pst.setString(7,dato.getImagen());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            String nl = System.getProperty("line.separator");

            JOptionPane.showMessageDialog(null,"Error tabla anime_manga "+nl+e);
            System.out.println("error 3: "+e);
            return false;
    }
    }
    @Override
    public  boolean eliminar(Object datos){
        anime_manga dato=(anime_manga)datos;
        sSQL="delete from anime/manga where Nombre=?";
        try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dato.getNombre());
   
            
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            String nl = System.getProperty("line.separator");

            JOptionPane.showMessageDialog(null,"Error tabla anime_manga "+nl+e);
            System.out.println("error 2: "+e);
            return false;
            
    }   
    }
    @Override
        public Object objeto(Object buscar){
        String busca=(String)buscar;
        anime_manga obj;
        sSQL="select * from anime/manga where Nombre like '%"+busca+"%'order by Nombre";
        
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
           
            
            obj=new anime_manga(rs.getString(""),rs.getString(""),rs.getString(""),rs.getString(""),rs.getBoolean(""), rs.getInt(""), rs.getString(""));
                
                
            return obj;
        }catch(Exception e){
            String nl = System.getProperty("line.separator");

            JOptionPane.showMessageDialog(null,"Error tabla anime_manga "+nl+e);
            System.out.println("error 1: "+e);
            return null;
        }
     }
}
