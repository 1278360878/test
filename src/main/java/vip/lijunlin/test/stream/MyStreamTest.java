package vip.lijunlin.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static java.util.Comparator.comparing;

import vip.lijunlin.test.stream.inter.AppleFormatter;
import vip.lijunlin.test.stream.inter.ApplePredicate;

public class MyStreamTest {

	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
		// TODO
//		List<Apple> heavyApples = apples.stream().filter((Apple a) -> a.getWeight() > 100).collect(null);
		ApplePredicate p = (Apple a) -> a.getWeight() > 100;
		List<Apple> heavyApples = filterApples(apples, p);
		System.out.println(heavyApples);
		Predicate<Apple> p2 = (Apple a) -> a.getWeight() > 100;
		heavyApples = filterApples(apples, p2);
		System.out.println(heavyApples);
		prettyPrintApple(heavyApples, (Apple a) -> "Apple is " + a.getColor() + "  weight: " + a.getWeight());
		//
		apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(apples);
		// 方法引用
		apples.sort(comparing(Apple::getWeight));
		System.out.println(apples);
	}

//	public static List<Apple> filterGreenApples(List<Apple> inventory) {
//		List<Apple> result = new ArrayList<Apple>();
//		for (Apple apple : inventory) {
//			if ("green".equals(apple.getColor())) {
//				result.add(apple);
//			}
//		}
//		return result;
//	}
//
//	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
//		List<Apple> result = new ArrayList<Apple>();
//		for (Apple apple : inventory) {
//			if (apple.getColor().equals(color)) {
//				result.add(apple);
//			}
//		}
//		return result;
//	}
//
//	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
//		List<Apple> result = new ArrayList<Apple>();
//		for (Apple apple : inventory) {
//			if (apple.getWeight() > weight) {
//				result.add(apple);
//			}
//		}
//		return result;
//	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}

	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}
