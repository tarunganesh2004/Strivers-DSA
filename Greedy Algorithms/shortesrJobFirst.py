# Shortest Job First (SJF) Scheduling Algorithm

arr = [4, 3, 7, 1, 2]


def shortestJobFirst(arr):
    n = len(arr)
    arr.sort()  # Sort by burst time (SJF)

    total_waiting_time = 0
    current_wait = 0

    for i in range(n - 1):  # Last process has 0 waiting time
        current_wait += arr[i]
        total_waiting_time += current_wait

    average_waiting_time = total_waiting_time / n
    return average_waiting_time


print("Average Waiting Time:", shortestJobFirst(arr))
