package co.edu.poli.contexto2.vista;
 
import co.edu.poli.contexto2.model.*;
 
public class Principal {
    
    // ============================================
    // MÉTODOS POLIMÓRFICOS
    // ============================================
    
    /**
     * MÉTODO POLIMÓRFICO 1: Recibe un parámetro de tipo supersuperclase (Alimento)
     * Puede recibir cualquier objeto que sea Alimento o sus subclases
     */
    public static void procesarAlimento(Alimento alimento) {
        System.out.println("  ┌─ [POLIMORFISMO] Procesando alimento:");
        System.out.println("  │  Tipo: " + alimento.getClass().getSimpleName());
        System.out.println("  │  " + alimento.toString());
        System.out.println("  │  " + alimento.obtenerCategoria()); // Método final
        System.out.println("  │  Verificando caducidad...");
        boolean caducado = alimento.verificarCaducidad("15/02/2025");
        System.out.println("  └─ Estado: " + (caducado ? "⚠️  CADUCADO" : "✓ VIGENTE"));
        System.out.println();
    }
    
    /**
     * MÉTODO POLIMÓRFICO 2: Retorna un tipo supersuperclase (Alimento)
     * Puede retornar cualquier objeto que sea subclase de Alimento
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
            // Por defecto retorna Deshidratado
            return new Deshidratado("Empacado", "Dulce", "15/08/2026", "DH888", "01/01/2025",
                                   "Planta Beta", "15/08/2026", registro, 365);
        }
    }
    
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
        
        // Crear varios objetos Inventario
        Inventario inventario1 = new Inventario(201, "15/02/2025", "20/02/2025", "Alimentos", "SpaceCorp", registro1);
        System.out.println("Inventario 1 creado - contraseniaingreso ahora es: " + Inventario.contraseniaingreso);
        
        Inventario inventario2 = new Inventario(202, "16/02/2025", "21/02/2025", "Herramientas", "MarsIndustries", registro2);
        System.out.println("Inventario 2 creado - contraseniaingreso ahora es: " + Inventario.contraseniaingreso);
        
        Inventario inventario3 = new Inventario(203, "17/02/2025", "22/02/2025", "Equipos", "JupiterTech", registro3);
        System.out.println("Inventario 3 creado - contraseniaingreso ahora es: " + Inventario.contraseniaingreso);
        System.out.println();
        
        // Modificar el atributo estático
        System.out.println(">>> MODIFICANDO el atributo estático a 1000 <<<");
        Inventario.contraseniaingreso = 1000;
        System.out.println();
        
        // Evidenciar que TODOS los objetos tienen el mismo valor
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
        System.out.println("Deshidratado extiende de Alimento e implementa verificarCaducidad():");
        boolean caducado = alimento1.verificarCaducidad("15/02/2025");
        System.out.println("  Resultado: " + (caducado ? "Caducado" : "Vigente"));
        System.out.println();
        
        System.out.println("--- DEMOSTRACIÓN DE SOBRECARGA ---");
        System.out.println("Método calcularconservacion() tiene 2 versiones:");
        
        // Sobrecarga 1: método con 1 parámetro
        String resultado1 = alimento1.calcularconservacion("15/02/2025");
        System.out.println("  [SOBRECARGA 1] " + resultado1);
        System.out.println();
        
        // Sobrecarga 2: método con 2 parámetros
        String resultado2 = alimento1.calcularconservacion("15/02/2025", "Refrigerado");
        System.out.println("  [SOBRECARGA 2] " + resultado2);
        System.out.println("\n");
        
        // ============================================
        // ARREGLO POLIMÓRFICO
        // ============================================
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  ARREGLO DE TIPO SUPERSUPERCLASE (Alimento)           ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");
        
        System.out.println("EXPLICACIÓN:");
        System.out.println("  - Supersuperclase = Alimento (clase padre)");
        System.out.println("  - Subclases = Deshidratado y Enlatado");
        System.out.println("  - Subsubclase = Deshidratadoespecial\n");
        
        // CREAR ARREGLO DE TIPO ALIMENTO CON 5 POSICIONES
        System.out.println("1) Creando arreglo de tipo Alimento con 5 posiciones:");
        Alimento[] alimentosEspaciales = new Alimento[5];
        System.out.println("   Alimento[] alimentosEspaciales = new Alimento[5];");
        System.out.println("   ✓ Arreglo creado\n");
        
        // COLOCAR 3 OBJETOS DE DIFERENTES SUBCLASES
        System.out.println("2) Colocando 3 objetos de diferentes subclases:\n");
        
        // Objeto 1: Deshidratado (subclase)
        System.out.println("   Posición [0] - Objeto de tipo Deshidratado:");
        alimentosEspaciales[0] = new Deshidratado("Empacado", "Neutro", "31/12/2025", "DH001", "01/01/2025", "Planta A", "31/12/2025", registro1, 365);
        System.out.println("   " + alimentosEspaciales[0]);
        System.out.println();
        
        // Objeto 2: Enlatado (subclase)
        System.out.println("   Posición [1] - Objeto de tipo Enlatado:");
        alimentosEspaciales[1] = new Enlatado("Sellado", "Salado", "30/06/2026", "EN002", "15/01/2025", "Planta B", "30/06/2026", registro2, "Aluminio");
        System.out.println("   " + alimentosEspaciales[1]);
        System.out.println();
        
        // Objeto 3: Deshidratado (otra instancia de subclase)
        System.out.println("   Posición [2] - Objeto de tipo Deshidratado (segundo objeto):");
        alimentosEspaciales[2] = new Deshidratado("Seco", "Dulce", "15/08/2025", "DH003", "20/01/2025", "Planta C", "15/08/2025", registro3, 180);
        System.out.println("   " + alimentosEspaciales[2]);
        System.out.println();
        
        System.out.println("   Posiciones [3] y [4] = null (vacías)\n");
        
        // IMPRIME RESULTADO DE SOBREESCRITURA DE MÉTODOS
        System.out.println("3) Imprimiendo resultado de SOBREESCRITURA del método verificarCaducidad():\n");
        System.out.println("   (Cada subclase tiene su propia implementación del método)\n");
        
        String fechaActual = "15/02/2025";
        System.out.println("   Fecha actual para verificación: " + fechaActual);
        System.out.println("   " + "─".repeat(60) + "\n");
        
        // Recorrer el arreglo e invocar el método sobreescrito
        for (int i = 0; i < 3; i++) {
            System.out.println("   ► Posición [" + i + "]: " + alimentosEspaciales[i].getClass().getSimpleName());
            
            // Llamar al método sobreescrito
            boolean estaCaducado = alimentosEspaciales[i].verificarCaducidad(fechaActual);
            
            // Imprimir el resultado
            System.out.println("     Código de barras: " + alimentosEspaciales[i].getCodigodebarras());
            System.out.println("     Fecha de caducidad: " + alimentosEspaciales[i].getFechacaducidad());
            System.out.println("     ┌─ RESULTADO: " + (estaCaducado ? "⚠️  CADUCADO" : "✓ VIGENTE"));
            System.out.println("     └─────────────────────────────────────────\n");
        }
        
        System.out.println("\n" + "═".repeat(60));
        System.out.println("RESUMEN PUNTO 1:");
        System.out.println("✓ Arreglo de tipo Alimento (supersuperclase) con 5 posiciones");
        System.out.println("✓ 3 objetos de subclases diferentes colocados");
        System.out.println("✓ Método sobreescrito verificarCaducidad() invocado y resultado impreso");
        System.out.println("═".repeat(60) + "\n\n");
        
        // ============================================
        // INVOCACIÓN DE MÉTODOS POLIMÓRFICOS
        // ============================================
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║       MÉTODOS POLIMÓRFICOS                            ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");
        
        System.out.println("EXPLICACIÓN:");
        System.out.println("  - Método 1: Recibe parámetro de tipo Alimento (supersuperclase)");
        System.out.println("  - Método 2: Retorna tipo Alimento (supersuperclase)");
        System.out.println("  - Ambos trabajan con polimorfismo\n");
        
        System.out.println("─".repeat(60));
        System.out.println("MÉTODO 1: procesarAlimento(Alimento alimento)");
        System.out.println("Recibe un parámetro de tipo supersuperclase");
        System.out.println("─".repeat(60) + "\n");
        
        // Invocar método 1 con diferentes tipos de objetos
        System.out.println("Invocación 1 - Pasando objeto Deshidratado:");
        procesarAlimento(alimentosEspaciales[0]);
        
        System.out.println("Invocación 2 - Pasando objeto Enlatado:");
        procesarAlimento(alimentosEspaciales[1]);
        
        System.out.println("Invocación 3 - Pasando objeto Deshidratado:");
        procesarAlimento(alimentosEspaciales[2]);
        
        System.out.println("\n" + "─".repeat(60));
        System.out.println("MÉTODO 2: crearAlimentoSegunTipo(String tipo, Registro reg)");
        System.out.println("Retorna un objeto de tipo supersuperclase (Alimento)");
        System.out.println("─".repeat(60) + "\n");
        
        // Invocar método 2 que retorna tipo Alimento
        System.out.println("Invocación 1 - Solicitar tipo 'deshidratado':");
        Alimento nuevoAlimento1 = crearAlimentoSegunTipo("deshidratado", registro1);
        System.out.println("  Objeto retornado: " + nuevoAlimento1.getClass().getSimpleName());
        System.out.println("  " + nuevoAlimento1);
        System.out.println();
        
        System.out.println("Invocación 2 - Solicitar tipo 'enlatado':");
        Alimento nuevoAlimento2 = crearAlimentoSegunTipo("enlatado", registro2);
        System.out.println("  Objeto retornado: " + nuevoAlimento2.getClass().getSimpleName());
        System.out.println("  " + nuevoAlimento2);
        System.out.println();
        
        System.out.println("Invocación 3 - Solicitar tipo desconocido:");
        Alimento nuevoAlimento3 = crearAlimentoSegunTipo("otro", registro3);
        System.out.println("  Objeto retornado: " + nuevoAlimento3.getClass().getSimpleName());
        System.out.println("  " + nuevoAlimento3);
        System.out.println();
        
        System.out.println("═".repeat(60));
        System.out.println("RESUMEN PUNTO 2:");
        System.out.println("✓ Método 1 recibe parámetro de tipo Alimento - invocado 3 veces");
        System.out.println("✓ Método 2 retorna tipo Alimento - invocado 3 veces");
        System.out.println("✓ Polimorfismo aplicado correctamente");
        System.out.println("═".repeat(60) + "\n\n");
        
        // ============================================
        // PUNTO 3: DEMOSTRACIÓN DE FINAL
        // ============================================
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  ATRIBUTO FINAL, MÉTODO FINAL Y CLASE FINAL           ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");
        
        System.out.println("─".repeat(60));
        System.out.println("1. ATRIBUTO FINAL");
        System.out.println("─".repeat(60));
        System.out.println("Ubicación: Clase Alimento.java (línea 13)");
        System.out.println("Código: public final String CATEGORIA = \"Alimento Espacial\";");
        System.out.println();
        System.out.println("Demostración:");
        System.out.println("  Valor del atributo final: " + alimentosEspaciales[0].CATEGORIA);
        System.out.println("  Este atributo NO puede cambiar después de la inicialización");
        System.out.println("  // alimentosEspaciales[0].CATEGORIA = \"Otro\"; ← ERROR de compilación");
        System.out.println();
        
        System.out.println("─".repeat(60));
        System.out.println("2. MÉTODO FINAL");
        System.out.println("─".repeat(60));
        System.out.println("Ubicación: Clase Alimento.java (línea 96)");
        System.out.println("Código: public final String obtenerCategoria()");
        System.out.println();
        System.out.println("Demostración:");
        System.out.println("  " + alimentosEspaciales[0].obtenerCategoria());
        System.out.println("  Este método NO puede ser sobreescrito en las subclases");
        System.out.println("  Todas las subclases usan la MISMA implementación");
        System.out.println();
        
        System.out.println("─".repeat(60));
        System.out.println("3. CLASE FINAL");
        System.out.println("─".repeat(60));
        System.out.println("Ubicación: Clase Enlatado.java (línea 5)");
        System.out.println("Código: public final class Enlatado extends Alimento");
        System.out.println();
        System.out.println("Demostración:");
        System.out.println("  La clase Enlatado es final");
        System.out.println("  NO se puede crear ninguna subclase de Enlatado");
        System.out.println("  // class SubEnlatado extends Enlatado {} ← ERROR de compilación");
        System.out.println();
        
        System.out.println("═".repeat(60));
        System.out.println("RESUMEN PUNTO 3:");
        System.out.println("✓ Atributo final CATEGORIA en Alimento.java");
        System.out.println("✓ Método final obtenerCategoria() en Alimento.java");
        System.out.println("✓ Clase final Enlatado en Enlatado.java");
        System.out.println("═".repeat(60) + "\n\n");
        
        // ============================================
        // DEMOSTRACIÓN COMPLETA DEL SISTEMA
        // ============================================
        System.out.println(">>> DEMOSTRACIÓN COMPLETA DEL SISTEMA <<<");
        System.out.println("-----------------------------------------");
        
        Nave nave1 = new Nave("10/06/2018", "Carguero", "Estación Lunar", 50000.0, "Nave-Alpha", "NAVE-001", "Plateado", 150, 10000, 50, capitan1, inventario1);
        System.out.println("Nave creada:");
        System.out.println(nave1);
        System.out.println();
        
        Empresa empresa1 = new Empresa("SpaceCorp", "John Smith", "Transporte espacial", 250, "logo.png", "EMP-001", "Marte-Ciudad Central", capitan1);
        System.out.println("Empresa creada:");
        System.out.println(empresa1);
        System.out.println("¿Es empresa grande? " + empresa1.esempresagrande());
        System.out.println();
        
        System.out.println("=================================================");
        System.out.println("   FIN DE LA DEMOSTRACIÓN");
        System.out.println("=================================================");
        
        /*
         * ═══════════════════════════════════════════════════════════════
         * COMENTARIOS SOBRE UBICACIÓN DE CAMBIOS
         * ═══════════════════════════════════════════════════════════════
         * 
         * 1. ATRIBUTO FINAL (no se puede cambiar):
         *    ┌─────────────────────────────────────────────────────────┐
         *    │ Archivo: Alimento.java                                   │
         *    │ Línea: 13                                                │
         *    │ Código: public final String CATEGORIA = "Alimento Espa  │
         *    │         cial";                                           │
         *    │ Explicación: Este atributo se inicializa al declararlo   │
         *    │              y NO puede ser modificado después.          │
         *    └─────────────────────────────────────────────────────────┘
         * 
         * 2. MÉTODO FINAL (no se puede sobreescribir):
         *    ┌─────────────────────────────────────────────────────────┐
         *    │ Archivo: Alimento.java                                   │
         *    │ Línea: 96-98                                             │
         *    │ Código: public final String obtenerCategoria() {         │
         *    │             return "Categoría: " + CATEGORIA;            │
         *    │         }                                                │
         *    │ Explicación: Las subclases (Deshidratado, Enlatado) NO  │
         *    │              pueden sobreescribir este método.           │
         *    └─────────────────────────────────────────────────────────┘
         * 
         * 3. CLASE FINAL (no se puede heredar):
         *    ┌─────────────────────────────────────────────────────────┐
         *    │ Archivo: Enlatado.java                                   │
         *    │ Línea: 5                                                 │
         *    │ Código: public final class Enlatado extends Alimento    │
         *    │ Explicación: NO se puede crear ninguna subclase de      │
         *    │              Enlatado. Es el final de esa rama de la    │
         *    │              jerarquía.                                  │
         *    └─────────────────────────────────────────────────────────┘
         * 
         * ═══════════════════════════════════════════════════════════════
         */
    }
}