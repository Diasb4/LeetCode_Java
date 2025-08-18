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

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs == null || strs.length == 0) {
//             return "";
//         }
//         String prefix = strs[0];
//         for (int i = 1; i < strs.length; i++) {
//             while (strs[i].indexOf(prefix) != 0) {
//                 prefix = prefix.substring(0, prefix.length() - 1);
//                 if (prefix.isEmpty()) {
//                     return "";
//                 }
//             }
//         }
//         return prefix;
//     }
// }
// class Solution {
// public boolean isValid(String s) {
// Stack<Character> stack = new Stack<>();

// for (char c : s.toCharArray()) {
// if (c == '(' || c == '{' || c == '[') {
// stack.push(c); // добавляем открывающую скобку в стек
// } else if (c == ')' || c == '}' || c == ']') {
// if (stack.isEmpty())
// return false; // закрывающая скобка без пары
// char open = stack.pop();
// if (!isMatchingPair(open, c))
// return false;
// } else {
// return false; // если встретили неожиданный символ
// }
// }

// return stack.isEmpty(); // если стек пуст — все скобки закрыты корректно
// }

// private boolean isMatchingPair(char open, char close) {
// return (open == '(' && close == ')')
// || (open == '{' && close == '}')
// || (open == '[' && close == ']');
// }
// }

// class ListNode {
// int val;
// ListNode next;

// ListNode() {
// }

// ListNode(int val) {
// this.val = val;
// }

// ListNode(int val, ListNode next) {
// this.val = val;
// this.next = next;
// }
// }

// class Solution {
// public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
// ListNode dummy = new ListNode(0);
// ListNode current = dummy;

// while (list1 != null && list2 != null) {
// if (list1.val < list2.val) {
// current.next = list1;
// list1 = list1.next;
// } else {
// current.next = list2;
// list2 = list2.next;
// }
// current = current.next;
// }

// // Append any remaining elements from either list
// current.next = (list1 != null) ? list1 : list2;

// return dummy.next;
// }
// }

// class Solution {
// public int removeDuplicates(int[] nums) {
// if (nums.length == 0)
// return 0;

// int uniqueCount = 1;
// for (int i = 1; i < nums.length; i++) {
// if (nums[i] != nums[uniqueCount - 1]) {
// nums[uniqueCount] = nums[i]; // записываем уникальный элемент внутрь nums
// uniqueCount++;
// }
// }

// return uniqueCount;
// }
// }

// class Solution {
// public int removeElement(int[] nums, int val) {
// int k = 0; // индекс для записи элементов, не равных val

// for (int i = 0; i < nums.length; i++) {
// if (nums[i] != val) {
// nums[k] = nums[i]; // записываем элемент, не равный val
// k++;
// }
// }

// return k; // возвращаем количество элементов, не равных val
// }
// }

// class Solution {
// public int strStr(String haystack, String needle) {
// if (needle == null || needle.length() == 0) {
// return 0;
// }
// for (int i = 0; i <= haystack.length() - needle.length(); i++) {
// if (haystack.substring(i, i + needle.length()).equals(needle)) {
// return i;
// }
// }
// return -1;
// }
// }

// class Solution {
// public int searchInsert(int[] nums, int target) {
// int left = 0;
// int right = nums.length - 1;

// while (left <= right) {
// int mid = left + (right - left) / 2;
// if (nums[mid] == target) {
// return mid;
// } else if (nums[mid] < target) {
// left = mid + 1;
// } else {
// right = mid - 1;
// }
// }
// return left;
// }
// }

// class Solution {
// public int lengthOfLastWord(String s) {
// s = s.trim(); // Удаляем пробелы в начале и конце строки
// int lastSpaceIndex = s.lastIndexOf(' '); // Находим последний пробел
// if (lastSpaceIndex == -1) {
// return s.length(); // Если пробелов нет, возвращаем длину всей строки
// }
// return s.length() - lastSpaceIndex - 1; // Возвращаем длину последнего слова

// }
// }
// class Solution {
//     public int[] plusOne(int[] digits) {
//         for (int i = digits.length - 1; i >= 0; i--) {
//             if (digits[i] < 9) {
//                 digits[i]++;
//                 return digits; // Если не 9, просто увеличиваем и возвращаем
//             }
//             digits[i] = 0; // Если 9, делаем его 0 и продолжаем
//         }
//         // Если все цифры были 9, добавляем 1 в начало массива
//         int[] newNumber = new int[digits.length + 1];
//         newNumber[0] = 1;
//         return newNumber;
//     }
// }

// class Solution {
//     public String addBinary(String a, String b) {
//         StringBuilder result = new StringBuilder();
//         int carry = 0;
//         int i = a.length() - 1, j = b.length() - 1;

//         while (i >= 0 || j >= 0 || carry > 0) {
//             int sum = carry;
//             if (i >= 0) {
//                 sum += a.charAt(i--) - '0';
//             }
//             if (j >= 0) {
//                 sum += b.charAt(j--) - '0';
//             }

//             result.append(sum % 2); // Добавляем текущий бит
//             carry = sum / 2; // Вычисляем перенос
//         }

//         return result.reverse().toString(); // Переворачиваем результат
//     }
// }

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4)); // Output: 2
        System.out.println(solution.mySqrt(8)); // Output: 2
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x; // 0 и 1 возвращают сами себя
        }
        int left = 2, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // Используем long для избежания переполнения
            if (square == x) {
                return mid; // Найден точный корень
            } else if (square < x) {
                left = mid + 1; // Ищем в правой половине
            } else {
                right = mid - 1; // Ищем в левой половине
            }
        }
        return right; // Возвращаем наибольший целый корень
    }
}