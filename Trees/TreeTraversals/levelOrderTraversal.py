# Inorder Traversal


class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def build_tree(self, arr):
        if not arr or arr[0] == "N":
            return None

        root = TreeNode(arr[0])
        i = 1
        q = []
        q.append(root)
        while i < len(arr) and q:
            node = q.pop(0)
            if arr[i] != "N":
                node.left = TreeNode(arr[i])
                q.append(node.left)
            i += 1
            if i >= len(arr):
                break
            if i < len(arr) and arr[i] != "N":
                node.right = TreeNode(arr[i])
                q.append(node.right)
            i += 1

        return root

    def levelOrder(self, root):
        if not root:
            return []
        res = []
        q = []
        q.append(root)
        while q:
            node = q.pop(0)
            res.append(node.data)
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)

        return res


arr = [1, 2, 3, 4, 5]
root = TreeNode(arr[0])
root = root.build_tree(arr)
print(root.levelOrder(root))  # type: ignore # [4, 2, 5, 1, 3]
