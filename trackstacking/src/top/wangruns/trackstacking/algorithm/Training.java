// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import top.wangruns.trackstacking.model.Song;
import java.util.List;

public class Training
{
    public static Map<Integer, float[]> train(final List<Song> engSongList, final Map<String, int[]> w2wNetwork, final Map<String, int[]> w2dNetwork, int iter, final int d, final float alpha, final Set<String> wordSet) {
        final Map<Integer, float[]> lyricEmbedding = new HashMap<Integer, float[]>();
        final Map<String, float[]> wordEmbedding = new HashMap<String, float[]>();
        for (final Song song : engSongList) {
            final float[] e = initialEmbedding(d);
            lyricEmbedding.put(song.getSongId(), e);
        }
        System.out.println("---------\u968f\u673a\u521d\u59cb\u5316 done----------");
        w2dNetwork.keySet().forEach(new Consumer<String>() {
            public void accept(final String word) {
                final float[] e = initialEmbedding(d);
                wordEmbedding.put(word, e);
            }
        });
        final Set<String> bipartiteSetA = getBipartiteSetA(w2wNetwork, wordSet);
        final Map<Integer, Edge<String, String>> weight2EdgeTableW2W = Sample.getWeight2EdgeTableW2W(w2wNetwork, wordSet, bipartiteSetA);
        final Map<Integer, Edge<String, Integer>> weight2EdgeTableW2D = Sample.getWeight2EdgeTableW2D(w2dNetwork, engSongList);
        while (iter-- > 0) {
            final Edge<String, String> edgeW2W = Sample.simpleProbabilitySamplingW2W(weight2EdgeTableW2W);
            final String sourceNodeW2W = edgeW2W.getSourceNode();
            final String destinationNodeW2W = edgeW2W.getDestinateNode();
            final float[] eW2WSource = wordEmbedding.get(sourceNodeW2W);
            final float[] eW2WDestination = wordEmbedding.get(destinationNodeW2W);
            final float[] descentW2WSource = new float[d];
            final float[] descentW2WDestination = new float[d];
            SGD.getW2WSourceDescent(edgeW2W, eW2WSource, bipartiteSetA, wordEmbedding, w2wNetwork, wordSet, descentW2WSource, descentW2WDestination);
            final float[] newEW2WSource = Operator.dotMinus(eW2WSource, Operator.dotTimes(alpha, descentW2WSource));
            final float[] newEW2WDestination = Operator.dotMinus(eW2WDestination, Operator.dotTimes(alpha, descentW2WDestination));
            Operator.assign(wordEmbedding.get(sourceNodeW2W), newEW2WSource);
            Operator.assign(wordEmbedding.get(destinationNodeW2W), newEW2WDestination);
            final Edge<String, Integer> edgeW2D = Sample.simpleProbabilitySamplingW2D(weight2EdgeTableW2D);
            final String sourceNodeW2D = edgeW2D.getSourceNode();
            final Integer destinationNodeW2D = edgeW2D.getDestinateNode();
            final float[] eW2DSource = wordEmbedding.get(sourceNodeW2D);
            final float[] eW2DDestination = lyricEmbedding.get(destinationNodeW2D);
            final float[] descentW2DSource = new float[d];
            final float[] descentW2DDestination = new float[d];
            SGD.getW2DSourceDescent(edgeW2D, eW2DSource, wordEmbedding, lyricEmbedding, w2dNetwork, engSongList, descentW2DSource, descentW2DDestination);
            final float[] newEW2DSource = Operator.dotMinus(eW2DSource, Operator.dotTimes(alpha, descentW2DSource));
            final float[] newEW2DDestination = Operator.dotMinus(eW2DDestination, Operator.dotTimes(alpha, descentW2DDestination));
            Operator.assign(wordEmbedding.get(sourceNodeW2D), newEW2DSource);
            Operator.assign(lyricEmbedding.get(destinationNodeW2D), newEW2DDestination);
        }
        return lyricEmbedding;
    }
    
    private static Set<String> getBipartiteSetA(final Map<String, int[]> w2wNetwork, final Set<String> wordSet) {
        final Set<String> bipartiteSetA = new HashSet<String>();
        final Set<String> bipartiteSetB = new HashSet<String>();
        w2wNetwork.keySet().forEach(new Consumer<String>() {
            public void accept(final String node_i) {
                if (!bipartiteSetB.contains(node_i)) {
                    w2wNetwork.keySet().forEach(new Consumer<String>() {
                        public void accept(final String node_j) {
                            if (!node_i.equals(node_j) && this.isRelated(node_i, node_j)) {
                                bipartiteSetA.add(node_i);
                                bipartiteSetB.add(node_j);
                            }
                        }
                        
                        private boolean isRelated(final String node_i, final String node_j) {
                            final int[] weights = w2wNetwork.get(node_i);
                            final int index = W2WNetwork.getW2WIndex(node_j, wordSet);
                            return weights[index] != 0;
                        }
                    });
                }
            }
        });
        return bipartiteSetA;
    }
    
    private static float[] initialEmbedding(final int dimension) {
        final Random random = new Random(47L);
        final float[] e = new float[dimension];
        for (int i = 0; i < dimension; ++i) {
            e[i] = random.nextFloat();
        }
        return e;
    }
}
