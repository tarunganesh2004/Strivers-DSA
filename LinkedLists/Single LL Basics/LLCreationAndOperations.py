class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
    
    # insert at the beginning
    def insert_at_beginning(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    # insert at the end
    def insert_at_end(self,data):
        new_node=Node(data)
        if self.head is None:
            self.head=new_node
            return
        
        last=self.head
        while last.next:
            last=last.next
        last.next=new_node

    # insert one by one 
    def insert(self, data):
        if self.head is None:
            self.head = Node(data)
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = Node(data)
        
    
    # insert at a specific position
    def insert_at_position(self,data,pos):
        new_node=Node(data)
        if pos==0: # insert at the beginning
            new_node.next=self.head
            self.head=new_node
            return
        
        temp=self.head
        count=0
        while temp is not None and count<pos-1:
            temp=temp.next
            count+=1
        
        if temp is None:
            print("Position out of bounds")
            return
        
        new_node.next=temp.next
        temp.next=new_node

    # delete a node by value
    def delete_node_by_value(self, key):
        temp = self.head

        if temp is not None:
            if temp.data == key:
                self.head = temp.next
                temp = None
                return
        
        while temp is not None:
            if temp.data == key:
                break
            prev = temp
            temp = temp.next
        
        if temp is None:
            print("Value not found in the list")
            return
        
        prev.next = temp.next
        temp = None
    
    # delete a node by position
    def delete_node_by_position(self, pos):
        if self.head is None:
            return
        
        temp = self.head
        
        if pos == 0:
            self.head = temp.next
            temp = None
            return
        
        for i in range(pos - 1):
            temp = temp.next
            if temp is None:
                break
        
        if temp is None or temp.next is None:
            return
        
        next = temp.next.next
        temp.next = None
        temp.next = next

    # search for a node by value
    def search_node_by_value(self, key):
        current = self.head
        while current:
            if current.data == key:
                return True
            current = current.next
        return False
    
    # search for a node by position
    def search_node_by_position(self, pos):
        current = self.head
        count = 0
        while current:
            if count == pos:
                return current.data
            current = current.next
            count += 1
        return None
    
    # delete at the beginning
    def delete_at_beginning(self):
        if self.head is None:
            return
        self.head = self.head.next
    
    # delete at the end
    def delete_at_end(self):
        if self.head is None:
            return
        
        if self.head.next is None:
            self.head = None
            return
        
        second_last = self.head
        while(second_last.next.next):
            second_last = second_last.next
        
        second_last.next = None