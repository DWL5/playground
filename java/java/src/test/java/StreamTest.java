import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    @Test
    @DisplayName("프레디케이트로 필터링")
    void stream_filtering_test() {
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());


        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("스트림 슬라이싱")
    void stream_slicing_test() {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        //takeWhile -> 리스트가 이미 정렬되어 있다는 사실을 이용해 320 칼로리보다 크거나 같은 요리가 나왔을 때 반복 작업을 중단 할 수 있다.
        List<Dish> sliceMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        assertThat(sliceMenu1).contains(new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH));


        //dropWhile -> 처으므로 프레디케이트가 거짓이 되는 지점 까지 발견된 요소를 버린다.
        // 프레디케이트가 거짓이 되면 그 지점에서 작업을 중단하고 남은 모든 요소를 반환한다.

        List<Dish> sliceMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        assertThat(sliceMenu1).contains(new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        // 스트림 축소
        List<Dish> dishes1 = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());

        // 요소 건너뛰기
        List<Dish> dishes2 = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("매핑")
    void stream_mapping() {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        List<Integer> words = Arrays.asList("Modern", "Java", "In", "Action").stream()
                .map(String::length)
                .collect(Collectors.toList());

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("스트림 평면화")
    void stream_flattening() {
        /*
            ["H", "e", "l", "o", "W", "r", "d"]를 나타내고 싶다면? flatMap 사용하기
         */
        List<String> words = Arrays.asList("Hello", "World");

        List<String[]> collect = words.stream()
                .map(word -> {
                    return word.split("");
                })
                .distinct()
                .collect(Collectors.toList());

         List<Stream<String>> collect1 = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("flatMap 사용")
    void stream_flatmap() {
        /*
            ["H", "e", "l", "o", "W", "r", "d"]를 나타내고 싶다면? flatMap 사용하기
         */
        List<String> words = Arrays.asList("Hello", "World");

        // flatMap은 각 배열을 스트림이 아니라 스트림 콘텐츠로 매핑한다.
        // 즉 map (Arrays::stream)과 달리 flatMap은 평면화된 스트림을 반환한다.
        final List<String> collect = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        collect.stream().forEach(System.out::print);

    }

}
