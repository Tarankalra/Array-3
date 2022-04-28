import java.util.Arrays;

public class HIndex {
    /*
    TC - O(nlogn)
    SC - O(1)
     */
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;

        Arrays.sort(citations); // sorting helps us to know how many papers will be > or < then the ith index
        int n = citations.length;
        for(int i = 0 ; i < n ; i ++)
        {
            int count = n - i; // finding that how many papers have value greater than the citations[i]
            if(citations[i] >= count) // 0 1 3 5 6, i =2, n-i = 3 -> 3 papers have citations greater than citations[i] = 3
                return count;
        }
        return 0;
    }
    /*
    TC - O(n)
    SC - O(n)
    Bucket Sort
     */
    public int hIndexOptimised(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int [] diff = new int[n+1]; // to store the count of papers with i citations

        // get the count of citiations for each i value
        for (int citation : citations) {
            if (citation > n) {
                diff[n]++; // if the citation count is > then n, we are incrementing at n place only. it means
                // those many papers have citations >=n
            } else {
                diff[citation]++; // else incrementing the count at i only
            }
        }
        int count = 0;
        // because we want to find the max, start traversing from back
        for(int i = n ; i >= 0 ; i--)
        {
            count += diff[i]; // count contains the count of count of all papers with citations greater than i
            if(count >= i) // the moment the count is greater than i, that means we found i papers with count
                return i; // H -index is i
        }
        return 0;
    }

    public static void main(String[] args) {
        new HIndex().hIndexOptimised(new int[] {3,0,6,1,5});
    }
}
