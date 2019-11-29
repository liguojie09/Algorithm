package me.liguojie.sort;

/*
 * merge sort 输在常数项，空间复杂度为0n，因为他还有一遍拷贝数组；
 * 快排的时候，浪费中间缝隙的点；断点可以复用，为一个二叉树的高度，最好最差为log n - n 之间
 * 随机快排复杂度的长期期望是nlogn 空间复杂度为logn
 */

/*
 * 排序稳定性指的是能否保证原始的相对次序不变，比如1111，3333，这样相同的值。可以的：冒泡（看相等情况下是否交换）；插入排序，如果相当不往前扎；
 * 选择排序，做不到，交换为位置；归并排序，位置相当的时候，先拷贝左边的；快速排序，做不到稳定性。堆排序，做不到。重要性：想排排序之前的有用信息
 * 留下来。
 */

/*
 * 工业上的综合排序：如果是int，short，char，long，double，float这种基本数据类型的话，她会进行快排；但是如果是一些object，如自定义的
 * people，这些，会用归并排序来排。
 * 如果数组长度很短，直接用插排。插排的长度项很低，数组长度小于60的时候，直接使用，小样本的情况下非飞快；递归部分小于60的情况下，直接插入排序；
 */
public class QuickSort {

	public static void quickSort(int[] array, int left, int right)
	{
		if (left < right)
		{
			int[] tool =flagQuestion(array,left,right);
			quickSort(array,left,tool[0]);
			quickSort(array,tool[1],right);
		}
	}
	
	public static int[] flagQuestion(int[] array, int left, int right)
	{
		int min = left - 1;
		int max = right + 1;
		int current = left;
		int goal = array[right];
		while(current < max)
		{
			if(array[current] < goal)
			{
				swap(array,++min,current++);
			}
			else if(array[current] > goal)
			{
				swap(array,--max,current);
			}
			else
			{
				current++;
			}
				
		}
		int[] help = new int[] {min,max};
		return help;
	}
	
	public static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	public static void main(String[] args) {
		int[] array = new int[] {1,4,5,2,5,7,2,5,8,9,3,24};
		quickSort(array,0,array.length-1);
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(" " + array[i]);
		}
		
	}
}
