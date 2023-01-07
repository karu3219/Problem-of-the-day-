

//User function Template for Java

class Solution {
    public int removeStudents(int[] arr, int N) {
        // code here
        // 1 1 2 3 5 9
        // 9 1 2 3 1 5
        // Arrays.sort(H);
       int n = arr.length;
       LinkedList<Integer> ans =  new LinkedList<>();
       ans.add(arr[0]);
       
        for(int i = 0; i < n ; i++){    
            
            if(arr[i] > ans.peekLast()){
                ans.add(arr[i]);
            }
            else{               
            	int ind = Collections.binarySearch(ans, arr[i]);
                if(ind == -1){
                    ans.set(ind+1, arr[i]);
                }else if(ind >= 0){
                   continue;
                }else{
                    ind = -(ind)-1;
                    ans.set(ind, arr[i]);
                }
            }
          }
        return N-ans.size();
        
            // 2
    }
};
