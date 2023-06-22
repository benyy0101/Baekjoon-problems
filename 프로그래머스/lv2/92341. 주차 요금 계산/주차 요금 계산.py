from collections import defaultdict, deque
from math import ceil


def solution(fees, records):
    data = defaultdict(int)
    temp = defaultdict(int)
    for i in records:
        time, car, cmd = i.split()
        car = int(car)
        h,m = map(int,time.split(':'))
        if cmd == 'IN':
            temp[car] = h * 60 + m
        elif cmd == 'OUT':
            data[car] += (h * 60 + m) - temp[car]
            del temp[car]
    for i in temp.keys():
        data[i] += (23 * 60 + 59 - temp[i])
    result = []
    for i in sorted(list(data.keys())):
        cost = fees[1]
        data[i] -= fees[0]
        if data[i] < 0:
            data[i] = 0
        cost += ceil(data[i] / fees[2]) * fees[3]
        result.append(cost)
    return result