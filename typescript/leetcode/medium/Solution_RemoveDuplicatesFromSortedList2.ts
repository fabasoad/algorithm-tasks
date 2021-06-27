{
  class ListNode {
    val: number;
    next: ListNode | null;
    constructor(val?: number, next?: ListNode | null) {
      this.val = (val===undefined ? 0 : val);
      this.next = (next===undefined ? null : next);
    }
  }

  function findNext(head: ListNode | null, n: number): ListNode | null {
    let node: ListNode | null = head;

    while (node != null && node.val === n) {
      node = node.next;
    }

    return node;
  }

  function deleteDuplicates(head: ListNode | null): ListNode | null {
    let head1: ListNode | null = new ListNode(0, head);
    let node: ListNode | null = head1;

    while (node != null) {
      while (node.next != null && node.next.next != null && node.next.val === node.next.next.val) {
        node.next = findNext(node.next, node.next.val);
      }
      node = node.next;
    }

    head1 = head1.next;
    return head1;
  }

  let input1: ListNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
  let input2: ListNode = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
  let input: ListNode = input1;

  console.log(deleteDuplicates(input));
}
