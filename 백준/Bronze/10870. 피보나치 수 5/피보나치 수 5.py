import sys

def fib(n):
    if n == 1:
        return 1
    elif n == 0:
        return 0
    else:
        return fib(n-1) + fib(n-2)


if __name__ == '__main__':
    N = int(sys.stdin.readline())
    answer = fib(N)
    print(answer)