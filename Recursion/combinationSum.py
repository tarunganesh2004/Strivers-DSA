# Combination Sum
arr=[2,3,6,7]
target=7
res=[]

def f(ind,target,sub,arr,r):
    if ind==len(arr):
        if target==0:
            r.append(sub.copy())
        return
    
    if arr[ind]<=target:
        sub.append(arr[ind])
        f(ind,target-arr[ind],sub,arr,r)
        sub.pop()

    f(ind+1,target,sub,arr,r)

# f(0,target,[],arr)
f(0,target,[],arr,res)
print(res)