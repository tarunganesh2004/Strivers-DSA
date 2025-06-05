# Count the Paths from Source to Destination (Directed acyclic graph)
# https://www.geeksforgeeks.org/problems/count-the-paths4332/1

from functools import lru_cache


edges=[[0,1], [0,3], [2,0], [2,1], [1,3]]
V = 4
src = 2
dest = 3

def countPaths(edges, V, src, dest):
    graph = [[] for _ in range(V)]
    for u, v in edges:
        graph[u].append(v)

    @lru_cache(maxsize=None)
    def dfs(node,path):
        if node == dest:
            print(f"Path found: {path} -> {node}")
            return 1
        count = 0
        for neighbor in graph[node]:

            count += dfs(neighbor,path+f" -> {node}")
        return count

    return dfs(src,"")

countPaths(edges, V, src, dest)