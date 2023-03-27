import sys

def solution(wallpaper):
    answer = []
    lux, luy, rdx, rdy = sys.maxsize, sys.maxsize,-1,-1
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                lux = min(lux, i)
                luy = min(luy,j)
                rdx = max(rdx, i+1)
                rdy = max(rdy, j+1)
                
    answer = [lux, luy, rdx,rdy]
                
    return answer