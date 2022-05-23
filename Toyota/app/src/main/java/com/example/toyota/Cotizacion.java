package com.example.toyota;

public class Cotizacion {
    public int numCotizacion;
    public String descripcion;
    public int precio;
    public int porPagoInicial;
    public int plazo;

    //Constructores

    //Constructor vacío
    public Cotizacion() {
    }

    //Constructor de parámetros
    public Cotizacion(int numCotizacion, String descripcion, int precio, int porPagoInicial, int plazo) {
        this.numCotizacion = numCotizacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.porPagoInicial = porPagoInicial;
        this.plazo = plazo;
    }

    //Constructor de copia
    public Cotizacion(Cotizacion copy) {
        this.numCotizacion = copy.numCotizacion;
        this.descripcion = copy.descripcion;
        this.precio = copy.precio;
        this.porPagoInicial = copy.porPagoInicial;
        this.plazo = copy.plazo;
    }

    //Encapsulamiento
    /**
     * @return the numCotizacion
     */
    public int getNumCotizacion() {
        return numCotizacion;
    }

    /**
     * @param numCotizacion the numCotizacion to set
     */
    public void setNumCotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the porPagoInicial
     */
    public int getPorPagoInicial() {
        return porPagoInicial;
    }

    /**
     * @param porPagoInicial the porPagoInicial to set
     */
    public void setPorPagoInicial(int porPagoInicial) {
        this.porPagoInicial = porPagoInicial;
    }

    /**
     * @return the plazo
     */
    public int getPlazo() {
        return plazo;
    }

    /**
     * @param plazo the plazo to set
     */
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    //Métodos
    public float calcularPagoInicial(){
        float pagoInicial = 0.0f;
        pagoInicial = (precio * porPagoInicial) / 100;
        return pagoInicial;
    }

    public float calcularTotalFinanciar(){
        float totalFinanciar = 0.0f;
        totalFinanciar = precio - calcularPagoInicial();
        return totalFinanciar;
    }

    public float calcularPagoMensual(){
        float pagoMensual = 0.0f;
        pagoMensual = calcularTotalFinanciar() / plazo;
        return pagoMensual;
    }
}
