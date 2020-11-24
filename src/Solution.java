import java.util.Scanner;
import java.util.*;

public class Solution {

    static List<Interval> sortedAs = new ArrayList<Interval>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i = 0; i < n; i++) {
            int val = Integer.valueOf(st.nextToken())-1;
            if(i < val) {
             insertSort(new Interval(i, val));
            }
            else {
                insertSort(new Interval(val, i));
            }
        }
       int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1 ; j < n; j++) {
                if(sortedAs.get(j).start > sortedAs.get(i).end) {
                    break;
                }
                if(sortedAs.get(j).end <= sortedAs.get(i).end) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void insertSort(Interval a) {
        int search = Collections.binarySearch(sortedAs, a, Comparator.comparingInt(Interval::getStart));
        if(search >= 0) {
            sortedAs.add(search, a);
            return;
        }
        int newIndex = -1*(Collections.binarySearch(sortedAs, a, Comparator.comparingInt(Interval::getStart))+1);
        sortedAs.add(newIndex, a);
    }
}

class Interval {
    int start;
    int end;
    Interval(int start, int end){
        this.start = start;
        this.end  = end;
    }
    public int getStart() {return start;}
}
