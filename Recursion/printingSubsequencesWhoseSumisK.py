# printing subsequences whose sum is k
# take/not-take

arr=[1,2,1]
target=2

# def f(i,sub,arr,cur_sum):
#     if i==len(arr):
#         if cur_sum==target:
#             print(sub)
#         return
#     sub.append(arr[i])
#     cur_sum+=arr[i]
#     f(i+1,sub,arr,cur_sum)

#     sub.pop()
#     cur_sum-=arr[i]
#     f(i+1,sub,arr,cur_sum)

# f(0,[],arr,0)

# print any subsequence whose sum is k
# technique to print only one answer
def f(i,sub,arr,cur_sum):
    if i==len(arr):
        # condition satisfied
        if cur_sum==target:
            print(sub)
            return True
        else: 
            return False
        
    sub.append(arr[i])
    cur_sum+=arr[i]
    if(f(i+1,sub,arr,cur_sum)):
        return True
    

    cur_sum -= arr[i]
    sub.pop()

    # not pick
    if f(i+1,sub,arr,cur_sum):
        return True
    return False

f(0,[],arr,0)

# count the subsequences with sum=k
count=0
def f1(i,arr,cur_sum):
    if cur_sum>target:
        return 0
    if i==len(arr):
        # condition satisfied
        if cur_sum==target:
            return 1
        else: 
            return 0
        
    cur_sum+=arr[i]

    l=f1(i+1,arr,cur_sum)

    cur_sum-=arr[i]

    r=f1(i+1,arr,cur_sum)

    return l+r
print(f1(0,arr,0))