package co.edu.poli.contexto2.model;
 
/**
 * Representa un alimento de tipo deshidratado.
 *
 * <p>Hereda de {@link Alimento} y agrega el atributo de cantidad máxima de días
 * de conservación. El valor nutricional se calcula en función de dicho atributo.</p>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public class Deshidratado extends Alimento {
 
    /** Cantidad máxima de días que el alimento puede conservarse. */
    private int cantidadtamaximaadias;
 
    /**
     * Construye un nuevo {@code Deshidratado} con todos sus atributos.
     *
     * @param estado                estado del alimento
     * @param sabor                 sabor del alimento
     * @param fechadevencimiento    fecha de vencimiento
     * @param codigodebarras        código de barras único
     * @param fechafabricacion      fecha de fabricación
     * @param lugardefabricacion    lugar de fabricación
     * @param fechacaducidad        fecha de caducidad
     * @param registro              registro de misión asociado
     * @param cantidadtamaximaadias cantidad máxima de días de conservación
     */
    public Deshidratado(String estado, String sabor, String fechadevencimiento, String codigodebarras,
                        String fechafabricacion, String lugardefabricacion, String fechacaducidad,
                        Registro registro, int cantidadtamaximaadias) {
        super(estado, sabor, fechadevencimiento, codigodebarras, fechafabricacion,
              lugardefabricacion, fechacaducidad, registro);
        this.cantidadtamaximaadias = cantidadtamaximaadias;
    }
 
    /**
     * Retorna la cantidad máxima de días de conservación.
     * @return cantidad máxima de días
     */
    public int getCantidadtamaximaadias() { return cantidadtamaximaadias; }
 
    /**
     * Establece la cantidad máxima de días de conservación.
     * @param cantidadtamaximaadias nueva cantidad máxima de días
     */
    public void setCantidadtamaximaadias(int cantidadtamaximaadias) {
        this.cantidadtamaximaadias = cantidadtamaximaadias;
    }
 
    /**
     * Verifica si el alimento deshidratado ha caducado.
     *
     * <p>Compara la fecha actual con la fecha de caducidad del alimento.</p>
     *
     * @param fechaActual fecha actual en formato comparable (ej. "2024-12-31")
     * @return {@code true} si el alimento ha caducado, {@code false} en caso contrario
     */
    @Override
    public boolean verificarCaducidad(String fechaActual) {
        System.out.println("    [SOBREESCRITURA - Deshidratado] Verificando caducidad del alimento deshidratado");
        return fechaActual.compareTo(this.getFechacaducidad()) > 0;
    }
 
    /**
     * Calcula el valor nutricional del alimento deshidratado.
     *
     * <p>El valor se obtiene multiplicando la cantidad máxima de días
     * de conservación por el factor 2.5.</p>
     *
     * @return valor nutricional calculado
     */
    @Override
    public double calcularValorNutricional() {
        return cantidadtamaximaadias * 2.5;
    }
 
    /**
     * Retorna una representación en texto del alimento deshidratado.
     * @return cadena con los atributos del alimento
     */
    @Override
    public String toString() {
        return "Deshidratado{" +
                "cantidadtamaximaadias=" + cantidadtamaximaadias +
                ", estado='" + getEstado() + '\'' +
                ", sabor='" + getSabor() + '\'' +
                ", codigodebarras='" + getCodigodebarras() + '\'' +
                ", fechacaducidad='" + getFechacaducidad() + '\'' +
                '}';
    }
}