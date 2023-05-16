// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

public class Edge<S, D>
{
    private S sourceNode;
    private D destinateNode;
    private int weight;
    
    public Edge() {
    }
    
    public Edge(final S sourceNode, final D destinateNode, final int weight) {
        this.sourceNode = sourceNode;
        this.destinateNode = destinateNode;
        this.weight = weight;
    }
    
    public Edge(final S sourceNode, final D destinateNode) {
        this.sourceNode = sourceNode;
        this.destinateNode = destinateNode;
    }
    
    public S getSourceNode() {
        return this.sourceNode;
    }
    
    public void setSourceNode(final S sourceNode) {
        this.sourceNode = sourceNode;
    }
    
    public D getDestinateNode() {
        return this.destinateNode;
    }
    
    public void setDestinateNode(final D destinateNode) {
        this.destinateNode = destinateNode;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public void setWeight(final int weight) {
        this.weight = weight;
    }
}
