arr=[2,3,4,1,2]

def rev(l,r):
    if l>=r:
        return
    arr[l],arr[r]=arr[r],arr[l]
    rev(l+1,r-1)

rev(0,len(arr)-1)
print(arr)  

def rev1(i,arr,n):
    if i>=n//2:
        return
    arr[i],arr[n-i-1]=arr[n-i-1],arr[i]
    rev1(i+1,arr,n)

rev1(0,arr,len(arr))
print(arr)