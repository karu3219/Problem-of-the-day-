

class Solution 
{
    public static String longestString(int n, String[] arr) 
    {
        // code here
        Arrays.sort(arr);
        HashSet<String> lookUp = new HashSet<>();
        for(String i:arr)
        {
            lookUp.add(i);
        }
        int max=0;
        String ans="";
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i].length())
            {
                if(check(lookUp,arr[i]))
                {
                    max=arr[i].length();
                    ans=arr[i];
                }
            }
        }
        return ans;
    }
    public static boolean check(HashSet<String> lookUp, String s)
    {
        for(int i=1;i<=s.length();i++)
        {
            // System.out.print(s.substring(0,i));
            if(!lookUp.contains(s.substring(0,i)))
            {
                return false;
            }
        }
        return true;
    }
}
        
