arr=[3,1,2]
# arr.sort()
# take not take approach on indices

def f(ind,sub,arr):
    if ind>=len(arr):
        for i in sub:
            print(i,end=' ')
        print()
        return
    sub.append(arr[ind])
    f(ind+1,sub,arr)
    sub.pop()
    f(ind+1,sub,arr)

f(0,[],arr) 