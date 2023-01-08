

//User function Template for Java

class Solution {
	static long countPairs(int n, int[] arr, int k) 
	{
		// code here
		int rem_freq[]=new int[k];
		for(int i:arr)
		{
		    rem_freq[(i+k)%k]++;
		}
		long cnt_pairs=0;
		for(int i:rem_freq)
		{
		    cnt_pairs+=(i*(i-1))>>1;
		}
		return cnt_pairs;
	}
}
