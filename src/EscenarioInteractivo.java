/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class EscenarioInteractivo extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane layout  = new Pane();  
        Canvas canvas = new Canvas(1024,512);
        layout.getChildren().add(canvas);
        Scene escena = new Scene(layout,1024,512, Color.WHITESMOKE);
        
        GraphicsContext lapiz = canvas.getGraphicsContext2D();
        LoopJuego juego = new LoopJuego(escena, lapiz);
        juego.start();
        
        primaryStage.setScene(escena);
        primaryStage.setTitle("Ejemplo Escenario Interactivo");
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
