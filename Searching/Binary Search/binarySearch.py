def binarySearch(arr,target):
    n=len(arr)
    low=0
    high=n-1
    while low<=high:
        mid=high+(low-high)//2
        if arr[mid]==target:
            return mid
        elif arr[mid]<target:
            low=mid+1
        else:
            high=mid-1

    return -1

arr=[1,2,3,4,5,6,7,8,9,10]
target=5
print(binarySearch(arr,target))