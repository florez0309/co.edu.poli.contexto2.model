package co.edu.poli.contexto2.model;

public class Capitan {
    private String id;
    private String nombre;
    private double peso;
    private double altura;
    private String registroentrada;
    private String registrosalida;
    private String fechanacimiento;
    
    public Capitan(String id, String nombre, double peso, double altura, String registroentrada, String registrosalida, String fechanacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.registroentrada = registroentrada;
        this.registrosalida = registrosalida;
        this.fechanacimiento = fechanacimiento;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public String getRegistroentrada() {
        return registroentrada;
    }
    
    public void setRegistroentrada(String registroentrada) {
        this.registroentrada = registroentrada;
    }
    
    public String getRegistrosalida() {
        return registrosalida;
    }
    
    public void setRegistrosalida(String registrosalida) {
        this.registrosalida = registrosalida;
    }
    
    public String getFechanacimiento() {
        return fechanacimiento;
    }
    
    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
    public boolean esmayoresedad(String fechaActual) {
        return true;
    }
    
    public int tiempoenservicio() {
        return 5;
    }
    
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