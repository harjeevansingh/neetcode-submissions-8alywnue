class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null){
            return true;
        } else if(s == null || t == null){
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        s = new String(sArr);
        t = new String(tArr);

        System.out.println(s);
        System.out.println(t);

        return s.equals(t);

    }
}
