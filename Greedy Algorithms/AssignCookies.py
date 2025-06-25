# Assign Cookies

greed=[1,5,3,3,4]
size=[4,2,1,2,1,3]

def assignCookies(greed,size):
    # n=len(greed)
    m=len(size)

    left=0
    right=0
    greed.sort()
    size.sort()

    while left<m:
        if greed[right]<=size[left]:
            right+=1
        left+=1
    
    return right 

print(assignCookies(greed,size))