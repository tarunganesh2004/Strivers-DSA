s="enstggtsne"

def f(i,j):
    if i>=j:
        return True
    if s[i]!=s[j]:
        return False
    return f(i+1,j-1)

print(f(0,len(s)-1))

def f1(i):
    if i>=len(s)//2: return True
    if s[i]!=s[len(s)-i-1]:
        return False
    
    return f1(i+1)

print(f1(0))