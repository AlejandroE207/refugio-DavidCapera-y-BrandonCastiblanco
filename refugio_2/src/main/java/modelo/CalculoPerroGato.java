
package modelo;

import java.util.*;

public class CalculoPerroGato implements ICalculo{

    @Override
    public int promEdad(ArrayList lista) {
        int suma=0;
        int numMasc=0;
        int prom=0;
        //RECORRA EL ARRAYLIST CON UN ITERATOR Y CALCULA PROMEDIO
        Iterator it = lista.iterator();
        while(it.hasNext()){
            Mascota objeto = (Mascota)it.next();
            suma+=objeto.getEdad();
            numMasc++;
        }
        if(numMasc==0){
            return prom;
        }else{
        prom=suma/numMasc;
        return prom;
        }
    }
    
    public int nPerros(ArrayList lista){
        int nPerros=0;
        Iterator it = lista.iterator();
        while(it.hasNext()){
            Mascota objeto = (Mascota)it.next();
            if(objeto instanceof Canino){
                nPerros++;
            }
        }
        return nPerros;
    }
    public int nGatos(ArrayList lista){
        int nGatos=0;
        Iterator it = lista.iterator();
        while(it.hasNext()){
            Mascota objeto = (Mascota)it.next();
            if(objeto instanceof Canino){
                nGatos++;
            }
        }
        return nGatos;
    }
    
    
}
