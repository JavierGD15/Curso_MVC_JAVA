package ConexionConsola;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColegioFuncion {

    Scanner sp = new Scanner(System.in);
    Scanner sp2 = new Scanner(System.in);
    ColegioDAO cl = new ColegioDAO();

    public void menu() {

        System.out.println("---------------------");
        System.out.println("| 1. Mostrar Alumnos   |");
        System.out.println("| 2. Crear Alumnos     |");
        System.out.println("| 3. Modificar Alumnos |");
        System.out.println("| 4. Eliminar Alumnos  |");
        System.out.println("| 5. Salir             |");

        int uso = sp.nextInt();

        switch (uso) {
            case 1:
                System.out.println("-----Todos los alumnos Ingresados--------");
                cl.listar();

                break;
            case 2:
                Boolean salir = true;

                do {

                    System.out.println("Ingresa su codigo");
                    int codigo = sp.nextInt();
                    sp.nextLine();

                    System.out.println("Ingresa su nombre");
                    String nombre = sp.nextLine();

                    System.out.println("Ingresa su direccion");
                    String direc = sp2.nextLine();

                    System.out.println("Ingresa su telefono");
                    int telefono = sp2.nextInt();

                    cl.crear(codigo, nombre, direc, telefono);

                    System.out.println("Desea Ingresar mas Alumnos?");
                    System.out.println("Ingresa 1 para continuar y 0 para salir");

                    if (sp.nextInt() != 1) {
                        salir = false;
                    }

                } while (salir);

                break;
            case 3:

                System.out.println("-----Todos los alumnos Ingresados--------");
                cl.listar();

                System.out.println("Ingrese el codigo del alumno a modificar: ");
                int seleccion = sp.nextInt();
                sp.nextLine();

                System.out.println("Ingresa su nombre");
                String nombre = sp.nextLine();

                System.out.println("Ingresa su direccion");
                String direc = sp2.nextLine();

                System.out.println("Ingresa su telefono");
                int telefono = sp2.nextInt();

                cl.modificar(seleccion, nombre, direc, telefono);

                break;
            case 4:
                System.out.println("-----Todos los alumnos Ingresados--------");
                cl.listar();

                System.out.println("Ingrese el codigo del alumno a eliminar: ");
                cl.eliminar(sp.nextInt());

                break;
            case 5:
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void frame() {

        JFrame frame = new JFrame();

        JPanel p1 = new JPanel();

        frame.setTitle("Bienvenido al banco");
        frame.setSize(400, 400);
        frame.setVisible(true);

        frame.add(p1);
        p1.setBackground(Color.red);

    }


}
