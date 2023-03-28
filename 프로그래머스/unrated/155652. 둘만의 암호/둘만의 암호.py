def solution(s, skip, index):
    
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    answer = ''
    for i in skip:
        alphabet = alphabet.replace(i,'')
    length = len(alphabet)
    print(alphabet)
    for i in s:
        answer += alphabet[(alphabet.index(i) + index) % length]
    

    return answer