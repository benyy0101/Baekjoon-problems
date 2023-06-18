def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        temp = ''
        
        str1 = bin(arr1[i]).replace('0b','')
        str1 = '0' * (n - len(str1)) + str1
        str2 = bin(arr2[i]).replace('0b','')
        str2 =  '0' * (n - len(str2)) + str2
        
        for j in range(n):
            if str1[j] == '1' or str2[j] == '1':
                temp += '#'
            else:
                temp += ' '
        answer.append(temp)
            
    return answer