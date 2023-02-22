package main.solution;

public class BinarySearch {

    public int bs(int[] weights, int days,int total, int lo, int hi) {

        int mid = (lo+hi)/2;

        int sum1 = 0, sum2=0;
        for(int i=lo;i<=mid;++i){
            sum1 += weights[i];
        }
        for(int i=mid+1;i<hi;++i){
            sum2 += weights[i];
        }

//        int tSum1 = sum1*days;
//        int tSum2 = sum2*days;
//
//        int d1 = total - tSum1;
//        int d2 = total - tSum2;

        if(sum1<sum2){
            return bs(weights,days,sum1,lo,mid);
        }
        else {
            return bs(weights,days,sum2,mid,hi);
        }
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for(int i=0;i<weights.length;++i){
            sum += weights[i];
        }

        return bs(weights,days,sum,0,weights.length);
    }
}
