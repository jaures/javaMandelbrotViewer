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

import  java.lang.Math;
import  java.math.BigDecimal;
import  java.math.MathContext;


public class Complex
{
    private BigDecimal img;
    private BigDecimal real;

    /**
     *  Default Constructor
     *
     *  @param  img     Value of the imaginary component of the complex number
     *  @param  real    Value of the real component of the complex number
     *
     **/
    public Complex(double img, double real)
    {
        this.img    = new BigDecimal(img, new MathContext(64));
        this.real   = new BigDecimal(real, new MathContext(64));
    }
    
    public Complex(BigDecimal img, BigDecimal real)
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
    public void setImg(BigDecimal img)
    {
        this.img = img;
    }

    /**
     *  Set the imaginary component of the complex number
     *
     **/
    public void setReal(BigDecimal real)
    {
        this.real = real;
    }

    /**
     *  Get the imaginary component of the complex number
     *
     *  @return BigDecimal img      Value of the imaginary component
     *
     **/
    public BigDecimal getImg()
    {
        return this.img;
    }

    /**
     *  Get the real component of the complex number
     *
     *  @return BigDecimal real     Value of the imaginary component
     *
     **/
    public BigDecimal getReal()
    {
        return this.real;
    }

    /**
     *  Computes and returns the magnitude of the complex number
     *
     *  @return new Complex   Value of the magnitude of the complex number
     *
     **/
    public Complex mag()
    {
        return new Complex(BigDecimal.ZERO, img.multiply(img).add(real.multiply(real)));
    }

    /**
     *  Computes and returns the conjugate of the complex number
     *
     *  @return new Complex   Value of the complex number's conjugate
     *
     **/
    public Complex conj()
    {
        return new Complex(img.negate(), real);
    }

    /**
     *  Compute and returns the sum of this and another complex number
     *
     *  @return new Complex     Value of addition operation
     *
     **/
    public Complex add(Complex a)
    {
        return new Complex(this.img.add(a.img), this.real.add(a.real));
    }

    /**
     *  Compute and returns the difference of this and another complex 
     *  number
     *
     *  @return new Complex     Value of subtraction operation
     *
     **/
    public Complex sub(Complex a)
    {
        return new Complex(this.img.subtract(a.img), this.real.subtract(a.real));
    }

    /**
     *  Compute and returns the product of this and another complex number
     *
     *  @return new Complex     Value of multiplication operation
     *
     **/
    public Complex mul(Complex a)
    {
        return new Complex(
                this.img.multiply(a.real).add(this.real.multiply(a.img)),
                this.real.multiply(a.real).subtract(this.img.multiply(a.img)));
    }

    /**
     *  Compute and returns the quotient of this and another complex number
     *
     *  @return new Complex     Value of division operation
     *
     **/
    public Complex div(Complex a)
    {
        return new Complex(this.img.divide(a.mag().real, new MathContext(4)),
                           this.real.divide(a.mag().real, new MathContext(4)));
    }

    /**
     *  @Return String      String representation of the complex number
     *
     **/
    public String toString()
    {
        return String.format("%f %fi", real, img);
    }

    /**
     *  @Return boolean     Whether or not the two complex numbers are equal
     *
     **/
    public boolean equals(Complex a)
    {
        return (this.img.equals(a.img)) && (this.real.equals(a.real));
    }
}
