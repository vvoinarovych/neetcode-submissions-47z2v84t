class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int number = nums[i];
            if(seen.containsKey(target - number)){
                return new int[]{seen.get(target - number), i};
            }
            seen.put(number, i);
        }
        return new int[2];
    }
}
