package vip.lijunlin.test.stream;

import java.util.ArrayList;
import java.util.List;

public class MyStreamTest {

	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple(100, "red"));
		apples.add(new Apple(101, "green"));
		apples.add(new Apple(103, "green"));
		// TODO
		List<Apple> heavyApples1 = apples.stream().filter((Apple a) -> a.getWeight() > 100).collect(null);
		System.out.println(heavyApples1);
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
}
