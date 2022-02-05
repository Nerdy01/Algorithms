public class SumOnTheSegmentTree {
    private int[] segmentTree;
    private int arrLength;

    public SumOnTheSegmentTree(int[] arr) {
        int treeSize = 2*arr.length;
        if(arr.length%2 == 1) treeSize += 2;
        segmentTree = new int[treeSize];
        constructTree(1, 0, arr.length - 1, arr);
        arrLength = arr.length;
    }

    private void constructTree(int segmentTreeIndex, int startIndex, int endIndex, int[] arr) {
        if(startIndex == endIndex) {
            segmentTree[segmentTreeIndex] = arr[startIndex];
            return;
        }
        int middle = startIndex + (endIndex - startIndex)/2;
        constructTree(2*segmentTreeIndex, startIndex, middle, arr);
        constructTree(2*segmentTreeIndex + 1, middle + 1, endIndex, arr);
        segmentTree[segmentTreeIndex] = segmentTree[2*segmentTreeIndex] + segmentTree[2*segmentTreeIndex+1];
    }

    private int findSum(int index, int searchingScopeStart, int searchingScopeEnd, int startIndex, int endIndex) {
        if (searchingScopeEnd < startIndex || searchingScopeStart > endIndex) return 0;
        if(searchingScopeStart >= startIndex && searchingScopeEnd <= endIndex) {
            return segmentTree[index];
        }
        int middle = searchingScopeStart + (searchingScopeEnd - searchingScopeStart)/2;
        return findSum(2*index, searchingScopeStart, middle, startIndex, endIndex) +
                findSum(2*index + 1, middle + 1, searchingScopeEnd, startIndex, endIndex);
    }


    public int sumOnInterval(int startIndex, int endIndex) {
        return findSum(1, 0, arrLength - 1, startIndex, endIndex);
    }

}
