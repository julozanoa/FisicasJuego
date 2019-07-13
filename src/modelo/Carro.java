/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public class Carro {
    private int xref;
    private int yref;
    private int ancho;
    private int alto;
    private Chasis chasis;
    private Llanta[] llantas;

    public Carro(int xref, int yref, int ancho, int alto) {
        this.xref = xref;
        this.yref = yref;
        this.ancho = ancho;
        this.alto = alto;
        //Chasis chasis;
        this.chasis = new Chasis(xref, yref, ancho, alto-5);
        
        //Llantas
        
    }

    public int getXref() {
        return xref;
    }

    public int getYref() {
        return yref;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    
       public void moverDerecha(){
      this.xref++;
    }
    public void moverIzquierda(){
      this.xref--;
    }
    
    
    public void moverArriba(){
      this.yref--;
    }
    
    
     public void moverAbajo(){
      this.yref++;
    }
     
    public void subir(int unidades){
      this.yref = this.yref - unidades ;
    }

    public Chasis getChasis() {
        return chasis;
    }

    public Llanta[] getLlantas() {
        return llantas;
    }
    
    
}
