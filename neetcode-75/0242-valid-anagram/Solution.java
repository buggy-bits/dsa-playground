// Problem: Valid Anagram
// URL: https://leetcode.com/problems/valid-anagram/
// Difficulty: Easy
// Date Solved: 2026-05-30

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         char[] sArre = s.toCharArray();
//         char[] tArre = t.toCharArray();

//         int sn = sArre.length;
//         int tn = tArre.length;

//         if (sn !=tn){
//             return false;
//         }

//         HashMap<Integer,Integer> myMap = new HashMap<>();
//         for(int i=0;i<sn ; i++){
//             myMap.put(sArre[i] - 'a', myMap.getOrDefault(sArre[i]- 'a' , 0) + 1);
//             myMap.put(tArre[i]- 'a', myMap.getOrDefault(tArre[i] - 'a', 0) - 1);

//         }
//          for (int count : myMap.values()) {
//             if (count != 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArre = s.toCharArray();
        char[] tArre = t.toCharArray();

        int sn = sArre.length;
        int tn = tArre.length;
        if (sn != tn) {
            return false;
        }

        int[] arre = new int[26];

        for (int i = 0; i < sn; i++) {
            arre[sArre[i] - 'a'] += 1;
            arre[tArre[i] - 'a'] -= 1;

        }

        for (Integer x : arre) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}