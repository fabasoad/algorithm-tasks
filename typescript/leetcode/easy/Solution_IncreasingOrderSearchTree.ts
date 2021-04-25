class TreeNode897 {
  val: number
  left: TreeNode897 | null
  right: TreeNode897 | null
  constructor(val?: number, left?: TreeNode897 | null, right?: TreeNode897 | null) {
      this.val = (val===undefined ? 0 : val)
      this.left = (left===undefined ? null : left)
      this.right = (right===undefined ? null : right)
  }
}

function traverse(arr: number[], node: TreeNode897 | null): void {
  if (node == null) {
    return;
  }
  traverse(arr, node.left);
  arr.push(node.val);
  traverse(arr, node.right);
}

function increasingBST(root: TreeNode897 | null): TreeNode897 | null {
  const arr: number[] = [];
  traverse(arr, root);
  console.log(arr);
  let r = new TreeNode897(arr[0]);
  const result = r;
  for (let i = 1; i < arr.length; i++) {
    r.right = new TreeNode897(arr[i]);
    r = r.right;
  }
  return result;
};

// console.log(increasingBST(new TreeNode897(2, null, new TreeNode897(131, null, new TreeNode897(223, null, new TreeNode897(331, null, new TreeNode897(486)))))));
// console.log(increasingBST(new TreeNode897(5, new TreeNode897(3, new TreeNode897(2, new TreeNode897(1)), new TreeNode897(4)), new TreeNode897(6, null, new TreeNode897(8, new TreeNode897(7), new TreeNode897(9))))));