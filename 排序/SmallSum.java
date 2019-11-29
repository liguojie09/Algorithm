package me.liguojie.sort;

public class SmallSum {
	public SmallSum()
	{
		
	}
	
	public static int[] samllSum(int[] array)
	{
		int[] sum = new int[1];
		if (array.length < 2 || array == null)
		{
			return null;
		}
		smallRecer(array,0,array.length-1,sum);
		return sum;
	}
	
	public static void smallRecer(int[] array, int left, int right, int[] sum)
	{
		if (left == right)
		{
			return;
		}
		int mid = (left+right)/2;
		smallRecer(array,left,mid,sum);
		smallRecer(array,mid+1,right,sum);
		mergeCompare(array,left,right,sum);
	}
		
	public static void mergeCompare(int[] array, int left, int right, int sum[])
	{
		int[] help = new int[right - left + 1];
		int i = left;
		int mid = (left + right) / 2;
		int j = mid + 1;
		int index = 0;
		while(i <= mid && j <= right)
		{	
			if(array[i] < array[j])
			{
				help[index] = array[i];
				System.out.println("plus number: " + array[i]);
				sum[0] += array[i] * (right-j+1);
				i++;
				index++;
			}
			else
			{
				help[index] = array[j];
				j++;
				index++;
			}
		}
		while(i<=mid)
		{
			help[index++] = array[i++];
		}
		while(j<=right)
		{
			help[index++] = array[j++];
		}
		int k = 0;
		for (int b = left; b <= right; b++)
		{
			array[b] = help[k++];
			System.out.print(array[b]);
		}
		System.out.println("___");
		System.out.println("sum number" + sum[0]);
		System.out.println("####");
	}
	
	public static int smallSort2(int[] array)
	{
		if (array.length < 2 || array == null)
		{
			return -1;
		}
		int result = sort2(array,0,array.length-1);
		return result;
	}
	
	public static int sort2(int[] array,int left, int right)
	{
		if(left == right)
		{
			return 0;
		}
		int mid = (left+right)/2;
		return sort2(array,left,mid) + sort2(array,mid+1,right) + merge2(array,left,right);
	}
	
	public static int merge2(int[] array, int left, int right)
	{
		int sum = 0;
		int[] help = new int[right-left+1];
		int mid = (left+right)/2;
		int l = left;
		int r = mid + 1;
		int index = 0;
		while(l <= mid && r <= right)
		{
			if (array[l] < array[r])
			{
				sum += array[l] * (right - r + 1);
				help[index] = array[l];
				index++;
				l++;
			}
			else
			{
				help[index] = array[r];
				index++;
				r++;
			}
		}
		while(l<=mid)
		{
			help[index++] = array[l++];
		}
		while(r<= right)
		{
			help[index++] = array[r++];
		}
		int m = 0;
		for (int k = left ; k <= right; k++)
		{
			array[k] = help[m++];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,3,4,2,5};
		int[] array2 = new int[] {1,3,4,2,5};
		int result[] = samllSum(array);
		System.out.println("result is " + result[0]);
		for (int i =0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
		int result2 = smallSort2(array2);
		System.out.println("result2 is: "+result2);
		for (int i =0; i < array2.length; i++)
		{
			System.out.println(array[i]);
		}
	}

}
