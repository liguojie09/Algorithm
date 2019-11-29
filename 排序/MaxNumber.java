package me.liguojie.sort;

/*
 * 在一个数组总找最大值，用递归方式
 * 函数，系统帮你压栈
 */
public class MaxNumber {
	public MaxNumber()
	{}
	
	public static int getMaxNumber(int[] array, int left, int right)
	{
		if (array.length < 2 || array == null)
		{
			return -1;
		}
		int mid = (left + right) /2;
		if(left == right)
		{
			return array[mid];
		}
		int maxLeft = getMaxNumber(array,left,mid);
		int maxRight = getMaxNumber(array,mid+1,right);
		return Math.max(maxLeft,maxRight);
	}
	public static void main(String[] args) {
		int[] array = new int[] {1,32,43,2,31,5,2,31,531,324,31212};
		System.out.println(getMaxNumber(array,0,array.length - 1));
	}
}
