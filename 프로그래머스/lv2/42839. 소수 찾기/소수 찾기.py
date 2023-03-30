from itertools import permutations

def solution(numbers):
    
    answer = 0
    nominee = set()
    for i in range(1,len(numbers)+1):
        temp = list(permutations(list(numbers), i))
        for j in temp:
            if j not in nominee:
                nominee.add(int(''.join(j)))
    
    for case in nominee:
        if isPrime(case):
            print(case)
            answer += 1
    return answer

def isPrime(n):
    if n == 1 or n == 0:
        return False
    
    for i in range(2, n):
        if n % i == 0:
            return False
    return True