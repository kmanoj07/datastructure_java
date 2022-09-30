package com.Array.AdvancedArray;

import java.util.ArrayList;


public class MergeInterval {


    public static int[] get2unique() {
        return  new int[] {1,2};
    }
    
    public static void main(String[] args)
    {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new MergeInterval.Interval(1, 3));
        intervals.add(new MergeInterval.Interval(6, 9));
        Interval newInterval = new Interval(2,5);
        ArrayList<Interval> result =  insert(intervals, newInterval);
        printList(result);
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        int N = intervals.size();
        int S = newInterval.start;
        int E = newInterval.end;

        for(int i=0;i<N;i++){
            Interval curinterval = intervals.get(i);
            int Si = curinterval.start;
            int Ei = curinterval.end;
            //no overlapping
            if(Ei < S)
            {
                //add to the ans;
                ans.add(curinterval);
            } 
            else if (Si > E)
            {
                ans.add(new Interval(S, E));
                //print Remaining Interval
                for(int j = i;j < N ; j++)
                {
                    //printing all remaining intervals from the intervals list
                    ans.add(intervals.get(j));
                }

                return ans;
            } 
            else 
            {
                S = Math.min(Si, S);
                E = Math.max(Ei, E);
            }
        }
        ans.add(new Interval(S, E));
        return ans;
    }

    public static void printList(ArrayList<Interval> intervals) {
        int N = intervals.size();
        for(int i=0;i<N;i++){
            System.out.println("[ "+ intervals.get(i).start + " " + intervals.get(i).end +" ]");
        }
    }

    static class Interval{
        int start;
        int end;

        public Interval(){
            this.start = 0;
            this.end = 0;
        }

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    };
}
