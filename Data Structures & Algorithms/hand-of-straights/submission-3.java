class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h : hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for(int i = 0; i < hand.length / groupSize; i++){
            int first = map.firstKey();
            for(int j = 0; j < groupSize; j++){
                if(map.containsKey(first + j)){
                    if(map.get(first + j) == 1){
                        map.remove(first + j);
                    }else{
                        map.put(first + j, map.get(first + j) - 1);
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
