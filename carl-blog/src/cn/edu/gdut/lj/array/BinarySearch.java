package cn.edu.gdut.lj.array;

import java.util.Scanner;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class BinarySearch {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        // sc.hasNext()：扫描器当前缓存里存在非空标志返回true，等待输入时该方法阻塞，不从缓存中拿出任何东西
        while (SC.hasNext()) {
            // sc.nextLine()：只会将扫描器当前缓存中的第一行拿出，以换行符（"\n"）为界，解析为String
            String[] numsStr = SC.nextLine().split("\\s+");
            // sc.nextInt()：只会将扫描器当前缓存中的第一个非空标志拿出，以空格（" "）为界，解析为int
            int target = SC.nextInt();
            SC.nextLine();
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            System.out.println(binarySearch(nums, target));
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int light = 0, right = nums.length - 1;
        while (light <= right) {
            int middle = (light + right) >> 1;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                light = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
