package FlyWeight;

import java.util.HashMap;
import java.util.Map;

// https:// medium.com/@maheshmaddi92/3-6-flyweight-efc16010d316
// The Flyweight Design Pattern is a structural design pattern used to minimize memory usage and
// improve performance by sharing as much data as possible between similar objects. Instead of
// creating a large number of similar objects, the Flyweight pattern reuses existing objects to
// reduce the overhead.

// When to Use:
// You have a large number of similar objects that consume a lot of memory.
// The intrinsic and extrinsic states can be clearly separated.
// Example scenarios: rendering objects in a game, managing reusable resources like threads,
// or optimizing large datasets.


// Flyweight: Interface for text formatting styles
interface TextFormattingStyle {
    void apply(String text);
}


// ConcreteFlyweight: Concrete text formatting style
class ConcreteTextFormattingStyle implements TextFormattingStyle {
    private final String font;
    private final int size;
    private final String color;

    public ConcreteTextFormattingStyle(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    @Override
    public void apply(String text) {
        System.out.println(
                "Applying style - Font: " + font + ", Size: " + size + ", Color: " + color);
        System.out.println(text);
    }
}


// FlyweightFactory: Manages creation and sharing of text formatting styles
class TextFormattingStyleFactory {
    private final Map<String, TextFormattingStyle> styleMap = new HashMap<>();

    public TextFormattingStyle getStyle(String font, int size, String color) {
        String key = font + size + color;
        if (!styleMap.containsKey(key)) {
            styleMap.put(key, new ConcreteTextFormattingStyle(font, size, color));
        }
        return styleMap.get(key);
    }
}


// Client code
public class FlyWeight {
    public static void main(String[] args) {
        TextFormattingStyleFactory styleFactory = new TextFormattingStyleFactory();

        TextFormattingStyle style1 = styleFactory.getStyle("Arial", 12, "Black");
        TextFormattingStyle style2 = styleFactory.getStyle("Times New Roman", 14, "Blue");

        style1.apply("Hello, World!");
        style2.apply("Flyweight Pattern Example");
    }
}
