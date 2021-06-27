{
  class ListNode {
    val: number;
    next: ListNode | null;
    constructor(val?: number, next?: ListNode | null) {
      this.val = (val===undefined ? 0 : val);
      this.next = (next===undefined ? null : next);
    }
  }

  function deleteDuplicates(head: ListNode | null): ListNode | null {
    let node: ListNode | null = head;

    while (node != null) {
      while (node.next != null && node.next.val === node.val) {
        node.next = node.next.next;
      }
      node = node.next;
    }

    return head;
  }

  let input1: ListNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))));
  let input2: ListNode = new ListNode(1, new ListNode(1, new ListNode(1)));
  let input: ListNode = input2;

  console.log(deleteDuplicates(input));
}
