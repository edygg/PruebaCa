/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Alecx
 */
public class Peso {

    String Aerolinea;
    double precio;

    public Peso(String Aerolinea, double precio) {
        this.Aerolinea = Aerolinea;
        this.precio = precio;
    }

    public String getAerolinea() {
        return Aerolinea;
    }

    public void setAerolinea(String Aerolinea) {
        this.Aerolinea = Aerolinea;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Aerolinea: " + Aerolinea + "/nprecio: " + precio;
    }
}
