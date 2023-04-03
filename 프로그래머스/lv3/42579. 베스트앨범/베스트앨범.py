from collections import defaultdict

def solution(genres, plays):
    songs = {}
    total = defaultdict(int)
    answer = []
    for i in range(len(genres)):
        songs[genres[i]] = defaultdict(int)
    for i in range(len(plays)):
        songs[genres[i]][i] = plays[i]
        total[genres[i]] += plays[i]
    genre = list(v for v,k in sorted(total.items(), key = lambda x: x[1], reverse = True))
    for i in genre:
        answer += list(v for v,k in sorted(list(songs[i].items()),key= lambda x: x[1], reverse = True)[:2])
    
    return answer