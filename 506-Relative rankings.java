import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] sorted = score.clone();
        Arrays.sort(sorted);

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int rank = n - Arrays.binarySearch(sorted, score[i]);

            if (rank == 1)
                result[i] = "Gold Medal";
            else if (rank == 2)
                result[i] = "Silver Medal";
            else if (rank == 3)
                result[i] = "Bronze Medal";
            else
                result[i] = String.valueOf(rank);
        }

        return result;
    }
}
