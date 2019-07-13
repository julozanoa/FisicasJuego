
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import modelo.Carro;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer{
    private  Scene escena; //Para controlar los eventos del teclado y para el cambio de nivel.
    private GraphicsContext lapiz;
    
    private boolean seMueve = false;
    private Carro carro;
    private Image fondo ;   
    private Image gato;
    private int maxSalto = 20;
    private int contSalto = 0;
    private int piso = 401;
    private Image a = new Image("image/ufo_0.png");
    private int secuencia = 0;
    private int numero ; 
    private boolean arIsPres = false;
    private ArrayList<String> pulsacionTeclado = null;

    public LoopJuego(Scene escena, GraphicsContext lapiz) {
        this.lapiz = lapiz;
        this.escena = escena;
      
        this.carro = new Carro(0, 100, 20, 20);
        this.fondo = new Image( "image/fondo.png" );
        this.gato = new Image( "image/cats.gif" );
        pulsacionTeclado = new ArrayList<>();
                
        
        
        escena.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !pulsacionTeclado.contains(code) )
                        pulsacionTeclado.add( code );
                }
            });

        escena.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    pulsacionTeclado.remove( code );
                }
            });
        
    }
    
    
    @Override
    public void handle(long now) {
         
        //Carro
        lapiz.clearRect(0, 0, 1024, 512);
        
        //Permite dibujar una imagen
        lapiz.drawImage(  this.fondo, 0, 0 );
        
        
        
        lapiz.strokeRect(carro.getXref(), carro.getYref(), carro.getAncho(), carro.getAlto());
        
        //Obstaculo
        lapiz.fillRect(100, 100, 20, 20);
        
          if (pulsacionTeclado.contains("LEFT"))
                   carro.moverIzquierda();
                if (pulsacionTeclado.contains("RIGHT")){
                    //this.gato = a;
                    this.seMueve = true;
                    carro.moverDerecha();
                }if (pulsacionTeclado.contains("UP")  && (carro.getYref() + carro.getAlto()) > this.piso - 70 ){
                   System.out.println("AAAAAA");
                    if( ( ( (carro.getYref() + carro.getAlto()) < this.piso + 3 ) && ( (carro.getYref() + carro.getAlto()) > this.piso - 35  )   )         ){
                        carro.subir(50);
 
                    }
                    this.arIsPres = true;
                }
            if(!this.arIsPres && (carro.getYref() + carro.getAlto()) < this.piso ){    
                carro.moverAbajo();
                carro.moverAbajo();
                this.contSalto = 0;
            }  
            this.arIsPres = false;
        //Validando colision
        Shape sChasis = new Rectangle(carro.getXref(), carro.getYref(), carro.getAncho(), carro.getAlto());
         //Obstaculo
        Shape sObstaculo = new Rectangle(100, 100, 20, 20);
        //Calculando la Interseccion
        Shape intersection = SVGPath.intersect(sChasis, sObstaculo);
        
         if (intersection.getBoundsInLocal().getWidth() != -1) {
             System.out.println("Acaban de Chocar");
            // stop();
         }
         
          if(this.numero % 5 == 0  && this.seMueve ){
                if(this.secuencia == 5){
                  this.secuencia = 0;
                }else{                    
                  this.secuencia++;
                  this.seMueve = false;
                }
          }
          
        lapiz.drawImage(gato, 132*this.secuencia, 0, 132, 80, carro.getXref(), carro.getYref(), 132,80);
        lapiz.strokeText("Puntaje: 100", 200, 10);
         this.numero++;

    }

    
     
}
