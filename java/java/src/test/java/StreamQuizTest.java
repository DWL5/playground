import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
public class StreamQuizTest {

    @Test
    void mapping() {
        /*
            숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오. 예를 들어 [1, 2, 3, 4, 5]가
            주어지면 [1, 4, 9, 16, 25]를 반환해야 한다.
         */

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        final List<Integer> collect = numbers.stream()
                .map(number -> (int) Math.pow(number, 2))
                .collect(Collectors.toList());

        assertThat(collect).contains(1, 4, 9, 16, 25);
    }

    @Test
    void pair() {
        /*
        두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하시오. 예를 들어 두 개의 리스트 [1,2,3]과 [3,4]가 주어지면
        [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]를 반환해야 한다.
         */

        List<Integer> numbers1 = List.of(1, 2, 3);
        List<Integer> numbers2 = List.of(3, 4);

        List<int[]> pairs = numbers1.stream().flatMap(number1 -> numbers2.stream()
                                                        .map(number2 -> new int[]{number1, number2}))
        .collect(Collectors.toList());

        assertThat(pairs).contains(new int[]{1,3}, new int[]{1,4}, new int[]{2,3}, new int[]{2,4}, new int[]{3,3},  new int[]{3,4});
    }

    @Test
    void filter() {
        /*
        이전 예제에서 합이 3으로 나누어떨어지는 쌍만 반환하려면 어떻게 해야 할까? 예를 들어 (2,4), (3,3)을 반환해야 한다.
         */
        List<Integer> numbers1 = List.of(1, 2, 3);
        List<Integer> numbers2 = List.of(3, 4);

        List<int[]> pairs = numbers1.stream().flatMap(number1 -> numbers2.stream()
                .filter(number2 -> (number1 + number2) % 3 == 0)
                .map(number2 -> new int[]{number1, number2}))
                .collect(Collectors.toList());

        assertThat(pairs).contains(new int[]{2,4}, new int[]{3,3});

    }
}
