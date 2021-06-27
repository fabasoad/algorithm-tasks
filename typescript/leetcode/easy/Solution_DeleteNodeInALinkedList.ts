{
  class ListNode {
    val: number;
    next: ListNode | null;
    constructor(val?: number, next?: ListNode | null) {
      this.val = (val===undefined ? 0 : val);
      this.next = (next===undefined ? null : next);
    }
  }

  function deleteNode(root: ListNode | null): void {
    if (root != null) {
      root.val = root.next?.val || 0;
      root.next = root.next?.next || null;
    }
  }

  let node1: ListNode = new ListNode(5, new ListNode(1, new ListNode(9)));
  let input1: ListNode = new ListNode(4, node1);

  deleteNode(node1);
  console.log(input1);
}
