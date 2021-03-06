public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0){
            return res;
        } 
        
        for (int i =0; i < n; i++){
            int flipper = 1<<i;
            for (int j = res.size()-1; j >= 0; j--){
                int num = res.get(j) | flipper;
                res.add(num);
            }
        }
        return res;
    }
}

// Accepted, Dec 31
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n==0)   return res;
        for (int i=1; i<=n; i++){
            for (int j=res.size()-1; j>=0; j--){
                res.add(res.get(j) | (1<<(i-1)));
            }
        }
        return res;
    }
}