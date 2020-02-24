package traverse;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Consumer;

public class TraverseBreadth extends TraverseAbs {

    public static void main(String[] args) {
        new TraverseBreadth().traverse(createTree(), p -> System.out.println(p.name));
    }

    @Override
    void traverse(TraverseAbs.Person person, Consumer<TraverseAbs.Person> callback) {
        final Queue<TraverseAbs.Person> q = new ArrayDeque<>();
        q.add(person);
        while (!q.isEmpty()) {
            final Person p = q.poll();
            callback.accept(p);
            q.addAll(p.children);
        }
    }
}
