import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Peliculas implements PeliculasInterface{
    static Scanner sc = new Scanner(System.in);
    ArrayList<Pelicula> listado_peliculas = new ArrayList<>();

    public static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica3", "root", "Noteloesperas1");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Pelicula> buscarPorGeneroOrdenarEstreno(String genero) throws SQLException{
        String query1 = "use practica3";
        PreparedStatement ps = conn.prepareStatement("select * from Pelicula where genero = ? order by estreno desc");
        ps.setString(1,genero);
        ResultSet rs = ps.executeQuery();

        Pelicula p = null;

        while (rs.next()){

            p = new Pelicula(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4));
            listado_peliculas.add(p);

        }

        System.out.println(listado_peliculas.toString());


        return null;
    }

    public ArrayList<Pelicula> buscarTodo() throws SQLException{


        String query1 = "use practica3";
        PreparedStatement ps = conn.prepareStatement("select * from Pelicula");
        ResultSet rs = ps.executeQuery();

        Pelicula p = null;

        while (rs.next()){

            p = new Pelicula(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4));
            listado_peliculas.add(p);

        }

        System.out.println(listado_peliculas.toString());

        return null;
    }


    public Pelicula buscarPelicula(int id) throws SQLException{
        String query1 = "use practica3";
        PreparedStatement ps = conn.prepareStatement("select * from Pelicula where id = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println("ID: "+rs.getInt(1) + "TITULO: "+rs.getString(2)+
            " GENERO: "+rs.getString(3) + "ESTRENO "+ rs.getInt(4));
        }

        return null;
    }



    public void eliminarPelicula(int id) throws SQLException{
        String query1 = "use practica3";
        PreparedStatement ps = conn.prepareStatement("delete from Pelicula where id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Película eliminada correctamente");
    }

    public void crearPelicula(Pelicula p) throws SQLException{

        String query1 = "use practica3";
        PreparedStatement ps = conn.prepareStatement("insert into Pelicula values (?,?,?,?)");

        ps.setInt(1,p.getId());
        ps.setString(2,p.getTitulo());
        ps.setString(3, p.getGenero().toString());
        ps.setInt(4,p.getEstreno());
        ps.executeUpdate();
        System.out.println("Película insertada correctamente");


    }

    public void eliminarTabla() throws SQLException{
        String query1 = "use practica3";

        String query = "drop table Pelicula";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        System.out.println("Tabla borrada correctamente");
    }


    public void crearTabla() throws SQLException{
        String query1 = "use practica3";

        String query = "create table Pelicula(" +
                "id int primary key," +
                "titulo varchar(10) not null," +
                "genero varchar(30)," +
                "estreno int)";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        System.out.println("Tabla creada correctamente");
    }




}
