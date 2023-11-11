package org.example.data;

public class ComplexNumber {
    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        if (imaginary >= 2) {
            return real + " + " + imaginary + "i";
        } else if (imaginary == 1) {
            return real + " + i";
        } else if (imaginary == -1) {
            return real + " - i";
        } else if (imaginary == 0) {
            return real + "";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }
}
