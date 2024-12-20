# Search in a Rotated Sorted Array II(with duplicates)

# Array contains duplicates

# comparing to the rotated sorted array I problem , it fails in the case where arr[low]==arr[mid]==arr[high]
# Ex: [3,1,2,3,3,3,3] target=2
# In this case we can't decide which half is sorted
# So we need to add an additional check to handle this case
# If arr[low]==arr[mid]==arr[high] we can't decide which half is sorted
# So we can shrink the search space
# We can do this by decrementing high and incrementing low

arr=[3,1,2,3,3,3,3]
target=2

def SearchInRotatedArrayII(arr,target):
    # approach is to shrink the search space by half
    n=len(arr)
    low=0
    high=n-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]==target:
            return mid
        
        if arr[low]==arr[mid]==arr[high]:
            low+=1
            high-=1
            continue

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

print(SearchInRotatedArrayII(arr,target))