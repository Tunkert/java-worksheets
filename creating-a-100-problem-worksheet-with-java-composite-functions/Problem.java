import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Problem {
    public static void main(String[] args) {
        try {
            
            FileWriter compProbFile = new FileWriter("composite-problem.md");
            FileWriter compProbFileSol = new FileWriter("composite-problem-sol.md");
            for (int i = 0; i < 100; i++) {
                Random rand = new Random();
                int upperbound = 21;
                int int_coeff_1 = rand.nextInt(upperbound);
                int int_coeff_2 = rand.nextInt(upperbound);
                int int_const_1 = rand.nextInt(upperbound);
                int int_const_2 = rand.nextInt(upperbound);
                int xValue = rand.nextInt(upperbound);
                int problemNumber = i + 1;
                compProbFile.write("<div><h3>Problem " + problemNumber + "</h3>" + System.lineSeparator());
                compProbFile.write(CompositeProblem.fOfX(int_coeff_1, int_const_1) + System.lineSeparator() + System.lineSeparator());
                compProbFile.write(CompositeProblem.gOfX(int_coeff_2, int_const_2) + System.lineSeparator() + System.lineSeparator());
                compProbFile.write(CompositeProblem.problem(xValue) + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + "</div>");
                compProbFileSol.write("<div><h3>Problem " + problemNumber + "</h3>" + System.lineSeparator() + System.lineSeparator());
                compProbFileSol.write(CompositeProblem.solution(int_coeff_1, int_coeff_2, int_const_1, int_const_2, xValue) + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + "</div>");
            }
            compProbFile.close();
            compProbFileSol.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}