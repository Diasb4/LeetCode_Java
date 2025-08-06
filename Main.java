// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int m = nums1.length, n = nums2.length;
//         int total = m + n;
//         int mid1 = (total - 1) / 2;
//         int mid2 = total / 2;

//         int i = 0, j = 0, count = 0;
//         int current = 0, prev = 0;

//         while (count <= mid2) {
//             prev = current;

//             if (i < m && (j >= n || nums1[i] <= nums2[j])) {
//                 current = nums1[i++];
//             } else {
//                 current = nums2[j++];
//             }

//             count++;
//         }

//         if (total % 2 == 0) {
//             return (prev + current) / 2.0;
//         } else {
//             return current;
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 })); // Output: 2.0
//         System.out.println(new Solution().findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 8, 4 })); // Output:
//                                                                                                            // 2.5
//     }
// }

// import java.util.*;

// class Solution {
//     public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//         int n = quality.length;
//         double[][] workers = new double[n][2]; // [ratio, quality]

//         for (int i = 0; i < n; i++) {
//             workers[i][0] = (double) wage[i] / quality[i];
//             workers[i][1] = quality[i];
//         }

//         Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0])); // сортировка по ratio

//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//         int qualitySum = 0;
//         double result = Double.MAX_VALUE;

//         for (double[] worker : workers) {
//             int q = (int) worker[1];
//             qualitySum += q;
//             maxHeap.offer(q);

//             if (maxHeap.size() > k) {
//                 qualitySum -= maxHeap.poll(); // удаляем самого "дорогого" по качеству
//             }

//             if (maxHeap.size() == k) {
//                 result = Math.min(result, qualitySum * worker[0]); // текущий ratio * суммарное качество
//             }
//         }

//         return result;
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         System.out.println(solution.mincostToHireWorkers(new int[] { 10, 20, 5 }, new int[] { 70, 50, 30 }, 2)); // Output:
//                                                                                                                  // 105.0
//         System.out
//                 .println(solution.mincostToHireWorkers(new int[] { 3, 1, 10, 10, 1 }, new int[] { 4, 8, 2, 2, 7 }, 3)); // Output:
//                                                                                                                         // 30.666666666666668
//     }
// }

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // Using a nested loop to find two indices such that nums[i] + nums[j] == target
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     return new int[] { i, j };
//                 }
//             }
//         }
//         return new int[] { -1, -1 }; // If no solution found
//     }
// }

// import java.util.HashMap;

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         HashMap<Integer, Integer> numMap = new HashMap<>();
//         int n = nums.length;

//         for (int i = 0; i < n; i++) {
//             int complement = target - nums[i];
//             if (numMap.containsKey(complement)) {
//                 return new int[] { numMap.get(complement), i };
//             }
//             numMap.put(nums[i], i);
//         }

//         return new int[] {}; // No solution found
//     }
// }

// class Solution {
//     public boolean isPalindrome(int x) {
//         // Check if the number is negative or ends with 0 (except for 0 itself)
//         if (x < 0 || (x % 10 == 0 && x != 0)) {
//             return false; // Negative numbers are not palindromes
//         }
//         int original = x;
//         int reversed = 0;
//         while (x > 0) {
//             reversed = reversed * 10 + x % 10;
//             x /= 10;
//         }
//         return original == reversed;
//     }
// }

// class Solution {
//     public int romanToInt(String s) {
//         s = s.replace("IV", "IIII").replace("IX", "VIIII")
//                 .replace("XL", "XXXX").replace("XC", "LXXXX")
//                 .replace("CD", "CCCC").replace("CM", "DCCCC");
//         int result = 0;
//         for (char c : s.toCharArray()) {
//             switch (c) {
//                 case 'I':
//                     result += 1;
//                     break;
//                 case 'V':
//                     result += 5;
//                     break;
//                 case 'X':
//                     result += 10;
//                     break;
//                 case 'L':
//                     result += 50;
//                     break;
//                 case 'C':
//                     result += 100;
//                     break;
//                 case 'D':
//                     result += 500;
//                     break;
//                 case 'M':
//                     result += 1000;
//                     break;
//             }
//         }
//         return result;
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("1: " + solution.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println("2: " + solution.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
        System.out.println("3: " + solution.longestCommonPrefix(new String[] { "ball", "ballon", "bald" }));
        System.out.println("4: " + solution.longestCommonPrefix(new String[] { "a", "b", "c" }));
        System.out.println("5: " + solution.longestCommonPrefix(new String[] { "abc", "ab", "a" }));
        System.out.println("6: " + solution.longestCommonPrefix(new String[] { "", "b", "c" }));
    }
}