package com.julive.textdemo.dp;

/**
 * 机器人必须走 K 步，最终能来到P位置的方法有多少种
 * Created by jinxianlun
 * on 10/22/21
 */
public class RobotWalk {

    /**
     * N、M、K、P
     *
     * @param N 排成一行的N个位置
     * @param M 机器人在其中的M位置上
     * @param K 机器人必须走 K 步
     * @param P 最终能来到P位置
     */
    public int way1(int N, int M, int K, int P) {
        return process(N, P, M, K);
    }

    private int process(int N, int aim, int cur, int rest) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }

        if (cur == 1) {
            return process(N, aim, 2, rest - 1);
        }

        if (cur == N) {
            return process(N, aim, N - 1, rest - 1);
        }

        return process(N, aim, cur - 1, rest - 1) + process(N, aim, cur + 1, rest - 1);
    }

    public static int way2(int N, int start, int aim, int K) {
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][K];
    }
}
