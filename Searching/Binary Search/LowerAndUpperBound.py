def lowerBound(arr,target):
    # lower bound is the smallest index such that arr[ind]>=target
    n=len(arr)
    low=0
    high=n-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]<target:
            low=mid+1
        else:
            high=mid-1
    return low

def upperBound(arr,target):
    # upper bound is the smallest index such that arr[ind]>target
    n=len(arr)
    low=0
    high=n-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]<=target:
            low=mid+1
        else:
            high=mid-1
    return low

arr=[1,2,3,4,5,6,7,8,9,9,11]
target=10
print(lowerBound(arr,target))

target=9
print(upperBound(arr,target)) 