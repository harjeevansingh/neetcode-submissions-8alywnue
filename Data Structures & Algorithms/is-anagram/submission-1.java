class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null){
            return true;
        } else if(s == null || t == null){
            return false;
        }

        HashMap<Character, Integer> track1 = new HashMap<>();
        HashMap<Character, Integer> track2 = new HashMap<>();

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        s = new String(sArr);
        t = new String(tArr);

        System.out.println(s);
        System.out.println(t);

        return s.equals(t);
        // for(char c: Arrays.sorted(s.toCharArray())){
        //     track1.put(c, track1.computeIfAbsent(c, k -> 0) + 1);
        // }

    }
}
