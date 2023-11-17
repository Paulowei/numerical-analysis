The project entails the use of data structures and algorithms in Java to replicate the numerical iteration methods used to solve polynomial equations, Including NewtonRaphson Iteration , Bisection Iteration, FixedPointIteration , and Lagrange Interpolation .

Prerequisites ;

Java 11 or above ; Maven 3.8.5 ;

To compile the project ;

Use the following command ;

mvn compile ;

To package the project to a Jar (Java Archive)

Use the following command ;

mvn package ;

change directories to the /target folder

where the .jar (Java Archive ) file is found, ;

The name of the file should be "numerical-analysis-2.6.jar" ;

To interact with the terminal ;

Use the following command ;

As for Lagrange interpolation, polynomials are expressed as arrays of pairs of double values (List<double[]>)

To perform lagrange interpolation with the following pairs of x:y values (2:3 3:4 4:5) ;

java -jar "numerical-analysis-2.6.jar" "Interpolation" 2:3 3:4 4:5

As for the remaining types of iteration , polynomials are expressed as arrays of pairs of double and integer values (List<Pair<Double,Integer>>)

The Pair class (com.moderneinstein.logical.numerical.Pair) , it is a central figure within this API , and helps to represent expressions of powers of unknowns ;

For example, The expression 4z^3 could be expressed as Pair<Double,Integer> temps = new Pair<Double,Integer>(4.0,3) , it remains implemented as a Generic Template Object, and it extends Cloneable,Comparable<Pair<N,M>> ;

The first value in each pair represents the co-efficient of that term , and the second value represents the power of x in that term ;

So the polynomial 2x^3 + 3x^4 + 4x^5 will be represented as 2:3 3:4 4:5 , likewise the polynomial 4x^2 + 3x^3 + 2x^4

could be represented 4:2 3:3 2:4 , in any order, as there are alogrithms that will handle the sorting accordingly ;

To perform Bisection iteration with the following pairs of x:y values (2:3 3:4 4:5) ;

java -jar "numerical-analysis-2.6.jar" "Bisection" 2:3 3:4 4:5

To perform Newton Raphson iteration with the following pairs of values (2:3 3:4 4:5) ;

java -jar "numerical-analysis-2.6.jar" "NewtonRaphson" 2:3 3:4 4:5

To perform lagrange Fixed Point Iteration with the following pairs of x:y values (2:3 3:4 4:5) ;

java -jar "numerical-analysis-2.6.jar" "FixedPointIteration" 2:3 3:4 4:5
