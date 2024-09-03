import sys
import itertools

if __name__ == '__main__':
    while True:
        lines = list(map(int, sys.stdin.readline().split()))

        if len(lines) == 1 or lines[0] == 0: break

        length = lines.pop(0)

        for comb in itertools.combinations(lines, 6):
            print(" ".join(list(map(str, comb))))
        print()