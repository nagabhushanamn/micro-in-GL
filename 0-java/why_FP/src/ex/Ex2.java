package ex;

import java.util.function.Predicate;

/*
 * 
 *  FP principles
 *  ---------------
 *  
 *  
    in FP-language, functions are first-class values/citizens
    
    - A function can be stored in a variable
    - A parameter of a function can be a function
    - The return value of a function can be a function
    
 * 
 */

public class Ex2 {

	// Higher-Order-Function ( HOF ) ==> Higher-Order-Programming  i.e function-composition
	public static Predicate<Integer> and(Predicate<Integer> f1, Predicate<Integer> f2) {
		return n -> f1.test(n) && f2.test(n);
	}

	public static void main(String[] args) {

		Predicate<Integer> isMin = n -> n > 100;
		Predicate<Integer> isMax = n -> n < 1000;

		Predicate<Integer> isMinAndMax = and(isMin, isMax);

		System.out.println(isMinAndMax.test(500));

	}

}
