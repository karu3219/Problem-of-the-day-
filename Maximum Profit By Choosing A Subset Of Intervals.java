

class Solution {
    public static int maximum_profit(int n, int[][] intervals) {
        /* 1 2 4
           2 4 4
           1 5 7 */
        ArrayList<Triple> arr = new ArrayList<>();
        int dp[]=new int[n];
        for(int i=0;i<intervals.length;i++)
        {
            arr.add(new Triple(intervals[i][0],intervals[i][1],intervals[i][2]));
            // dp[i]=intervals[i][2];
        }
        Collections.sort(arr,(a,b)-> a.end-b.end);
        // for(int i=0;i<arr.size();i++)
        // {
        //     dp[i]=arr.get(i).prof;
        // }
        dp[0]=arr.get(0).prof;
        for(int i=1;i<n;i++)
        {
            dp[i]=Math.max(arr.get(i).prof,dp[i-1]);
            for(int j=i-1;j>=0;j--)
            {
                if(isSafe(i,j,arr))
                {
                    //  System.out.println(j+" "+i+" "+dp[j]+" "+arr.get(i).prof);
                    dp[i]=Math.max(dp[i],dp[j]+arr.get(i).prof);
                    break;
                }
            }
        }

        int max=dp[0];
        for(int i:dp)
        {
            // System.out.print(i+" ");
            max=Math.max(max,i);
        }
        
        return max;
    }
    public static boolean isSafe(int i,int j,ArrayList<Triple> arr)
    {
        return arr.get(j).end<=arr.get(i).start && arr.get(j).start<arr.get(i).start;
    }
}
class Triple
{
    int start,end,prof;
    public Triple(int a,int b,int c)
    {
        start=a;
        end=b;
        prof=c;
    }
}
/* 10
    61 70 20
    1 10 20
    31 40 20
    51 60 20
    91 100 20
    11 20 20
    71 80 20
    21 30 20
    41 50 20
    81 90 20  
    
    2
    5 7 7
    1 4 8 */
