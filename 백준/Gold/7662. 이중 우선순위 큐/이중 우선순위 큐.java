import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    // 1. 우선순위큐 2개 + 삭제된 데이터 검증
    // 2. SMMH 구현하기
    // 1번째 시도 : 1번 에서 삭제검증을 무식하게 배열의 remove 사용해서 시도 (시간초과예상됨) -> 1쿼리에서 시간초과 확인
    // 2번째 시도 : 1번 에서 삭제검증때 시간복잡도를 낮춰야함..

    static Map<Integer, int[]> hash;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int Q = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            hash = new HashMap<>();

            for (int j = 0; j < Q; j++) {
                st = new StringTokenizer(br.readLine());

                String type = st.nextToken();
                int data = Integer.parseInt(st.nextToken());

                if (type.equals("I")) {
                    minHeap.add(data);
                    maxHeap.add(data);
                } else if (type.equals("D")) {
                    if (data > 0) {
                        while (!maxHeap.isEmpty()) {
                            int p = maxHeap.poll();

                            if (hash.get(p) != null) {
                                int[] h = hash.get(p);

                                if (h[0] > 0) {
                                    h[0]--;
                                    hash.put(p, h);
                                } else {
                                    h[1]++;
                                    hash.put(p, h);
                                    break;
                                }
                            } else {
                                int[] h = {0, 1};
                                hash.put(p, h);
                                break;
                            }
                        }
                    } else {
                        while (!minHeap.isEmpty()) {
                            int p = minHeap.poll();

                            if (hash.get(p) != null) {
                                int[] h = hash.get(p);

                                if (h[1] > 0) {
                                    h[1]--;
                                    hash.put(p, h);
                                } else {
                                    h[0]++;
                                    hash.put(p, h);
                                    break;
                                }
                            } else {
                                int[] h = {1, 0};
                                hash.put(p, h);
                                break;
                            }
                        }
                    }
                }
            }



            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                while (!maxHeap.isEmpty()) {
                    int p = maxHeap.peek();

                    if (hash.get(p) != null) {
                        int[] h = hash.get(p);

                        if (h[0] > 0) {
                            h[0]--;
                            hash.put(p, h);
                            maxHeap.poll();
                        } else {
                            sb.append(p).append(" ");
                            break;
                        }
                    } else {
                        sb.append(p).append(" ");
                        break;
                    }
                }

                while (!minHeap.isEmpty()) {
                    int p = minHeap.peek();

                    if (hash.get(p) != null) {
                        int[] h = hash.get(p);

                        if (h[1] > 0) {
                            h[1]--;
                            hash.put(p, h);
                            minHeap.poll();
                        } else {
                            sb.append(p);
                            break;
                        }
                    } else {
                        sb.append(p);
                        break;
                    }
                }
            }

            if (minHeap.isEmpty() || maxHeap.isEmpty()) {
                sb.append("EMPTY");
            }

            if (i + 1 != T) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}