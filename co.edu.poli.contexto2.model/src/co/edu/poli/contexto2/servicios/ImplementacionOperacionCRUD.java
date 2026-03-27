package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;

public class ImplementacionOperacionCRUD implements OperacionCRUD {

    // Arreglo que empieza en tamaño 2 (según el enunciado)
    private Alimento[] arreglo;
    private int cantidad; // cuántos objetos hay realmente (sin contar nulls)

    public ImplementacionOperacionCRUD() {
        arreglo = new Alimento[2];
        cantidad = 0;
    }

    // ─────────────────────────────────────────────────────────────
    // CREAR
    // Inserta en el primer null de izquierda a derecha.
    // Si no hay null disponible, expande el arreglo al doble y luego inserta.
    // ─────────────────────────────────────────────────────────────
    @Override
    public void crear(Alimento alimento) {
        // Validación: no permitir objetos nulos
        if (alimento == null) {
            System.out.println("  [CREAR] Error: el alimento no puede ser null.");
            return;
        }

        // Validación: no permitir código de barras repetido
        if (consultar(alimento.getCodigodebarras()) != null) {
            System.out.println("  [CREAR] Error: ya existe un alimento con codigodebarras '"
                    + alimento.getCodigodebarras() + "'.");
            return;
        }

        // Buscar el primer null de izquierda a derecha
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = alimento;
                cantidad++;
                System.out.println("  [CREAR] Alimento '" + alimento.getCodigodebarras()
                        + "' insertado en posición [" + i + "]. Capacidad actual: " + arreglo.length);
                return;
            }
        }

        // No había null: expandir al doble
        System.out.println("  [CREAR] Arreglo lleno (capacidad " + arreglo.length
                + "). Expandiendo al doble...");
        Alimento[] nuevo = new Alimento[arreglo.length * 2];
        for (int i = 0; i < arreglo.length; i++) {
            nuevo[i] = arreglo[i];
        }
        arreglo = nuevo;

        // Insertar en la primera posición libre del arreglo expandido
        arreglo[cantidad] = alimento;
        cantidad++;
        System.out.println("  [CREAR] Alimento '" + alimento.getCodigodebarras()
                + "' insertado en posición [" + (cantidad - 1) + "]. Nueva capacidad: " + arreglo.length);
    }

    // ─────────────────────────────────────────────────────────────
    // CONSULTAR por codigodebarras
    // ─────────────────────────────────────────────────────────────
    @Override
    public Alimento consultar(String codigodebarras) {
        // Validación: código no puede ser null ni vacío
        if (codigodebarras == null || codigodebarras.trim().isEmpty()) {
            System.out.println("  [CONSULTAR] Error: el codigodebarras no puede ser vacío.");
            return null;
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigodebarras().equals(codigodebarras)) {
                return arreglo[i];
            }
        }
        return null; // No encontrado
    }

    // ─────────────────────────────────────────────────────────────
    // MODIFICAR por codigodebarras
    // ─────────────────────────────────────────────────────────────
    @Override
    public boolean modificar(String codigodebarras, Alimento alimento) {
        // Validaciones
        if (codigodebarras == null || codigodebarras.trim().isEmpty()) {
            System.out.println("  [MODIFICAR] Error: el codigodebarras no puede ser vacío.");
            return false;
        }
        if (alimento == null) {
            System.out.println("  [MODIFICAR] Error: el alimento nuevo no puede ser null.");
            return false;
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigodebarras().equals(codigodebarras)) {
                arreglo[i] = alimento;
                System.out.println("  [MODIFICAR] Alimento '" + codigodebarras
                        + "' modificado correctamente en posición [" + i + "].");
                return true;
            }
        }

        System.out.println("  [MODIFICAR] Error: no se encontró alimento con codigodebarras '"
                + codigodebarras + "'.");
        return false;
    }

    // ─────────────────────────────────────────────────────────────
    // ELIMINAR por codigodebarras (pone null en esa posición)
    // ─────────────────────────────────────────────────────────────
    @Override
    public boolean eliminar(String codigodebarras) {
        // Validación
        if (codigodebarras == null || codigodebarras.trim().isEmpty()) {
            System.out.println("  [ELIMINAR] Error: el codigodebarras no puede ser vacío.");
            return false;
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigodebarras().equals(codigodebarras)) {
                System.out.println("  [ELIMINAR] Alimento '" + codigodebarras
                        + "' eliminado de la posición [" + i + "].");
                arreglo[i] = null;
                cantidad--;
                return true;
            }
        }

        System.out.println("  [ELIMINAR] Error: no se encontró alimento con codigodebarras '"
                + codigodebarras + "'.");
        return false;
    }

    // ─────────────────────────────────────────────────────────────
    // LISTAR - retorna el arreglo completo
    // ─────────────────────────────────────────────────────────────
    @Override
    public Alimento[] listar() {
        return arreglo;
    }

    // Getter auxiliar para saber cuántos elementos reales hay
    public int getCantidad() {
        return cantidad;
    }

    // Getter auxiliar para saber la capacidad actual del arreglo
    public int getCapacidad() {
        return arreglo.length;
    }
}