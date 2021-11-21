public class CompositeProblem
{
    public static String problem(int xValue)
    {
        String theProblem = "What is the value of f(g(x)) when x = " + xValue + "?";
        return theProblem;
    }
    public static String fOfX(int int_coeff_1, int int_const_1)
    {   
        String fOfXString = "f(x) = " + int_coeff_1 + "x + " + int_const_1;
        return fOfXString;
    }

    public static String gOfX(int int_coeff_2, int int_const_2)
    {
        String gOfXString = "g(x) = " + int_coeff_2 + "x + " + int_const_2;
        return gOfXString;
    }
    public static String solution(int int_coeff_1, int int_coeff_2, int int_const_1, int int_const_2, int xValue)
    {
        int numericSolution = int_coeff_1 * (int_coeff_2 * xValue + int_const_2) + int_const_1;
        String theSolution = "Solution = " + numericSolution;
        return theSolution;
    }
}
