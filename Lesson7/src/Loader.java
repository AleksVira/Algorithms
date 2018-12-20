public class Loader {
    public static void main(String[] args) {
        Graph g = new Graph(14);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(0, 6);
        g.addEdge(0, 7);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 9);
        g.addEdge(5, 7);
        g.addEdge(5, 9);
        g.addEdge(6, 8);

/*
        DepthFirstPath dfs = new DepthFirstPath(g, 0);
        System.out.println(dfs.hasPathTo(5));
        System.out.println(dfs.hasPathTo(12));
        System.out.println(dfs.pathTo(5));
        System.out.println();
*/

        BreadthFirstPath bfp = new BreadthFirstPath(g, 0);
        System.out.println(bfp.hasPathTo(1));
        System.out.println(bfp.hasPathTo(5));
        System.out.println(bfp.pathTo(8));
        System.out.println(bfp.pathTo(9));
        System.out.println(bfp.distTo(8));
        System.out.println(bfp.distTo(5));
        System.out.println(bfp.distTo(3));
        System.out.println(bfp.distTo(9));


    }
}
