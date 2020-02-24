package traverse;

import java.util.function.Consumer;

public class TraverseDepth extends TraverseAbs {

    public static void main(String[] args) {
        new TraverseDepth().traverse(createTree(), p -> System.out.println(p.name));
    }

    @Override
    void traverse(TraverseAbs.Person person, Consumer<TraverseAbs.Person> callback) {
        callback.accept(person);
        person.children.forEach(p -> traverse(p, callback));
    }
}
