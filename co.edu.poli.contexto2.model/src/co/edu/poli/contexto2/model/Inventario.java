package co.edu.poli.contexto2.model;

public class Inventario {
    // ATRIBUTO ESTÁTICO - compartido por todos los objetos de esta clase
    public static int contraseniaingreso = 0;
    
    private int idinventario;
    private String fecha;
    private String fechasalida;
    private String tipoproductos;
    private String organizacionprodu;
    private Registro registro;
    
    public Inventario(int idinventario, String fecha, String fechasalida, String tipoproductos, String organizacionprodu, Registro registro) {
        this.idinventario = idinventario;
        this.fecha = fecha;
        this.fechasalida = fechasalida;
        this.tipoproductos = tipoproductos;
        this.organizacionprodu = organizacionprodu;
        this.registro = registro;
        contraseniaingreso++; // Incrementar el contador estático
    }
    
    public int getIdinventario() {
        return idinventario;
    }
    
    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getFechasalida() {
        return fechasalida;
    }
    
    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }
    
    public String getTipoproductos() {
        return tipoproductos;
    }
    
    public void setTipoproductos(String tipoproductos) {
        this.tipoproductos = tipoproductos;
    }
    
    public String getOrganizacionprodu() {
        return organizacionprodu;
    }
    
    public void setOrganizacionprodu(String organizacionprodu) {
        this.organizacionprodu = organizacionprodu;
    }
    
    public Registro getRegistro() {
        return registro;
    }
    
    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
    
    public int calculartiempoeninventario() {
        return 15;
    }
    
    @Override
    public String toString() {
        return "Inventario{" +
                "idinventario=" + idinventario +
                ", fecha='" + fecha + '\'' +
                ", fechasalida='" + fechasalida + '\'' +
                ", tipoproductos='" + tipoproductos + '\'' +
                ", organizacionprodu='" + organizacionprodu + '\'' +
                ", contraseniaingreso(estatico)=" + contraseniaingreso +
                '}';
    }
}