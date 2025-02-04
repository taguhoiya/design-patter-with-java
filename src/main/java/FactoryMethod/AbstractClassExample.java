package FactoryMethod;

// Abstract Product Class
// It’s an abstract class or interface that defines the common operations
// for the objects that the factory will create.
// Concrete Products are the actual classes
// that implement the Product interface, each representing a specific type of object to be created.
abstract class Product {
  public abstract void display();
}


// Concrete Products
class ConcreteProductA extends Product {
  @Override
  public void display() {
    System.out.println("This is Concrete Product A.");
  }
}


class ConcreteProductB extends Product {
  @Override
  public void display() {
    System.out.println("This is Concrete Product B.");
  }
}


// Creator Abstract Class
// It’s an abstract class or interface that declares the factory method.
// This method is responsible for creating Product objects, but it delegates the actual creation to
// subclasses.
abstract class Creator {
  // It’s typically declared as abstract in the Creator and implemented in the Concrete Creators.
  public abstract Product factoryMethod();
}


// Concrete Creators
class ConcreteCreatorA extends Creator {
  @Override
  public Product factoryMethod() {
    return new ConcreteProductA();
  }
}


class ConcreteCreatorB extends Creator {
  @Override
  public Product factoryMethod() {
    return new ConcreteProductB();
  }
}


// Client Code
public class AbstractClassExample {
  public static void main(String[] args) {
    Creator creatorA = new ConcreteCreatorA();
    Product productA = creatorA.factoryMethod();
    productA.display();

    Creator creatorB = new ConcreteCreatorB();
    Product productB = creatorB.factoryMethod();
    productB.display();
  }
}
