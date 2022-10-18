package ConexionConsola;

import VistasConCodigo.conexion;
import VistasConCodigo.alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ColegioDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    public ArrayList listar() {

        String sql = "select * from alumnos";

        try {

            //Inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<alumno> datos = new ArrayList<alumno>();
            
            while (rs.next()) {
                alumno al = new alumno();
                al.setCodigo(rs.getInt(1));
                al.setNombre(rs.getString(2)); 
                al.setDireccion(rs.getString(3));
                al.setTelefono(rs.getInt(4));
                datos.add(al);
            }
            
            return datos;
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;

    }

    public void crear(int codigo, String nombre, String direccion, int telefono) {

        String sql = "insert into alumnos(codigo,nombre,direccion,telefono) values (?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setInt(4, telefono);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modificar(int codigo, String nombre, String direccion, int telefono) {

        String sql = "update alumnos set nombre=?, direccion=?, telefono=? where codigo=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setInt(3, telefono);
            ps.setInt(4, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminar(int codigo) {
        String sql = "delete from alumnos where codigo=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void buscar(int codigo){
    //SELECT * FROM `alumnos` WHERE carnet=201800555; ejemplo
    String sql = "select * from alumnos where codigo ="+codigo;
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Modificar_vista mv = new Modificar_vista();
                mv.mostrar(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                mv.setVisible(true);
                
            }else{
                System.out.println("Codigo invalido");
            }
        } catch (Exception e) {
        }
    }
    
    public void buscar_eliminar(int codigo){
        String sql = "select * from alumnos where codigo ="+codigo;
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Eliminar elim = new Eliminar();
                elim.txtCodigo.setText(rs.getInt(1)+"");
                elim.txtNombre.setText( rs.getString(2));
                elim.txtDireccion.setText(rs.getString(3));
                elim.txtTelefono.setText(rs.getInt(4)+"");
                elim.setVisible(true);
                
            }else{
                System.out.println("Codigo invalido");
            }
        } catch (Exception e) {
        }
    
    
    
    }
    
    public static void main(String[] args) {
        ColegioDAO dl = new ColegioDAO();
        dl.listar();
    }
}
