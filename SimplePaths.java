package simplepaths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SimplePaths {
    public static int countSimplePaths(ArrayList<ArrayList<Integer>> a, int start, int length) {
        Set<Integer> visited = new HashSet<>();
        int[] count = {0};
        dfs(a, start, length, visited, count, new ArrayList<>());
        return count[0] / 2;}

    private static void dfs(ArrayList<ArrayList<Integer>> a, int node, int currentLength, Set<Integer> visited, int[] count, List<Integer> currentPath) {
        visited.add(node);
        currentPath.add(node);
        if (currentLength >= 2) {
            count[0]++;}

        for (int neighbor : a.get(node)) {
            if (!visited.contains(neighbor) && !currentPath.contains(neighbor)) {
                dfs(a, neighbor, currentLength + 1, visited, count, currentPath);}}

        visited.remove(node);
        currentPath.remove(currentPath.size() - 1);}
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList());}
        System.out.println("Enter the edges in the form 'i j', indicating an edge between vertex i and vertex j:");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            a.get(v).add(u);
            a.get(u).add(v);}
        System.out.println(a);

        int totalPaths = 0;

        for (int vertex = 1; vertex <= n; vertex++) {
            totalPaths += countSimplePaths(a, vertex, 0);}
        
        System.out.println("Number of simple paths of length at least 2: " + totalPaths);}}
    

