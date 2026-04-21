class Solution {

   public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimiter = str.indexOf('#', i);

            int length = Integer.parseInt(str.substring(i, delimiter));

            String word = str.substring(delimiter + 1, delimiter + 1 + length);
            result.add(word);

            i = delimiter + 1 + length;
        }

        return result;
    }
}