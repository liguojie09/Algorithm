package me.liguojie.sort;

public class MergeSort {

	public MergeSort()
	{
		
	}
	/*
	 * 自己的写的方法，最下层最微小的部分取的是一个值，把这个值存在存在一个数组里，然后返回各部分数组；
	 * 这个方法会额外消耗很多空间，每一个数要创建一个感觉空间复杂度是n^2
	 */
	public static int[] mergeSort(int[] array, int left, int right)
	{
		if (array.length < 2 || array == null)
		{
			return null;
		}
		int mid = (left + right) / 2;
		if (left == right)
		{
			int[] test = new int[1];
			test[0] = array[mid];
			return test;
		}		
		int[] leftArray = mergeSort(array,left,mid);
		int[] rightArray = mergeSort(array,mid+1,right);
		return merge(leftArray,rightArray);
	}
	
	public static int[] merge(int[] leftArray, int[] rightArray)
	{
		for (int i = 0; i < leftArray.length; i++)
		{
			System.out.print(leftArray[i]);
		}
		System.out.println(" zuo");
		for (int i = 0; i < rightArray.length; i++)
		{
			System.out.print(rightArray[i]);
		}
		System.out.println(" you");
		int lenLeft = leftArray.length;
		int lenRight = rightArray.length;
		int totalLen = lenLeft + lenRight;
		int[] help = new int[totalLen];
		int a = 0;
		int b = 0;
		for (int i = 0; i < totalLen; i++)
		{
			if (a < lenLeft && b < lenRight)
			{
				help[i] =  leftArray[a] > rightArray[b] ? rightArray[b++] : leftArray[a++]; 
				continue; //出错是因为这里
			}
			if (b < lenRight)
			{
				help[i] = rightArray[b++];
			}
			if (a  <lenLeft)
			{
				help[i] = leftArray[a++];
			}
		}
		for (int i = 0; i < help.length; i++)
		{
			System.out.print(help[i]);
			System.out.print(" ");
		}
		System.out.println(" _____");
		return help;
	}
	/*
	 * 如果不想消耗额外的空间储存，我们可以直接操作index；在这里，左边是[left,mid],右面是[mid+1，right]，全部可以
	 * 取到相关的值，所以，我们在接下来递归操作的过程中，也要完全取到俩便的值，以便相互对应。
	 * 同时，在这个void方法中，我们取到单个的符号是，return，然后返回栈中上一个函数，那么我们就得到l，r，则我们可以得到mid，
	 * 在最下层由最小的俩个l，r包括俩个单独的数字merge成一个，如左0，右1，中0（坐标）；结果为1 3；直到把栈中所有的方法跑完。
	 * 总结心得：递归的本质就是压栈，是一种分治的思想，我们需要关心最底层的关系，究竟是取数，还是取范围，返回值是什么，都要
	 * 用栈的思路来想。这个是很重要的。
	 */
	public static int[] mergeSort2(int[] array)
	{
		if(array.length < 2 || array == null)
		{
			return null;
		}
		int left = 0;
		int right = array.length - 1;
		recersive(array,left,right);
		return array;
	}
	
	public static void recersive(int[] array,int left, int right)
	{
		if (left == right)
		{
			return;
		}
		int mid = (left + right) /2;
		recersive(array,left,mid);
		recersive(array,mid+1,right);
		merge2(array,left,mid,right);
		}
	
	public static void merge2(int[] array, int left, int mid, int right)
	{
		int totalLen = right - left + 1;
		int[] help = new int[totalLen];
		int l = left;
		int m = mid + 1;
		int i = 0;
		while(l <= mid && m <= right)
		{
			help[i++] = array[l] < array[m] ? array[l++] : array[m++];
		}
		while(l <= mid)
		{
			help[i++] = array[l++];
		}
		while(m <= right)
		{
			help[i++] = array[m++];
		}
		int k = 0;
		for (int a = 0; a < help.length; a++)
		{
			System.out.print(help[a]);
		}
		System.out.println("+");
		for (int index = left; index <= right; index++)
		{
			array[index] = help[k++];
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,3,5,5,7,2,92,3,13};
		int[] result = mergeSort(array,0,array.length-1);
		for (int i = 0; i < result.length;i++)
		{
			System.out.println(result[i]);
		}
		System.out.println("result 2");
		int[] result2 = mergeSort2(array);
		for (int i = 0; i < result2.length;i++)
		{
			System.out.println(result2[i]);
		}
	}
}
