package co.edu.poli.contexto2.model;

public class Empresa {
    private String nombre;
    private String propietario;
    private String labor;
    private int empleados;
    private String logo;
    private String id;
    private String lugarubicacion;
    private Capitan capitan;
    
    public Empresa(String nombre, String propietario, String labor, int empleados, String logo, String id, String lugarubicacion, Capitan capitan) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.labor = labor;
        this.empleados = empleados;
        this.logo = logo;
        this.id = id;
        this.lugarubicacion = lugarubicacion;
        this.capitan = capitan;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPropietario() {
        return propietario;
    }
    
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    public String getLabor() {
        return labor;
    }
    
    public void setLabor(String labor) {
        this.labor = labor;
    }
    
    public int getEmpleados() {
        return empleados;
    }
    
    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }
    
    public String getLogo() {
        return logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getLugarubicacion() {
        return lugarubicacion;
    }
    
    public void setLugarubicacion(String lugarubicacion) {
        this.lugarubicacion = lugarubicacion;
    }
    
    public Capitan getCapitan() {
        return capitan;
    }
    
    public void setCapitan(Capitan capitan) {
        this.capitan = capitan;
    }
    
    public boolean esempresagrande() {
        return this.empleados > 100;
    }
    
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