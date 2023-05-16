// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

public class MininumHeap
{
    private int curHeapSize;
    private TreeNode[] array;
    private boolean isFirstTime;
    
    public MininumHeap() {
        this.isFirstTime = true;
    }
    
    public MininumHeap(final int heapSize) {
        this.isFirstTime = true;
        this.array = new TreeNode[heapSize];
    }
    
    public void addElement(final TreeNode treeNode) {
        if (this.curHeapSize < this.array.length) {
            this.array[this.curHeapSize++] = treeNode;
        }
        else {
            if (this.isFirstTime) {
                for (int i = this.curHeapSize / 2 - 1; i >= 0; --i) {
                    this.shiftdown(this.array, i, this.curHeapSize);
                }
                this.isFirstTime = false;
            }
            if (treeNode.val <= this.array[0].val) {
                return;
            }
            this.array[0] = treeNode;
            this.shiftdown(this.array, 0, this.curHeapSize);
        }
    }
    
    private void shiftdown(final TreeNode[] array, int position, final int len) {
        while (position <= len / 2 - 1) {
            int l = 2 * position + 1;
            final int r = 2 * position + 2;
            if (r < len && array[l].val > array[r].val) {
                l = r;
            }
            if (array[l].val >= array[position].val) {
                return;
            }
            this.swap(array, l, position);
            position = l;
        }
    }
    
    private void swap(final TreeNode[] array, final int i, final int j) {
        final TreeNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public TreeNode[] getArray() {
        return this.array;
    }
    
    public int getCurHeapSize() {
        return this.curHeapSize;
    }
}
