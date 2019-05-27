package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PrimitiveMultiply {
  @EpiTest(testDataFile = "primitive_multiply.tsv")
  public static long multiply(long x, long y) {
      long j = y;

      long result = 0;
      long tempX = x;
      while (j != 0){
          if((j & 1) == 1){
              result = add(result, tempX);
          }
          tempX <<= 1;
          j >>>= 1;
      }
    return result;
  }

  public static long add(long x, long y) {
      long carryin = 0;
      long sum = 0;

      long i = x;
      long j = y;

      long k = 1;

      while(i !=0 || j != 0){
          long xk = x & k;
          long yk = y & k;

          long carryout = (carryin & xk) | (carryin & yk) | (xk & yk);

          sum = sum | (carryin ^ xk ^ yk);

          carryin = carryout <<=1 ;

          k <<= 1;
          i >>>= 1;
          j >>>= 1;
      }
      return sum | carryin;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
