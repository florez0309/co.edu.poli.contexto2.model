package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;

public interface OperacionCRUD {

    // Inserta en el primer null de izquierda a derecha; si el arreglo está lleno, lo expande
    void crear(Alimento alimento);

    // Busca por codigodebarras; retorna null si no existe
    Alimento consultar(String codigodebarras);

    // Reemplaza el objeto con ese codigodebarras; retorna true si tuvo éxito
    boolean modificar(String codigodebarras, Alimento alimento);

    // Pone null en la posición del objeto con ese codigodebarras; retorna true si tuvo éxito
    boolean eliminar(String codigodebarras);

    // Retorna el arreglo completo (incluyendo nulls)
    Alimento[] listar();
}