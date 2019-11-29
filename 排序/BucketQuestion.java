package me.liguojie.sort;

public class BucketQuestion {
	
	public static int[] partitionBuckets(int[] array)
	{
		int[] help = new int[2];
		int len = array.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
			}
			if (array[i] < min)
			{
				min = array[i];
			}
		}
		/*
		for (int i = 0; i < len; i++)
		{
			min = Math.min(min, array[i]);
			max = Math.max(max, array[i]);
		}
		*/
		help[0] = min;
		help[1] = max;
		return help;
	}
	
	public static int findMaxDistance(int[] array)
	{
		int result = 0;
		int[] help = partitionBuckets(array);
		int min = help[0];
		int max = help[1];
		if (min == max)
		{
			return 0;
		}
		int len = array.length;
		int[] minBucket = new int[len+1];
		int[] maxBucket = new int[len+1];
		boolean[] hasItem = new boolean[len+1];
		for (int i = 0; i < len + 1; i ++)
		{
			minBucket[i] = Integer.MAX_VALUE;
			maxBucket[i] = Integer.MIN_VALUE;
 		}
		for (int i = 0; i < len; i ++)
		{
			int idx = ((array[i] - min) * len )/ (max - min); //这块没想明白
			System.out.println(array[i]);
			System.out.println(min);
			System.out.println(max);
			System.out.println(idx);
			hasItem[idx] = true;
			minBucket[idx] = Math.min(array[i],minBucket[idx]);
			maxBucket[idx] = Math.max(array[i],minBucket[idx]);
		
		}
		int previous = 0;
		int current = 0;
		for (int i = 0; i < hasItem.length; i ++)
		{
			System.out.println(hasItem[i]);
			if (hasItem[i])
			{
				if (previous == 0)
				{
					previous = maxBucket[i];
					current = maxBucket[i];
				}
				else
				{
					current = minBucket[i];
					System.out.println(current);
					result = Math.max(result, current - previous);
					previous = maxBucket[i];
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] array = new int[] {100,200,30000};
		int result = findMaxDistance(array);
		System.out.println(result);
		
	}
}
