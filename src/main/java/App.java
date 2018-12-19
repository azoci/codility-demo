public class App {
  public static void main(String[] args) {
    //System.out.printf("{1, 3, 6, 4, 1, 2} = %d\n", Solution.solution(new int[]{1, 3, 6, 4, 1, 2}));
    //System.out.printf("{1, 2, 3} = %d\n", Solution.solution(new int[]{1, 2, 3}));
    //System.out.printf("{1, 3, 6, 4, 1, 2} = %d", Solution.solution(new int[]{−1, −3}));
    //System.out.printf("of 1041 is %d\n", Solution.solution_binarygap(1041));
    //System.out.printf("of 9 is %d\n", Solution.solution_binarygap(9));
    //System.out.printf("of 8 is %d\n", Solution.solution_binarygap(8));
    int[] result = Solution.solution_cyclic(new int[0], 4);
    result = Solution.solution_cyclic(new int[]{3, 8, 9, 7, 6}, 3);
    for(int i: result) {
      System.out.println(i);
    }
  }
}
