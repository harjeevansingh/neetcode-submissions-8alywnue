class Solution {

    public String encode(List<String> strs) {
        String strCombine = strs.stream()
            .map(str -> str.length() + "#" + str)
            .collect(Collectors.joining(""));
        System.out.println(strCombine);
        return strCombine;
    }

    public List<String> decode(String str) {
        List<String> finalList = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            StringBuilder currentStrLen = new StringBuilder();
            while (i < str.length() && str.charAt(i) != '#') {
                currentStrLen.append(str.charAt(i));
                i++;
            }
            i++;

            int currentLength = Integer.parseInt(currentStrLen.toString());

            StringBuilder currentString = new StringBuilder();
            for(int j=0;j<currentLength;j++){
                currentString.append(str.charAt(i));
                i++;
            }

            finalList.add(currentString.toString());
        }

        return finalList;
    }
}
