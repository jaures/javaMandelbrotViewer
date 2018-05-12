/**https://stackoverflow.com/jobs?med=site-ui&ref=jobs-tab
 *******************************************************************************
 *  <h1>
 *      Complex.java
 *  </h1>
 *
 *  <h3>
 *      Description:
 *  </h3>
 *
 *  <p>
 *      Class that handles working with complex numbers and related operations
 *      that can be done on them.
 *  </p>
 *
 *  @author     Jaures Ade
 *  @version    1.0
 *  @since      5/11/2018
 *******************************************************************************
 **/

import  java.lang.Math.sqrt;


public class Complex
{
    private double img;
    private double real;

    /**
     *  Default Constructor
     *
     *  @param  img     Value of the imaginary component of the complex number
     *  @param  real    Value of the real component of the complex number
     *
     **/
    public Complex(double img, double real)
    {
        this.img    = img;
        this.real   = real;
    }

    /**
     *  Set the imaginary component of the complex number
     *
     *  @param  img     Value to set the imaginary component
     *
     **/
    public void setImg(double img)
    {
        this.img = img;
    }

    /**
     *  Set the imaginary component of the complex number
     *
     **/
    public void setReal(double real)
    {
        this.real = real;
    }

    /**
     *  Get the imaginary component of the complex number
     *
     *  @return double img      Value of the imaginary component
     *
     **/
    public double getImg()
    {
        return this.img;
    }

    /**
     *  Get the real component of the complex number
     *
     *  @return double real     Value of the imaginary component
     *
     **/
    public double getReal()
    {
        return this.real;
    }

    /**
     *  Computes and returns the magnitude of the complex number
     *
     *  @return Complex   Value of the magnitude of the complex number
     *
     **/
    public Complex mag()
    {
        return Complex(sqrt(img * img + real * real), 0);
    }

    /**
     *  Computes and returns the conjugate of the complex number
     *
     *  @return Complex   Value of the complex number's conjugate
     *
     **/
    public Complex conj()
    {
        return Complex(-img, real);
    }

    /**
     *  Compute and returns the sum of this and another complex number
     *
     *  @return Complex     Value of addition operation
     *
     **/
    public Complex add(Complex a)
    {
        return new Complex(this.img + a.img, this.real + a.real);
    }

    /**
     *  Compute and returns the difference of this and another complex 
     *  number
     *
     *  @return Complex     Value of subtraction operation
     *
     **/
    public Complex sub(Complex a)
    {
        return new Complex(this.img - a.img, this.real - a.real);
    }

    /**
     *  Compute and returns the product of this and another complex number
     *
     *  @return Complex     Value of multiplication operation
     *
     **/
    public Complex mul(Complex a)
    {
        return new Complex(
                this.img * a.real + this.real * a.img,
                this.img * a.img + this.real * a.real);
    }

    /**
     *  Compute and returns the product of this and another complex number
     *
     *  @return Complex     Value of division operation
     *
     **/
    public Complex div(Complex a)
    {
        return new Complex(this.img - a.img, this.real - a.real);
    }

    /**
     *  @Return String      String representation of the complex number
     *
     **/
    @Override
    public String toString()
    {
        return String.format("%d %di", real, img);
    }

    /**
     *  @Return boolean     Whether or not the two complex numbers are equal
     *
     **/
    @Override
    public boolean equals(Complex a)
    {
        return (this.img == a.img) && (this.real == a.real);
    }

}
