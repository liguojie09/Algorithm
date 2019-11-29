package me.liguojie.sort;
public class BublleSort {
	/*
	 * constructure
	 */
	public BublleSort()
	{
		
	}
	
	/*
	 * method Bubble Sort
	 * 得从俩侧分别开始，跟后面的那个有序二维数组结合一下思考，这类问题控制的变量需要从俩个不同的端点出发，
	 * 从而有所抉择。
	 */
	
	public static int[] bubbleSort(int[] array)
	{
		int len = array.length;
		if (array == null || array.length < 2)
		{
			return array;
		}
		for (int i = len - 1; i > 0; i--)
		{
			for (int j = 0 ; j < i; j ++)
			{
				if (array[j]  > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	

	
	public static void main(String[] args) {
		int[] array = new int[] {1,3,5,5,7,2,92,3,13};
		int[] result = bubbleSort(array);
		for (int i = 0; i < result.length;i++)
		{
			System.out.println(result[i]);
		}
	}

}
