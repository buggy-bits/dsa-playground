// Problem: Evaluate Division
// URL: https://leetcode.com/problems/evaluate-division/?envType=study-plan-v2&envId=leetcode-75
// Difficulty: Medium
// Date Solved: 2026-05-20

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> mygraph = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            mygraph.putIfAbsent(u, new HashMap<>());
            mygraph.putIfAbsent(v, new HashMap<>());
            double weight = values[i];
            mygraph.get(u).put(v, weight);
            mygraph.get(v).put(u, 1.0 / weight);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!mygraph.containsKey(start) || !mygraph.containsKey(end)) {
                ans[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(start, end, mygraph, 1.0, visited);
            }
        }
        return ans;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> mygraph, double cproduct,
            Set<String> visited) {
        if (start.equals(end)) {
            return cproduct;
        }

        visited.add(start);

        for (Map.Entry<String, Double> neibhour : mygraph.get(start).entrySet()) {
            String nextNode = neibhour.getKey();
            double weight = neibhour.getValue();

            if (!visited.contains(nextNode)) {
                double result = dfs(nextNode, end, mygraph, cproduct * weight, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }

}