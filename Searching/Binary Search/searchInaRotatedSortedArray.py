# Search in a Rotated Sorted Array

# Array contains unique integers

arr=[7,8,9,1,2,3,4,5,6]
target=1

# We can solve this using linear search O(n) but we can do better using binary search O(logn)

def SearchInRotatedArray(arr,target):
    # first step is to identify the sorted half
    n=len(arr)
    low=0
    high=n-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]==target:
            return mid
        
        # identify the sorted half
        # if left half is sorted
        if arr[low]<=arr[mid]:
            if arr[low]<=target and target<=arr[mid]:
                high=mid-1
            else:
                low=mid+1

        # if right half is sorted
        else:
            if arr[mid]<=target and target<=arr[high]:
                low=mid+1
            else:
                high=mid-1

    return -1

print(SearchInRotatedArray(arr,target))