/*
문제 설명
n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.
입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.

입출력 예 #2

+4+1-2+1 = 4
+4-1+2-1 = 4
총 2가지 방법이 있으므로, 2를 return 합니다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Level2_타겟_넘버 {
    public int solution(int[] numbers, int target) {
        int index = 0;
        int sum = numbers[index];

        int answer = 0;
        answer = answer + bfs(numbers, target, index+1, sum);
        answer = answer + bfs(numbers, target, index+1, -sum);

        return answer;
    }

    private int bfs(int[] numbers, int target, int index, int sum) {
        if (index >= numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        result = result + bfs(numbers, target, index+1, sum + numbers[index]);
        result = result + bfs(numbers, target, index+1, sum - numbers[index]);

        return result;
    }

    public static void main(String[] args) throws IOException {
        Level2_타겟_넘버 solution = new Level2_타겟_넘버();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());

        int result = solution.solution(numbers, target);

        System.out.println(result);
    }
}
