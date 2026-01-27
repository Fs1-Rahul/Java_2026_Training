import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
public class Streamspractice {
    public static void main(String[] args) {
        System.out.println("This is a placeholder for Streamspractice class.");
        Stream<String> stream = Stream.of("A", "B", "C");
        Stream<String> stream1;
        Stream<String> stream2;
        Stream<String> stream3;
        Stream<List<String>> listStream = Stream.of(
            List.of("cAc", "azBc"),
            List.of("arCc", "gDc"),
            List.of("Ec", "6Fc")
        );
        List<String> intermediateResults = new java.util.ArrayList<>();
        stream=listStream.flatMap(List::stream).peek(intermediateResults::add).filter(s->s.startsWith("a")).sorted();
        stream.forEach(System.out::println);
        listStream = Stream.of(
            List.of("cAc", "azBc"),
            List.of("arCc", "gDc"),
            List.of("Ec", "6Fc")
        );
        stream=listStream.flatMap(List::stream).peek(intermediateResults::add).filter(s->s.startsWith("a")).sorted();
        System.out.println("Count : " + stream.count());
        listStream = Stream.of(
            List.of("cAc", "azBc"),
            List.of("arCc", "gDc"),
            List.of("Ec", "6Fc")
        );
        stream=listStream.flatMap(List::stream).peek(intermediateResults::add).filter(s->s.startsWith("a")).sorted();
        System.out.println("All Match " + intermediateResults.stream().allMatch(s -> s.startsWith("a")));
        listStream = Stream.of(
            List.of("cAc", "azBc"),
            List.of("arCc", "gDc"),
            List.of("Ec", "6Fc")
        );
        stream=listStream.flatMap(List::stream).peek(intermediateResults::add).filter(s->s.startsWith("a")).sorted();
        System.out.println("Any Match " + stream.anyMatch(s -> s.startsWith("a")));
    }
}
