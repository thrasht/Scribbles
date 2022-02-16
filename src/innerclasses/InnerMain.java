package innerclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InnerMain {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.addElement("Hola");
        outer.addElement("Perro");
        outer.addElement("del");
        outer.addElement("mal");

        Iterator<String> i = outer.getIterator();

        while (i.hasNext())
            System.out.println(i.next());

        System.out.println("----Iterator with anonymous class----");
        Iterator<String> i2 = outer.getIterator();

        while (i2.hasNext())
            System.out.println(i2.next());

        Outer.TopLevelNestedClass t = new Outer.TopLevelNestedClass();

        Outer.Inner innerClass = outer.new Inner();

        System.out.println("---Elements from an inner class---");
        innerClass.getOuterList().forEach(System.out::println);
        innerClass.printValues();
        outer.setValue(30);
        innerClass.printValues();

        final List<String> list = new ArrayList<>();
    }
}
