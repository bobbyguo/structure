package sort;

public interface Sort<T extends Comparable<T>> {
	
	T[] sort(T[] sourceArray, boolean ascending);
	T[] sort(T[] sourceArray);
	
}
