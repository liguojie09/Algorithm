package me.liguojie.sort;

public class NumberPartitionArray {
	
	public static void partitionArray(int[] array, int num)
	{
		int len = array.length;
		int index = -1;
		for (int i = 0; i < len; i ++)
		{
			if(array[i] <= num)
			{
				swap(index+1,i,array);
				index++;
			}
		}
	}
	
	public static void swap(int a, int b, int[] array)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	public static void main(String[] args) {
		int array[] = new int[] {1,5,2,3,5,6, 61,43,21,2,7};
		partitionArray(array,6);
		for (int i = 0; i < array.length;i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
