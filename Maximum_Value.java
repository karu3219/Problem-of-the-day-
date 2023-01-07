//User function Template for Java
/*
Tree node structure  used in the program
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution 
{
    ArrayList<Integer> maximumValue(Node node) 
    {
       //code here
       ArrayList<Integer> ans = new ArrayList<>();
       Queue<Node> bfs = new LinkedList<Node>();
       bfs.add(node);
       while(!bfs.isEmpty())
       {
           int n = bfs.size();
           int max=bfs.peek().data;
           for(int i=0;i<n;i++)
           {
               Node adr = bfs.poll();
               max=Math.max(max,adr.data);
               if(adr.left!=null)
               {
                   bfs.add(adr.left);
               }
               if(adr.right!=null)
               {
                   bfs.add(adr.right);
               }
           }
            ans.add(max);
       }
       return ans;
    }
}
