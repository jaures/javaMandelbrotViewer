/**
 *******************************************************************************
 *  <h1>
 *      MandelbrotApp.java
 *  </h1>
 *
 *  <h3>
 *      Description:
 *  </h3>
 *
 *  <p>
 *      Driver Class that handles generating the window and displaying the image
 *      onto a canvas component.
 *  </p>
 *
 *  @author     Jaures Ade
 *  @version    1.0
 *  @since      5/11/2018
 *******************************************************************************
 **/

import  javafx.application.Application;
import  javafx.util.Duration;
import  javafx.animation.Timeline;
import  javafx.animation.KeyFrame;
import  javafx.animation.KeyValue;
import  javafx.scene.input.KeyCode;
import  javafx.event.ActionEvent;
import  javafx.event.EventHandler;
import  javafx.stage.Stage;
import  javafx.scene.Scene;
import  javafx.scene.layout.StackPane;
import  javafx.scene.canvas.Canvas;
import  javafx.scene.canvas.GraphicsContext;
import  javafx.scene.paint.Paint;
import  javafx.scene.paint.Color;


public class MandelbrotApp extends Application
{
    private Mandelbrot mand;
    private Color[][] colorGrid;
    private final int DIM = 100;

    ///*
    public static void main(String[] args)
    {
        launch(args);
    }
    //*/

    public void paintGrid(GraphicsContext gc)
    {
        for(int i = 0; i < DIM; i++)
        {
            for(int j = 0; j < DIM; j++)
            {
                gc.setFill(Color.hsb(6 * mand.getGrid()[i][j], 
                                    1.0 - 0.9/32 * mand.getGrid()[i][j],
                                        1.0 - 0.9/32 * mand.getGrid()[i][j]));
                gc.fillRect(j * 2,i * 2,2.0,2.0);
            }
        }
    }

    public void init()
    {
        mand = new Mandelbrot(DIM, 0.85, new Complex(0, 0), 5);
        colorGrid = new Color[DIM][DIM];

    }

    public void start(Stage primaryStage)
    {
        //mand.computeGrid();
        //System.out.println(mand);

        Canvas cv   = new Canvas(DIM * 2,DIM * 2);
        StackPane sp    = new StackPane();

        sp.getChildren().addAll(cv);
        primaryStage.setScene(new Scene(sp));
        primaryStage.show();

        Timeline tm = new Timeline( new KeyFrame(Duration.millis(1000), e->
            {
                mand.computeGrid();
            }));

        cv.setFocusTraversable(true);
        cv.setOnKeyPressed(e ->
            {
                System.out.println(e.getCode());
                switch(e.getCode())
                {
                    case UP:
                        System.out.println("UP");
                        mand.mvCenter(-16,0);
                        mand.computeGrid();
                        paintGrid(cv.getGraphicsContext2D());
                        break;
                    case RIGHT:
                        System.out.println("RIGHT");
                        mand.mvCenter(0,16);
                        mand.computeGrid();
                        paintGrid(cv.getGraphicsContext2D());
                        break;
                    case DOWN:
                        System.out.println("DOWN");
                        mand.mvCenter(16,0);
                        mand.computeGrid();
                        paintGrid(cv.getGraphicsContext2D());
                        break;
                    case LEFT:
                        System.out.println("LEFT");
                        mand.mvCenter(0,-16);
                        mand.computeGrid();
                        paintGrid(cv.getGraphicsContext2D());
                    case SPACE:
                        mand.computeGrid();
                paintGrid(cv.getGraphicsContext2D());
                        break;
                }
            });
        tm.setCycleCount(20);
        //tm.play();

    }
}
