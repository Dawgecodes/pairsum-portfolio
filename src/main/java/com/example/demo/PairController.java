package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PairController {

    @GetMapping("/")
    public String home() {
        return "index"; // templates/index.html
    }

    @PostMapping("/check")
    public String check(@RequestParam("numbers") String numbers,
                        @RequestParam("target") int target,
                        Model model) {

        String[] parts = numbers.split(",");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i].trim());
        }

        List<String> pairs = findPairs(nums, target);
        model.addAttribute("pairs", pairs);
        model.addAttribute("target", target);

        return "result"; // templates/result.html
    }

    public List<String> findPairs(int[] nums, int target) {
        Arrays.sort(nums); // two-pointer requires sorted array
        int left = 0, right = nums.length - 1;
        List<String> results = new ArrayList<>();

        while (left < right) {
            int curr = nums[left] + nums[right];
            if (curr == target) {
                results.add(nums[left] + " + " + nums[right]);
                left++;
                right--;
            } else if (curr > target) {
                right--;
            } else {
                left++;
            }
        }
        return results;
    }
}

