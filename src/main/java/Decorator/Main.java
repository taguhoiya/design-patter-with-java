package Decorator;

public class Main {
  public static void main(String[] args) {
    ChristmasTree tree = new ChristmasTreeImpl();
    System.out.println(tree.decorate());

    ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
    System.out.println(tree1.decorate());

    ChristmasTree tree2 = new BubbleLights(new Garland(new ChristmasTreeImpl()));
    System.out.println(tree2.decorate());
  }
}
