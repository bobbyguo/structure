package sort;

import util.CopyUtils;

/**
 * 希尔排序又叫做缩小增量排序。
 * 基本思想：先取定一个小于n（n为记录个数）的整数 d(d = n/2)作为第一个增量，把表的记录分为d组，
 * 所有距离为d的记录放在一个组（即以d为间隔，分组），在各组内进行直接插入排序。然后取第二个增量d = d/2,重复上述过程
 * 直到d=1为止。
 * @author Administrator
 *
 * @param <T>
 */
public class ShellSort<T extends Comparable<T>> implements Sort<T> {

	public T[] sort(T[] sourceArray, boolean ascending) {
		if (sourceArray == null) {
			return null;
		}
		
		T[] copyArray = CopyUtils.deepCopy(sourceArray);
		int n = copyArray.length;
		int d = n /2;
		int i = 0;
		int j = 0;
		T tem = null;
		while (d > 0) {
			for (i = d; i < n; i++) {
				j = i - d;
				while (j >= 0 && ascending && copyArray[j].compareTo(copyArray[j + d]) > 0) {
					tem = copyArray[j];
					copyArray[j] = copyArray[j + d];
					copyArray[j + d] = tem;
					j = j - d;
				}
				
				while (j >= 0 && !ascending && copyArray[j].compareTo(copyArray[j + d]) < 0) {
					tem = copyArray[j];
					copyArray[j] = copyArray[j + d];
					copyArray[j + d] = tem;
					j = j - d;
				}
			}
			
			d = d/2;
		}
		
		
		return copyArray;
	}

	public T[] sort(T[] sourceArray) {
		return sort(sourceArray, true);
	}

	
	public static void main(String[] args) {
		Integer[] a = {65, 1, 59, 23, 45, 76, 5, 13};
		ShellSort<Integer> ss = new ShellSort<Integer>();
		Integer b[] = ss.sort(a);
		for (Integer i : b) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println();
		
	}
}
