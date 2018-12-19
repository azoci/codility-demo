import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
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

  public static int solution_binarygap(int N) {

    //1.정수를 이진수로 표현함  1041 = 10000010001
    String binary = Integer.toBinaryString(N);

    //2.이진수 각각의 문자를 캐릭터 배열 -> 리스트에 저장 [1,0,0,0,0,0,1,0,0,0,1]
    char[] charArray = binary.toCharArray();
    List<Character> list = new ArrayList<Character>();

    //3.1의 자리부터 연속된 0 제거 (32 예외 처리)
    boolean isfirstZero = true;
    for (int i = charArray.length-1; i >= 0; i--){
      if(charArray[i] == '0' && isfirstZero) {
        ;
      } else {
        list.add(charArray[i]);
        isfirstZero = false;
      }
    }

    //3.최장길이를 구함
    int max = 0;
    int distance = 0;
    Character pre = new Character('1');
    ListIterator<Character> listIterator = list.listIterator();
    while(listIterator.hasNext()){
      if(listIterator.next().equals(new Character('0'))) {
        //4.바로 앞 값이 0인 경우 distance 길이 추가
        if(pre.equals(new Character('0'))) {
          distance++;
        } else {
          distance = 1;
        }
        //max값 갱신
        if(distance > max) {
          max = distance;
        }
        pre = new Character('0');
      } else {
        distance = 0;
        pre = new Character('1');
      }
    }
    //4.max값을 리턴함
    return max;
  }

  public static int[] solution_cyclic(int[] A, int K) {
    if(A.length < 1) {
      return null;
    }
    //1.shift값 저장 배열 선언
    int[] shift = new int[A.length];

    //2.반복 제거
    int rK = K % A.length;
    //3.K값 만큼 오른쪽 이동
    for(int i=0; i < A.length; i++) {

      //4.index가 넘어가는 경우 앞으로 이동
      if(i+rK >= A.length) {
        shift[i+rK - A.length] =  A[i];
      } else {
        shift[i+rK] = A[i];
      }
    }
    //5.shift된 배열 리턴
    return shift;
  }

}
