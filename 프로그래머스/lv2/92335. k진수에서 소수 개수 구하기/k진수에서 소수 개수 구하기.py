import math

def solution(n, k):
    answer = 0
    temp = prime(n,k)
    target = [int(i) for i in temp.split('0') if len(i) > 0]
    
    for i in target:
        if isPrime(i):
            answer += 1
    return answer

def prime(n,k):
    temp = ''
    while n > 0:
        b = n % k
        temp += str(b)
        n //= k
    return str(temp)[::-1]
        
def isPrime(n):
    if n <= 1:
        return False

    max_div = math.floor(math.sqrt(n))
    for i in range(2, 1 + max_div):
        if n % i == 0:
            return False
    return True
        
        
    
                
        
        