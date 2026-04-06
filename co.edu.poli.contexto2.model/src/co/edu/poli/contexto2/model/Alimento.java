package co.edu.poli.contexto2.model;
 
/**
 * Clase abstracta que representa un alimento espacial.
 *
 * <p>Es la superclase raíz de toda la jerarquía de alimentos del sistema.
 * Define los atributos comunes a todos los tipos de alimento y declara
 * los métodos abstractos que cada subclase debe implementar según
 * su tipo de conservación.</p>
 *
 * <p>Contiene una constante final {@code CATEGORIA} y un método final
 * {@code obtenerCategoria()} que no puede ser sobreescrito.</p>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public abstract class Alimento {
 
    /** Estado actual del alimento (ej. fresco, deteriorado). */
    private String estado;
 
    /** Sabor del alimento. */
    private String sabor;
 
    /** Fecha de vencimiento del alimento. */
    private String fechadevencimiento;
 
    /** Código de barras único que identifica el alimento. */
    private String codigodebarras;
 
    /** Fecha de fabricación del alimento. */
    private String fechafabricacion;
 
    /** Lugar donde fue fabricado el alimento. */
    private String lugardefabricacion;
 
    /** Fecha de caducidad del alimento. */
    private String fechacaducidad;
 
    /** Registro de misión al que pertenece este alimento. */
    private Registro registro;
 
    /**
     * Constante que identifica la categoría general de todos los alimentos del sistema.
     * No puede ser modificada una vez inicializada.
     */
    public final String CATEGORIA = "Alimento Espacial";
 
    /**
     * Construye un nuevo {@code Alimento} con todos sus atributos base.
     *
     * @param estado             estado actual del alimento
     * @param sabor              sabor del alimento
     * @param fechadevencimiento fecha de vencimiento
     * @param codigodebarras     código de barras único
     * @param fechafabricacion   fecha de fabricación
     * @param lugardefabricacion lugar de fabricación
     * @param fechacaducidad     fecha de caducidad
     * @param registro           registro de misión asociado
     */
    public Alimento(String estado, String sabor, String fechadevencimiento, String codigodebarras,
                    String fechafabricacion, String lugardefabricacion,
                    String fechacaducidad, Registro registro) {
        this.estado = estado;
        this.sabor = sabor;
        this.fechadevencimiento = fechadevencimiento;
        this.codigodebarras = codigodebarras;
        this.fechafabricacion = fechafabricacion;
        this.lugardefabricacion = lugardefabricacion;
        this.fechacaducidad = fechacaducidad;
        this.registro = registro;
    }
 
    /**
     * Retorna el estado del alimento.
     * @return estado actual
     */
    public String getEstado() { return estado; }
 
    /**
     * Establece el estado del alimento.
     * @param estado nuevo estado
     */
    public void setEstado(String estado) { this.estado = estado; }
 
    /**
     * Retorna el sabor del alimento.
     * @return sabor
     */
    public String getSabor() { return sabor; }
 
    /**
     * Establece el sabor del alimento.
     * @param sabor nuevo sabor
     */
    public void setSabor(String sabor) { this.sabor = sabor; }
 
    /**
     * Retorna la fecha de vencimiento.
     * @return fecha de vencimiento
     */
    public String getFechadevencimiento() { return fechadevencimiento; }
 
    /**
     * Establece la fecha de vencimiento.
     * @param fechadevencimiento nueva fecha de vencimiento
     */
    public void setFechadevencimiento(String fechadevencimiento) { this.fechadevencimiento = fechadevencimiento; }
 
    /**
     * Retorna el código de barras del alimento.
     * @return código de barras
     */
    public String getCodigodebarras() { return codigodebarras; }
 
    /**
     * Establece el código de barras del alimento.
     * @param codigodebarras nuevo código de barras
     */
    public void setCodigodebarras(String codigodebarras) { this.codigodebarras = codigodebarras; }
 
    /**
     * Retorna la fecha de fabricación.
     * @return fecha de fabricación
     */
    public String getFechafabricacion() { return fechafabricacion; }
 
    /**
     * Establece la fecha de fabricación.
     * @param fechafabricacion nueva fecha de fabricación
     */
    public void setFechafabricacion(String fechafabricacion) { this.fechafabricacion = fechafabricacion; }
 
    /**
     * Retorna el lugar de fabricación del alimento.
     * @return lugar de fabricación
     */
    public String getLugardefabricacion() { return lugardefabricacion; }
 
    /**
     * Establece el lugar de fabricación del alimento.
     * @param lugardefabricacion nuevo lugar de fabricación
     */
    public void setLugardefabricacion(String lugardefabricacion) { this.lugardefabricacion = lugardefabricacion; }
 
    /**
     * Retorna la fecha de caducidad del alimento.
     * @return fecha de caducidad
     */
    public String getFechacaducidad() { return fechacaducidad; }
 
    /**
     * Establece la fecha de caducidad del alimento.
     * @param fechacaducidad nueva fecha de caducidad
     */
    public void setFechacaducidad(String fechacaducidad) { this.fechacaducidad = fechacaducidad; }
 
    /**
     * Retorna el registro de misión asociado al alimento.
     * @return registro de misión
     */
    public Registro getRegistro() { return registro; }
 
    /**
     * Establece el registro de misión asociado al alimento.
     * @param registro nuevo registro
     */
    public void setRegistro(Registro registro) { this.registro = registro; }
 
    /**
     * Verifica si el alimento ha caducado según la fecha actual proporcionada.
     *
     * <p>Cada subclase implementa este método según su propio criterio de caducidad.</p>
     *
     * @param fechaActual fecha actual para comparar con la fecha de caducidad
     * @return {@code true} si el alimento ha caducado, {@code false} en caso contrario
     */
    public abstract boolean verificarCaducidad(String fechaActual);
 
    /**
     * Calcula el valor nutricional del alimento.
     *
     * <p>Cada subclase define su propio cálculo según el tipo de conservación.</p>
     *
     * @return valor nutricional como número decimal
     */
    public abstract double calcularValorNutricional();
 
    /**
     * Calcula las instrucciones de conservación del alimento para una fecha dada.
     *
     * @param fechaActual fecha actual para calcular la conservación
     * @return cadena con las instrucciones de conservación
     */
    public String calcularconservacion(String fechaActual) {
        return "Conservación calculada para fecha: " + fechaActual;
    }
 
    /**
     * Calcula las instrucciones de conservación según el tipo de almacenamiento.
     *
     * <p>Sobrecarga del método {@link #calcularconservacion(String)} que añade
     * el tipo de almacenamiento al cálculo.</p>
     *
     * @param fechaActual        fecha actual
     * @param tipoAlmacenamiento tipo de almacenamiento utilizado
     * @return cadena con las instrucciones de conservación
     */
    public String calcularconservacion(String fechaActual, String tipoAlmacenamiento) {
        return "Conservación en " + tipoAlmacenamiento + " para fecha: " + fechaActual;
    }
 
    /**
     * Retorna la categoría general del alimento.
     *
     * <p>Este método es final y no puede ser sobreescrito por las subclases.</p>
     *
     * @return cadena con la categoría del alimento
     */
    public final String obtenerCategoria() {
        return "Categoría: " + CATEGORIA;
    }
 
    /**
     * Retorna una representación en texto del alimento.
     * @return cadena con los atributos principales del alimento
     */
    @Override
    public String toString() {
        return "Alimento{" +
                "estado='" + estado + '\'' +
                ", sabor='" + sabor + '\'' +
                ", codigodebarras='" + codigodebarras + '\'' +
                ", fechacaducidad='" + fechacaducidad + '\'' +
                '}';
    }
}