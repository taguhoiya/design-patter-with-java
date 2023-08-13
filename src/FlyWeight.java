import java.util.HashMap;
import java.util.Map;

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
        System.out.println("Applying style - Font: " + font + ", Size: " + size + ", Color: " + color);
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
