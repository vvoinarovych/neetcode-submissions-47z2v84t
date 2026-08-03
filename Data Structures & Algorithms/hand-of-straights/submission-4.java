class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h : hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        for(int i = 0; i < hand.length / groupSize; i++){
            int num = map.firstKey();
            for(int j = 0; j < groupSize; j++){
                if(!map.containsKey(num + j)) return false;
                if(map.get(num + j) == 1){
                    map.remove(num + j);
                }else{
                    map.put(num + j, map.get(num + j) - 1);
                }
            }
        }
        return true;
    }
}
