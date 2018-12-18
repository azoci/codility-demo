import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Solution {

  public Solution() {}

  public static int solution(int[] A) {
    // write your code in Java SE 8
    List<Integer> list = new ArrayList<Integer>(A.length);
    for (int i : A) list.add(i);
    int max = Collections.max(list);
    // 최대값이 1보다 작은 경우 1 리턴
    if(max < 1) {
      return 1;
    }else {

      // sorting 및 중복 값 제거
      List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
      Collections.sort(distinct);

      //최소값 구하기
      int min = Collections.min(distinct);
      int index = 0;
      for(int i = min; i < 100000 && index < distinct.size(); i++) {
        if(i == distinct.get(index).intValue()) index++;
        else return i;
      }
      return distinct.get(--index).intValue() + 1;
    }
  }
}
