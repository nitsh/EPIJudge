package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
      double maxProfit = 0.0;
      if(!prices.isEmpty()){
          Double currMin = prices.get(0);
          for(int i = 0; i < prices.size(); i++){
              Double currPrice = prices.get(i);
              if(currMin > currPrice){
                  currMin = currPrice;
              }
              Double currProfit = currPrice - currMin;

              if(currProfit > maxProfit){
                  maxProfit = currProfit;
              }
          }
      }

      return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
