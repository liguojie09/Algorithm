package me.liguojie.sort;
import java.util.Arrays;
/*
 * 一个有序数组A，另一个无序数组B，请打印B中的所有不在A中的数，A数组长度为N，B数组长度为M
 */
/*
 * 在第三个的时候，模拟下整个流程，以b为基准，当b的系数不得不增加且a已经大于b的时候，这个时候就说明b不在a里面
 * 同时，如果b的长度比a短，且最后没走到最后，那么就把剩余的数字打出来。外排的过程模拟了一遍
 * 
 * 另外，去java文档看了下Arrays这个类，有binary search直接的方法，还有平行方法。
 */


public class ArrayBnotInArrayA {
	/*
	 * 创建器
	 */
	public ArrayBnotInArrayA() {
	}
	
	/*
	 * 对于B中每一个数，都在A中遍历查找一下
	 */
	public static void method1(int[] arrayA,int[] arrayB)
	{
		int lenA = arrayA.length;
		int lenB = arrayB.length;
		for (int i = 0; i < lenB; i++)    //这里需要按b为基准，按b数组去循环
		{
			boolean whetherFound = false;
			for(int j = 0; j < lenA; j++)
			{
				if (arrayA[j] == arrayB[i])
				{
					whetherFound = true;
				}
			}
			if (!whetherFound)
			{
				System.out.println(arrayB[i]);
			}
		}
	}
	/*
	 * 第二种方法，对于B中每一个数，都在A中二分查找一下
	 */
	public static void method2(int[] arrayA, int[] arrayB)
	{
		int lenA = arrayA.length;
		int lenB = arrayB.length;
		for (int i = 0; i < lenB; i++)
		{
			boolean whetherFound = binarySearch(arrayA,arrayB[i],lenA-1, 0);
			if (!whetherFound)
			{
				System.out.println(arrayB[i]);
			}
		}
	}
	
	public static boolean binarySearch(int[] arrayA,int goal,int right, int left)
	{
		boolean whetherFound = false;
		if(left > right)
		{
			return whetherFound;
		}
		int mid = (left+right)/2;
		if(arrayA[mid] > goal)
		{
			right = mid - 1;
			return binarySearch(arrayA,goal,right,left);
		}
		else if(arrayA[mid] < goal)
		{
			left = mid + 1;
			return binarySearch(arrayA,goal,right,left);
		}
		else {
			whetherFound = true;
			return whetherFound;
		}
		
	}
	
	
	/*
	 * 先把b数组排序，然后用类似外排的方法打印所有的数
	 */
	public static void method3(int[] arrayA, int[] arrayB)
	{
		Arrays.sort(arrayB);
		int indexA = 0;
		int indexB = 0;
		int lenA = arrayA.length ;
		int lenB = arrayB.length;
		while(indexA <= lenA - 1 && indexB <= lenB-1)
		{
			if(arrayA[indexA] < arrayB[indexB])
			{
				indexA++;
			}
			else if(arrayA[indexA] > arrayB[indexB])
			{
				System.out.println(arrayB[indexB]);
				indexB++;
			}
			else
			{
				indexA++;
				indexB++;
			}
		}
		if (indexB < lenB)
		{
			for (int i = indexB; i < lenB; i++)
			{
				System.out.println(arrayB[i]);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] arrayA = new int[] {1,2,3,4,7,8,10,12};
		int[] arrayB = new int[] {4,5,62,34,12,10,8,7,23};
		method1(arrayA,arrayB);
		method2(arrayA,arrayB);
		method3(arrayA,arrayB);
	}
}
