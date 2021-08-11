import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SubSequence {

    private static class Result {
        private Set<ArrayList<Integer>> subSequences;

        public Result() {
            subSequences = new HashSet<>();
        }

        public int count() {
            return subSequences.size();
        }

        public Set<ArrayList<Integer>> getSubSequences() {
            return subSequences;
        }

        public void add(ArrayList<Integer> sequence) {
            subSequences.add(sequence);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers);
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int k = Integer.parseInt(br.readLine());
        Result result = getSequences(list, n, k);
        System.out.println("Count: " + result.count());
        System.out.println("Subsequences:");
        for (ArrayList<Integer> subSequence : result.getSubSequences()) {
            for (Integer i : subSequence) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static Result getSequences(ArrayList<Integer> list, int n, int k) {
        Result result = new Result();
        getSequencesRecursive(list, new ArrayList<>(), result, 0, k, 0);
        return result;
    }

    private static void getSequencesRecursive(ArrayList<Integer> list, ArrayList<Integer> subSequence, Result result, int total, int k, int index) {
        ArrayList<Integer> includedSubSequence = new ArrayList<>(subSequence);
        includedSubSequence.add(list.get(index));
        int includedTotal = total + list.get(index);
        if (includedTotal == k) {
            result.add(includedSubSequence);
        } else if (!((total + list.get(index) > k) || (total + 2 * list.get(index) > k))) {
            for (int i = index + 1; i < list.size(); i++) {
                getSequencesRecursive(list, includedSubSequence, result, includedTotal, k, i);
                getSequencesRecursive(list, subSequence, result, total, k, i);
            }
        }
    }


}
