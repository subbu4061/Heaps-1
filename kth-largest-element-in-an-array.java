


// TimeComplexity: O(nlogn)
// SpaceComplexity: O(n)
// Explanation: This approach inserts almost all elements into a max-heap and removes the largest elements until the k-th largest remains at the top. 
// Because the heap can grow close to size n, each operation costs O(log n), giving an overall time complexity of O(n log n).
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > nums.length-k+1){
                pq.poll();
            }
        }
       
        return pq.poll();
    }
}



// TimeComplexity: O(nlogk)
// SpaceComplexity: O(k)
// Explanation: This approach maintains a min-heap containing only the k largest elements seen so far while iterating through the array.
//  Whenever the heap size exceeds k, the smallest element is removed, ensuring that only the top k remain. After processing all elements, the heap’s root is the k-th largest number.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}