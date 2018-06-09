package Graph_API;

import java.util.*;

public class MyGraphWork {
     //图的数据结构
     static class Graph{
         private int V;// 顶点个数
         private int E = 0;// 边数初始为0
         private Edge[] edges;  //带权重边
         private LinkedList<Edge> edges1;
         private int n = 0;  //edges 的标记
         private LinkedList<Integer>[] adj; //连接表
         public Graph(int V){
            this.V = V;
            //初始化连接表
            adj = (LinkedList<Integer>[]) new LinkedList[V];
            //初始化链表
            for(int i = 0; i < V; i++){
                adj[i] = new LinkedList<>();
            }
            edges1 = new LinkedList<>();
         }
         //可以添加边的条数, 但使用这个构造函数就不能再每加一条边E值增一
         public Graph(int V, int E) {
             this.V = V;
             this.E = E;
//             初始化连接表
             adj = (LinkedList<Integer>[]) new LinkedList[V];
//             初始化链表
             for (int i = 0; i < V; i++) {
                 adj[i] = new LinkedList<>();
             }
             edges = new Edge[E];
         }
         //无向图,不带权值
         public void addEdge(int u, int v){
            adj[u].add(v);
            adj[v].add(u);
            E++;
         }
         //无向图，带权值
         public void addEdge(int u, int v, double w){
             adj[u].add(v);
             adj[v].add(u);
//             kruskal用到
             edges[n] = new Edge(u, v, w);
             n += 1; //标记增一
         }
         //权重为整型
         public void addEdge(int u, int v, int w){
             adj[u].add(v);
             adj[v].add(u);
             //bellman用到
             edges1.add(new Edge(u, v, w));
             E++;
         }
         //返回adj[v],即顶点v的链表
         public LinkedList<Integer> getAdj(int v){
             return adj[v];
         }

         //返回边的条数
         public int getE() {
             return E;
         }

         //返回边顶点的个数
         public int getV() {
             return V;
         }
         //边的数据结构
         //实现Comparable 以便实现排序
         class Edge implements Comparable{
             private int u, v; //u为起始点，v为另一点
             double w;  //边权重
             public Edge(int u, int v, double w){
                 this.u = u;
                 this.v = v;
                 this.w = w;
             }
             public Edge(int u, int v) {
                 this.u = u;
                 this.v = v;
             }
             int getU(){
                 return u;
             }
             int getV(){
                 return v;
             }
             double getW(){
                 return w;
             }
             //实现权值排序
             @Override
             public int compareTo(Object o) {
                 if(this.w > ((Edge) o).w) return 1;
                 else if(this.w == ((Edge) o).w) return 0;
                 else return -1;
             }
             public String toString(){
                 return this.getU() + " " + this.getV() + " " + " w: " + this.getW();
             }
         }
     }
    //深度优先搜索，G为图，s为起始顶点,非递归
    public static void DFS(Graph G, int s){
        //每个顶点的标记
        boolean[] marked = new boolean[G.getV()];
        Iterator<Integer>[] adj1 = (Iterator<Integer>[]) new Iterator[G.getV()];
        //将adj装入adj1
        for(int i = 0; i < G.getV(); i++){
            adj1[i] = (Iterator<Integer>) G.getAdj(i).iterator();
        }
        System.out.print(s + " ");
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        marked[s] = true;
        while (!stack.isEmpty()){
            int u = stack.peek();
            //还有连接的节点继续
            if(adj1[u].hasNext()) {
                int v = adj1[u].next();
                //没访问的话继续访问，并标记
                if (!marked[v]) {
                    marked[v] = true;
                    System.out.print(v + " ");
                    stack.push(v);
                }
            }
            //没有链接表了，就出栈进入下一个顶点的链接表
            else {
                stack.pop();
            }
        }
    }
    //递归
    static class DeepFirstSearch1{
         private boolean marked[];
         private Graph G;
         public DeepFirstSearch1(Graph G){
             marked = new boolean[G.getV()];
             this.G = G;
         }
         //每次都是一个没有标记的顶点,递归查找
         public void dfs(int s){
             marked[s] = true;
             System.out.print(s + " ");
             for(int u : G.getAdj(s)){
                 if(!marked[u])
                     dfs(u);
             }
         }
    }
    static class BreadFirstSearch{
         private boolean marked[];
         private Graph G;
         private Queue<Integer> queue;
         public BreadFirstSearch(Graph G){
            marked = new boolean[G.getV()];
            queue = new LinkedList<Integer>();
            this.G = G;
         }
         public void bfs(int s){
             marked[s] = true;
             System.out.print(s + " ");
             //第一个节点入队
             queue.add(s);
             while (!queue.isEmpty()) {
                 //队列不为空，就遍历队列第一个节点链接表，并将节点出队
                 for (int i : G.getAdj(queue.poll())) {
                     if (!marked[i]) {
                         System.out.print(i + " ");
                         marked[i] = true;
                         queue.add(i);
                     }
                 }
             }
         }
    }
    //最小生成树
    static class Kruskal{
         private Graph G;
         private HashSet<Integer> set;
         private HashSet<Graph.Edge> miniTree;
         public Kruskal(Graph G){
             set = new HashSet<>();
             miniTree = new HashSet<>();
            this.G = G;
            //将边按权值大小排序
            Arrays.sort(G.edges);
         }
         public HashSet<Graph.Edge> kruskal(){
//             set.add(G.edges[0].u); //把起始点加入集合
             for(Graph.Edge edge: G.edges){
                 //如果集合不包括访问过边的顶点,将边加入最小生成树
                 if(!set.contains(edge.v) || !set.contains(edge.u)){  //如果是有向图的话只需改为 if !set.contains(edge.v)
                     set.add(edge.v);                                 //                            set.add(v);
                     set.add(edge.u);
                     miniTree.add(edge);
                     System.out.println(edge.toString());
                 }
             }
             return miniTree;
         }
    }

    static class BellmanFord {
        private Graph G;
        private int s;
        private int[] distance;   //存放总距离和
        private int[] preNode;    //前驱结点
        private final int Max = 0xffff; //表示无穷大的值
        private Stack stack;   //用于存路径使用

        public BellmanFord(Graph G, int s) {
            this.G = G;
            this.s = s;
            distance = new int[G.getV()];
            preNode = new int[G.getV()];
            stack = new Stack();
            //初始化所有节点
            for (int i = 0; i < G.getV(); i++) {
                distance[i] = Max; //无穷表示不能确定
                preNode[i] = -1; //-1表示不存在
            }
            distance[s] = 0;    //源起点权值合为0
        }

        //松弛操作
        public void relex(Graph.Edge edge) {
            if (distance[edge.getV()] > distance[edge.getU()] + edge.getW()) {
                distance[edge.getV()] = (int) (distance[edge.getU()] + edge.getW());
                preNode[edge.getV()] = edge.getU();
            }
        }
        //填装路径
        public void initContain(int e){
            if(preNode[e] == s || preNode[e] == -1)
                return;
           stack.push(preNode[e]);
           initContain(preNode[e]);
        }
        //遍历
        public void traverse(int e){
            System.out.print(s + "->");
            while (!stack.isEmpty())
                System.out.print(stack.pop() + "->");
            System.out.print(e + " 长度为：" + this.getLength(e) + "\n");
        }

        public boolean bellmanFord(int e) {
            //每一条边进行松弛操作
            for (Graph.Edge edge : G.edges1) {
                relex(edge);
            }
            //判断有无负环
            for (int i : distance) {
                if(i < 0)  return false;
            }
            //填栈
            initContain(e);
            //遍历
            traverse(e);
            return true;
        }

        public int getS(){
            return s;
        }
        public int getLength(int i){
            return distance[i];
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        G.addEdge(1, 4);
        G.addEdge(1, 5);
        G.addEdge(5, 3);
        System.out.println("深度优先递归: ");
        DeepFirstSearch1 dfs1 = new DeepFirstSearch1(G);
        dfs1.dfs(0);
        System.out.println(" ");
        System.out.println("深度优先非递归: ");
        DFS(G, 0);
        System.out.println("");
        System.out.println("广度优先：");
        BreadFirstSearch bfs1 = new BreadFirstSearch(G);
        bfs1.bfs(0);
        System.out.println("");
        System.out.println("kruskal: ");
        Graph G1 = new Graph(8, 8);
        G1.addEdge(0, 1,  0.1);
        G1.addEdge(0, 2, 0.2);
        G1.addEdge(0, 3, 0.1);
        G1.addEdge(1, 4, 0.8);
        G1.addEdge(1, 5, 1.3);
        G1.addEdge(5, 3, 0.5);
        G1.addEdge(2, 5, 0.2);
        G1.addEdge(4, 0 , 0.1);
        Kruskal kruskal = new Kruskal(G1);
        HashSet miniTree = kruskal.kruskal();
        System.out.println("最小生成树: ");
        System.out.println(miniTree);
        System.out.println("BellManFord最短路径:");
        Graph G2 = new Graph(6);
        G2.addEdge(0, 1, 1);
        G2.addEdge(0, 2, 1);
        G2.addEdge(0, 3, 2);
        G2.addEdge(1, 4, 3);
        G2.addEdge(1, 5, 2);
        G2.addEdge(5, 3, -2);
        G2.addEdge(2, 5, 2);
        G2.addEdge(4, 5, -1);
        BellmanFord bellmanFord = new BellmanFord(G2, 0);
        for(int i = 0; i < G2.getV(); i++) {
            System.out.println(bellmanFord.getS() + "到" + i + "的最短路径:");
            if (bellmanFord.bellmanFord(i)) ;
            else
                System.out.println("存在负还路");
        }
    }
}
