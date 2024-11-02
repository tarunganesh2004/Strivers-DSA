arr=[3,1,2,4,1,5,2,6,4]
n=len(arr)

def merge(arr,low,mid,high):
    L=arr[low:mid+1]
    R=arr[mid+1:high+1]

    i=0
    j=0
    k=low

    while i<len(L) and j<len(R):
        if L[i]<=R[j]:
            arr[k]=L[i]
            i+=1
        else:
            arr[k]=R[j]
            j+=1

        k+=1
    
    while i<len(L):
        arr[k]=L[i]
        i+=1
        k+=1
    
    while j<len(R):
        arr[k]=R[j]
        j+=1
        k+=1


def mergeSort(arr,low,high):  
    if low>=high:
        return
    mid=low+(high-low)//2
    mergeSort(arr,low,mid)
    mergeSort(arr,mid+1,high)
    merge(arr,low,mid,high)

mergeSort(arr,0,n-1)
print(arr)