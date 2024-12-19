# Count Occurance of a number GFG (https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence)
def countFreq( arr, target):
    # Find the first occurrence of the target
    first_occurrence = firstOccurrence(arr, target)

    # If the target is not found, return 0
    if first_occurrence == -1:
        return 0

    # Find the last occurrence of the target
    last_occurrence = lastOccurrence(arr, target)

    # Return the count of the target
    return last_occurrence - first_occurrence + 1


def firstOccurrence( arr, target):
    # Find the first occurrence of the target
    n = len(arr)
    low, high = 0, n - 1
    ans = -1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            ans = mid
            high = mid - 1  # Move left to find the first occurrence
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return ans


def lastOccurrence(arr, target):
    # Find the last occurrence of the target
    n = len(arr)
    low, high = 0, n - 1
    ans = -1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            ans = mid
            low = mid + 1  # Move right to find the last occurrence
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return ans
