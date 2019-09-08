package Java.graph.questions.shortest.path;

import Java.graph.graph.IWeightedGraph;
import Java.graph.graph.types.Edges;
import Java.graph.graph.types.WeightedDirectedGraph;
import Java.graph.graph.types.WeightedUnDirectedGraph;

import java.util.List;

/**
 * Author: Nitin Gupta(nitin.gupta@walmart.com)
 * Date: 2019-09-08
 * Description:
 */
public class ShortestPathTest {

    private static IWeightedGraph getGraph(int[][] edges, int vertices) {
        IWeightedGraph graph = new WeightedUnDirectedGraph(vertices);

        for (int edge[] : edges) {

            graph.addEdge(edge[0], edge[1], edge[2]);

        }

        return graph;

    }

    public static void main(String[] args) {
         /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */


        test(getGraph(new int[][]{{0, 1, 10}, {1, 3, 15}, {2, 3, 4}, {0, 2, 6}, {0, 3, 5}}, 4));


        test(getGraph(new int[][]{{0, 1, 9}, {0, 2, 6}, {0, 3, 5}, {0, 4, 3}, {2, 1, 2}, {2, 3, 4}}, 5));


        test(getGraph(new int[][]{{0, 1, 4}, {0, 7, 8}, {1, 2, 8}, {2, 3, 7}, {3, 4, 9},
                {4, 5, 10}, {5, 6, 2}, {6, 7, 1}, {7, 8, 7}, {2, 8, 2}, {1, 7, 11}, {2, 5, 4}, {3, 5, 14}, {8, 6, 6}}, 9));

    }

    private static void test(IWeightedGraph graph) {
        System.out.println("\n Graph :\n" + graph.scan());

        final IShortestPath dijkstraShortestPath = new DijkstraShortestPath();
        final List<Edges> shortestPath = dijkstraShortestPath.shortestPath(graph, 0);
        shortestPath.stream().forEach(e -> System.out.println(e));

    }
}