
package modelo;


public class Canino extends Mascota {
    private int nivelE;

    public Canino(int nivelE, String nombre, String color, int edad, String raza) {
        super(nombre, color, edad, raza);
        this.nivelE = nivelE;
    }
 
    public int getNivelE() {
        return nivelE;
    }

    public void setNivelE(int nivelE) {
        this.nivelE = nivelE;
    }
    
}
