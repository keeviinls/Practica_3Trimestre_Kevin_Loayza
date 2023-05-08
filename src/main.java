import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
   static  Scanner sc = new Scanner(System.in);
    static Peliculas peliculas = new Peliculas();




    public static void main(String[] args) throws SQLException {
        int opcion=0;
        do {


        System.out.println("0.Salir del programa");
        System.out.println("1.Crear Tabla Película");
        System.out.println("2.Eliminar tabla Película");
        System.out.println("3.Crear película ");
        System.out.println("4.Eliminar Película por id");
        System.out.println("5.Buscar película por id e imprimir información");
        System.out.println("6.Buscar e imprimir todas las peliculas");
        System.out.println("7.Buscar por genero y orden descendente de estreno e imprimir");
        System.out.println("....");
        opcion = sc.nextInt();


        switch (opcion){
            case 0:
                System.out.println("¡Gracias por usar el programa!");break;
            case 1:
                peliculas.crearTabla();break;
            case 2:
                peliculas.eliminarTabla();break;

            case 3:
                System.out.println("Indicame el id");
                int id = sc.nextInt();

                System.out.println("Indicame el titulo");
                String titulo = sc.next();

                System.out.println("Indicame el genero ROMANTICA, MIEDO, COMEDIA");
                String genero = sc.next().toUpperCase();

                System.out.println("Indicame el estreno");
                int estreno = sc.nextInt();

                Pelicula p = new Pelicula(id,titulo,genero,estreno);
                peliculas.crearPelicula(p);break;

            case 4:

                System.out.println("Indícame el id de la película que deseas eliminar");
                id = sc.nextInt();
                peliculas.eliminarPelicula(id);break;

            case 5:

                System.out.println("Dime el id de la pelicula y te mostrare informacion sobre ella");
                id = sc.nextInt();
                peliculas.buscarPelicula(id);
                /**
                 * FALTA SOUTPRINT, QUE YA ESTABA EN LA CLASE PELICULAS, ASI CON LAS 3 OPCIONES FINALES
                 */
                break;

            case 6:
                peliculas.buscarTodo();break;
            case 7:

                System.out.println("Indicame el genero ROMANTICA, MIEDO, COMEDIA");
                genero = sc.next();
                peliculas.buscarPorGeneroOrdenarEstreno(genero);break;
        }
        }while (opcion!=0);
    }

}
