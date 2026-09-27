public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        
        Pair[] people = new Pair[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Pair(names[i], heights[i]);
        }
        
        Arrays.sort(people, (a, b) -> Integer.compare(b.height, a.height));
        
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i].name;
        }
        
        return sortedNames;
    }
    
    private static class Pair {
        String name;
        int height;
        
        Pair(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}