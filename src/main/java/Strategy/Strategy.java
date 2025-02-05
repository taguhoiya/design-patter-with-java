package Strategy;

// https:// refactoring.guru/design-patterns/strategy
// The **Strategy Pattern** is a design pattern that promotes flexibility by enabling a family of
// algorithms to be defined and encapsulated individually. Each algorithm is implemented in its own
// class, and they can be swapped out at runtime without affecting the client that uses them. The
// key benefit is avoiding complex conditional logic (`if-else` or `switch` statements) by
// delegating behavior to objects.

// 1.**Strategy Interface**:Common interface for all strategies.
// 2.**Concrete Strategies**:Implementations of the interface.
// 3.**Context**:Uses a strategy object to execute behavior.

// ###Explanation:
// -**Strategy Interface(`PaymentStrategy`)**:Defines the method signature(`pay`).-**Concrete
// Strategies**:Implement the`PaymentStrategy`interface for different payment
// methods(e.g.,CreditCard,PayPal).-**Context(`ShoppingCart`)**:Holds a reference to
// a`PaymentStrategy`and delegates payment behavior to it.

interface PaymentStrategy {
  void pay(int amount);
}


class CreditCardPayment implements PaymentStrategy {
  public void pay(int amount) {
    System.out.println("Paid " + amount + " using Credit Card.");
  }
}


class PayPalPayment implements PaymentStrategy {
  public void pay(int amount) {
    System.out.println("Paid " + amount + " using PayPal.");
  }
}


class ShoppingCart {
  private PaymentStrategy strategy;

  public ShoppingCart(PaymentStrategy strategy) {
    this.strategy = strategy;
  }

  public void checkout(int amount) {
    strategy.pay(amount);
  }
}


public class Strategy {
  public static void main(String[] args) {
    ShoppingCart cart1 = new ShoppingCart(new CreditCardPayment());
    cart1.checkout(100); // Output: Paid 100 using Credit Card.

    ShoppingCart cart2 = new ShoppingCart(new PayPalPayment());
    cart2.checkout(200); // Output: Paid 200 using PayPal.
  }
}
