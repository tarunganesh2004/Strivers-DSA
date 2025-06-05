# Check cycle in a directed graph using DFS

edges = [[0, 1], [1, 2], [2, 0]]

def hasCycle(v,edges):
    graph=[[] for _ in range(v)]
    for u, w in edges:
        graph[u].append(w)

    vis=[False]*v
    recStack=[False]*v # to keep track of the nodes in the current path
    def dfs(node):
        vis[node] = True
        recStack[node] = True

        for neighbor in graph[node]:
            if not vis[neighbor]:
                if dfs(neighbor):
                    return True
            elif recStack[neighbor]:
                return True
        recStack[node] = False
        return False
    
    for i in range(v):
        if not vis[i]:
            if dfs(i):
                return True
    return False

print("Cycle exists" if hasCycle(3, edges) else "No cycle")