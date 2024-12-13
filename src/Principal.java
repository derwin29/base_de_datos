/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DERWIN
 */
public class Principal {
    public static void main(String[] args) {

        crudL crud = new crudL();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n=== Menú de Operaciones ===");
            System.out.println("1. Insertar institución");
            System.out.println("2. Consultar institución por ID");
            System.out.println("3. Actualizar institución");
            System.out.println("4. Eliminar institución");
            System.out.println("5. Listar todas las instituciones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo de institución (publico/semiprivado): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Nivel educativo (formacion tecnica laboral,formacion no formal, formacion profesional ): ");
                    String nivel = scanner.nextLine();
                    System.out.print("Número de estudiantes: ");
                    int estudiantes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    Date fecha = Date.valueOf(fechaStr);

                    crud.crearInstitucion(nombre, tipo, nivel, estudiantes, fecha);
                    break;

                case 2:
                    
                    System.out.print("Ingrese el ID de la institución a consultar: ");
                    int idConsulta = scanner.nextInt();
                    crud.consultarInstitucion(idConsulta);
                    break;

                case 3:
                    
                    System.out.print("ID de la institución a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nuevo Nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo Tipo (publico/semiprivado): ");
                    String nuevoTipo = scanner.nextLine();
                    System.out.print("Nuevo Nivel educativo: ");
                    String nuevoNivel = scanner.nextLine();
                    System.out.print("Nuevo Número de estudiantes: ");
                    int nuevosEstudiantes = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nueva Fecha (YYYY-MM-DD): ");
                    String nuevaFechaStr = scanner.nextLine();
                    Date nuevaFecha = Date.valueOf(nuevaFechaStr);

                    crud.actualizarInstitucion(idActualizar, nuevoNombre, nuevoTipo, nuevoNivel, nuevosEstudiantes, nuevaFecha);
                    break;

                case 4:
                    
                    System.out.print("ID de la institución a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    crud.eliminarInstitucion(idEliminar);
                    break;

                case 5:
                    
                    List<String> instituciones = crud.listarInstituciones();
                    System.out.println("\n=== Lista de Instituciones ===");
                    for (String institucion : instituciones) {
                        System.out.println(institucion);
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}

    
    

