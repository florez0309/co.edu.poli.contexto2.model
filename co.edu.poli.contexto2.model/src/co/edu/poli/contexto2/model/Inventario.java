package co.edu.poli.contexto2.model;

/**
 * Representa el inventario de productos a bordo de una nave espacial.
 *
 * <p>Cada vez que se crea un inventario, el contador estático
 * {@code contraseniaingreso} se incrementa automáticamente,
 * registrando cuántos inventarios han sido creados en total.</p>
 *
 * @author florez0309
 * @version 1.0
 */
public class Inventario {

    /**
     * Contador estático compartido por todos los objetos de esta clase.
     * Se incrementa en cada instanciación de {@code Inventario}.
     */
    public static int contraseniaingreso = 0;

    /** Identificador único del inventario. */
    private int idinventario;

    /** Fecha de ingreso de los productos al inventario. */
    private String fecha;

    /** Fecha de salida de los productos del inventario. */
    private String fechasalida;

    /** Tipo de productos almacenados en el inventario. */
    private String tipoproductos;

    /** Organización o criterio de ordenamiento de los productos. */
    private String organizacionprodu;

    /** Registro de misión asociado a este inventario. */
    private Registro registro;

    /**
     * Construye un nuevo {@code Inventario} con todos sus atributos.
     * Incrementa automáticamente el contador estático {@code contraseniaingreso}.
     *
     * @param idinventario      identificador único del inventario
     * @param fecha             fecha de ingreso de los productos
     * @param fechasalida       fecha de salida de los productos
     * @param tipoproductos     tipo de productos almacenados
     * @param organizacionprodu criterio de organización de los productos
     * @param registro          registro de misión asociado
     */
    public Inventario(int idinventario, String fecha, String fechasalida,
                      String tipoproductos, String organizacionprodu, Registro registro) {
        this.idinventario = idinventario;
        this.fecha = fecha;
        this.fechasalida = fechasalida;
        this.tipoproductos = tipoproductos;
        this.organizacionprodu = organizacionprodu;
        this.registro = registro;
        contraseniaingreso++;
    }

    /**
     * Retorna el identificador del inventario.
     * @return identificador del inventario
     */
    public int getIdinventario() { return idinventario; }

    /**
     * Establece el identificador del inventario.
     * @param idinventario nuevo identificador
     */
    public void setIdinventario(int idinventario) { this.idinventario = idinventario; }

    /**
     * Retorna la fecha de ingreso de los productos.
     * @return fecha de ingreso
     */
    public String getFecha() { return fecha; }

    /**
     * Establece la fecha de ingreso de los productos.
     * @param fecha nueva fecha de ingreso
     */
    public void setFecha(String fecha) { this.fecha = fecha; }

    /**
     * Retorna la fecha de salida de los productos.
     * @return fecha de salida
     */
    public String getFechasalida() { return fechasalida; }

    /**
     * Establece la fecha de salida de los productos.
     * @param fechasalida nueva fecha de salida
     */
    public void setFechasalida(String fechasalida) { this.fechasalida = fechasalida; }

    /**
     * Retorna el tipo de productos del inventario.
     * @return tipo de productos
     */
    public String getTipoproductos() { return tipoproductos; }

    /**
     * Establece el tipo de productos.
     * @param tipoproductos nuevo tipo de productos
     */
    public void setTipoproductos(String tipoproductos) { this.tipoproductos = tipoproductos; }

    /**
     * Retorna el criterio de organización de los productos.
     * @return organización de productos
     */
    public String getOrganizacionprodu() { return organizacionprodu; }

    /**
     * Establece el criterio de organización de los productos.
     * @param organizacionprodu nuevo criterio de organización
     */
    public void setOrganizacionprodu(String organizacionprodu) { this.organizacionprodu = organizacionprodu; }

    /**
     * Retorna el registro de misión asociado.
     * @return registro de misión
     */
    public Registro getRegistro() { return registro; }

    /**
     * Establece el registro de misión asociado.
     * @param registro nuevo registro de misión
     */
    public void setRegistro(Registro registro) { this.registro = registro; }

    /**
     * Calcula el tiempo estimado que llevan los productos en el inventario.
     *
     * @return número de días estimados en inventario
     */
    public int calculartiempoeninventario() {
        return 15;
    }

    /**
     * Retorna una representación en texto del inventario.
     * @return cadena con los valores de todos los atributos
     */
    @Override
    public String toString() {
        return "Inventario{" +
                "idinventario=" + idinventario +
                ", fecha='" + fecha + '\'' +
                ", fechasalida='" + fechasalida + '\'' +
                ", tipoproductos='" + tipoproductos + '\'' +
                ", organizacionprodu='" + organizacionprodu + '\'' +
                ", contraseniaingreso(estatico)=" + contraseniaingreso +
                '}';
    }
}