package vip.lijunlin.test.stream;

public class Apple {

	private Integer weight;// 重量

	private String color;// 颜色

	public Apple(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}

	public Apple() {
		super();
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {

		return "weight: " + weight + "  color: " + color;
	}

}
