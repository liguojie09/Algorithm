package me.liguojie.sort;

/*
 * 这个题比较重要，就是分组的原理：个人总结
 * while：如果一个流程不是每一次都要增加系数，用while比较好；
 * 左边是小区，每次换肯定都是推着等于区走，但是在右面，大于区换过来的数没有经过处理，不一定属于大于区
 */
public class NetherlandFlag {
	
	public static void netherlandFlag(int[] array, int num)
	{
		int len = array.length;
		int leftIndex = -1;
		int rightIndex = len;
		int current = 0;
		while (current < rightIndex)
		{
			if (array[current] < num)
			{
				swap(array,++leftIndex,current++);
			}
			else if(array[current] > num)
			{
				swap(array,current,--rightIndex);
			}
			else
			{
				current++;
			}
		}
	}
	
	public static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1,5,2,3,5,6, 61,43,21,2,7};
		netherlandFlag(array,5);
		for (int i = 0; i < array.length;i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
