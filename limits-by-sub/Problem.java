import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Problem
{
    public static void main(String[] args)
    {
        try
        {
            FileWriter limitProbFile = new FileWriter("limit-problem-file.tex");
            FileWriter limitProbSolFile = new FileWriter("limit-problem-sol-file.tex");
            FileWriter limitProbFileSpanish = new FileWriter("limit-problem-file-spanish.tex");
            FileWriter limitProbFileSolSpanish = new FileWriter("limit-problem-file-sol-spanish.tex");

            limitProbFile.write("\\documentclass{article}" + System.lineSeparator() + System.lineSeparator());
            limitProbSolFile.write("\\documentclass{article}" + System.lineSeparator() + System.lineSeparator());
            limitProbFileSpanish.write("\\documentclass{article}" + System.lineSeparator() + System.lineSeparator());
            limitProbFileSolSpanish.write("\\documentclass{article}" + System.lineSeparator() + System.lineSeparator());

            limitProbFile.write("\\begin{document}" + System.lineSeparator() + System.lineSeparator());
            limitProbSolFile.write("\\begin{document}" + System.lineSeparator() + System.lineSeparator());
            limitProbFileSpanish.write("\\begin{document}" + System.lineSeparator() + System.lineSeparator());
            limitProbFileSolSpanish.write("\\begin{document}" + System.lineSeparator() + System.lineSeparator());

            for (int i = 0; i < 100; i++)
            {
                Random rand = new Random();
                int upperbound = 21;
                int exponentUpperbound = 9;
                int coeffOne = rand.nextInt(upperbound);
                int coeffTwo = rand.nextInt(upperbound);
                int constantOne = rand.nextInt(upperbound);
                int exponentOne = rand.nextInt(exponentUpperbound);
                int exponentTwo = rand.nextInt(exponentUpperbound);
                while (exponentOne <= exponentTwo)
                {
                    exponentOne = rand.nextInt(upperbound);
                    exponentTwo = rand.nextInt(upperbound);
                }
                int xValue = rand.nextInt(upperbound);
                int problemNumber = i + 1;
                int signChooser = rand.nextInt(2);
                if (signChooser == 0)
                {
                    xValue = xValue * -1;
                }
                limitProbFile.write("Problem " + problemNumber + System.lineSeparator() + System.lineSeparator());
                limitProbSolFile.write("Problem " + problemNumber + System.lineSeparator() + System.lineSeparator());
                limitProbFileSpanish.write("Problema " + problemNumber + System.lineSeparator() + System.lineSeparator());
                limitProbFileSolSpanish.write("Problema " + problemNumber + System.lineSeparator() + System.lineSeparator());

                limitProbFile.write(Limits.fOfX(coeffOne, coeffTwo, constantOne, exponentOne, exponentTwo, xValue) + System.lineSeparator() + System.lineSeparator());
                limitProbFileSpanish.write(Limits.fOfXSpanish(coeffOne, coeffTwo, constantOne, exponentOne, exponentTwo, xValue) + System.lineSeparator() + System.lineSeparator());
                limitProbSolFile.write("Solution " + Limits.solution(coeffOne, coeffTwo, constantOne, exponentOne, exponentTwo, xValue) + System.lineSeparator() + System.lineSeparator());
                limitProbFileSolSpanish.write("Solution " + Limits.solution(coeffOne, coeffTwo, constantOne, exponentOne, exponentTwo, xValue) + System.lineSeparator() + System.lineSeparator());
                
            }
            
            limitProbFile.write("\\end{document}" + System.lineSeparator() + System.lineSeparator());
            limitProbSolFile.write("\\end{document}" + System.lineSeparator() + System.lineSeparator());
            limitProbFileSpanish.write("\\end{document}" + System.lineSeparator() + System.lineSeparator());
            limitProbFileSolSpanish.write("\\end{document}" + System.lineSeparator() + System.lineSeparator());

            limitProbFile.close();
            limitProbSolFile.close();
            limitProbFileSpanish.close();
            limitProbFileSolSpanish.close();
            
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
                
        
