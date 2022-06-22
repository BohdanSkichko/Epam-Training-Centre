package chapter10.varianta;

import java.util.Set;

public class SetHelper {
    Set<Integer> Intersection(Set<Integer> first, Set<Integer> second) {
        first.retainAll(second);
        return first;
    }

    Set<Integer> Union(Set<Integer> first, Set<Integer> second) {
        first.addAll(second);
        return first;
    }

}
