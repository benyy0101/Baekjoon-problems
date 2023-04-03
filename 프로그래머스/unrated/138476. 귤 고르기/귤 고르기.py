from collections import Counter
def solution(k, tangerine):
    answer = 0
    x = 0
    for i,j in Counter(tangerine).most_common(k):
        x += j
        answer += 1
        if x >= k:
            return answer
    