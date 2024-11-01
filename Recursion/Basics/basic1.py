# print name 5 times

# name="Tarun"
# count=0
# def print_name():
#     global count
#     if count==5:
#         return
#     print(name)
#     count+=1
#     print_name()

# print_name()

# print n times using recursion

# def print_n(i,n):
#     if i>n:
#         return
#     print("TG")
#     # i+=1
#     print_n(i+1,n)

# print_n(1,5)


# print linearly frpm 1 to n

# def print_n(i,n):
#     if i>n:
#         return
#     print(i)
#     print_n(i+1,n)

# print_n(1,5)

# print from n to 1

# def print_n(i,n):
#     if i<1:
#         return
#     print(i)
#     print_n(i-1,n)

# print_n(5,1)

# # print from 1 to n (dont use + operator)

# def f(i,n):
#     if i<1:
#         return
#     f(i-1,n)
#     print(i)

# f(3,3) # f(n,n)

# print n to 1 (dont use - operator)

def f(i,n):
    if i<1:
        return
    print(i)
    f(i-1,n)

f(50,50)