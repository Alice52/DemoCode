package cn.edu.ntu.javase.common.model;

/**
 * @author zack <br>
 * @create 2020-04-04 20:49 <br>
 */
public class Apple {
  private String color;
  private int weight;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Apple() {}

  public Apple(String color, int weght) {
    this.color = color;
    this.weight = weght;
  }

  @Override
  public String toString() {
    return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
  }
}
