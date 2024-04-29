import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int[][] board;
    static int[][][] dY = new int [][][] {
        {
            {0, 0, 0, 0},
            {0, 1, 2, 3}
        },
        {
            {0, 1, 2, 2},
            {0, 0, 0, -1},
            {0, -1, -2, -2},
            {0, 0, 0, 1},
            {0, 1, 2, 2},
            {0, 0, 0, 1},
            {0, -1, -2, -2},
            {0, 0, 0, -1}
        },
        {
            {0, 1, 1, 2},
            {0, 0, -1, -1},
            {0, 1, 1, 2},
            {0, 0, 1, 1}
        },
        {
            {0, 0, 1, 1}
        },
        {
            {0, 0, 0, 1},
            {0, 1, 2, 1},
            {0, 0, 0, -1},
            {0, 1, 2, 1}
        }
    };

    static int[][][] dX = new int[][][] {
        {
            {0, 1, 2, 3},
            {0, 0, 0, 0}
        },
        {
            {0, 0, 0, 1},
            {0, 1, 2, 2},
            {0, 0, 0, -1},
            {0, -1, -2, -2},
            {0, 0, 0, -1},
            {0, 1, 2, 2},
            {0, 0, 0, 1},
            {0, -1, -2, -2}
        },
        {
            {0, 0, 1, 1},
            {0, 1, 1, 2},
            {0, 0, -1, -1},
            {0 ,1, 1, 2}
        },
        {
            {0, 1, 0, 1}
        },
        {
            {0, 1, 2, 1},
            {0, 0, 0, 1},
            {0, -1, -2, -1},
            {0, 0, 0, -1}
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                //5개의 도형
                for (int k = 0; k < 5; k++) {
                    //회전포함, 대칭추가
                    for (int l = 0; l < dY[k].length; l++) {
                        //System.out.println(k + "번째 도형의 " + l + "번째 회전");

                        int sum = 0;
                        boolean check = false;

                        for (int m = 0; m < 4; m++) {
                            int pY = i + dY[k][l][m];
                            int pX = j + dX[k][l][m];

                            if (pY < 0 || pX < 0 || pY >= N || pX >= M) {
                                check = true;
                                break;
                            }

                            sum += board[pY][pX];
                        }

                        if (!check) {
                            if (result < sum) {
                                result = sum;
                            }
                        }

                        //System.out.println("sum : " + sum);
                    }
                }
            }
        }

        System.out.println(result);
    }
}