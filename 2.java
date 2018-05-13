//import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// ('LLMMLLMMMLLLLLMMMMLLLL'), 7) 2
// ('LLMMLLLMLLMMMMMLLLMMMLLMMLLLMMMMLLLLLMMMMMLMMLLMMMM'), 14) 3
// ('MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMLMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM'), 72) 0

class Solution {
   public static int solution(String S, int K) {
      int res = 0, bsqe = 0, bsqc = 0, bsqs=0, csqs = 0, cnt = 0;
      char[] m = S.toCharArray();
      int len = S.length();
      for(int i=0; i<len; ++i)
      {
         if(m[i]=='M')
         {
            if(cnt==0) csqs = i;
            ++cnt;
         }
         if(m[i]=='L' || i==len-1)
         {
            if(cnt>bsqc)
            {
               bsqe = cnt + csqs;
               bsqc = cnt;
               bsqs = csqs;
            }
            if(cnt>K)
            {
               res += (int)Math.floor(cnt / ((double)K + 1));
            }
            cnt = 0;
         }
      }
      if(res>0) return res;
      if(K==0) return 0;
      if(bsqc==K && res==0) return res;
      for(int i=bsqe; i<len; ++i)
      {
         if(m[i]=='L') ++res;
         if(++bsqc==K)
         {
            if(i<len-1 && m[i+1]=='M') ++res;
            return res;
         }
      }
      for(int i=bsqs-1; i>=0; --i)
      {
         if(m[i]=='L') ++res;
         if(++bsqc==K)
         {
            if(i<0 && m[i-1]=='M') ++res;
            return res;
         }
      }
      return res;
   }

   public static void main(String[] args)
   {
      String ML = String.format("%1$" + 99 + "s", "L").replace(' ', 'L');
      ML = ML + "M" + String.format("%1$" + 99900 + "s", "L").replace(' ', 'L');
      System.out.println(Solution.solution(ML, 100000));
      System.out.println(Solution.solution("MMMMLMMMMM", 5));
   }
}
