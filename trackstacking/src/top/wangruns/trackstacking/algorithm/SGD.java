// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.util.Iterator;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SGD
{
    public static void getW2WSourceDescent(final Edge<String, String> edgeW2W, final float[] ei, final Set<String> bipartiteSetA, final Map<String, float[]> wordEmbedding, final Map<String, int[]> w2wNetwork, final Set<String> wordSet, final float[] descentW2WSource, final float[] descentW2WDestination) {
        final String sourceNode = edgeW2W.getSourceNode();
        final String destinationNode = edgeW2W.getDestinateNode();
        final float[] ej = wordEmbedding.get(destinationNode);
        final int[] relatedArray = w2wNetwork.get(sourceNode);
        final int len = relatedArray.length;
        float sumCurI2B = 0.0f;
        final float[] sumCurI2BTimesNodeInB = new float[ei.length];
        for (int i = 0; i < len; ++i) {
            final String node = W2WNetwork.getW2WNode(i, wordSet);
            final float[] eB = wordEmbedding.get(node);
            if (!bipartiteSetA.contains(node)) {
                final float temp = (float)Math.exp(Operator.times(ei, eB));
                sumCurI2B += temp;
                Operator.add(sumCurI2BTimesNodeInB, Operator.dotTimes(temp, eB));
            }
        }
        final int weight = edgeW2W.getWeight();
        final float[] descentSource = Operator.dotTimes(weight, Operator.dotMinus(ej, Operator.divide(sumCurI2BTimesNodeInB, sumCurI2B)));
        final float[] curI2JTimesJ = Operator.dotTimes((float)Math.exp(Operator.times(ei, ej)), ej);
        final float[] descentDestination = Operator.dotTimes(weight, Operator.dotMinus(ei, Operator.divide(curI2JTimesJ, sumCurI2B)));
        Operator.assign(descentW2WSource, Operator.dotTimes(-1.0f, descentSource));
        Operator.assign(descentW2WDestination, Operator.dotTimes(-1.0f, descentDestination));
    }
    
    public static void getW2DSourceDescent(final Edge<String, Integer> edgeW2D, final float[] ei, final Map<String, float[]> wordEmbedding, final Map<Integer, float[]> lyricEmbedding, final Map<String, int[]> w2dNetwork, final List<Song> engSongList, final float[] descentW2DSource, final float[] descentW2DDestination) {
        final Integer documentNode = edgeW2D.getDestinateNode();
        final float[] ej = lyricEmbedding.get(documentNode);
        float sumCurI2B = 0.0f;
        final float[] sumCurI2BTimesNodeInB = new float[ei.length];
        for (final Song song : engSongList) {
            final Integer node_j = song.getSongId();
            final float[] eB = lyricEmbedding.get(node_j);
            final float temp = (float)Math.exp(Operator.times(ei, eB));
            sumCurI2B += temp;
            Operator.add(sumCurI2BTimesNodeInB, Operator.dotTimes(temp, eB));
        }
        final int weight = edgeW2D.getWeight();
        final float[] descentSource = Operator.dotTimes(weight, Operator.dotMinus(ej, Operator.divide(sumCurI2BTimesNodeInB, sumCurI2B)));
        final float[] curI2JTimesJ = Operator.dotTimes((float)Math.exp(Operator.times(ei, ej)), ej);
        final float[] descentDestination = Operator.dotTimes(weight, Operator.dotMinus(ei, Operator.divide(curI2JTimesJ, sumCurI2B)));
        Operator.assign(descentW2DSource, Operator.dotTimes(-1.0f, descentSource));
        Operator.assign(descentW2DDestination, Operator.dotTimes(-1.0f, descentDestination));
    }
}
