package co.edu.poli.contexto2.model;

/**
 * Representa una nave espacial utilizada en las misiones de recolección de alimentos.
 *
 * <p>Cada nave tiene un capitán asignado y un inventario de productos a bordo.
 * Permite calcular el consumo de combustible según la distancia recorrida.</p>
 *
 * @author florez0309
 * @version 1.0
 */
public class Nave {

    /** Fecha de fabricación de la nave. */
    private String fechafabricacion;

    /** Tipo o categoría de la nave. */
    private String tipo;

    /** Lugar donde fue fabricada la nave. */
    private String lugarfabricacion;

    /** Peso de la nave en toneladas. */
    private double peso;

    /** Nombre de la nave. */
    private String nombre;

    /** Identificador único de la nave. */
    private String id;

    /** Color de la nave. */
    private String color;

    /** Tamaño de la nave (unidad definida por el sistema). */
    private int tamanio;

    /** Capacidad máxima de combustible de la nave. */
    private int capacidadcombustible;

    /** Consumo de combustible de la nave. */
    private int consumocombustible;

    /** Capitán asignado a la nave. */
    private Capitan capitan;

    /** Inventario de productos a bordo de la nave. */
    private Inventario inventario;

    /**
     * Construye una nueva {@code Nave} con todos sus atributos.
     *
     * @param fechafabricacion    fecha de fabricación
     * @param tipo                tipo o categoría
     * @param lugarfabricacion    lugar de fabricación
     * @param peso                peso en toneladas
     * @param nombre              nombre de la nave
     * @param id                  identificador único
     * @param color               color de la nave
     * @param tamanio             tamaño de la nave
     * @param capacidadcombustible capacidad máxima de combustible
     * @param consumocombustible  consumo de combustible
     * @param capitan             capitán asignado
     * @param inventario          inventario de productos a bordo
     */
    public Nave(String fechafabricacion, String tipo, String lugarfabricacion, double peso,
                String nombre, String id, String color, int tamanio,
                int capacidadcombustible, int consumocombustible,
                Capitan capitan, Inventario inventario) {
        this.fechafabricacion = fechafabricacion;
        this.tipo = tipo;
        this.lugarfabricacion = lugarfabricacion;
        this.peso = peso;
        this.nombre = nombre;
        this.id = id;
        this.color = color;
        this.tamanio = tamanio;
        this.capacidadcombustible = capacidadcombustible;
        this.consumocombustible = consumocombustible;
        this.capitan = capitan;
        this.inventario = inventario;
    }

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
     * Retorna el tipo de la nave.
     * @return tipo de nave
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo de la nave.
     * @param tipo nuevo tipo
     */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Retorna el lugar de fabricación.
     * @return lugar de fabricación
     */
    public String getLugarfabricacion() { return lugarfabricacion; }

    /**
     * Establece el lugar de fabricación.
     * @param lugarfabricacion nuevo lugar de fabricación
     */
    public void setLugarfabricacion(String lugarfabricacion) { this.lugarfabricacion = lugarfabricacion; }

    /**
     * Retorna el peso de la nave.
     * @return peso en toneladas
     */
    public double getPeso() { return peso; }

    /**
     * Establece el peso de la nave.
     * @param peso nuevo peso en toneladas
     */
    public void setPeso(double peso) { this.peso = peso; }

    /**
     * Retorna el nombre de la nave.
     * @return nombre de la nave
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre de la nave.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Retorna el identificador de la nave.
     * @return identificador único
     */
    public String getId() { return id; }

    /**
     * Establece el identificador de la nave.
     * @param id nuevo identificador
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna el color de la nave.
     * @return color
     */
    public String getColor() { return color; }

    /**
     * Establece el color de la nave.
     * @param color nuevo color
     */
    public void setColor(String color) { this.color = color; }

    /**
     * Retorna el tamaño de la nave.
     * @return tamaño
     */
    public int getTamanio() { return tamanio; }

    /**
     * Establece el tamaño de la nave.
     * @param tamanio nuevo tamaño
     */
    public void setTamanio(int tamanio) { this.tamanio = tamanio; }

    /**
     * Retorna la capacidad máxima de combustible.
     * @return capacidad de combustible
     */
    public int getCapacidadcombustible() { return capacidadcombustible; }

    /**
     * Establece la capacidad máxima de combustible.
     * @param capacidadcombustible nueva capacidad
     */
    public void setCapacidadcombustible(int capacidadcombustible) { this.capacidadcombustible = capacidadcombustible; }

    /**
     * Retorna el consumo de combustible de la nave.
     * @return consumo de combustible
     */
    public int getConsumocombustible() { return consumocombustible; }

    /**
     * Establece el consumo de combustible.
     * @param consumocombustible nuevo consumo
     */
    public void setConsumocombustible(int consumocombustible) { this.consumocombustible = consumocombustible; }

    /**
     * Retorna el capitán asignado a la nave.
     * @return capitán
     */
    public Capitan getCapitan() { return capitan; }

    /**
     * Establece el capitán asignado a la nave.
     * @param capitan nuevo capitán
     */
    public void setCapitan(Capitan capitan) { this.capitan = capitan; }

    /**
     * Retorna el inventario de productos a bordo.
     * @return inventario
     */
    public Inventario getInventario() { return inventario; }

    /**
     * Establece el inventario de productos a bordo.
     * @param inventario nuevo inventario
     */
    public void setInventario(Inventario inventario) { this.inventario = inventario; }

    /**
     * Calcula el consumo de combustible por unidad de distancia.
     *
     * @param distanciaRecorrida distancia recorrida por la nave
     * @param combustibleUsado   cantidad de combustible consumido
     * @return consumo de combustible por unidad de distancia
     */
    public double calcularConsumo(double distanciaRecorrida, double combustibleUsado) {
        return combustibleUsado / distanciaRecorrida;
    }

    /**
     * Retorna una representación en texto de la nave.
     * @return cadena con los valores de todos los atributos
     */
    @Override
    public String toString() {
        return "Nave{" +
                "fechafabricacion='" + fechafabricacion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", lugarfabricacion='" + lugarfabricacion + '\'' +
                ", peso=" + peso +
                ", nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", tamanio=" + tamanio +
                ", capacidadcombustible=" + capacidadcombustible +
                ", consumocombustible=" + consumocombustible +
                ", capitan=" + capitan +
                ", inventario=" + inventario +
                '}';
    }
}