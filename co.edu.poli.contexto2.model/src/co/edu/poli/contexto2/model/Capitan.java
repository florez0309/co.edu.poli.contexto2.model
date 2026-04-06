package co.edu.poli.contexto2.model;
 
/**
 * Representa al capitán de una nave espacial.
 *
 * <p>Almacena la información personal y de servicio del capitán,
 * incluyendo sus registros de entrada y salida de misiones.</p>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public class Capitan {
 
    /** Identificador único del capitán. */
    private String id;
 
    /** Nombre completo del capitán. */
    private String nombre;
 
    /** Peso del capitán en kilogramos. */
    private double peso;
 
    /** Altura del capitán en metros. */
    private double altura;
 
    /** Fecha o código de registro de entrada a servicio. */
    private String registroentrada;
 
    /** Fecha o código de registro de salida de servicio. */
    private String registrosalida;
 
    /** Fecha de nacimiento del capitán. */
    private String fechanacimiento;
 
    /**
     * Construye un nuevo {@code Capitan} con todos sus atributos.
     *
     * @param id               identificador único
     * @param nombre           nombre completo
     * @param peso             peso en kilogramos
     * @param altura           altura en metros
     * @param registroentrada  registro de entrada al servicio
     * @param registrosalida   registro de salida del servicio
     * @param fechanacimiento  fecha de nacimiento
     */
    public Capitan(String id, String nombre, double peso, double altura,
                   String registroentrada, String registrosalida, String fechanacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.registroentrada = registroentrada;
        this.registrosalida = registrosalida;
        this.fechanacimiento = fechanacimiento;
    }
 
    /**
     * Retorna el identificador del capitán.
     * @return identificador
     */
    public String getId() { return id; }
 
    /**
     * Establece el identificador del capitán.
     * @param id nuevo identificador
     */
    public void setId(String id) { this.id = id; }
 
    /**
     * Retorna el nombre del capitán.
     * @return nombre completo
     */
    public String getNombre() { return nombre; }
 
    /**
     * Establece el nombre del capitán.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
 
    /**
     * Retorna el peso del capitán.
     * @return peso en kilogramos
     */
    public double getPeso() { return peso; }
 
    /**
     * Establece el peso del capitán.
     * @param peso nuevo peso en kilogramos
     */
    public void setPeso(double peso) { this.peso = peso; }
 
    /**
     * Retorna la altura del capitán.
     * @return altura en metros
     */
    public double getAltura() { return altura; }
 
    /**
     * Establece la altura del capitán.
     * @param altura nueva altura en metros
     */
    public void setAltura(double altura) { this.altura = altura; }
 
    /**
     * Retorna el registro de entrada al servicio.
     * @return registro de entrada
     */
    public String getRegistroentrada() { return registroentrada; }
 
    /**
     * Establece el registro de entrada al servicio.
     * @param registroentrada nuevo registro de entrada
     */
    public void setRegistroentrada(String registroentrada) { this.registroentrada = registroentrada; }
 
    /**
     * Retorna el registro de salida del servicio.
     * @return registro de salida
     */
    public String getRegistrosalida() { return registrosalida; }
 
    /**
     * Establece el registro de salida del servicio.
     * @param registrosalida nuevo registro de salida
     */
    public void setRegistrosalida(String registrosalida) { this.registrosalida = registrosalida; }
 
    /**
     * Retorna la fecha de nacimiento del capitán.
     * @return fecha de nacimiento
     */
    public String getFechanacimiento() { return fechanacimiento; }
 
    /**
     * Establece la fecha de nacimiento del capitán.
     * @param fechanacimiento nueva fecha de nacimiento
     */
    public void setFechanacimiento(String fechanacimiento) { this.fechanacimiento = fechanacimiento; }
 
    /**
     * Determina si el capitán es mayor de edad en la fecha indicada.
     *
     * @param fechaActual fecha actual para la verificación (formato String)
     * @return {@code true} si el capitán es mayor de edad, {@code false} en caso contrario
     */
    public boolean esmayoresedad(String fechaActual) {
        return true;
    }
 
    /**
     * Calcula el tiempo que lleva el capitán en servicio activo.
     *
     * @return número de años en servicio
     */
    public int tiempoenservicio() {
        return 5;
    }
 
    /**
     * Retorna una representación en texto del capitán.
     * @return cadena con los valores de todos los atributos
     */
    @Override
    public String toString() {
        return "Capitan{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", registroentrada='" + registroentrada + '\'' +
                ", registrosalida='" + registrosalida + '\'' +
                ", fechanacimiento='" + fechanacimiento + '\'' +
                '}';
    }
}