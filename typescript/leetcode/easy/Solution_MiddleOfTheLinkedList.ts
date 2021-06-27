{
  class ListNode {
    val: number;
    next: ListNode | null;
    constructor(val?: number, next?: ListNode | null) {
      this.val = (val===undefined ? 0 : val);
      this.next = (next===undefined ? null : next);
    }
  }

  function middleNode(head: ListNode | null): ListNode | null {
    if (head == null) return null;

    let node: ListNode | null = head;
    let count: number = 0;
    while (node != null) {
      node = node.next;
      count++;
    }
    let half: number = Math.ceil(count / 2);
    let result: ListNode | null = head;
    for (let i = (count % 2 === 0 ? 0 : 1); i < half; i++) {
      if (result != null) {
        result = result.next;
      }
    }
    return result;
  }

  let input1: ListNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
  let input2: ListNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

  let input: ListNode = input1;
  console.log(middleNode(input));
}
