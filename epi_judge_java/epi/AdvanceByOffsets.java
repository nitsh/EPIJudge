package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class AdvanceByOffsets {
  @EpiTest(testDataFile = "advance_by_offsets.tsv")
  public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {

      Integer furthestSoFar = 0;
      for(int i = 0; i < maxAdvanceSteps.size(); i++){
          if(furthestSoFar >= maxAdvanceSteps.size() -1){
              return true;
          }
          furthestSoFar = (furthestSoFar < i + maxAdvanceSteps.get(i))? i + maxAdvanceSteps.get(i):furthestSoFar;
          if(furthestSoFar == i ){
              return false;
          }
      }
      return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AdvanceByOffsets.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
