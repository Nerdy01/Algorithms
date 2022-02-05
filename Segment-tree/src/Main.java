public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 4, 5, 1};
        SumOnTheSegmentTree tree = new SumOnTheSegmentTree(arr);
        System.out.println(tree.sumOnInterval(1,3));
    }
}
