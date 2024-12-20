# Minimum in Rotated Sorted Array

arr=[4,5,6,7,0,1,2]

def findMinimum(arr):
    # identify the sorted half
    n=len(arr)
    low=0
    high=n-1
    ans=float('inf')
    # sorted half may or may not have the minimum element
    while low<=high:
        mid=low+(high-low)//2

        # if the array is already sorted
        if arr[low]<=arr[high]: # this condition is for better TC
            ans=min(ans,arr[low])
            break

        # if left half is sorted , take the smallest from left half and eliminate the left half
        if arr[low]<=arr[mid]:
            ans=min(ans,arr[low])
            low=mid+1
        else:
            ans=min(ans,arr[mid])
            high=mid-1
    # at the end low and high will be pointing to the same element which is the minimum element

    return ans

print(findMinimum(arr))