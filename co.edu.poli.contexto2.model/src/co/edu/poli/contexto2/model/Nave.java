package co.edu.poli.contexto2.model;

public class Nave {
    private String fechafabricacion;
    private String tipo;
    private String lugarfabricacion;
    private double peso;
    private String nombre;
    private String id;
    private String color;
    private int tamanio;
    private int capacidadcombustible;
    private int consumocombustible;
    private Capitan capitan;
    private Inventario inventario;
    
    public Nave(String fechafabricacion, String tipo, String lugarfabricacion, double peso, String nombre, String id, String color, int tamanio, int capacidadcombustible, int consumocombustible, Capitan capitan, Inventario inventario) {
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
    
    public String getFechafabricacion() {
        return fechafabricacion;
    }
    
    public void setFechafabricacion(String fechafabricacion) {
        this.fechafabricacion = fechafabricacion;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getLugarfabricacion() {
        return lugarfabricacion;
    }
    
    public void setLugarfabricacion(String lugarfabricacion) {
        this.lugarfabricacion = lugarfabricacion;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public int getTamanio() {
        return tamanio;
    }
    
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    public int getCapacidadcombustible() {
        return capacidadcombustible;
    }
    
    public void setCapacidadcombustible(int capacidadcombustible) {
        this.capacidadcombustible = capacidadcombustible;
    }
    
    public int getConsumocombustible() {
        return consumocombustible;
    }
    
    public void setConsumocombustible(int consumocombustible) {
        this.consumocombustible = consumocombustible;
    }
    
    public Capitan getCapitan() {
        return capitan;
    }
    
    public void setCapitan(Capitan capitan) {
        this.capitan = capitan;
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    public double calcularConsumo(double distanciaRecorrida, double combustibleUsado) {
        return combustibleUsado / distanciaRecorrida;
    }
    
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