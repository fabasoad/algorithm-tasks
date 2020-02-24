package traverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

abstract class TraverseAbs {

    static Person createTree() {
        final Person root = new Person("root");
        root.children.add(new Person("1"));
        final Person p2 = new Person("2");
        p2.children.add(new Person("2-1"));
        root.children.add(p2);
        final Person p3 = new Person("3");
        p3.children.add(new Person("3-1"));
        final Person p3_2 = new Person("3-2");
        p3.children.add(p3_2);
        root.children.add(p3);
        return root;
    }

    abstract void traverse(final Person person, Consumer<Person> callback);

    static class Person {
        final String name;
        Collection<Person> children;

        Person(final String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }
    }
}
