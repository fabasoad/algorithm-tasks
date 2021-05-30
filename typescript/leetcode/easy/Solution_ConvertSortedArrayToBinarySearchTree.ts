{
  /**
   * Definition for a binary tree node. */
  class TreeNode108 {
    val: number
    left: TreeNode108 | null
    right: TreeNode108 | null

    constructor(val?: number, left?: TreeNode108 | null, right?: TreeNode108 | null) {
      this.val = (val === undefined ? 0 : val)
      this.left = (left === undefined ? null : left)
      this.right = (right === undefined ? null : right)
    }
  }

  function traverse108(arr: number[], start: number, end: number): TreeNode108 | null {
    if (start > end) {
      return null;
    }
    const mid: number = Math.floor((start + end) / 2);
    const node: TreeNode108 = new TreeNode108(arr[mid]);
    node.left = traverse108(arr, start, mid - 1);
    node.right = traverse108(arr, mid + 1, end);
    return node;
  }

  function sortedArrayToBST(nums: number[]): TreeNode108 | null {
    return traverse108(nums, 0, nums.length - 1);
  }

  console.log(sortedArrayToBST([-10, -3, 0, 5, 9]));
}
