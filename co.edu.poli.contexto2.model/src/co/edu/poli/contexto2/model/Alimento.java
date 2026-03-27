package co.edu.poli.contexto2.model;

// SUPERSUPERCLASE - Clase padre de toda la jerarquía
public abstract class Alimento {
    private String estado;
    private String sabor;
    private String fechadevencimiento;
    private String codigodebarras;
    private String fechafabricacion;
    private String lugardefabricacion;
    private String fechacaducidad;
    private Registro registro;

    // PUNTO 3: ATRIBUTO FINAL - No se puede cambiar después de inicialización
    public final String CATEGORIA = "Alimento Espacial";

    public Alimento(String estado, String sabor, String fechadevencimiento, String codigodebarras,
                    String fechafabricacion, String lugardefabricacion, String fechacaducidad, Registro registro) {
        this.estado = estado;
        this.sabor = sabor;
        this.fechadevencimiento = fechadevencimiento;
        this.codigodebarras = codigodebarras;
        this.fechafabricacion = fechafabricacion;
        this.lugardefabricacion = lugardefabricacion;
        this.fechacaducidad = fechacaducidad;
        this.registro = registro;
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getSabor() { return sabor; }
    public void setSabor(String sabor) { this.sabor = sabor; }

    public String getFechadevencimiento() { return fechadevencimiento; }
    public void setFechadevencimiento(String fechadevencimiento) { this.fechadevencimiento = fechadevencimiento; }

    public String getCodigodebarras() { return codigodebarras; }
    public void setCodigodebarras(String codigodebarras) { this.codigodebarras = codigodebarras; }

    public String getFechafabricacion() { return fechafabricacion; }
    public void setFechafabricacion(String fechafabricacion) { this.fechafabricacion = fechafabricacion; }

    public String getLugardefabricacion() { return lugardefabricacion; }
    public void setLugardefabricacion(String lugardefabricacion) { this.lugardefabricacion = lugardefabricacion; }

    public String getFechacaducidad() { return fechacaducidad; }
    public void setFechacaducidad(String fechacaducidad) { this.fechacaducidad = fechacaducidad; }

    public Registro getRegistro() { return registro; }
    public void setRegistro(Registro registro) { this.registro = registro; }

    // Método abstracto ya existente - sobreescrito por las subclases
    public abstract boolean verificarCaducidad(String fechaActual);

    // NUEVO MÉTODO ABSTRACTO (semana actual)
    // Cada subclase define cómo calcula su valor nutricional
    public abstract double calcularValorNutricional();

    // SOBRECARGA - Método con mismo nombre pero diferentes parámetros
    public String calcularconservacion(String fechaActual) {
        return "Conservación calculada para fecha: " + fechaActual;
    }

    // SOBRECARGA - Otra versión del método con diferente firma
    public String calcularconservacion(String fechaActual, String tipoAlmacenamiento) {
        return "Conservación en " + tipoAlmacenamiento + " para fecha: " + fechaActual;
    }

    // PUNTO 3: MÉTODO FINAL - No se puede sobreescribir en las subclases
    public final String obtenerCategoria() {
        return "Categoría: " + CATEGORIA;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "estado='" + estado + '\'' +
                ", sabor='" + sabor + '\'' +
                ", codigodebarras='" + codigodebarras + '\'' +
                ", fechacaducidad='" + fechacaducidad + '\'' +
                '}';
    }
}