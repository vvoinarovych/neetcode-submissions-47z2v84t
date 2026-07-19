class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int size = hand.length % groupSize;
        if(size != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h : hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        for(int i = 0; i < hand.length / groupSize; i++){
            var entry = map.firstEntry();
            int k = entry.getKey();            
            for(int j = 0; j < groupSize; j++){
                if(!map.containsKey(k + j)){
                    return false;
                }else{
                    var val = map.get(k + j);
                    if(val == 1){
                        map.remove(k + j);
                    }else{
                        map.put(k +j, map.get(k + j) - 1);
                    }
                }
            }
        }
        return true;
    }
}
