n=10

def f(n):
    if n<=1:
        return n
    last=f(n-1)
    slast=f(n-2)

    return last+slast # TC O(2^n)

l=[]
for i in range(n):
    l.append(f(i))
print(' '.join(map(str,l)))