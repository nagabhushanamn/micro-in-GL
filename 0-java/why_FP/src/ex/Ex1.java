package ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Lib {
	public static List<Integer> filter(List<Integer> inp, Predicate<Integer> predicate) {
		List<Integer> out = new ArrayList<Integer>();
		for (Integer ele : inp) {
			if (predicate.test(ele)) {
				out.add(ele);
			}
		}
		return out;
	}
}

public class Ex1 {

	private static List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // data

	// ---------------------------------------------
	// Imperative style ==> what ( intention ) + How ( implementation )
	// ---------------------------------------------

//	public static List<Integer> getEvens(List<Integer> inp) {
//		List<Integer> out = new ArrayList<Integer>();
//		for (Integer ele : inp) {
//			if (ele % 2 == 0) {
//				out.add(ele);
//			}
//		}
//		return out;
//
//	}
//
//	public static List<Integer> getOdds(List<Integer> inp) {
//		List<Integer> out = new ArrayList<Integer>();
//		for (Integer ele : inp) {
//			if (ele % 2 != 0) {
//				out.add(ele);
//			}
//		}
//		return out;
//
//	}

	// --------------------------------------------------------------------
	// declarative style ==> what ( intention ) ==> Named Local-Inner Classe
	// -----------------------------------------------------------------------

//	public static List<Integer> getEvens(List<Integer> inp) {
//		class EvenCondition implements Predicate<Integer> {
//			@Override
//			public boolean test(Integer t) {
//				return t % 2 == 0;
//			}
//		}
//		return Lib.filter(data, new EvenCondition());
//	}
//
//	public static List<Integer> getOdds(List<Integer> inp) {
//		class OddCondition implements Predicate<Integer> {
//			@Override
//			public boolean test(Integer t) {
//				return t % 2 != 0;
//			}
//		}
//		return Lib.filter(data, new OddCondition());
//	}

	// --------------------------------------------------------------------
	// declarative style ==> what ( intention ) ==> Anonymous Local-Inner Classe
	// -----------------------------------------------------------------------

//	public static List<Integer> getEvens(List<Integer> inp) {
//		Predicate<Integer> evenCondition = new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer t) {
//				return t % 2 == 0;
//			}
//		};
//		return Lib.filter(data, evenCondition);
//	}
//	

	// --------------------------------------------------------------------
	// declarative style ==> what ( intention ) ==> function
	// -----------------------------------------------------------------------

	public static List<Integer> getEvens(List<Integer> inp) {
		return Lib.filter(data, t -> t % 2 == 0);
	}

	public static void main(String[] args) {

		System.out.println(getEvens(data));

	}

}
