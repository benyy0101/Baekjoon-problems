def solution(price, money, count):
    answer = -1
    total = [n for n in range(price,count*price+1,price)]
    answer = sum(total) - money
    
    if answer <= 0:
        return 0
    else:
        return answer