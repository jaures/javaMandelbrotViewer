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

import  java.math.BigDecimal;
import  java.math.MathContext;

public class Mandelbrot
{
    private int[][] grid;
    private int     dim;
    private int     stepLimit;
    private double  zoom;
    private double  zoomFactor;
    private double  unit;
    private Complex center;
    private double range  =   4.0;

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
        this.unit   = range / dim;
        this.zoom   = zoom;
        this.zoomFactor = zoom;
        this.stepLimit  = stepLimit;

        this.center = center;

        grid = new int[dim][dim];

    }

    public void mvCenter(int i, int r)
    {
        center = new Complex(center.getImg().add(new BigDecimal(i * unit)), 
                                center.getReal().add(new BigDecimal(r * unit)));
        System.out.println("Moved: " + i + "," + r);
    }

    public void zoomGrid()
    {
        zoom    *= zoomFactor;
        range   *= zoomFactor; 
        unit     = range / dim;
    }

    public void computeGrid()
    {
        Complex c,z;
 //       System.out.println(this.center);
        for(int i = 0; i < dim; i++)
        {
            for(int j = 0; j < dim; j++)
            {
                grid[i][j]  = getStep(
                        (new Complex(new BigDecimal((dim/2 - i) * unit), 
                            new BigDecimal((5 * dim/8 - j) * unit))).sub(center));
            }
        }

        zoomGrid();
    }

    public int getStep(Complex c)
    {
        int iter = 0;

        Complex z = new Complex(c.getImg(), c.getReal());

        while(z.mag().getReal().compareTo(new BigDecimal(2)) < 0
                && iter < stepLimit)
        {
            z = z.mul(z).sub(c);

            if(z.mag().getReal().equals(BigDecimal.ZERO))
                return 0;
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
                str += String.format("%04d ",grid[i][j]);
            }

            str += "\n";
        }

        return str;
    }

    /*
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
