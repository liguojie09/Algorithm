package me.liguojie.sort;

public class SelectionSort {
	
	/*
	 * 第一个方法记住index，然后交换，第二种每次都交换；后来的写错了，它应该是处理坐标，不用都交换
	 * 都交换就类似bubble了。
	 */

	public SelectionSort()
	{
		
	}
	
	public static int[] selectionSort(int[] array) 
	{
		int len = array.length;
		if (array == null || len < 2)
		{
			return null;
		}
		for (int i = 0; i < len - 1; i ++)
		{
			int minIndex = i;
			for (int j = i+1; j < len; j++)
			{
				minIndex = array[j] < array[minIndex] ? j : minIndex;
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
		return array;
	}
	
	public static void selectionSort2(int[] array)
	{
		if (array == null || array.length < 2)
		{
			return;
		}
		int len = array.length;
		for (int i = 0; i < len -1; i ++)
		{
			for (int j = i + 1; j < len; j ++)
			{
				if (array[j] < array[i])
				{
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,3,5,5,7,2,92,3,13};
		int[] result = selectionSort(array);
		for (int i = 0; i < result.length;i++)
		{
			System.out.println(result[i]);
		}
		int[] array2 = new int[] {1,3,5,5,7,2,92,3,13};
		selectionSort2(array2);
		for (int i = 0; i < array2.length;i++)
		{
			System.out.println(array2[i]);
		}
	}
}
