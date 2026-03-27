package co.edu.poli.contexto2.model;

// SUBCLASE - Hereda de Alimento (supersuperclase)
// PUNTO 3: CLASE FINAL - No se puede heredar de esta clase
public final class Enlatado extends Alimento {
    private String materialdelas;

    public Enlatado(String estado, String sabor, String fechadevencimiento, String codigodebarras,
                    String fechafabricacion, String lugardefabricacion, String fechacaducidad,
                    Registro registro, String materialdelas) {
        super(estado, sabor, fechadevencimiento, codigodebarras, fechafabricacion, lugardefabricacion,
              fechacaducidad, registro);
        this.materialdelas = materialdelas;
    }

    public String getMaterialdelas() { return materialdelas; }
    public void setMaterialdelas(String materialdelas) { this.materialdelas = materialdelas; }

    // SOBREESCRITURA - verificarCaducidad
    @Override
    public boolean verificarCaducidad(String fechaActual) {
        System.out.println("    [SOBREESCRITURA - Enlatado] Verificando caducidad del alimento enlatado");
        return fechaActual.compareTo(this.getFechacaducidad()) > 0;
    }

    // IMPLEMENTACIÓN del nuevo método abstracto
    // Para enlatados: valor fijo alto por el proceso de conservación en lata
    @Override
    public double calcularValorNutricional() {
        return materialdelas.equalsIgnoreCase("Acero") ? 350.0 : 280.0;
    }

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