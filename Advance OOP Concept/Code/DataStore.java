import java.util.Arrays;
import java.util.Comparator;

public class DataStore<T> {
    private T[] data;
    private int size;
    @SuppressWarnings("unchecked")
    public DataStore(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void add(T item) {
        if (size < data.length) data[size++] = item;
    }
    public T search(T item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                System.out.println("Found: " + data[i]);
                return data[i];
            }
        }
        System.out.println("Item not found.");
        return null;
    }
    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) return;
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        System.out.println("Swapped positions " + i + " and " + j);
    }
    public void sort(Comparator<T> comp) {
        Arrays.sort(data, 0, size, comp);
        System.out.println("DataStore sorted.");
    }
    public void displayAll() {
        System.out.println("--- DataStore contents (" + size + " items) ---");
        for (int i = 0; i < size; i++) System.out.println("  [" + i + "] " + data[i]);
    }
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) return null;
        T max = arr[0];
        for (T item : arr) if (item.compareTo(max) > 0) max = item;
        return max;
    }
    public static <T> void printAll(T[] arr) {
        System.out.println("=== printAll ===");
        for (T item : arr) System.out.println("  " + item);
    }
    public static <T> int countMatching(T[] arr, Checker<T> checker) {
        int count = 0;
        for (T item : arr) if (checker.check(item)) count++;
        return count;
    }
    public interface Checker<T> {
        boolean check(T item);
    }
}