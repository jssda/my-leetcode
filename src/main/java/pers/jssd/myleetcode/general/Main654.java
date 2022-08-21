package pers.jssd.myleetcode.general;

/**
 * @author root
 */
public class Main654 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Solution solution = new Solution();
        TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return generated(nums, 0, nums.length - 1);
        }

        public TreeNode generated(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            if (start == end) {
                return new TreeNode(nums[start]);
            }
            int max = nums[start];
            int index = start;
            for (int i = start; i <= end; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    index = i;
                }
            }
            TreeNode treeNode = new TreeNode(nums[index]);
            treeNode.left = generated(nums, start, index - 1);
            treeNode.right = generated(nums, index + 1, end);
            return treeNode;
        }
    }
}
