import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        tails[0] = nums[0];
        int size = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] > tails[size - 1]){
                tails[size] = nums[i];
                size++;
            }else{
                int index = binarySearch(tails, nums[i], size - 1);
                tails[index] = nums[i];
            }
        }

        return size;
    }
    private int binarySearch(int[] tails, int target, int r){
        int l = 0;

        int mid = l + (r - l) / 2;
        int indexOfSmallestNumberLargerThanTarget = r;
        while(l <= r){
            mid = l + (r - l) / 2;

            if(tails[mid] == target){
                return mid;
            }

            if(tails[mid] < target){
                l = mid + 1;
            }else{
                if(tails[mid] < tails[indexOfSmallestNumberLargerThanTarget]){
                    indexOfSmallestNumberLargerThanTarget = mid;
                }
                r = mid - 1;
            }

        }
        return indexOfSmallestNumberLargerThanTarget;
    }
}

