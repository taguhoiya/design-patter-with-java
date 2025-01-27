package Decorator;

// https://www.baeldung.com/java-decorator-patternl

// The Decorator Pattern is based on composition rather than inheritance.
// Instead of creating subclasses to extend functionality, it "wraps" objects with decorators that
// add new behavior or modify existing behavior

// When to Use:
// You need to dynamically add or remove responsibilities to an object at runtime.
// Inheritance would lead to an explosion of subclasses to support every combination of behaviors.
// Example use cases:
// Extending graphical elements in a GUI(e.g.,adding borders,shadows).
// Enhancing logging functionality.Wrapping or formatting data.



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
