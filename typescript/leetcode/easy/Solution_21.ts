{
  // https://leetcode.com/problems/merge-two-sorted-lists/
  class ListNode {
    val: number
    next: ListNode | null

    constructor(val?: number, next?: ListNode | null) {
      this.val = (val === undefined ? 0 : val)
      this.next = (next === undefined ? null : next)
    }
    
    public toString = (): string => {
      let curr: ListNode | null = this
      let res: string = ''
      while (curr != null) {
        res += `${curr.val}, `
        curr = curr.next
      }
      return res
    }
  }

  function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
    if (list1 == null) {
      if (list2 == null) {
        return null
      }
    }
    if (list2 == null) {
      if (list1 == null) {
        return null
      }
    }
    let head: ListNode | null = null
    let current: ListNode | null = null
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        if (current == null) {
          current = new ListNode(list1.val)
        } else {
          current.next = new ListNode(list1.val)
          current = current.next
        }
        list1 = list1.next
      } else {
        if (current == null) {
          current = new ListNode(list2.val)
        } else {
          current.next = new ListNode(list2.val)
          current = current.next
        }
        list2 = list2.next
      }
      if (head == null) {
        head = current
      }
    }
    if (list1 != null) {
      if (current == null) {
        current = list1
        head = current
      } else {
        current.next = list1
      }
    }
    if (list2 != null) {
      if (current == null) {
        current = list2
        head = current
      } else {
        current.next = list2
      }
    }
    return head
  }

  const actual: ListNode | null = mergeTwoLists(
      new ListNode(1, new ListNode(2, new ListNode(4))),
      new ListNode(1, new ListNode(3, new ListNode(4)))
  )
  console.log(actual?.toString())
}