def floor(arr,x):
    # floor is the largest element such that arr[ind]<=x
    n=len(arr)
    ans=-1
    low=0
    high=n-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]<=x:
            ans=arr[mid]
            low=mid+1
        else:
            high=mid-1
    return ans

def ceil(arr,x):
    # ceil is the smallest element such that arr[ind]>=x
    n=len(arr)
    ans=-1
    low=0
    high=n-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]>=x:
            ans=arr[mid]
            high=mid-1
        else:
            low=mid+1
    return ans