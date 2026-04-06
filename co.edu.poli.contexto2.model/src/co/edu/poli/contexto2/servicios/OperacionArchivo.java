package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;

/**
 * Interfaz que define las operaciones de persistencia en archivo
 * para los objetos de tipo {@link Alimento}.
 *
 * <p>Las clases que implementen esta interfaz deben proveer la lógica
 * para guardar el estado del arreglo de alimentos en un archivo de texto
 * y para recuperarlo desde dicho archivo, indicando la ruta y el nombre
 * del archivo como parámetros.</p>
 *
 * <p>Formato de cada línea en el archivo:</p>
 * <pre>
 * TIPO;estado;sabor;fechavencimiento;codigodebarras;fechafabricacion;
 * lugarfabricacion;fechacaducidad;idregistro;atributoEspecifico
 * </pre>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public interface OperacionArchivo {

    /**
     * Serializa el arreglo de alimentos y lo guarda en un archivo de texto.
     *
     * <p>Cada alimento se escribe en una línea con sus atributos separados
     * por punto y coma (;). El tipo de alimento se incluye como primer campo
     * para permitir su reconstrucción al deserializar.</p>
     *
     * @param alimentos arreglo de {@link Alimento} a guardar en el archivo
     * @param path      ruta del directorio donde se creará el archivo (ej. {@code "src/"})
     * @param name      nombre del archivo sin extensión (ej. {@code "alimentos"})
     * @return mensaje de confirmación si la operación fue exitosa,
     *         o mensaje de error en caso de fallo
     */
    String serializar(Alimento[] alimentos, String path, String name);

    /**
     * Lee un archivo de texto y reconstruye los objetos {@link Alimento}
     * almacenados previamente.
     *
     * @param path ruta del directorio donde se encuentra el archivo (ej. {@code "src/"})
     * @param name nombre del archivo sin extensión (ej. {@code "alimentos"})
     * @return arreglo de {@link Alimento} con los datos leídos del archivo,
     *         o {@code null} si el archivo no existe o está vacío
     */
    Alimento[] deserializar(String path, String name);
}