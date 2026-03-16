package co.edu.poli.contexto2.model;

public class Registro {
    private int idregistro;
    private int fecha;
    private String lugar;
    private String mision;
    private String tipodeproductos;
    private String navealsiguiera;
    private String lugardesextraccion;
    
    public Registro(int idregistro, int fecha, String lugar, String mision, String tipodeproductos, String navealsiguiera, String lugardesextraccion) {
        this.idregistro = idregistro;
        this.fecha = fecha;
        this.lugar = lugar;
        this.mision = mision;
        this.tipodeproductos = tipodeproductos;
        this.navealsiguiera = navealsiguiera;
        this.lugardesextraccion = lugardesextraccion;
    }
    
    public int getIdregistro() {
        return idregistro;
    }
    
    public void setIdregistro(int idregistro) {
        this.idregistro = idregistro;
    }
    
    public int getFecha() {
        return fecha;
    }
    
    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    
    public String getLugar() {
        return lugar;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    public String getMision() {
        return mision;
    }
    
    public void setMision(String mision) {
        this.mision = mision;
    }
    
    public String getTipodeproductos() {
        return tipodeproductos;
    }
    
    public void setTipodeproductos(String tipodeproductos) {
        this.tipodeproductos = tipodeproductos;
    }
    
    public String getNavealsiguiera() {
        return navealsiguiera;
    }
    
    public void setNavealsiguiera(String navealsiguiera) {
        this.navealsiguiera = navealsiguiera;
    }
    
    public String getLugardesextraccion() {
        return lugardesextraccion;
    }
    
    public void setLugardesextraccion(String lugardesextraccion) {
        this.lugardesextraccion = lugardesextraccion;
    }
    
    public boolean esproductoalimenticio() {
        return this.tipodeproductos != null && this.tipodeproductos.toLowerCase().contains("alimento");
    }
    
    @Override
    public String toString() {
        return "Registro{" +
                "idregistro=" + idregistro +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", mision='" + mision + '\'' +
                ", tipodeproductos='" + tipodeproductos + '\'' +
                ", navealsiguiera='" + navealsiguiera + '\'' +
                ", lugardesextraccion='" + lugardesextraccion + '\'' +
                '}';
    }
}