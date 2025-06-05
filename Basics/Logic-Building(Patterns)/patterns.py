n=5

# square pattern
def square(n):
    for i in range(n):
        for j in range(n):
            print("*",end=" ")
        print()

# square(n)

# right traingle
def right_triangle(n):
    for i in range(n):
        for j in range(i+1):
            print("*",end=" ")
        print()

# right_triangle(n)

def right_triangle_numbers(n):
    # num=1/
    for i in range(n):
        for j in range(i+1):
            print(j+1,end=" ")
        print()

# right_triangle_numbers(n)

def right_triangle_another(n):
    c='A'
    for i in range(n):
        for j in range(i+1):
            print(c,end=" ")
        c=chr(ord(c)+1)
        print()

    # another
    for i in range(n):
        ch='A'
        for j in range(i+1):
            print(ch,end=" ")
            ch=chr(ord(ch)+1)
        print()

# right_triangle_another(n)

def reverse_right_triangle(n):
    for i in range(n):
        for j in range(n-i):
            print("*",end=" ")
        print()

    # with numbers
    for i in range(n):
        for j in range(n-i):
            print(j+1,end=" ")
        print()
reverse_right_triangle(n)

