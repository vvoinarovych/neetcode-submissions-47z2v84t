class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int h : hand){
            count.put(h, count.getOrDefault(h, 0) + 1);
        }
        for(int i = 0; i < hand.length / groupSize; i++){
            int first = count.firstKey();
            for(int j = 0; j < groupSize; j++){
                if(!count.containsKey(first + j)){
                    return false;
                }else{
                    int c = count.get(first + j);
                    if(c == 1){
                        count.remove(first + j);
                    }else{
                        count.put(first + j, count.get(first + j) - 1);
                    }
                }
            }
        }
        return true;
    }
}
