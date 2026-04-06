package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;

/**
 * Interfaz que define las operaciones básicas CRUD sobre objetos {@link Alimento}.
 *
 * <p>CRUD corresponde a: Crear, leer (Consultar), actualizar (Modificar)
 * y eliminar. Cualquier clase que implemente esta interfaz debe proveer
 * la lógica completa para cada una de estas operaciones.</p>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public interface OperacionCRUD {

    /**
     * Inserta un nuevo alimento en el arreglo.
     *
     * <p>Se inserta en el primer espacio {@code null} disponible de izquierda
     * a derecha. Si el arreglo está lleno, se expande al doble de su capacidad.</p>
     *
     * @param alimento objeto {@link Alimento} a insertar; no debe ser {@code null}
     */
    void crear(Alimento alimento);

    /**
     * Busca y retorna el alimento con el código de barras indicado.
     *
     * @param codigodebarras código de barras del alimento a buscar
     * @return el {@link Alimento} encontrado, o {@code null} si no existe
     */
    Alimento consultar(String codigodebarras);

    /**
     * Reemplaza el alimento que tenga el código de barras indicado.
     *
     * @param codigodebarras código de barras del alimento a reemplazar
     * @param alimento       nuevo objeto {@link Alimento} con los datos actualizados
     * @return {@code true} si la modificación fue exitosa, {@code false} si no se encontró
     */
    boolean modificar(String codigodebarras, Alimento alimento);

    /**
     * Elimina el alimento con el código de barras indicado, dejando {@code null}
     * en su posición dentro del arreglo.
     *
     * @param codigodebarras código de barras del alimento a eliminar
     * @return {@code true} si la eliminación fue exitosa, {@code false} si no se encontró
     */
    boolean eliminar(String codigodebarras);

    /**
     * Retorna el arreglo completo de alimentos, incluyendo posiciones {@code null}.
     *
     * @return arreglo de {@link Alimento} con todos los elementos almacenados
     */
    Alimento[] listar();
}