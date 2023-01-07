//User function Template for Java

class Solution
{
    boolean[] prime;
    Solution()
    {
        prime = new boolean[10000];
        Arrays.fill(prime,true);
        // prime[0]=false;
        prime[1]=false;
        
        for(int i=2;i<10000;i++)
        {
            for(int j=i*2;j<10000;j+=i)
            {
                prime[j]=false;
            }
        }
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
    }
    
    /*     1
         /   \
        0     3
        \     /
         3---n     */
    public int shortestPath(int Num1,int Num2){
        // Complete this function using prime array
        boolean vis[] = new boolean[10000];
        vis[Num1]=true;
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(Num1);
        int pathcnt[]=new int[10000];     
        
        while(!bfs.isEmpty())
        {
            int node=bfs.poll();
            String num=Integer.toString(node);
            for(int i=0;i<4;i++)
            {
                for(char ch='0';ch<='9';ch++)
                {
                    if(i==0 && ch=='0')
                    {
                        continue;
                    }
                    String dup=num.substring(0,i)+ch+num.substring(i+1);
                    int n=Integer.valueOf(dup);
                    if(prime[n] && !vis[n])
                    {
                        vis[n]=true;
                        pathcnt[n]=pathcnt[node]+1;
                        bfs.add(n);
                    }
                }
            }
        }
        return pathcnt[Num2];
    }
}
