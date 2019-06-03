package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
      Integer carryOver = 1;
      for(int i = A.size() - 1; i >= 0; i--){
          if (A.get(i) + carryOver == 10) {
              A.set(i, 0);
          } else {
              A.set(i, A.get(i) + carryOver);
              carryOver = 0;
              break;
          }
      }
      if(carryOver == 1) {
          A.add(0, 1);
      }
      return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
