#!/usr/bin/env python
# coding: utf-8

# In[1]:


x=5
y=8
print(x+y)
print(x-y)
print(x%y)
print(x*y)


# In[4]:


x=int(input("enter a number:"))
y=x*x
print("squre is:",y)
z=x*x*x
print("cube is :",z)
a=x**(1/2)
print("square root is:",a)


# In[5]:


x=int(input("enter a 1st number:"))
y=int(input("enter a 2nd number:"))
z=int(input("enter a 3rd number:"))
a=x+y+z/3
print(a)


# In[6]:


b=int(input("enter breadth:"))
h=int(input("enter a height:"))
c=(1/2)*b*h
print(c)


# In[7]:


r=int(input("enter radius:"))
h=int(input("enter a height:"))
c=3.14*r*r*h
print(c)


# In[8]:


p=int(input("enter principal:"))
r=int(input("enter a rate:"))
t=int(input("enter time:"))
c=(p*r*t)/100
print(c)


# In[9]:


c=int(input("enter celsius:"))
f=(c*9/5)+32
print(f)


# In[ ]:


f=int(input("enter celsius:"))
c=(f-32)*5/9
print(c)


# In[13]:


a=int(input("enter its sq1,rect2,circle3"))
if a==1:
    s=int(input("enter side of square:"))
    c=s*s
    print(c)
if a==2:
    l=int(input("enter length"))
    b=int(input("enter breadth"))
    k=l*b
    print(k)
if a==3:
    r=int(input("enter radius"))
    g=r*r*3.14
    print(g)
else:
    print("error")


# In[17]:


a=9
b=8
t=a
a=b
b=t
print(a,b)


# In[18]:


a=8
b=5
a,b=b,a
print(a,b)


# In[19]:


a=int(input("enter a number:"))
b=int(input("enter a number:"))
c=int(input("enter a number:"))
if a>b and a>c:
     print("a is greater")
elif b>c and b>a:
    print("b is greater")
elif c>b and c>a:
    print("c is greater")
else: 
    print("they are equal.")


# In[21]:


a=int(input("enter a yr:"))
if (a%400==0 or a%4==0 and a%100!=0): 
    print("its ly")
else:
    print("not a ly")


# In[24]:


a=int(input("enter a s1:"))
b=int(input("enter a s2:"))
c=int(input("enter a s3:"))
if (a+b>c) or (b+c>a) or (a+c>b):
    print("trinagle valid")
else:
    print("not valid")


# In[32]:


a=int(input("enter a no."))
for i in range(1,11):
    print(a*i)
        


# In[34]:


#factorial
a=int(input("enter a no."))
g=1
for i in range (1,a+1):
    g=g*i
print(g)


# In[36]:


#base and power
a=int(input("enter a base."))
b=int(input("enter a power."))
g=1
for i in range(1,1+b):
    g=a*g
print(g)


# In[8]:


sum=0
for i in range(1,100,2):
    sum+=i
print(sum)


# In[42]:


#10.	To display all prime numbers from 1 to n.
n = int(input("Enter a number: "))

for i in range(2, n+1):
    is_prime = True
    for j in range(2, i):
        if i % j == 0:
            is_prime = False
            break
    if is_prime:
        print(i)


# In[1]:


a=int(input("enter a number;"))
for i in range(2,a+1):
    is_prime = True
    for j in range (2,i):
        if i%j==0:
            is_prime=False
            break
    if is_prime:
        print(i)
    


# In[55]:


p=int(input("enter a no."))
n=int(input("enter a no."))
r=int(input("enter a no."))
t=int(input("enter a no."))
d=(1+r/n)
e=n*t
c=d**e
b=p*c
print(b)


# In[9]:


#amstrong
num = int(input("Enter a number: "))
order = len(str(num))
sum = 0
temp = num

while temp > 0:
    digit = temp % 10
    sum += digit ** order
    temp //= 10

if num == sum:
    print(num, "is an Armstrong number")
else:
    print(num, "is not an Armstrong number")


# In[10]:


#fabonaki
n = int(input("Enter the number of terms: "))

# first two terms
a, b = 0, 1

# check if the number of terms is valid
if n <= 0:
   print("Please enter a positive integer")
elif n == 1:
   print("Fibonacci sequence upto", n, ":")
   print(a)
else:
   print("Fibonacci sequence:")
   for i in range(n):
       print(a)
       c = a + b
       # update values
       a = b
       b = c


# In[11]:


#or
def fibonacci(n):
    a, b = 0, 1
    series = []
    while a < n:
        series.append(a)
        a, b = b, a+b
    return series
fib_series=fibonacci(200)
print(fib_series)


# In[ ]:




