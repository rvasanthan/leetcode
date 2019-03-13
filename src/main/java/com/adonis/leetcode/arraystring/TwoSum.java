package com.adonis.leetcode.arraystring;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] intArray = {2, 11,7,15, 13, 8, 5, 67};
        int target = 18;                                                                                                                      ;
        int[] result = twoSum.twoHashMap(intArray, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public int[] twoBruteForce(int[] nums, int target) {

        int[] result = {0, 0};
        boolean found = false;
        for(int i=0; i<nums.length; i++) {

            if(nums[i] < target) {
                int remaining = target - nums[i];
                for(int j=0; j<nums.length; j++) {
                    if(i == j) {
                        continue;
                    } else {
                        if(remaining == nums[j]) {
                            result[1] = j;
                            result[0] = i;
                            found = true;
                            break;
                        }
                    }
                }

            }
            if(found) {
                break;
            }
        }
        return result;
    }

    public int[] twoHashMap(int[] nums, int target) {
        int[] result = {0, 0};
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            int remaining = target - nums[i];
            if(!numsMap.containsKey(remaining)) {
                numsMap.put(nums[i], i);
            } else {
                result[0] = numsMap.get(remaining);
                result[1] = i;
                break;
            }
        }
        return result;
    }

}
