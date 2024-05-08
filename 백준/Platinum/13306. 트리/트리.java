import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] par;
        Stack<int[]> qList = new Stack<>();
        Stack<String> ans = new Stack<>();

        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        par = new int[N + 1];

        for (int i = 1; i <= N - 1; i++) {
            int parNode = scanner.nextInt();
            par[i + 1] = parNode;
        }

        int cnt = N - 1 + Q;
        while (cnt-- > 0) {
            int x = scanner.nextInt();
            if (x == 0) {
                int b = scanner.nextInt();
                qList.push(new int[]{0, b, par[b]});
                par[b] = b;
            } else {
                int c = scanner.nextInt();
                int d = scanner.nextInt();
                qList.push(new int[]{1, c, d});
            }
        }

        while (!qList.empty()) {
            int[] top = qList.peek();
            if (top[0] == 1) {
                int c = top[1];
                int d = top[2];
                if (doFind(par, c) == doFind(par, d))
                    ans.push("YES");
                else
                    ans.push("NO");
            } else {
                int parVal = qList.peek()[2];
                int child = qList.peek()[1];
                doUnion(par, child, parVal);
            }
            qList.pop();
        }

        while (!ans.empty()) {
            System.out.println(ans.peek());
            ans.pop();
        }
    }

    static int doFind(int[] par, int x) {
        if (x == par[x])
            return x;
        return par[x] = doFind(par, par[x]);
    }

    static void doUnion(int[] par, int a, int b) {
        a = doFind(par, a);
        b = doFind(par, b);
        if (a == b)
            return;
        par[a] = b;
    }
}