package co.edu.poli.contexto2.model;

/**
 * Representa el registro de una misión espacial en la que se recolectaron productos.
 *
 * <p>Esta clase almacena la información básica de cada misión: identificador,
 * fecha, lugar, tipo de productos extraídos y nave involucrada.</p>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public class Registro {

    /** Identificador único del registro. */
    private int idregistro;

    /** Fecha del registro expresada como entero (ej. 20240101). */
    private int fecha;

    /** Lugar donde se realizó la extracción. */
    private String lugar;

    /** Nombre o descripción de la misión. */
    private String mision;

    /** Tipo de productos recolectados en la misión. */
    private String tipodeproductos;

    /** Nave asignada a la siguiente misión. */
    private String navealsiguiera;

    /** Lugar de extracción de los productos. */
    private String lugardesextraccion;

    /**
     * Construye un nuevo {@code Registro} con todos sus atributos.
     *
     * @param idregistro        identificador único del registro
     * @param fecha             fecha del registro (formato entero, ej. 20240101)
     * @param lugar             lugar donde ocurrió la misión
     * @param mision            nombre o descripción de la misión
     * @param tipodeproductos   tipo de productos recolectados
     * @param navealsiguiera    nave asignada para la siguiente misión
     * @param lugardesextraccion lugar físico de extracción de los productos
     */
    public Registro(int idregistro, int fecha, String lugar, String mision,
                    String tipodeproductos, String navealsiguiera, String lugardesextraccion) {
        this.idregistro = idregistro;
        this.fecha = fecha;
        this.lugar = lugar;
        this.mision = mision;
        this.tipodeproductos = tipodeproductos;
        this.navealsiguiera = navealsiguiera;
        this.lugardesextraccion = lugardesextraccion;
    }

    /**
     * Retorna el identificador del registro.
     * @return identificador del registro
     */
    public int getIdregistro() { return idregistro; }

    /**
     * Establece el identificador del registro.
     * @param idregistro nuevo identificador
     */
    public void setIdregistro(int idregistro) { this.idregistro = idregistro; }

    /**
     * Retorna la fecha del registro.
     * @return fecha como entero
     */
    public int getFecha() { return fecha; }

    /**
     * Establece la fecha del registro.
     * @param fecha nueva fecha como entero
     */
    public void setFecha(int fecha) { this.fecha = fecha; }

    /**
     * Retorna el lugar de la misión.
     * @return lugar de la misión
     */
    public String getLugar() { return lugar; }

    /**
     * Establece el lugar de la misión.
     * @param lugar nuevo lugar
     */
    public void setLugar(String lugar) { this.lugar = lugar; }

    /**
     * Retorna el nombre de la misión.
     * @return nombre de la misión
     */
    public String getMision() { return mision; }

    /**
     * Establece el nombre de la misión.
     * @param mision nuevo nombre de misión
     */
    public void setMision(String mision) { this.mision = mision; }

    /**
     * Retorna el tipo de productos recolectados.
     * @return tipo de productos
     */
    public String getTipodeproductos() { return tipodeproductos; }

    /**
     * Establece el tipo de productos recolectados.
     * @param tipodeproductos nuevo tipo de productos
     */
    public void setTipodeproductos(String tipodeproductos) { this.tipodeproductos = tipodeproductos; }

    /**
     * Retorna la nave asignada a la siguiente misión.
     * @return nombre de la nave
     */
    public String getNavealsiguiera() { return navealsiguiera; }

    /**
     * Establece la nave asignada a la siguiente misión.
     * @param navealsiguiera nombre de la nave
     */
    public void setNavealsiguiera(String navealsiguiera) { this.navealsiguiera = navealsiguiera; }

    /**
     * Retorna el lugar de extracción de los productos.
     * @return lugar de extracción
     */
    public String getLugardesextraccion() { return lugardesextraccion; }

    /**
     * Establece el lugar de extracción.
     * @param lugardesextraccion nuevo lugar de extracción
     */
    public void setLugardesextraccion(String lugardesextraccion) { this.lugardesextraccion = lugardesextraccion; }

    /**
     * Determina si los productos registrados son de tipo alimenticio.
     *
     * <p>Retorna {@code true} si el campo {@code tipodeproductos} contiene
     * la palabra "alimento" (sin distinción de mayúsculas/minúsculas).</p>
     *
     * @return {@code true} si es un producto alimenticio, {@code false} en caso contrario
     */
    public boolean esproductoalimenticio() {
        return this.tipodeproductos != null
                && this.tipodeproductos.toLowerCase().contains("alimento");
    }

    /**
     * Retorna una representación en texto del registro.
     * @return cadena con los valores de todos los atributos
     */
    @Override
    public String toString() {
        return "Registro{" +
                "idregistro=" + idregistro +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", mision='" + mision + '\'' +
                ", tipodeproductos='" + tipodeproductos + '\'' +
                ", navealsiguiera='" + navealsiguiera + '\'' +
                ", lugardesextraccion='" + lugardesextraccion + '\'' +
                '}';
    }
}