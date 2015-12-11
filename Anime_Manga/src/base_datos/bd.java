/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Olman
 */
public abstract class bd {
    protected conexion mysql=new conexion();
    protected Connection cn=mysql.conectar();
    protected String sSQL="";
    public Integer totalRegistros;
    
    public abstract DefaultTableModel mostrar(Object buscar);
    public abstract DefaultTableModel mostrarTodo();
    public abstract boolean insertar(Object datos);
    public abstract boolean editar(Object datos);
    public abstract boolean eliminar(Object datos);
    public abstract Object objeto(Object buscar);
    
    
}
