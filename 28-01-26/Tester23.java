
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Tester23 {
   public static void main(String args[]) {
      List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

      Predicate<Integer> isEvenNumber = n -> n %2 == 0;
      numbers =  numbers.stream().filter(isEvenNumber).collect(Collectors.toList());

      System.out.println(numbers);
   }
}