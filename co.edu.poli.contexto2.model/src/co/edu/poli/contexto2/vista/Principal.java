package co.edu.poli.contexto2.vista;

import co.edu.poli.contexto2.model.*;
import co.edu.poli.contexto2.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto2.servicios.OperacionArchivo;
import co.edu.poli.contexto2.servicios.OperacionCRUD;

/**
 * Clase principal de la aplicación. Contiene el punto de entrada {@code main}
 * y los métodos polimórficos de demostración del sistema de alimentos espaciales.
 *
 * <p>Incluye demostración de:</p>
 * <ul>
 *   <li>Creación de objetos del modelo (Registro, Inventario, Capitan, Nave, Empresa)</li>
 *   <li>Atributo estático compartido ({@code contraseniaingreso})</li>
 *   <li>Sobreescritura y sobrecarga de métodos</li>
 *   <li>Arreglo polimórfico de tipo supersuperclase ({@link Alimento})</li>
 *   <li>Atributo final, método final y clase final</li>
 *   <li>Operaciones CRUD mediante {@link ImplementacionOperacionCRUD}</li>
 *   <li>Operaciones sobre archivo: serializar y deserializar</li>
 * </ul>
 *
 * @author florez0309
 * @version 1.0
 */
public class Principal {

    // ============================================
    // MÉTODOS POLIMÓRFICOS
    // ============================================

    /**
     * MÉTODO POLIMÓRFICO 1: Recibe un parámetro de tipo supersuperclase (Alimento).
     *
     * <p>Procesa cualquier tipo de {@link Alimento} de forma polimórfica,
     * mostrando su tipo real, representación en texto, categoría y estado de caducidad.</p>
     *
     * @param alimento objeto de tipo {@link Alimento} (o cualquier subclase) a procesar
     */
    public static void procesarAlimento(Alimento alimento) {
        System.out.println("  ┌─ [POLIMORFISMO] Procesando alimento:");
        System.out.println("  │  Tipo: " + alimento.getClass().getSimpleName());
        System.out.println("  │  " + alimento.toString());
        System.out.println("  │  " + alimento.obtenerCategoria());
        System.out.println("  │  Verificando caducidad...");
        boolean caducado = alimento.verificarCaducidad("15/02/2025");
        System.out.println("  └─ Estado: " + (caducado ? "CADUCADO" : "VIGENTE"));
        System.out.println();
    }

    /**
     * MÉTODO POLIMÓRFICO 2: Retorna un objeto de tipo supersuperclase (Alimento).
     *
     * <p>Crea y retorna una instancia concreta de {@link Alimento} según el tipo
     * indicado. Permite demostrar el polimorfismo de retorno.</p>
     *
     * @param tipo     tipo de alimento a crear: {@code "deshidratado"}, {@code "enlatado"}
     *                 o cualquier otro valor (genera un deshidratado por defecto)
     * @param registro registro de misión que se asignará al alimento creado
     * @return instancia de {@link Deshidratado} o {@link Enlatado} según el tipo indicado
     */
    public static Alimento crearAlimentoSegunTipo(String tipo, Registro registro) {
        System.out.println("  [POLIMORFISMO] Creando alimento de tipo: " + tipo);

        if (tipo.equalsIgnoreCase("deshidratado")) {
            return new Deshidratado("Seco", "Neutro", "31/12/2026", "DH999", "01/01/2025",
                                   "Fábrica Espacial", "31/12/2026", registro, 730);
        } else if (tipo.equalsIgnoreCase("enlatado")) {
            return new Enlatado("Sellado", "Salado", "30/06/2027", "EN999", "01/01/2025",
                               "Planta Industrial", "30/06/2027", registro, "Acero");
        } else {
            return new Deshidratado("Empacado", "Dulce", "15/08/2026", "DH888", "01/01/2025",
                                   "Planta Beta", "15/08/2026", registro, 365);
        }
    }

    /**
     * Punto de entrada de la aplicación. Ejecuta la demostración completa del sistema.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("   SISTEMA DE GESTIÓN ESPACIAL - DEMO");
        System.out.println("=================================================\n");

        // ============================================
        // Creación de objetos REGISTRO
        // ============================================
        System.out.println(">>> CREACIÓN DE OBJETOS TIPO REGISTRO <<<");
        System.out.println("--------------------------------------------------");

        Registro registro1 = new Registro(101, 20250215, "Marte", "Exploración Mineral", "Alimentos", "Nave-Alpha", "Cinturón de asteroides");
        System.out.println("Registro 1 creado:");
        System.out.println(registro1);
        System.out.println();

        Registro registro2 = new Registro(102, 20250220, "Luna", "Recolección de Muestras", "Herramientas", "Nave-Beta", "Mar de la Tranquilidad");
        System.out.println("Registro 2 creado:");
        System.out.println(registro2);
        System.out.println();

        Registro registro3 = new Registro(103, 20250225, "Júpiter", "Investigación Científica", "Alimentos y Equipos", "Nave-Gamma", "Europa");
        System.out.println("Registro 3 creado:");
        System.out.println(registro3);
        System.out.println("\n");

        // ============================================
        // ATRIBUTO ESTÁTICO - contraseniaingreso
        // ============================================
        System.out.println(">>> ATRIBUTO ESTÁTICO (contraseniaingreso) <<<");
        System.out.println("-------------------------------------------------------");
        System.out.println("Valor inicial del atributo estático: " + Inventario.contraseniaingreso);
        System.out.println();

        Inventario inventario1 = new Inventario(201, "15/02/2025", "20/02/2025", "Alimentos", "SpaceCorp", registro1);
        System.out.println("Inventario 1 creado - contraseniaingreso ahora es: " + Inventario.contraseniaingreso);

        Inventario inventario2 = new Inventario(202, "16/02/2025", "21/02/2025", "Herramientas", "MarsIndustries", registro2);
        System.out.println("Inventario 2 creado - contraseniaingreso ahora es: " + Inventario.contraseniaingreso);

        Inventario inventario3 = new Inventario(203, "17/02/2025", "22/02/2025", "Equipos", "JupiterTech", registro3);
        System.out.println("Inventario 3 creado - contraseniaingreso ahora es: " + Inventario.contraseniaingreso);
        System.out.println();

        System.out.println(">>> MODIFICANDO el atributo estático a 1000 <<<");
        Inventario.contraseniaingreso = 1000;
        System.out.println();

        System.out.println("EVIDENCIA: Todos los objetos comparten el mismo valor del atributo estático:");
        System.out.println("inventario1.contraseniaingreso = " + Inventario.contraseniaingreso);
        System.out.println("inventario2.contraseniaingreso = " + Inventario.contraseniaingreso);
        System.out.println("inventario3.contraseniaingreso = " + Inventario.contraseniaingreso);
        System.out.println("Clase.contraseniaingreso      = " + Inventario.contraseniaingreso);
        System.out.println("\n");

        // ============================================
        // SOBREESCRITURA Y SOBRECARGA
        // ============================================
        System.out.println(">>> SOBREESCRITURA Y SOBRECARGA DE MÉTODOS <<<");
        System.out.println("--------------------------------------------------------");

        Capitan capitan1 = new Capitan("CAP-001", "Ana Rodriguez", 68.5, 1.72, "01/01/2020", "Activo", "15/05/1985");

        Deshidratado alimento1 = new Deshidratado("Fresco", "Dulce", "01/03/2025", "7894561230", "10/01/2025", "Tierra", "01/03/2026", registro1, 365);

        System.out.println("\n--- DEMOSTRACIÓN DE SOBREESCRITURA ---");
        boolean caducado = alimento1.verificarCaducidad("15/02/2025");
        System.out.println("  Resultado: " + (caducado ? "Caducado" : "Vigente"));
        System.out.println();

        System.out.println("--- DEMOSTRACIÓN DE SOBRECARGA ---");
        String resultado1 = alimento1.calcularconservacion("15/02/2025");
        System.out.println("  [SOBRECARGA 1] " + resultado1);
        System.out.println();

        String resultado2 = alimento1.calcularconservacion("15/02/2025", "Refrigerado");
        System.out.println("  [SOBRECARGA 2] " + resultado2);
        System.out.println("\n");

        // ============================================
        // ARREGLO POLIMÓRFICO
        // ============================================
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  ARREGLO DE TIPO SUPERSUPERCLASE (Alimento)           ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        Alimento[] alimentosEspaciales = new Alimento[5];

        alimentosEspaciales[0] = new Deshidratado("Empacado", "Neutro", "31/12/2025", "DH001", "01/01/2025", "Planta A", "31/12/2025", registro1, 365);
        alimentosEspaciales[1] = new Enlatado("Sellado", "Salado", "30/06/2026", "EN002", "15/01/2025", "Planta B", "30/06/2026", registro2, "Aluminio");
        alimentosEspaciales[2] = new Deshidratado("Seco", "Dulce", "15/08/2025", "DH003", "20/01/2025", "Planta C", "15/08/2025", registro3, 180);

        System.out.println("Posiciones [3] y [4] = null (vacías)\n");

        String fechaActual = "15/02/2025";
        for (int i = 0; i < 3; i++) {
            System.out.println("   Posición [" + i + "]: " + alimentosEspaciales[i].getClass().getSimpleName());
            boolean estaCaducado = alimentosEspaciales[i].verificarCaducidad(fechaActual);
            System.out.println("     Código de barras: " + alimentosEspaciales[i].getCodigodebarras());
            System.out.println("     Fecha de caducidad: " + alimentosEspaciales[i].getFechacaducidad());
            System.out.println("     Resultado: " + (estaCaducado ? "CADUCADO" : "VIGENTE"));
            System.out.println("     Valor nutricional: " + alimentosEspaciales[i].calcularValorNutricional() + "\n");
        }

        // ============================================
        // POLIMORFISMO - métodos polimórficos
        // ============================================
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  MÉTODOS POLIMÓRFICOS                                 ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        System.out.println("--- Método polimórfico 1: procesarAlimento() ---");
        procesarAlimento(alimentosEspaciales[0]);
        procesarAlimento(alimentosEspaciales[1]);

        System.out.println("--- Método polimórfico 2: crearAlimentoSegunTipo() ---");
        Alimento polimorf1 = crearAlimentoSegunTipo("deshidratado", registro1);
        System.out.println("  Creado: " + polimorf1.getClass().getSimpleName() + " | " + polimorf1);
        Alimento polimorf2 = crearAlimentoSegunTipo("enlatado", registro2);
        System.out.println("  Creado: " + polimorf2.getClass().getSimpleName() + " | " + polimorf2);
        System.out.println();

        // ============================================
        // ATRIBUTO FINAL, MÉTODO FINAL, CLASE FINAL
        // ============================================
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  ATRIBUTO FINAL - MÉTODO FINAL - CLASE FINAL          ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        System.out.println("Atributo final CATEGORIA: " + alimentosEspaciales[0].CATEGORIA);
        System.out.println("Método final obtenerCategoria(): " + alimentosEspaciales[0].obtenerCategoria());
        System.out.println("Clase final: Enlatado.java declarada como 'public final class Enlatado'");
        System.out.println();

        // ============================================
        // DEMO NAVE Y EMPRESA
        // ============================================
        Nave nave1 = new Nave("10/06/2018", "Carguero", "Estación Lunar", 50000.0, "Nave-Alpha", "NAVE-001", "Plateado", 150, 10000, 50, capitan1, inventario1);
        System.out.println("Nave creada: " + nave1);

        Empresa empresa1 = new Empresa("SpaceCorp", "John Smith", "Transporte espacial", 250, "logo.png", "EMP-001", "Marte-Ciudad Central", capitan1);
        System.out.println("Empresa creada: " + empresa1);
        System.out.println("¿Es empresa grande? " + empresa1.esempresagrande());
        System.out.println();

        // ============================================================
        // OPERACIONES CRUD
        // ============================================================
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║         OPERACIONES CRUD - ImplementacionOperacionCRUD║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        // Crear instancia usando la interface como tipo (polimorfismo de interface)
        OperacionCRUD crud = new ImplementacionOperacionCRUD();

        // ── CREAR ──────────────────────────────────────────────────
        System.out.println("─── CREAR ───────────────────────────────────────────────");

        Alimento a1 = new Deshidratado("Fresco", "Dulce", "01/01/2027", "COD-001", "01/01/2025",
                                       "Planta A", "01/01/2027", registro1, 400);
        Alimento a2 = new Enlatado("Sellado", "Salado", "01/06/2027", "COD-002", "01/02/2025",
                                   "Planta B", "01/06/2027", registro2, "Acero");
        Alimento a3 = new Deshidratado("Seco", "Neutro", "01/09/2027", "COD-003", "01/03/2025",
                                       "Planta C", "01/09/2027", registro3, 600);

        crud.crear(a1); // Posición [0] — arreglo tamaño 2
        crud.crear(a2); // Posición [1] — arreglo lleno tras esto
        crud.crear(a3); // Expande a tamaño 4, inserta en [2]

        System.out.println("\n  Intentando crear con codigodebarras repetido (COD-001):");
        crud.crear(new Deshidratado("X", "X", "01/01/2028", "COD-001", "01/01/2025", "X", "01/01/2028", registro1, 100));

        System.out.println("\n  Intentando crear objeto null:");
        crud.crear(null);

        // ── CONSULTAR ─────────────────────────────────────────────
        System.out.println("\n─── CONSULTAR ───────────────────────────────────────────");

        Alimento encontrado = crud.consultar("COD-002");
        if (encontrado != null) {
            System.out.println("  [CONSULTAR] Encontrado: " + encontrado);
        }

        Alimento noExiste = crud.consultar("COD-999");
        if (noExiste == null) {
            System.out.println("  [CONSULTAR] COD-999 no existe en el arreglo.");
        }

        crud.consultar("");

        // ── MODIFICAR ─────────────────────────────────────────────
        System.out.println("\n─── MODIFICAR ───────────────────────────────────────────");

        Alimento aModificado = new Enlatado("Nuevo estado", "Dulce", "01/12/2028", "COD-002",
                                            "01/02/2025", "Planta B", "01/12/2028", registro2, "Aluminio");
        boolean modOk = crud.modificar("COD-002", aModificado);
        System.out.println("  Resultado modificación: " + modOk);

        Alimento verificacion = crud.consultar("COD-002");
        System.out.println("  Estado después de modificar: " + (verificacion != null ? verificacion.getEstado() : "null"));

        crud.modificar("COD-999", aModificado);
        crud.modificar("COD-001", null);

        // ── ELIMINAR ──────────────────────────────────────────────
        System.out.println("\n─── ELIMINAR ────────────────────────────────────────────");

        boolean elimOk = crud.eliminar("COD-003");
        System.out.println("  Resultado eliminación COD-003: " + elimOk);

        crud.eliminar("COD-999");
        crud.eliminar("");

        // ── LISTAR ────────────────────────────────────────────────
        System.out.println("\n─── LISTAR ──────────────────────────────────────────────");
        Alimento[] lista = crud.listar();
        System.out.println("  Capacidad del arreglo: " + lista.length);
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                System.out.println("  [" + i + "] " + lista[i].getClass().getSimpleName()
                        + " | código: " + lista[i].getCodigodebarras()
                        + " | valor nutricional: " + lista[i].calcularValorNutricional());
            } else {
                System.out.println("  [" + i + "] null");
            }
        }

        // ============================================================
        // OPERACIONES SOBRE ARCHIVO (serializar / deserializar)
        // ============================================================
        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║         OPERACIONES SOBRE ARCHIVO                     ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        // Usar la interfaz OperacionArchivo como tipo (polimorfismo de interfaz)
        OperacionArchivo archivo = new ImplementacionOperacionCRUD();

        // ── SERIALIZAR ────────────────────────────────────────────
        System.out.println("─── SERIALIZAR ──────────────────────────────────────────");
        String msgSer = archivo.serializar(crud.listar(), "src/", "alimentos");
        System.out.println("  " + msgSer);

        // Intentar serializar con arreglo null (validación)
        System.out.println("\n  Intentando serializar arreglo null:");
        String msgNull = archivo.serializar(null, "src/", "alimentos");
        System.out.println("  " + msgNull);

        // ── DESERIALIZAR ──────────────────────────────────────────
        System.out.println("\n─── DESERIALIZAR ────────────────────────────────────────");
        Alimento[] cargados = archivo.deserializar("src/", "alimentos");
        if (cargados != null) {
            System.out.println("  Alimentos cargados desde archivo:");
            for (int i = 0; i < cargados.length; i++) {
                if (cargados[i] != null) {
                    System.out.println("  [" + i + "] " + cargados[i].getClass().getSimpleName()
                            + " | código: " + cargados[i].getCodigodebarras()
                            + " | valor nutricional: " + cargados[i].calcularValorNutricional());
                }
            }
        }

        // Intentar deserializar un archivo que no existe
        System.out.println("\n  Intentando deserializar archivo inexistente:");
        Alimento[] noArchivo = archivo.deserializar("src/", "noexiste");
        if (noArchivo == null) {
            System.out.println("  Resultado: null (archivo no encontrado)");
        }

        System.out.println("\n=================================================");
        System.out.println("   FIN DE LA DEMOSTRACIÓN");
        System.out.println("=================================================");

        /*
         * ═══════════════════════════════════════════════════════════════
         * COMENTARIOS SOBRE UBICACIÓN DE CAMBIOS
         * ═══════════════════════════════════════════════════════════════
         *
         * 1. ATRIBUTO FINAL (no se puede cambiar):
         *    Archivo: Alimento.java
         *    Código: public final String CATEGORIA = "Alimento Espacial";
         *
         * 2. MÉTODO FINAL (no se puede sobreescribir):
         *    Archivo: Alimento.java
         *    Código: public final String obtenerCategoria()
         *
         * 3. CLASE FINAL (no se puede heredar):
         *    Archivo: Enlatado.java
         *    Código: public final class Enlatado extends Alimento
         *
         * 4. MÉTODO ABSTRACTO NUEVO (semana actual):
         *    Archivo: Alimento.java
         *    Código: public abstract double calcularValorNutricional();
         *    Implementado en: Deshidratado, Enlatado, Deshidratadoespecial
         *
         * 5. INTERFACE OperacionCRUD:
         *    Paquete: co.edu.poli.contexto2.servicios
         *    Métodos: crear, consultar, modificar, eliminar, listar
         *
         * 6. CLASE ImplementacionOperacionCRUD:
         *    Paquete: co.edu.poli.contexto2.servicios
         *    Implementa OperacionCRUD y OperacionArchivo con arreglo dinámico
         *
         * 7. INTERFACE OperacionArchivo:
         *    Paquete: co.edu.poli.contexto2.servicios
         *    Métodos: serializar(Alimento[], String, String)
         *             deserializar(String, String)
         * ═══════════════════════════════════════════════════════════════
         */
    }
}