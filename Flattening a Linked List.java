

/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	// Your code here
	    if(root==null || root.next==null)
	    {
	        return root;
	    }
	    root.next=flatten(root.next);
	    root=merge(root,root.next);
	    return root;
    }
    Node merge(Node root1,Node root2)
    {
        Node dummy=new Node(0);
        Node res=dummy;
        while(root1!=null && root2!=null)
        {
            if(root1.data<root2.data)
            {
                dummy.bottom = root1;
                root1=root1.bottom;
            }
            else
            {
                dummy.bottom=root2;
                root2=root2.bottom;
            }
            dummy=dummy.bottom;
        }
        if(root1!=null)
        {
            dummy.bottom=root1;
        }
        else
        {
            dummy.bottom=root2;
        }
        return res.bottom;
    }
}
