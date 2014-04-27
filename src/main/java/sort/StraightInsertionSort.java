package sort;

import util.CopyUtils;

/**
 * 直接插入排序：
 * 基本思想：从第二个记录开始，依次将每个记录按其关键字的大小，插入到一个有序的子序列中，使之仍然是有序的，
 * 直至所有的记录插完为止。
 * 
 * 时间复杂度为O(n*n), 空间复杂度为O(0). 不需要额外的空间，稳定排序。
 * @author Administrator
 *
 * @param <T>
 */
public class StraightInsertionSort<T extends Comparable<T>> implements Sort<T> {

	public T[] sort(T[] sourceArray, boolean ascending) {
		if (sourceArray == null) {
			return null;
		}
		
		T[] copyArray = CopyUtils.deepCopy(sourceArray);
		
		int i = 0;
		int j = 0;
		T tem = null;
		for (i = 1; i < sourceArray.length; i++) {
			tem = copyArray[i];
			j = i - 1;
			if (ascending) {
				while (j > -1 && tem.compareTo(copyArray[j]) < 0) {
					copyArray[j+1] = copyArray[j];
					j--;
				}
				
			} else {
				while (j > -1 && tem.compareTo(copyArray[j]) > 0) {
					copyArray[j+1] = copyArray[j];
					j--;
				}
			}
			
			
			copyArray[j+1] = tem;
		}
		
		return copyArray;
	}

	public T[] sort(T[] sourceArray) {
		return sort(sourceArray, true);
	}

	
	public static void main(String[] args) {
		Integer[] a = {65, 1, 51, 29, 37, 63, 4 , 94, 38};
		StraightInsertionSort<Integer> sis = new StraightInsertionSort<Integer>();
		Integer[] b = sis.sort(a);
		for (Integer i : a) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println();
		System.out.println("After sort...");
		for (Integer i : b) {
			System.out.print(i);
			System.out.print(",");
		}
		
		Integer[] c = sis.sort(a, false);
		System.out.println();
		System.out.println("After Decending sort...");
		for (Integer i : c) {
			System.out.print(i);
			System.out.print(",");
		}
	}
}
