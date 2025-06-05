# Cycle in Undirected Graph using DFS

edges=[[0, 1], [1, 2], [2, 0], [1, 3]]

def hasCycle(v, edges):
    graph = [[] for _ in range(v)]
    for u, w in edges:
        graph[u].append(w)
        graph[w].append(u)  # Undirected graph, add both directions

    vis = [False] * v
    parent = [-1] * v  # To keep track of the parent node

    def dfs(node):
        vis[node] = True
        for neighbor in graph[node]:
            if not vis[neighbor]:  # If the neighbor hasn't been visited
                parent[neighbor] = node
                if dfs(neighbor):
                    return True
            elif neighbor != parent[node]:  # If the neighbor is visited and is not the parent
                return True
        return False

    for i in range(v):
        if not vis[i]:
            if dfs(i):
                return True
    return False

print("Cycle exists" if hasCycle(4, edges) else "No cycle")