def find_duplicates(arr):
    n = len(arr)

    print("Duplicate elements are:", end=" ")

    # Iterate through the array
    for i in range(n):
        index = abs(arr[i]) % n  # Get the absolute value within the range

        # If the value at index is already greater than or equal to n, it's a duplicate
        if arr[index] >= n:
            # Check if it's already been printed by ensuring it's still less than 2*n
            if arr[index] < 2 * n:
                print(index, end=" ")

            # Mark it as processed by adding n again
            arr[index] += n
        else:
            # Mark the element as visited by adding n
            arr[index] += n


# Example usage
arr = [1, 1, 1]
find_duplicates(arr)
