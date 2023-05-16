// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

public class TreeNode
{
    public float val;
    int id;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    public TreeNode(final int id, final float similarity) {
        this.id = id;
        this.val = similarity;
    }
}
