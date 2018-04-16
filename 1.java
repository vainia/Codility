public int solution(boolean[] P) {
        int res = 0, prev = 0, count = 0, l = P.length;
        for(int i=0; i<l; ++i)
        {
            if(P[i])
            {
                ++count;
                res+=(i+1)*(l-i);
                if(count>1)
                {
                    res-=(prev+1)*((l-(i-prev))-prev);
                }
                prev=i;
            }
        }
        return (res<0||res>1000000000)?1000000000:res;
    }
}
