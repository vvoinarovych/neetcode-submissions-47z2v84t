class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> stack = new HashSet<>();
        for(int n : nums){
            if(stack.contains(n)) return true;
            stack.add(n);
        }
        return false;
    }
}