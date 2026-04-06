package co.edu.poli.contexto2.model;

/**
 * Representa un alimento de tipo enlatado.
 *
 * <p>Hereda de {@link Alimento} y agrega el material del que está hecho el envase.
 * Esta clase es {@code final} y no puede ser extendida.</p>
 *
 * <p>El valor nutricional varía según el material de la lata:
 * los envases de acero ofrecen mayor valor nutricional que otros materiales.</p>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public final class Enlatado extends Alimento {

    /** Material del que está fabricada la lata (ej. "Acero", "Aluminio"). */
    private String materialdelas;

    /**
     * Construye un nuevo {@code Enlatado} con todos sus atributos.
     *
     * @param estado             estado del alimento
     * @param sabor              sabor del alimento
     * @param fechadevencimiento fecha de vencimiento
     * @param codigodebarras     código de barras único
     * @param fechafabricacion   fecha de fabricación
     * @param lugardefabricacion lugar de fabricación
     * @param fechacaducidad     fecha de caducidad
     * @param registro           registro de misión asociado
     * @param materialdelas      material de fabricación de la lata
     */
    public Enlatado(String estado, String sabor, String fechadevencimiento, String codigodebarras,
                    String fechafabricacion, String lugardefabricacion, String fechacaducidad,
                    Registro registro, String materialdelas) {
        super(estado, sabor, fechadevencimiento, codigodebarras, fechafabricacion,
              lugardefabricacion, fechacaducidad, registro);
        this.materialdelas = materialdelas;
    }

    /**
     * Retorna el material de fabricación de la lata.
     * @return material de la lata
     */
    public String getMaterialdelas() { return materialdelas; }

    /**
     * Establece el material de fabricación de la lata.
     * @param materialdelas nuevo material
     */
    public void setMaterialdelas(String materialdelas) { this.materialdelas = materialdelas; }

    /**
     * Verifica si el alimento enlatado ha caducado.
     *
     * <p>Compara lexicográficamente la fecha actual con la fecha de caducidad.</p>
     *
     * @param fechaActual fecha actual en formato comparable (ej. "2024-12-31")
     * @return {@code true} si el alimento ha caducado, {@code false} en caso contrario
     */
    @Override
    public boolean verificarCaducidad(String fechaActual) {
        System.out.println("    [SOBREESCRITURA - Enlatado] Verificando caducidad del alimento enlatado");
        return fechaActual.compareTo(this.getFechacaducidad()) > 0;
    }

    /**
     * Calcula el valor nutricional del alimento enlatado.
     *
     * <p>Los envases de acero aportan 350 unidades nutricionales;
     * cualquier otro material aporta 280 unidades.</p>
     *
     * @return valor nutricional calculado según el material de la lata
     */
    @Override
    public double calcularValorNutricional() {
        return materialdelas.equalsIgnoreCase("Acero") ? 350.0 : 280.0;
    }

    /**
     * Retorna una representación en texto del alimento enlatado.
     * @return cadena con los atributos del alimento
     */
    @Override
    public String toString() {
        return "Enlatado{" +
                "materialdelas='" + materialdelas + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", sabor='" + getSabor() + '\'' +
                ", codigodebarras='" + getCodigodebarras() + '\'' +
                ", fechacaducidad='" + getFechacaducidad() + '\'' +
                '}';
    }
}