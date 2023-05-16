// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import top.wangruns.trackstacking.model.Song;
import java.util.List;
import java.util.function.Consumer;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Random;
import java.util.Map;

public class Sample
{
    private static int weightSumW2W;
    private static int weightSumW2D;
    
    public static Edge<String, String> simpleProbabilitySamplingW2W(final Map<Integer, Edge<String, String>> weight2EdgeTableW2W) {
        Edge<String, String> edge = null;
        final Random random = new Random(47L);
        final int seed = random.nextInt(Sample.weightSumW2W);
        final Iterator<Integer> iterator = weight2EdgeTableW2W.keySet().iterator();
        int prevousWeight = 0;
        while (iterator.hasNext()) {
            final int curWeight = iterator.next();
            if (seed >= prevousWeight && seed < curWeight) {
                edge = weight2EdgeTableW2W.get(curWeight);
                break;
            }
            prevousWeight = curWeight;
        }
        return edge;
    }
    
    public static Map<Integer, Edge<String, String>> getWeight2EdgeTableW2W(final Map<String, int[]> w2wNetwork, final Set<String> wordSet, final Set<String> bipartiteSetA) {
        final Map<Integer, Edge<String, String>> weight2EdgeTableW2W = new TreeMap<Integer, Edge<String, String>>();
        bipartiteSetA.forEach(new Consumer<String>() {
            public void accept(final String node_i) {
                final int[] relatedArray = w2wNetwork.get(node_i);
                for (int j = 0; j < relatedArray.length; ++j) {
                    if (relatedArray[j] > 0) {
                        final String node_j = W2WNetwork.getW2WNode(j, wordSet);
                        final Edge<String, String> edge = new Edge<String, String>(node_i, node_j, relatedArray[j]);
                        Sample.access$1(Sample.weightSumW2W + relatedArray[j]);
                        weight2EdgeTableW2W.put(Sample.weightSumW2W, edge);
                    }
                }
            }
        });
        return weight2EdgeTableW2W;
    }
    
    public static Map<Integer, Edge<String, Integer>> getWeight2EdgeTableW2D(final Map<String, int[]> w2dNetwork, final List<Song> engSongList) {
        final Set<String> bipartiteSetA = w2dNetwork.keySet();
        final Map<Integer, Edge<String, Integer>> weight2EdgeTableW2D = new TreeMap<Integer, Edge<String, Integer>>();
        bipartiteSetA.forEach(new Consumer<String>() {
            public void accept(final String node_i) {
                final int[] relatedArray = w2dNetwork.get(node_i);
                for (int j = 0; j < relatedArray.length; ++j) {
                    if (relatedArray[j] > 0) {
                        final int node_j = W2DNetwork.getW2DNode(j, engSongList);
                        final Edge<String, Integer> edge = new Edge<String, Integer>(node_i, node_j, relatedArray[j]);
                        Sample.access$3(Sample.weightSumW2D + relatedArray[j]);
                        weight2EdgeTableW2D.put(Sample.weightSumW2D, edge);
                    }
                }
            }
        });
        return weight2EdgeTableW2D;
    }
    
    public static Edge<String, Integer> simpleProbabilitySamplingW2D(final Map<Integer, Edge<String, Integer>> weight2EdgeTableW2D) {
        Edge<String, Integer> edge = null;
        final Random random = new Random(47L);
        final int seed = random.nextInt(Sample.weightSumW2D);
        final Iterator<Integer> iterator = weight2EdgeTableW2D.keySet().iterator();
        int prevousWeight = 0;
        while (iterator.hasNext()) {
            final int curWeight = iterator.next();
            if (seed >= prevousWeight && seed < curWeight) {
                edge = weight2EdgeTableW2D.get(curWeight);
                break;
            }
            prevousWeight = curWeight;
        }
        return edge;
    }
    
    static /* synthetic */ void access$1(final int weightSumW2W) {
        Sample.weightSumW2W = weightSumW2W;
    }
    
    static /* synthetic */ void access$3(final int weightSumW2D) {
        Sample.weightSumW2D = weightSumW2D;
    }
}
