package FlyWeight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Flyweight Class (Intrinsic State)
class TreeType {
  private String name;
  private String color;
  private String texture;

  public TreeType(String name, String color, String texture) {
    this.name = name;
    this.color = color;
    this.texture = texture;
  }

  public void draw(int x, int y) {
    System.out.println("Drawing tree '" + name + "' at (" + x + ", " + y + ") with color " + color);
  }
}


// Flyweight Factory
class TreeTypeFactory {
  private static Map<String, TreeType> treeTypes = new HashMap<>();

  public static TreeType getTreeType(String name, String color, String texture) {
    String key = name + "-" + color + "-" + texture;
    if (!treeTypes.containsKey(key)) {
      treeTypes.put(key, new TreeType(name, color, texture));
    }
    return treeTypes.get(key);
  }
}


// Context Class (Extrinsic State)
class Tree {
  private int x;
  private int y;
  private TreeType type;

  public Tree(int x, int y, TreeType type) {
    this.x = x;
    this.y = y;
    this.type = type;
  }

  public void draw() {
    type.draw(x, y);
  }
}


// Forest Class (Client)
class Forest {
  private List<Tree> trees = new ArrayList<>();

  public void plantTree(int x, int y, String name, String color, String texture) {
    TreeType type = TreeTypeFactory.getTreeType(name, color, texture);
    Tree tree = new Tree(x, y, type);
    trees.add(tree);
  }

  public void draw() {
    for (Tree tree : trees) {
      tree.draw();
    }
  }
}


// Main Class
public class FlyweightPatternExample {
  public static void main(String[] args) {
    Forest forest = new Forest();

    // Planting trees (many of them share the same type)
    forest.plantTree(1, 1, "Oak", "Green", "Rough");
    forest.plantTree(2, 3, "Oak", "Green", "Rough");
    forest.plantTree(4, 5, "Pine", "Dark Green", "Smooth");
    forest.plantTree(7, 9, "Oak", "Green", "Rough");

    // Drawing all trees
    forest.draw();
  }
}
