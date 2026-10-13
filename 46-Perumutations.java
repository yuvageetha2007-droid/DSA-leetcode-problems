import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            backtrack(nums, start + 1, result);

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
}
