
package modelo;


public class Felino extends Mascota {
    private boolean toxo;

    public Felino(String nombre, String color, int edad, String raza,boolean toxo) {
        super(nombre, color, edad, raza);
        this.toxo = toxo;
    }

    public boolean isToxo() {
        return toxo;
    }

    public void setToxo(boolean toxo) {
        this.toxo = toxo;
    }

   

    


    
    
    
}