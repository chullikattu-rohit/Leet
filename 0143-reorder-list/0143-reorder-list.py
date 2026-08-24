# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return
        fast,slow=head,head
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next
        b=self.reverseList(slow.next)
        a=head
        slow.next=None
        dummy=ListNode(0)
        dummy.next=head
        temp=dummy
        while a or b:
            if a:
                temp.next=a
                a=a.next
                temp=temp.next
            if b:
                temp.next=b
                b=b.next
                temp=temp.next
    def reverseList(self, head: Optional[ListNode])->Optional[ListNode]:
        cur=head;
        prev=None;
        while cur:
            nextnode=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nextnode;
        return prev;