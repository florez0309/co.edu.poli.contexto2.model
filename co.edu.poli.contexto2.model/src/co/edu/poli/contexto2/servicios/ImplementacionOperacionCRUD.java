package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;
import co.edu.poli.contexto2.model.Deshidratado;
import co.edu.poli.contexto2.model.Enlatado;
import co.edu.poli.contexto2.model.Registro;

import java.io.*;

/**
 * Implementación de las interfaces {@link OperacionCRUD} y {@link OperacionArchivo}.
 *
 * <p>Gestiona un arreglo dinámico de objetos {@link Alimento} que inicia con
 * capacidad 2 y se duplica automáticamente cuando se llena. Además, permite
 * persistir y recuperar los datos en un archivo de texto cuya ruta y nombre
 * se indican como parámetros en cada operación.</p>
 *
 * <p>Formato del archivo de persistencia (una línea por alimento):</p>
 * <pre>
 * TIPO;estado;sabor;fechadevencimiento;codigodebarras;fechafabricacion;
 * lugardefabricacion;fechacaducidad;idregistro;atributoEspecifico
 * </pre>
 * <p>Donde {@code TIPO} es {@code DESHIDRATADO} o {@code ENLATADO}.</p>
 *
 * @author florez0309
 * @version 1.0
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

    /** Arreglo dinámico de alimentos; inicia con capacidad 2. */
    private Alimento[] arreglo;

    /** Número real de alimentos almacenados (sin contar posiciones null). */
    private int cantidad;

    /**
     * Construye una nueva instancia con un arreglo inicial de capacidad 2
     * y sin elementos.
     */
    public ImplementacionOperacionCRUD() {
        arreglo = new Alimento[2];
        cantidad = 0;
    }

    // ─────────────────────────────────────────────────────────────
    // CRUD
    // ─────────────────────────────────────────────────────────────

    /**
     * Inserta un nuevo alimento en el primer espacio disponible ({@code null})
     * del arreglo de izquierda a derecha.
     *
     * <p>Si el arreglo está completamente lleno, se expande al doble de su
     * capacidad antes de insertar. No se permiten alimentos {@code null} ni
     * códigos de barras duplicados.</p>
     *
     * @param alimento objeto {@link Alimento} a insertar; no debe ser {@code null}
     */
    @Override
    public void crear(Alimento alimento) {
        if (alimento == null) {
            System.out.println("  [CREAR] Error: el alimento no puede ser null.");
            return;
        }
        if (consultar(alimento.getCodigodebarras()) != null) {
            System.out.println("  [CREAR] Error: ya existe un alimento con codigodebarras '"
                    + alimento.getCodigodebarras() + "'.");
            return;
        }
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = alimento;
                cantidad++;
                System.out.println("  [CREAR] Alimento '" + alimento.getCodigodebarras()
                        + "' insertado en posición [" + i + "]. Capacidad actual: " + arreglo.length);
                return;
            }
        }
        System.out.println("  [CREAR] Arreglo lleno (capacidad " + arreglo.length
                + "). Expandiendo al doble...");
        Alimento[] nuevo = new Alimento[arreglo.length * 2];
        for (int i = 0; i < arreglo.length; i++) {
            nuevo[i] = arreglo[i];
        }
        arreglo = nuevo;
        arreglo[cantidad] = alimento;
        cantidad++;
        System.out.println("  [CREAR] Alimento '" + alimento.getCodigodebarras()
                + "' insertado en posición [" + (cantidad - 1) + "]. Nueva capacidad: " + arreglo.length);
    }

    /**
     * Busca y retorna el alimento con el código de barras indicado.
     *
     * @param codigodebarras código de barras a buscar; no debe ser {@code null} ni vacío
     * @return el {@link Alimento} encontrado, o {@code null} si no existe
     */
    @Override
    public Alimento consultar(String codigodebarras) {
        if (codigodebarras == null || codigodebarras.trim().isEmpty()) {
            System.out.println("  [CONSULTAR] Error: el codigodebarras no puede ser vacío.");
            return null;
        }
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigodebarras().equals(codigodebarras)) {
                return arreglo[i];
            }
        }
        return null;
    }

    /**
     * Reemplaza el alimento que tenga el código de barras indicado por el nuevo objeto.
     *
     * @param codigodebarras código de barras del alimento a reemplazar
     * @param alimento       nuevo objeto {@link Alimento} con los datos actualizados
     * @return {@code true} si la modificación fue exitosa, {@code false} si no se encontró
     */
    @Override
    public boolean modificar(String codigodebarras, Alimento alimento) {
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

    /**
     * Elimina el alimento con el código de barras indicado, dejando {@code null}
     * en su posición dentro del arreglo.
     *
     * @param codigodebarras código de barras del alimento a eliminar
     * @return {@code true} si la eliminación fue exitosa, {@code false} si no se encontró
     */
    @Override
    public boolean eliminar(String codigodebarras) {
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

    /**
     * Retorna el arreglo completo de alimentos, incluyendo posiciones {@code null}.
     *
     * @return arreglo de {@link Alimento}
     */
    @Override
    public Alimento[] listar() {
        return arreglo;
    }

    // ─────────────────────────────────────────────────────────────
    // ARCHIVO
    // ─────────────────────────────────────────────────────────────

    /**
     * Serializa el arreglo de alimentos recibido y lo guarda en el archivo
     * ubicado en {@code path + name + ".txt"}.
     *
     * <p>Formato de cada línea:</p>
     * <pre>
     * DESHIDRATADO;estado;sabor;fechavencimiento;codigodebarras;fechafabricacion;
     * lugarfabricacion;fechacaducidad;idregistro;cantidadDias
     *
     * ENLATADO;estado;sabor;fechavencimiento;codigodebarras;fechafabricacion;
     * lugarfabricacion;fechacaducidad;idregistro;material
     * </pre>
     *
     * @param alimentos arreglo de {@link Alimento} a guardar en el archivo
     * @param path      ruta del directorio donde se creará el archivo (ej. {@code "src/"})
     * @param name      nombre del archivo sin extensión (ej. {@code "alimentos"})
     * @return mensaje de confirmación o de error según el resultado de la operación
     */
    @Override
    public String serializar(Alimento[] alimentos, String path, String name) {
        if (alimentos == null) {
            return "[SERIALIZAR] Error: el arreglo de alimentos no puede ser null.";
        }
        String rutaCompleta = path + name + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaCompleta))) {
            int escritos = 0;
            for (int i = 0; i < alimentos.length; i++) {
                if (alimentos[i] == null) continue;
                Alimento a = alimentos[i];
                String idReg = (a.getRegistro() != null)
                        ? String.valueOf(a.getRegistro().getIdregistro()) : "0";

                if (a instanceof Deshidratado) {
                    Deshidratado d = (Deshidratado) a;
                    bw.write("DESHIDRATADO;" + a.getEstado() + ";" + a.getSabor() + ";"
                            + a.getFechadevencimiento() + ";" + a.getCodigodebarras() + ";"
                            + a.getFechafabricacion() + ";" + a.getLugardefabricacion() + ";"
                            + a.getFechacaducidad() + ";" + idReg + ";"
                            + d.getCantidadtamaximaadias());
                } else if (a instanceof Enlatado) {
                    Enlatado e = (Enlatado) a;
                    bw.write("ENLATADO;" + a.getEstado() + ";" + a.getSabor() + ";"
                            + a.getFechadevencimiento() + ";" + a.getCodigodebarras() + ";"
                            + a.getFechafabricacion() + ";" + a.getLugardefabricacion() + ";"
                            + a.getFechacaducidad() + ";" + idReg + ";"
                            + e.getMaterialdelas());
                }
                bw.newLine();
                escritos++;
            }
            return "[SERIALIZAR] " + escritos + " alimento(s) guardado(s) en '" + rutaCompleta + "'.";
        } catch (IOException e) {
            return "[SERIALIZAR] Error al escribir el archivo: " + e.getMessage();
        }
    }

    /**
     * Lee el archivo ubicado en {@code path + name + ".txt"} y reconstruye
     * los objetos {@link Alimento} almacenados previamente.
     *
     * <p>Si el archivo no existe o está vacío, retorna {@code null}.</p>
     *
     * @param path ruta del directorio donde se encuentra el archivo (ej. {@code "src/"})
     * @param name nombre del archivo sin extensión (ej. {@code "alimentos"})
     * @return arreglo de {@link Alimento} con los datos leídos,
     *         o {@code null} si el archivo no existe o está vacío
     */
    @Override
    public Alimento[] deserializar(String path, String name) {
        String rutaCompleta = path + name + ".txt";
        File archivo = new File(rutaCompleta);
        if (!archivo.exists()) {
            System.out.println("[DESERIALIZAR] El archivo '" + rutaCompleta + "' no existe.");
            return null;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            int total = 0;
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) total++;
            }
            if (total == 0) {
                System.out.println("[DESERIALIZAR] El archivo está vacío.");
                return null;
            }

            Alimento[] resultado = new Alimento[total];
            int idx = 0;

            try (BufferedReader br2 = new BufferedReader(new FileReader(archivo))) {
                while ((linea = br2.readLine()) != null) {
                    if (linea.trim().isEmpty()) continue;
                    String[] partes = linea.split(";");
                    Registro reg = new Registro(
                            Integer.parseInt(partes[8]), 0, "", "", "", "", "");

                    if (partes[0].equals("DESHIDRATADO")) {
                        resultado[idx++] = new Deshidratado(
                                partes[1], partes[2], partes[3], partes[4],
                                partes[5], partes[6], partes[7], reg,
                                Integer.parseInt(partes[9]));
                    } else if (partes[0].equals("ENLATADO")) {
                        resultado[idx++] = new Enlatado(
                                partes[1], partes[2], partes[3], partes[4],
                                partes[5], partes[6], partes[7], reg, partes[9]);
                    }
                }
            }
            System.out.println("[DESERIALIZAR] " + idx + " alimento(s) cargado(s) desde '"
                    + rutaCompleta + "'.");
            return resultado;

        } catch (IOException | NumberFormatException e) {
            System.out.println("[DESERIALIZAR] Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    // ─────────────────────────────────────────────────────────────
    // Getters auxiliares
    // ─────────────────────────────────────────────────────────────

    /**
     * Retorna el número real de alimentos almacenados (sin contar nulls).
     * @return cantidad de alimentos
     */
    public int getCantidad() { return cantidad; }

    /**
     * Retorna la capacidad actual del arreglo interno.
     * @return capacidad del arreglo
     */
    public int getCapacidad() { return arreglo.length; }
}