# Creating a 100 Problem Worksheet with Java

This afternoon I decided to challeng me Java skills a bit by creating a math worksheet of 100 composite function problems. I created it so I wrote to some markdown files and then compiled the html with markdown-it. I spoke a bit about that in [this blog](https://timunkert.net/2021/11/progress-of-the-blog.html).

To start I created two classes, Problem and CompositeProblem, with their corresponding files and methods. My main method was in my Problem class which was in the Problem.java file. At the top of the file I imported the following:

```
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
```

FileWriter was so I could write to files and I need a try and catch to be able to create this program. Java makes you handle exceptions. The java.util.Random was so that I could generate random numbers to pass into the methods from the other class. The way I did that was as follows:

```
Random rand = new Random();
int upperbound = 21;
int int_coeff_1 = rand.nextInt(upperbound);
int int_coeff_2 = rand.nextInt(upperbound);
int int_const_1 = rand.nextInt(upperbound);
int int_const_2 = rand.nextInt(upperbound);
int xValue = rand.nextInt(upperbound);
int problemNumber = i + 1;
```
The upperbound was to set how high I could have my random number go up to. By setting the upperbound at 21 the highest number I could have was 20.

The int_coeff_1 and int_coeff_2 were the two integers for the coefficients in functions f(x) and g(x). The int_const_1 and int_const_2 were for the constants in the functions f(x) and g(x). xValue was for the x value I was going to pass into the composite function problem and problemNumber was to label the problems.

To write into the files I needed the following lines:

```
FileWriter compProbFile = new FileWriter("composite-problem.md");
FileWriter compProbFileSol = new FileWriter("composite-problem-sol.md");
```

As you can see the files I wrote to were composite-problem.md for the problems and composite-problems-sol.md for the corresponding solutions.

## Creating the CompositeProblem class

The CompositeProblem class had four methods - problem, fOfX, gOfX, and solution. The problem method returned a string which was the problem. The code for the problem class was:

```
public static String problem(int xValue)
{
    String theProblem = "What is the value of f(g(x)) when x = " + xValue + "?";
    return theProblem;
}
```

This basically created a string that I returned at the end of the method creating the problem.

The fOfX and gOfX classes created the functions both f(x) and g(x) with the following code:

```
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
```

Both of these functions take the form of:

f(x) / g(x) = some_coefficient * xValue + some_constant. I passed that form into strings and returned these at the end of the method.

The solution was calculated with the following code:

```
public static String solution(int int_coeff_1, int int_coeff_2, int int_const_1, int int_const_2, int xValue)
{
    int numericSolution = int_coeff_1 * (int_coeff_2 * xValue + int_const_2) + int_const_1;
    String theSolution = "Solution = " + numericSolution;
    return theSolution;
}
```

You'll see I calculate the numericSolution by passing the equivalent of the function g(x) into the parenthesis multiplied to coefficient one. After that I simply add the first constant for the f(x) function.

I then pass it into a string and return the string.

## Writing out the Problems

I started writing out "problem" and the problem number in a h3 tag with the following code:

```
compProbFile.write("<div><h3>Problem " + problemNumber + "</h3>" + System.lineSeparator());
```

I then wrote out the f(x) and g(x) functions with the following code:

```
compProbFile.write(CompositeProblem.fOfX(int_coeff_1, int_const_1) + System.lineSeparator() + System.lineSeparator());
compProbFile.write(CompositeProblem.gOfX(int_coeff_2, int_const_2) + System.lineSeparator() + System.lineSeparator());
```

I wrote out the following part of the problem with this bit of code:

```
compProbFile.write(CompositeProblem.problem(xValue) + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + "</div>");
```

Notide that I added System.lineSeparator() several times to format line breaks in the markdown document. This method should be cross-platform.

## Creating the solutions

I wrote out "problem" and the problem number as I did above. After that I needed to write out the solution with the following code:

```
compProbFileSol.write(CompositeProblem.solution(int_coeff_1, int_coeff_2, int_const_1, int_const_2, xValue) + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + "</div>");
```

You'll notice I called the solution method and then added some line breaks.

## Closing the files

I needed to then close the files to prevent a memory leak. I closed the files with the following code:

```
compProbFile.close();
compProbFileSol.close();
```

## The Catch

You'll notice after that I wrote code for exception handling in a code block inside the catch. The code block was as follows:

```
System.out.println("An error occurred.");
e.printStackTrace();
```

You'll see that this code prints out that an error occurred and then handles the exception by calling the printStackTrace method in the IOException class.

## VS Code setup and Extensions

I used [VS Code](https://code.visualstudio.com/) to write these two files and it prompted me to install the [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) which includes [Language Support for Java by Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.java), [Debugger for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug), [Test Runner for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-test), [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven), [Project Manager for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency), and [Visual Studio IntelliCode](https://marketplace.visualstudio.com/items?itemName=VisualStudioExptTeam.vscodeintellicode). I'm not that familiar with what each of these do but they did help with the coding process as I could see errors that popped up while creating my project.

In terms of performance they did slow down VS Code a bit but I think part of that is the language server. I could maybe try to up the speed a bit by using swap storage. I might try "swap enable 2000" in crosh to open up 2GB and see if that makes a difference.

## Once the markdown files were created

Once the Java program created the markdown files it was time to convert those over to html. That was easy as I had previously installed node and a markdown compiler called [markdown-it](https://github.com/markdown-it/markdown-it).

The commands to compile the files to html were as follows:

```
markdown-it composite-problem.md -o composite-problem.html
```

and 

```
markdown-it composite-problem-sol.md -o composite-problem-sol.html
```

To touch up things I added a framework by expanding "!" with Emmet which resulted in the head of an html document. I cut the closing body and html tag and pasted them back at the bottom.

After that I went back to the head of the document, added a description, title, and style to add my 90s blog style. I then added the google analytics tag. 

After that all that was left was to format the document with ctrl-shift-i and then upload it to the server, link it from the home page and done! Just kidding!

## Creating the PDF files

Once uploaded to the server I used the browser by right clicking, choosing print, and then "save to PDF." You can check these files out at Teachers Pay Teachers via the following link:

* [100 Composite Function Problems Created with Java](https://www.teacherspayteachers.com/Product/100-Composite-Function-Problems-Created-With-Java-7458304)

A video on this is coming soon!

Copyright &copy; 2021 Timothy Unkert. All rights reserved.