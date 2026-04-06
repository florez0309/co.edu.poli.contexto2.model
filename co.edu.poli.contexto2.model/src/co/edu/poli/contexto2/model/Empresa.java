package co.edu.poli.contexto2.model;
 
/**
 * Representa una empresa del sector espacial asociada a las operaciones de la nave.
 *
 * <p>Cada empresa tiene un capitán asignado y puede tener múltiples empleados.
 * Se puede determinar si la empresa es grande según su número de empleados.</p>
 *
 * @author florez0309
 * @since 2026
 * @version 1.0
 */
public class Empresa {
 
    /** Nombre de la empresa. */
    private String nombre;
 
    /** Nombre del propietario de la empresa. */
    private String propietario;
 
    /** Actividad principal o labor de la empresa. */
    private String labor;
 
    /** Número de empleados de la empresa. */
    private int empleados;
 
    /** Ruta o nombre del logo de la empresa. */
    private String logo;
 
    /** Identificador único de la empresa. */
    private String id;
 
    /** Lugar de ubicación o sede de la empresa. */
    private String lugarubicacion;
 
    /** Capitán asignado a esta empresa. */
    private Capitan capitan;
 
    /**
     * Construye una nueva {@code Empresa} con todos sus atributos.
     *
     * @param nombre         nombre de la empresa
     * @param propietario    nombre del propietario
     * @param labor          actividad principal de la empresa
     * @param empleados      número de empleados
     * @param logo           ruta o nombre del logo
     * @param id             identificador único
     * @param lugarubicacion lugar de ubicación de la empresa
     * @param capitan        capitán asignado
     */
    public Empresa(String nombre, String propietario, String labor, int empleados,
                   String logo, String id, String lugarubicacion, Capitan capitan) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.labor = labor;
        this.empleados = empleados;
        this.logo = logo;
        this.id = id;
        this.lugarubicacion = lugarubicacion;
        this.capitan = capitan;
    }
 
    /**
     * Retorna el nombre de la empresa.
     * @return nombre de la empresa
     */
    public String getNombre() { return nombre; }
 
    /**
     * Establece el nombre de la empresa.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
 
    /**
     * Retorna el nombre del propietario.
     * @return nombre del propietario
     */
    public String getPropietario() { return propietario; }
 
    /**
     * Establece el nombre del propietario.
     * @param propietario nuevo propietario
     */
    public void setPropietario(String propietario) { this.propietario = propietario; }
 
    /**
     * Retorna la actividad principal de la empresa.
     * @return labor de la empresa
     */
    public String getLabor() { return labor; }
 
    /**
     * Establece la actividad principal de la empresa.
     * @param labor nueva labor
     */
    public void setLabor(String labor) { this.labor = labor; }
 
    /**
     * Retorna el número de empleados.
     * @return número de empleados
     */
    public int getEmpleados() { return empleados; }
 
    /**
     * Establece el número de empleados.
     * @param empleados nuevo número de empleados
     */
    public void setEmpleados(int empleados) { this.empleados = empleados; }
 
    /**
     * Retorna el logo de la empresa.
     * @return ruta o nombre del logo
     */
    public String getLogo() { return logo; }
 
    /**
     * Establece el logo de la empresa.
     * @param logo nueva ruta o nombre del logo
     */
    public void setLogo(String logo) { this.logo = logo; }
 
    /**
     * Retorna el identificador de la empresa.
     * @return identificador único
     */
    public String getId() { return id; }
 
    /**
     * Establece el identificador de la empresa.
     * @param id nuevo identificador
     */
    public void setId(String id) { this.id = id; }
 
    /**
     * Retorna el lugar de ubicación de la empresa.
     * @return lugar de ubicación
     */
    public String getLugarubicacion() { return lugarubicacion; }
 
    /**
     * Establece el lugar de ubicación de la empresa.
     * @param lugarubicacion nuevo lugar de ubicación
     */
    public void setLugarubicacion(String lugarubicacion) { this.lugarubicacion = lugarubicacion; }
 
    /**
     * Retorna el capitán asignado a la empresa.
     * @return capitán asignado
     */
    public Capitan getCapitan() { return capitan; }
 
    /**
     * Establece el capitán asignado a la empresa.
     * @param capitan nuevo capitán
     */
    public void setCapitan(Capitan capitan) { this.capitan = capitan; }
 
    /**
     * Determina si la empresa es considerada grande según su número de empleados.
     *
     * <p>Una empresa es grande si tiene más de 100 empleados.</p>
     *
     * @return {@code true} si tiene más de 100 empleados, {@code false} en caso contrario
     */
    public boolean esempresagrande() {
        return this.empleados > 100;
    }
 
    /**
     * Retorna una representación en texto de la empresa.
     * @return cadena con los valores de todos los atributos
     */
    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", propietario='" + propietario + '\'' +
                ", labor='" + labor + '\'' +
                ", empleados=" + empleados +
                ", logo='" + logo + '\'' +
                ", id='" + id + '\'' +
                ", lugarubicacion='" + lugarubicacion + '\'' +
                ", capitan=" + capitan +
                '}';
    }
}
 