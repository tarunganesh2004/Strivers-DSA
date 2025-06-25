# Lemonade Exchange

arr = [5, 5, 5, 10, 20]
arr1 = [5, 5, 10, 10, 20]


def canExchange(arr):
    five = 0
    ten = 0
    for i in range(len(arr)):
        if arr[i] == 5:
            five += 1
        elif arr[i] == 10:
            if five:
                ten += 1
                five -= 1
            else:
                return False
        else:
            if ten and five:
                ten -= 1
                five -= 1
            elif five >= 3:
                five -= 3
            else:
                return False

    return True


print(canExchange(arr))
print(canExchange(arr1))
