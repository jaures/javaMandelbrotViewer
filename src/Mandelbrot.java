/**
 *******************************************************************************
 *  <h1>
 *      Mandelbrot.java
 *  </h1>
 *
 *  <h3>
 *      Description:
 *  </h3>
 *
 *  <p>
 *      Class that handles computing the Mandelbrot Set for a specified area
 *      and returning a 2D array of the results
 *  </p>
 *
 *  @author     Jaures Ade
 *  @version    1.0
 *  @since      5/11/2018
 *******************************************************************************
 **/

public class Mandelbrot
{
    private Complex[][] grid;
    private Complex center;
    private double  zoom;
    private int     dim;
    private int     iterStepLimit;
    private final double RANGE  =   4.0;

    public Mandelbrot(int dim, double zoom, int iterStepLimit)
    {
        this.dim    = dim;
        this.zoom   = zoom;
        this.iterStepLimit  = iterStepLimit;

        grid = new Complex[dim][dim];

        for(int i = 0; i < dim; i++)
        {
            for(int j = 0; j < dim; j++)
            {
                complex[i][j] = (new Complex(i * zoom * RANGE / dim - 2,
                                    j * zoom * RANGE / dim - 2)).sub(center); 
            }
        }
    }

    public int getStep(Complex z, Complex c, int iter)
    {
        if(c.mag() <= 2 || iter < iterStepLimit)
        {
            return getStep(z.mul(z).add(c), c, iter + 1);
        }
        else
        {
            return iter - 1;
        }
    }



}
