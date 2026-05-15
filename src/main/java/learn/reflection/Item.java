package learn.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Item {
    public static void main(String[] args) {
        Item item = new Item("apple", 5);
        Class itemClass = item.getClass();

        Field[] fields = itemClass.getDeclaredFields();

        for (Field field: fields) {
            int modifier = field.getModifiers();
            
            if(Modifier.isPublic(modifier)) {
                System.out.print("public ");
            }
            if(Modifier.isProtected(modifier)) {
                System.out.print("protected ");
            }
            if(Modifier.isPrivate(modifier)) {
                System.out.print("private ");
            }
            if(Modifier.isStatic(modifier)) {
                System.out.print("static ");
            }
            if(Modifier.isFinal(modifier)) {
                System.out.print("final ");
            }

            System.out.print(field.getType() + " ");
            System.out.println(field.getName());
        }
    }

    public static final int maxItems = 100;
    public static int inStock = 19;

    private String name;
    protected int basePrice;

    public Item(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return (int) (basePrice * getMarkUp());
    }

    protected double getMarkUp() {
        double markUp = 0.1;
        // ... connecting to the remote server
        return 1 + markUp;
    }
}
