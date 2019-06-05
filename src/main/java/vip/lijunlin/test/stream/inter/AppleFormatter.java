package vip.lijunlin.test.stream.inter;

import vip.lijunlin.test.stream.Apple;

@FunctionalInterface
public interface AppleFormatter {
	String accept(Apple a);
}
