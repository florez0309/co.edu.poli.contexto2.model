package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Deshidratado;
import co.edu.poli.contexto2.model.Registro;

/**
 * Representa un alimento deshidratado espacial con características especiales.
 *
 * <p>Es una subclase abstracta de {@link Deshidratado} ubicada en el paquete
 * de servicios. Agrega el atributo de nivel de hidratación y ajusta el
 * cálculo del valor nutricional según dicho nivel.</p>
 *
 * <p>Tiene visibilidad de paquete (sin modificador {@code public}),
 * por lo que solo es accesible dentro del paquete {@code servicios}.</p>
 *
 * @author florez0309
 * @version 1.0
 */
abstract class Deshidratadoespecial extends Deshidratado {

    /** Nivel de hidratación del alimento (valores posibles: "alto", "medio", "bajo"). */
    private String nivelhidratacion;

    /**
     * Construye un nuevo {@code Deshidratadoespecial} con todos sus atributos.
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
     * @param nivelhidratacion      nivel de hidratación ("alto", "medio" o "bajo")
     */
    public Deshidratadoespecial(String estado, String sabor, String fechadevencimiento,
                                String codigodebarras, String fechafabricacion,
                                String lugardefabricacion, String fechacaducidad,
                                Registro registro, int cantidadtamaximaadias,
                                String nivelhidratacion) {
        super(estado, sabor, fechadevencimiento, codigodebarras, fechafabricacion,
              lugardefabricacion, fechacaducidad, registro, cantidadtamaximaadias);
        this.nivelhidratacion = nivelhidratacion;
    }

    /**
     * Retorna el nivel de hidratación del alimento.
     * @return nivel de hidratación
     */
    public String getNivelhidratacion() { return nivelhidratacion; }

    /**
     * Establece el nivel de hidratación del alimento.
     * @param nivelhidratacion nuevo nivel de hidratación
     */
    public void setNivelhidratacion(String nivelhidratacion) {
        this.nivelhidratacion = nivelhidratacion;
    }

    /**
     * Muestra en consola la porción de conservación para un dato dado.
     *
     * @param dato dato utilizado para calcular la porción de conservación
     */
    public void obtenerporcionconservacion(String dato) {
        System.out.println("  Obteniendo porción de conservación con dato: " + dato);
    }

    /**
     * Verifica si el alimento deshidratado especial ha caducado.
     *
     * <p>Los alimentos especiales se consideran siempre vigentes
     * debido a su proceso de conservación avanzado.</p>
     *
     * @param fechaActual fecha actual para la verificación
     * @return {@code false} siempre, ya que estos alimentos duran más
     */
    @Override
    public boolean verificarCaducidad(String fechaActual) {
        System.out.println("    [SOBREESCRITURA - Deshidratadoespecial] Verificando caducidad especial");
        return false;
    }

    /**
     * Calcula el valor nutricional del alimento deshidratado especial.
     *
     * <p>El valor base se obtiene de los días máximos de conservación multiplicados
     * por 2.5, y se ajusta con un factor según el nivel de hidratación:
     * "alto" aplica 1.5x, "medio" aplica 1.2x, y cualquier otro nivel aplica 1.0x.</p>
     *
     * @return valor nutricional ajustado según el nivel de hidratación
     */
    @Override
    public double calcularValorNutricional() {
        double base = getCantidadtamaximaadias() * 2.5;
        double factor = nivelhidratacion.equalsIgnoreCase("alto") ? 1.5 :
                        nivelhidratacion.equalsIgnoreCase("medio") ? 1.2 : 1.0;
        return base * factor;
    }

    /**
     * Retorna una representación en texto del alimento deshidratado especial.
     * @return cadena con los atributos principales
     */
    @Override
    public String toString() {
        return "Deshidratadoespecial{" +
                "cantidadtamaximaadias=" + getCantidadtamaximaadias() +
                ", nivelhidratacion='" + nivelhidratacion + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", codigodebarras='" + getCodigodebarras() + '\'' +
                '}';
    }
}