class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                int first = nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while(l < r){
                    int sum  = nums[l] + nums[r] + first;
                    if(sum == 0){
                        result.add(List.of(first, nums[l], nums[r]));
                        while(l < r && nums[l + 1] == nums[l]){
                            l++;
                        }
                        while(l < r && nums[r - 1] == nums[r]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if(sum < 0){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
