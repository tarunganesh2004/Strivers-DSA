class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
    
class LinkedList:
    def __init__(self):
        self.head=None

    def insert(self,data):
        new_node= Node(data)
        if self.head is None:
            self.head=new_node
        else:
            current=self.head
            while current.next:
                current=current.next
            current.next=new_node # type: ignore
        
    
    # Middle of LL, Tortoise and Hare approach
    def middle(self):
        slow=self.head
        fast=self.head

        while fast and fast.next:
            slow=slow.next # type: ignore
            fast=fast.next.next
        
        return slow.data if slow else None
    
    def printll(self):
        current=self.head
        while current:
            print(current.data,end="->")
            current=current.next
        print("None")

arr=[1,2,3,4,5,6]
ll=LinkedList()
for i in arr:
    ll.insert(i)

ll.printll()
print("Middle of LL is:",ll.middle())