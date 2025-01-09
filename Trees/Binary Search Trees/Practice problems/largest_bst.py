# Largest BST
# Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with largest number of nodes in it. The largest BST may or may not include all of its descendants.

# general brute force approach is to traverse each node from root and 
# check whether it forms a bst if it forms , then calculate the size of the bst and compare it with the max size of bst found so far
# O(n^2)
from collections import deque
class TreeNode:
    def __init__(self,val):
        self.val=val
        self.left=None
        self.right=None

def buildTree(s):
    if len(s)==0 or s[0]=='N':
        return None
    
    ip=list(map(str,s))
    root=TreeNode(int(ip[0]))
    size=0
    q=deque()
    # append root
    q.append(root)
    size+=1
    i=1
    while size>0 and i<len(ip):
        curNode=q.popleft()
        size-=1
        curVal=ip[i]
        if curVal!='N':
            curNode.left=TreeNode(int(curVal))
            q.append(curNode.left)
            size+=1
        i+=1
        if i>=len(ip):
            break
        curVal=ip[i]
        if curVal!='N':
            curNode.right=TreeNode(int(curVal))
            q.append(curNode.right)
            size+=1
        i+=1
    return root

def inorder(root):
    if root is None:
        return
    inorder(root.left)
    print(root.val,end=" ")
    inorder(root.right)

# Brute force approach
# def isBST(root):
#     if root is None:
#         return True
#     if root.left is not None and root.left.val>root.val:
#         return False
#     if root.right is not None and root.right.val<root.val:
#         return False
#     return isBST(root.left) and isBST(root.right)

# def size(root):
#     if root is None:
#         return 0
#     return size(root.left)+1+size(root.right)

# def largestBSTBrute(root):
#     if root is None:
#         return 0
#     if isBST(root):
#         return size(root)
#     return max(largestBSTBrute(root.left),largestBSTBrute(root.right))

def largestBST(root):
    def helper(node):
        if not node:
            return True,0,float('inf'),float('-inf')
        left_is_bst,left_size,left_min,left_max=helper(node.left)
        right_is_bst,right_size,right_min,right_max=helper(node.right)

        # check if current subtree is a bst
        if left_is_bst and right_is_bst and left_max<node.val<right_min:
            size=left_size+right_size+1
            return True,size,min(left_min,node.val),max(right_max,node.val)
        return False,max(left_size,right_size),0,0
    
    _,largest_bst_size,_,_=helper(root)
    return largest_bst_size

s=["6","7","3","N","2","2","4"]
root=buildTree(s)
inorder(root)
print()
# print(largestBSTBrute(root)) # 3
print(largestBST(root)) # 3