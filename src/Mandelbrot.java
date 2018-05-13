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
    private int[][] grid;
    private int     dim;
    private int     stepLimit;
    private double  zoom;
    private double  zoomFactor;
    private double  unit;
    private Complex center;
    private final double RANGE  =   4.0;

    /**
     *  Default Constructor that takes in 3 parameters to produce the viewport
     *  of the desired region of the Mandelbrot Set.
     *
     *  @param  int dim         The resolution of the image and the MxM size of
     *                          the array that contains it.
     *
     *  @param  double zoom     The zoom factor or each step of calculation.
     *                          Values greater than 1 imply zooming out, those
     *                          less than 1 imply zooming in.
     *
     *  @param  int stepLimit   The limit of the number of iterations to check
     *
     *
     **/
    public Mandelbrot(int dim, double zoom, Complex center, int stepLimit)
    {
        this.dim    = dim;
        this.unit   = RANGE / dim;
        this.zoom   = zoom;
        this.zoomFactor = zoom;
        this.stepLimit  = stepLimit;

        this.center = center;

        grid = new int[dim][dim];

    }

    public void zoomGrid()
    {
        zoom *= zoomFactor;
        unit   = RANGE * zoom / dim;
    }

    public void computeGrid()
    {
        Complex c,z;
        for(int i = 0; i < dim; i++)
        {
            for(int j = 0; j < dim; j++)
            {
                grid[i][j]  = getStep(
                        (new Complex(2.0 - i * unit, j * unit - 2)).sub(center));
            }
        }

        zoomGrid();
    }

    public int getStep(Complex c)
    {
        int iter = 0;

        Complex z = new Complex(c.getImg(), c.getReal());

        while(z.mag().getReal() < 2 && iter < stepLimit)
        {
            z = z.mul(z).add(c);

            if(z.mag().getReal() == 0)
                break;

            iter++;
        }

        return iter;
    }

    public int[][] getGrid()
    {
        return grid;
    }

    public String toString()
    {
        String str = new String("");

        for(int i = 0; i < dim; i++)
        {
            for(int j = 0; j < dim; j++)
            {
                str += String.format("%05d ",grid[i][j]);
            }

            str += "\n";
        }

        return str;
    }

    ///*
    public static void main(String[] args)
    {
        Mandelbrot m = new Mandelbrot(8, 0.65, new Complex(0,0), 16);
        m.computeGrid();
        System.out.println(m);
        m.computeGrid();
        System.out.println(m);
        m.computeGrid();
        System.out.println(m);
        m.computeGrid();
        System.out.println(m);
        m.computeGrid();
        System.out.println(m);
    }
    //*/



}
