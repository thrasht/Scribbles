package innerclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Outer {

    private int value = 10;
    private List<String> list;

    public Outer() {
        list = new ArrayList<>();
    }

    public void addElement(String e) {
        list.add(e);
    }

    public void setValue(int value) {
        Outer.this.value = value;
    }

    public int getValue() {
        return Outer.this.value;
    }

    public Iterator<String> getIterator() {
        class InnerIterator implements Iterator<String> {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < list.size();
            }

            @Override
            public String next() {
                return list.get(counter++);
            }
        }

        return new InnerIterator();
    }

    public Iterator<String> getIteratorWithAnonymous() {
        return new Iterator<String>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < list.size();
            }

            @Override
            public String next() {
                return list.get(counter++);
            }
        };
    }

    public class Inner {
        int value = 20;
        public final String s = new String("");

        public List<String> getOuterList() {
            return list;
        }

        public int getValue() {
            return value;
        }

        public void printValues() {
            System.out.println("---Printing values----");
            System.out.println("Outer= " + Outer.this.value);
            System.out.println("Inner= " + value);
        }
    }

    public static class TopLevelNestedClass {
        {
            System.out.println("This is a top level class inside another class");
        }
    }
}
