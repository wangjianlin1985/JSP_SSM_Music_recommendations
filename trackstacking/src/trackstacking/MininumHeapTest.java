// 
// Decompiled by Procyon v0.5.29
// 

package trackstacking;

import top.wangruns.trackstacking.algorithm.TreeNode;
import top.wangruns.trackstacking.algorithm.MininumHeap;

public class MininumHeapTest
{
    public static void main(final String[] args) {
        final int k = 5;
        final MininumHeap mininumHeap = new MininumHeap(k);
        for (int i = 0; i < 10; ++i) {
            final TreeNode node = new TreeNode(i, i);
            mininumHeap.addElement(node);
        }
        for (int i = 0; i < k; ++i) {
            System.out.println(mininumHeap.getArray()[i].val);
        }
    }
}
