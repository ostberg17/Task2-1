package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private HashSet<T> set;
    private Range(){
        set = new HashSet<>();
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    public boolean contains(Object o) {

        return set.contains(o);
    }

    public Iterator<T> iterator()
    {
        return set.iterator();
    }

    public Object[] toArray() {

        return set.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return set.toArray(a);
    }

    public boolean add(T t) {

        return set.add(t);
    }

    public boolean remove(Object o) {

        return set.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return set.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    public void clear() {
        set.clear();
    }

    public static <T extends Comparable<T>> Range<T> of(T beginIndex, T endIndex, Function<T, T> increment) {
        Range<T> set = new Range<T>();

        if(beginIndex.compareTo(endIndex)==0){
            return set;
        }
        T currentIndex = beginIndex;
        while(currentIndex.compareTo(endIndex)<=0){
            set.add(currentIndex);
            currentIndex = increment.apply(currentIndex);
        }

        return set;
    }
    public static Range<Float> of(float beginIndex , float endIndex ) {
        return of(beginIndex , endIndex , f -> f + 0.1f);
    }
    public static Range<Integer> of(int beginIndex, int endIndex) {
        return of(beginIndex, endIndex, i -> i + 1);
    }
    public static Range<Double> of(double beginIndex, double endIndex) {
        return of(beginIndex, endIndex, d -> d + 0.1);
    }
}
