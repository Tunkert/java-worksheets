import java.lang.Math;

public class Limits
{
    public static String fOfX(int coeffOne, int coeffTwo, int constantOne, int exponentOne, int exponentTwo, int xValue)
    {
        String fOfXString = "If f(x) equals " + coeffOne + "x^" + exponentOne + " " + coeffTwo + "x^" + exponentTwo + " " + constantOne;
        fOfXString += " what is " + "\\[ \\lim_{x\\to\\" + xValue + "} f(x) \\]" + "?";
        return fOfXString;
    }

    public static String solution(int coeffOne, int coeffTwo, int constantOne, int exponentOne, int exponentTwo, int xValue)
    {
        double value = coeffOne * Math.pow(xValue, exponentOne) + coeffTwo * Math.pow(xValue, exponentTwo) + constantOne;
        String theSolution = "Solution: " + value;
        return theSolution;
    }

    public static String fOfXSpanish(int coeffOne, int coeffTwo, int constantOne, int exponentOne, int exponentTwo, int xValue)
    {
        String fOfXSpanishString = "Si f (x) es igual a " + coeffOne + "x^" + exponentOne + " " + coeffTwo + "x^" + exponentTwo + " " + constantOne;
        fOfXSpanishString += " que es " + "\\[lim_{x\\to\\" + xValue + "} f(x) \\]" + "?";
        return fOfXSpanishString;
    }
}
    
