package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Deshidratado;
import co.edu.poli.contexto2.model.Registro;

// SUBSUBCLASE - Hereda de Deshidratado (que hereda de Alimento)
// Visibilidad de paquete (sin public) - clase abstracta
abstract class Deshidratadoespecial extends Deshidratado {
    private String nivelhidratacion;

    public Deshidratadoespecial(String estado, String sabor, String fechadevencimiento, String codigodebarras,
                                String fechafabricacion, String lugardefabricacion, String fechacaducidad,
                                Registro registro, int cantidadtamaximaadias, String nivelhidratacion) {
        super(estado, sabor, fechadevencimiento, codigodebarras, fechafabricacion, lugardefabricacion,
              fechacaducidad, registro, cantidadtamaximaadias);
        this.nivelhidratacion = nivelhidratacion;
    }

    public String getNivelhidratacion() { return nivelhidratacion; }
    public void setNivelhidratacion(String nivelhidratacion) { this.nivelhidratacion = nivelhidratacion; }

    public void obtenerporcionconservacion(String dato) {
        System.out.println("  Obteniendo porción de conservación con dato: " + dato);
    }

    // SOBREESCRITURA - verificarCaducidad
    @Override
    public boolean verificarCaducidad(String fechaActual) {
        System.out.println("    [SOBREESCRITURA - Deshidratadoespecial] Verificando caducidad especial");
        return false; // Los alimentos especiales duran más
    }

    // IMPLEMENTACIÓN del nuevo método abstracto
    // Para deshidratados espaciales: considera el nivel de hidratación
    @Override
    public double calcularValorNutricional() {
        double base = getCantidadtamaximaadias() * 2.5;
        double factor = nivelhidratacion.equalsIgnoreCase("alto") ? 1.5 :
                        nivelhidratacion.equalsIgnoreCase("medio") ? 1.2 : 1.0;
        return base * factor;
    }

    @Override
    public String toString() {
        return "Deshidratadoespecial{" +
                "cantidadtamaximaadias=" + getCantidadtamaximaadias() +
                ", nivelhidratacion='" + nivelhidratacion + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", codigodebarras='" + getCodigodebarras() + '\'' +
                '}';
    }
}