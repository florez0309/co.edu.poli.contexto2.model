package co.edu.poli.contexto2.vista;

import co.edu.poli.contexto2.model.*;
import co.edu.poli.contexto2.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto2.servicios.OperacionArchivo;
import co.edu.poli.contexto2.servicios.OperacionCRUD;
import java.util.Scanner;

/**
 * Clase principal de la aplicación. Contiene el punto de entrada {@code main}
 * y el menú interactivo por consola para gestionar alimentos espaciales.
 *
 * <p>Permite ejecutar operaciones CRUD y de archivo mediante un menú
 * numérico ingresado por el usuario desde la consola.</p>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public class Principal {

    /** Implementación del gestor CRUD y de archivo. */
    private static ImplementacionOperacionCRUD gestor = new ImplementacionOperacionCRUD();

    /** Scanner para leer entrada del usuario por consola. */
    private static Scanner sc = new Scanner(System.in);

    /** Ruta donde se guarda el archivo de persistencia. */
    private static final String PATH = "src/";

    /** Nombre del archivo de persistencia (sin extensión). */
    private static final String NOMBRE_ARCHIVO = "alimentos";

    // ============================================================
    // MÉTODOS POLIMÓRFICOS
    // ============================================================

    /**
     * MÉTODO POLIMÓRFICO 1: Recibe un parámetro de tipo supersuperclase (Alimento).
     *
     * @param alimento objeto de tipo {@link Alimento} a procesar
     */
    public static void procesarAlimento(Alimento alimento) {
        System.out.println("  Tipo real : " + alimento.getClass().getSimpleName());
        System.out.println("  Detalle   : " + alimento.toString());
        System.out.println("  " + alimento.obtenerCategoria());
        boolean caducado = alimento.verificarCaducidad("2025-12-31");
        System.out.println("  Estado    : " + (caducado ? "CADUCADO" : "VIGENTE"));
    }

    /**
     * MÉTODO POLIMÓRFICO 2: Retorna un objeto de tipo supersuperclase (Alimento).
     *
     * @param tipo     tipo de alimento: "deshidratado" o "enlatado"
     * @param registro registro de misión asociado
     * @return instancia de {@link Alimento} según el tipo indicado
     */
    public static Alimento crearAlimentoSegunTipo(String tipo, Registro registro) {
        if (tipo.equalsIgnoreCase("deshidratado")) {
            return new Deshidratado("Seco", "Neutro", "2026-12-31", "DH999",
                    "2025-01-01", "Fábrica Espacial", "2026-12-31", registro, 730);
        } else {
            return new Enlatado("Sellado", "Salado", "2027-06-30", "EN999",
                    "2025-01-01", "Planta Industrial", "2027-06-30", registro, "Acero");
        }
    }

    // ============================================================
    // MENÚ PRINCIPAL
    // ============================================================

    /**
     * Punto de entrada de la aplicación. Muestra el menú interactivo
     * y ejecuta la opción elegida por el usuario.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("  Seleccione una opcion: ");
            System.out.println();
            switch (opcion) {
                case 1: crear();        break;
                case 2: listarTodos();  break;
                case 3: consultarUno(); break;
                case 4: modificar();    break;
                case 5: eliminar();     break;
                case 6: guardar();      break;
                case 7: cargar();       break;
                case 0:
                    System.out.println("=== Saliendo del sistema. Hasta luego! ===");
                    break;
                default:
                    System.out.println("[!] Opcion no valida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);

        sc.close();
    }

    // ============================================================
    // OPCIONES DEL MENÚ
    // ============================================================

    /**
     * Muestra el menú de opciones en consola.
     */
    private static void mostrarMenu() {
        System.out.println("===========================================");
        System.out.println("   SISTEMA DE ALIMENTOS ESPACIALES");
        System.out.println("===========================================");
        System.out.println("  1. Crear alimento");
        System.out.println("  2. Listar todos los alimentos");
        System.out.println("  3. Consultar un alimento");
        System.out.println("  4. Modificar un alimento");
        System.out.println("  5. Eliminar un alimento");
        System.out.println("  6. Guardar en archivo");
        System.out.println("  7. Cargar desde archivo");
        System.out.println("  0. Salir");
        System.out.println("===========================================");
    }

    /**
     * Solicita al usuario los datos de un nuevo alimento y lo agrega al gestor.
     */
    private static void crear() {
        System.out.println("--- CREAR ALIMENTO ---");
        System.out.println("  Tipo de alimento:");
        System.out.println("  1 = Deshidratado");
        System.out.println("  2 = Enlatado");
        int tipo = leerEntero("  Ingrese tipo: ");

        System.out.print("  Estado: ");
        String estado = sc.nextLine().trim();

        System.out.print("  Sabor: ");
        String sabor = sc.nextLine().trim();

        System.out.print("  Fecha de vencimiento (aaaa-mm-dd): ");
        String fVenc = sc.nextLine().trim();

        System.out.print("  Codigo de barras: ");
        String cod = sc.nextLine().trim();

        System.out.print("  Fecha de fabricacion (aaaa-mm-dd): ");
        String fFab = sc.nextLine().trim();

        System.out.print("  Lugar de fabricacion: ");
        String lugar = sc.nextLine().trim();

        System.out.print("  Fecha de caducidad (aaaa-mm-dd): ");
        String fCad = sc.nextLine().trim();

        Registro reg = new Registro(1, 20250101, "Base Espacial",
                "Mision Demo", "Alimentos", "Nave-Demo", "Orbita");

        Alimento nuevo = null;

        if (tipo == 1) {
            int dias = leerEntero("  Cantidad maxima de dias de conservacion: ");
            nuevo = new Deshidratado(estado, sabor, fVenc, cod,
                    fFab, lugar, fCad, reg, dias);

        } else if (tipo == 2) {
            System.out.print("  Material de la lata: ");
            String mat = sc.nextLine().trim();
            nuevo = new Enlatado(estado, sabor, fVenc, cod,
                    fFab, lugar, fCad, reg, mat);

        } else {
            System.out.println("[!] Tipo no valido.");
            return;
        }

        gestor.crear(nuevo);
        System.out.println("[OK] Creacion completada.");
    }

    /**
     * Lista todos los alimentos almacenados en el gestor.
     */
    private static void listarTodos() {
        System.out.println("--- LISTADO DE TODOS LOS ALIMENTOS ---");
        Alimento[] lista = gestor.listar();
        boolean hayAlguno = false;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                hayAlguno = true;
                System.out.println("  [" + i + "] "
                        + lista[i].getClass().getSimpleName()
                        + " | Codigo: "     + lista[i].getCodigodebarras()
                        + " | Estado: "     + lista[i].getEstado()
                        + " | Caducidad: "  + lista[i].getFechacaducidad()
                        + " | Val.Nut: "    + lista[i].calcularValorNutricional());
            }
        }

        if (!hayAlguno) {
            System.out.println("  [!] No hay alimentos registrados.");
        }

        System.out.println("  Capacidad: " + lista.length
                + " | Registrados: " + gestor.getCantidad());
    }

    /**
     * Solicita un código de barras y muestra el alimento correspondiente.
     */
    private static void consultarUno() {
        System.out.println("--- CONSULTAR ALIMENTO ---");
        System.out.print("  Codigo de barras: ");
        String cod = sc.nextLine().trim();

        Alimento found = gestor.consultar(cod);
        if (found != null) {
            System.out.println("  Tipo             : " + found.getClass().getSimpleName());
            System.out.println("  " + found.toString());
            System.out.println("  Valor nutricional: " + found.calcularValorNutricional());
            System.out.println("  " + found.obtenerCategoria());
        } else {
            System.out.println("  [!] No se encontro alimento con codigo '" + cod + "'.");
        }
    }

    /**
     * Solicita un código de barras y los nuevos datos para modificar el alimento.
     */
    private static void modificar() {
        System.out.println("--- MODIFICAR ALIMENTO ---");
        System.out.print("  Codigo de barras a modificar: ");
        String cod = sc.nextLine().trim();

        Alimento actual = gestor.consultar(cod);
        if (actual == null) {
            System.out.println("  [!] No se encontro alimento con codigo '" + cod + "'.");
            return;
        }

        System.out.println("  Alimento actual  : " + actual);
        System.out.println("  Tipo             : " + actual.getClass().getSimpleName());
        System.out.println("  Ingrese los nuevos datos:");

        System.out.print("  Nuevo estado: ");
        String estado = sc.nextLine().trim();

        System.out.print("  Nuevo sabor: ");
        String sabor = sc.nextLine().trim();

        System.out.print("  Nueva fecha de vencimiento (aaaa-mm-dd): ");
        String fVenc = sc.nextLine().trim();

        System.out.print("  Nueva fecha de fabricacion (aaaa-mm-dd): ");
        String fFab = sc.nextLine().trim();

        System.out.print("  Nuevo lugar de fabricacion: ");
        String lugar = sc.nextLine().trim();

        System.out.print("  Nueva fecha de caducidad (aaaa-mm-dd): ");
        String fCad = sc.nextLine().trim();

        Registro reg = actual.getRegistro();
        Alimento modificado = null;

        if (actual instanceof Deshidratado) {
            int dias = leerEntero("  Nueva cantidad maxima de dias: ");
            modificado = new Deshidratado(estado, sabor, fVenc, cod,
                    fFab, lugar, fCad, reg, dias);

        } else if (actual instanceof Enlatado) {
            System.out.print("  Nuevo material de la lata: ");
            String mat = sc.nextLine().trim();
            modificado = new Enlatado(estado, sabor, fVenc, cod,
                    fFab, lugar, fCad, reg, mat);
        }

        boolean ok = gestor.modificar(cod, modificado);
        System.out.println("[OK] Modificacion exitosa: " + ok);
    }

    /**
     * Solicita un código de barras y elimina el alimento correspondiente.
     */
    private static void eliminar() {
        System.out.println("--- ELIMINAR ALIMENTO ---");
        System.out.print("  Codigo de barras a eliminar: ");
        String cod = sc.nextLine().trim();

        boolean ok = gestor.eliminar(cod);
        System.out.println("[OK] Eliminacion: " + (ok ? "exitosa" : "no encontrado"));
    }

    /**
     * Serializa el estado actual del gestor en el archivo de persistencia.
     */
    private static void guardar() {
        System.out.println("--- GUARDAR EN ARCHIVO ---");
        String msg = gestor.serializar(gestor.listar(), PATH, NOMBRE_ARCHIVO);
        System.out.println("  " + msg);
    }

    /**
     * Deserializa el archivo de persistencia y carga los alimentos al gestor.
     */
    private static void cargar() {
        System.out.println("--- CARGAR DESDE ARCHIVO ---");
        Alimento[] cargados = gestor.deserializar(PATH, NOMBRE_ARCHIVO);

        if (cargados != null) {
            gestor = new ImplementacionOperacionCRUD();
            for (Alimento a : cargados) {
                if (a != null) gestor.crear(a);
            }
            System.out.println("[OK] Archivo cargado. Alimentos disponibles: "
                    + gestor.getCantidad());
        } else {
            System.out.println("[!] No se encontro archivo o esta vacio.");
        }
    }

    // ============================================================
    // UTILIDAD
    // ============================================================

    /**
     * Lee un número entero desde la consola, repitiendo la solicitud
     * si el usuario ingresa un valor no numérico.
     *
     * @param mensaje texto que se muestra al usuario antes de leer
     * @return entero ingresado por el usuario
     */
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("[!] Ingrese un numero valido.");
            }
        }
    }
}