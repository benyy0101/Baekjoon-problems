def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        answer.append(bin_or(to_bin(arr1[i],n),to_bin(arr2[i], n)))
        
    return answer

def to_bin(n,size):
    num = ''
    while n > 0:
        rem = n % 2
        num += str(rem)
        n //= 2
        
    while len(num) < size:
        num += '0'
    return num[::-1]

def bin_or(a,b):
    result = ''
    for i in range(len(a)):
        temp1 = a[i]
        temp2 = b[i]
        if temp1 == '1' or temp2 == '1':
            result += '#'
        else:
            result += ' '
    return result