class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet dsu = new DisjointSet(edges.length);
        int[] ans = new int[2];
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(dsu.findUParent(u) == dsu.findUParent(v)){
                ans[0] = u;
                ans[1] = v;
            }
            else{
            dsu.unionBySize(u,v);
            }
        }

        return ans;
    }
}

class DisjointSet {
    int[] size;
    int[] parent;

    public DisjointSet(int n){
        this.size = new int[n+1];
        this.parent = new int[n+1];

        for(int i = 0; i <= n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUParent(int u){
        if(parent[u] == u){
            return u;
        }

        return parent[u] = findUParent(parent[u]);
    }

    public void unionBySize(int u, int v){
        int ulpU = findUParent(u);
        int ulpV = findUParent(v);

        if(ulpU == ulpV){
            return;
        }

        if(size[ulpU] < size[ulpV]){
            parent[ulpU] = ulpV;
            size[ulpV] += size[ulpU];
        }
        else{
            parent[ulpV] = ulpU;
            size[ulpU] += size[ulpV];
        }
    }
}
