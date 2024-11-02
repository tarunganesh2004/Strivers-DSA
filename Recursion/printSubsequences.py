arr=[3,1,2]
# arr.sort()
# take not take approach on indices

def f(ind,sub,arr):
    if ind>=len(arr):
        if len(sub)==0:
            print('Empty')
            return
        for i in sub:
            print(i,end=' ')
        print()
        return
    # f(ind + 1, sub, arr) # to print in reverse order
    sub.append(arr[ind])
    f(ind+1,sub,arr)
    sub.pop()
    f(ind+1,sub,arr)

f(0,[],arr) 