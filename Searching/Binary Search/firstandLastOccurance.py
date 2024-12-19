from re import L


arr=[2,4,6,8,8,8,11,13]
x=8

def bruteForce(arr,x):
    n=len(arr)
    first=-1
    last=-1
    for i in range(n):
        if arr[i]==x:
            if first==-1:
                first=i
            last=i
        
    return [first,last]

def lowerBound(arr,x): 
    # first occurance is the smallest index such that arr[ind]==x(i.e lower bound)
    n=len(arr)
    low=0
    high=n-1
    ans=-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]==x:
            ans=mid
            high=mid-1
        elif arr[mid]<x:
            low=mid+1
        else:
            high=mid-1

    return ans

def upperBound(arr,x):
    # last occurance is the largest index such that arr[ind]==x(i.e upper bound)
    n=len(arr)
    low=0
    high=n-1
    ans=-1
    while low<=high:
        mid=low+(high-low)//2
        if arr[mid]==x:
            ans=mid
            low=mid+1
        elif arr[mid]<x:
            low=mid+1
        else:
            high=mid-1

    return ans

def firstAndLastOccuranceUsingBounds(arr,x):
    first=lowerBound(arr,x)
    if first==-1:
        return [-1,-1]
    
    return [first,upperBound(arr,x)]

# Optimal way without using lower and upper bounds
def firstandlastOccurance(arr,x):
    # Using plain binary search
    n=len(arr)
    low=0
    high=n-1
    first=-1
    # first occurance
    while low<=high:
        mid=(low+high)//2
        if arr[mid]==x:
            first=mid
            # here to find the first occurance we need to move to the left
            high=mid-1
        elif arr[mid]<x:
            low=mid+1
        else:
            high=mid-1

    # last occurance
    low=0
    high=n-1
    last=-1
    while low<=high:
        mid=(low+high)//2
        if arr[mid]==x:
            last=mid
            # here to find the last occurance we need to move to the right
            low=mid+1
        elif arr[mid]<x:
            low=mid+1
        else:
            high=mid-1
    
    return [first,last]

print(bruteForce(arr,x))
print(firstAndLastOccuranceUsingBounds(arr,x))
print(firstandlastOccurance(arr,x))