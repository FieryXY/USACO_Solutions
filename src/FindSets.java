import java.io.*;
import java.util.*;

public class FindSets {

    static char[][] sortingOrder = {{'g','r','p'},{'o','s','d'},{'s','o','f'},{'1','2','3'}};

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int possibleSets = 0;
        String[] cards = sc.nextLine().split(" ");
        Comparator<String> cardSorter = (a, b) -> compareCards(a, b);
        Arrays.sort(cards, cardSorter);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                String requiredCard = generateCard(cards[i], cards[j]);
                if(Arrays.binarySearch(cards, requiredCard, cardSorter) >= 0) {
                    possibleSets++;
                }
            }
        }

        System.out.println(possibleSets/6);
    }

    private static int compareCards(String a, String b) {
        for(int i = 0; i < 4; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                for(int j = 0; j < 3; j++) {
                    if(sortingOrder[i][j] == a.charAt(i)) {
                        return -1;
                    }
                    else if(sortingOrder[i][j] == b.charAt(i)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private static String generateCard(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            if(a.charAt(i) == b.charAt(i)) {
                sb.append(a.charAt(i));
            }
            else {
                for(int j = 0; j < 3; j++) {
                    if(sortingOrder[i][j] != a.charAt(i) && sortingOrder[i][j] != b.charAt(i)) {
                        sb.append(sortingOrder[i][j]);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }


}