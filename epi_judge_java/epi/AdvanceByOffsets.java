package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class AdvanceByOffsets {
  @EpiTest(testDataFile = "advance_by_offsets.tsv")
  public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
      maxAdvanceSteps.set(maxAdvanceSteps.size()-1, -1);
      for(int i = maxAdvanceSteps.size() - 1; i >= 0; i--){
          for(int j = i+1; j <= i + maxAdvanceSteps.get(i); j++){
              if(j == maxAdvanceSteps.size() || maxAdvanceSteps.get(j) == -1){
                  maxAdvanceSteps.set(i, -1);
                  break;
              }
          }
      }

      return maxAdvanceSteps.get(0) == -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AdvanceByOffsets.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
