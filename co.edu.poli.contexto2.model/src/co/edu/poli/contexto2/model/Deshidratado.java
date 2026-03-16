package co.edu.poli.contexto2.model;
 
// SUBCLASE - Hereda de Alimento (supersuperclase)
public class Deshidratado extends Alimento {
    private int cantidadtamaximaadias;
    
    public Deshidratado(String estado, String sabor, String fechadevencimiento, String codigodebarras, String fechafabricacion, String lugardefabricacion, String fechacaducidad, Registro registro, int cantidadtamaximaadias) {
        super(estado, sabor, fechadevencimiento, codigodebarras, fechafabricacion, lugardefabricacion, fechacaducidad, registro);
        this.cantidadtamaximaadias = cantidadtamaximaadias;
    }
    
    public int getCantidadtamaximaadias() {
        return cantidadtamaximaadias;
    }
    
    public void setCantidadtamaximaadias(int cantidadtamaximaadias) {
        this.cantidadtamaximaadias = cantidadtamaximaadias;
    }
    
    // SOBREESCRITURA - Implementación del método abstracto de la clase padre
    @Override
    public boolean verificarCaducidad(String fechaActual) {
        System.out.println("    [SOBREESCRITURA - Deshidratado] Verificando caducidad del alimento deshidratado");
        // Lógica simple de ejemplo
        return fechaActual.compareTo(this.getFechacaducidad()) > 0;
    }
    
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