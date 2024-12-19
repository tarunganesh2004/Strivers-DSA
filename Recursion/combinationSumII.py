arr=[10,1,2,7,6,1,5]
t=8
r=[]

arr.sort()
s=set()
# similar to combination sum , but here we use set to remove duplicates
        def f(ind,t,sub,arr,s):
            if t==0:
                s.add(tuple(sub))
                return
            if ind==len(arr) or t<0:
                return
            
            if arr[ind]<=t:
                sub.append(arr[ind])
                f(ind+1,t-arr[ind],sub,arr,s)
                sub.pop()

            f(ind+1,t,sub,arr,s)

f(0,t,[],arr,s)
l=[list(c) for c in s]
print(l)
