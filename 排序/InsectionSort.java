package me.liguojie.sort;

public class InsectionSort {
	/*
	 * 最好情况：本身数据有序，n；对于冒泡排序和选择排序和数据状况无关，但是插入排序和数据状况有关。
	 * 如果是逆序的话，一路交换到底，它为一个n2的算法，和数据状况相关。
	 * 一律按照最差的估计，所以插入排序是n2的复杂度
	 * 别人给的测试拥立不一定对，所以用对数器来判断：其好处为：
	 * 1. 不需要考虑bigO
	 * 2. 面对大样本测试
	 * 3. 判断贪心策略是否正确，国手都不一定能证明贪心正确与否
	 * 对数器：
	 */

	public InsectionSort()
	{
		
	}
	
	public static int[] insectionSort(int[] array)
	{
		int len = array.length;
		for (int i = 1; i < len; i++)
		{
			for(int j = i -1; j >= 0 && array[j] > array[j+1]; j --)
			{
				swap(array,j,j+1);
			}
		}
		return array;
	}
	
	public static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,3,5,5,7,2,92,3,13};
		int[] result = insectionSort(array);
		for (int i = 0; i < result.length;i++)
		{
			System.out.println(result[i]);
		}
	}
}