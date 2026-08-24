# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k==0 or head==None:
            return head;
        temp=head;
        count=1;
        while temp.next:
            temp=temp.next;
            count+=1;
        k=k%count;
        if k==0:
            return head;
        current=head;
        number=count-k;
        for _ in range(1,number):
            current=current.next;
        temp.next=head;
        head=current.next;
        current.next=None;
        return head;