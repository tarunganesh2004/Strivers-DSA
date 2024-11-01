# sum of first n numbers (parameterized and non parameterized)

n=3
# parameterized
def f(i,sum):
    if i<1:
        print(sum)
        return
    f(i-1,sum+i)

f(n,0)

# functional approach
def f1(n):
    if n==0:
        return 0
    return n+f1(n-1)

print(f1(n))