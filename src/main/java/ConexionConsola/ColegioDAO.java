package ConexionConsola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ColegioDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    public void listar() {

        String sql = "select * from alumnos";

        try {

            //Inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("*****************************");
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Direccion: " + rs.getString(3));
                System.out.println("Telefono: " + rs.getInt(4));
            }
        } catch (Exception e) {

        }

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

    public static void main(String[] args) {
        ColegioDAO cl = new ColegioDAO();
        cl.listar();

        System.out.println("///////////////////////////////////");
        cl.eliminar(2);
//        cl.crear(3, "James", "Santa Rosa", 31213456);
        cl.listar();
    }
}
