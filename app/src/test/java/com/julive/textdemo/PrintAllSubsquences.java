package com.julive.textdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinxianlun
 * on 10/21/21
 */
public class PrintAllSubsquences {

    @Test
    public void test() {
        String content = "abc";
//        List<String> subs = subs(content);
//        System.out.println(subs.toString());

        List<String> strings = permutation2(content);
        System.out.println(strings.toString());
    }

    public List<String> subs(String s) {
        List<String> ans = new ArrayList<>();
        process(s, 0, ans, "");
        return ans;
    }

    private void process(String str, int index, List<String> ans, String path) {
        if (index == str.length()) {
            ans.add(path);
            return;
        }

        process(str, index + 1, ans, path);
        process(str, index + 1, ans, path + str.charAt(index));
    }

    public List<String> permutation2(String s) {
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        process1(chars, 0, ans);
        return ans;
    }

    private void process1(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            for (int i = index; i < str.length; i++) {
                swap(str, index, i);
                process1(str, index + 1, ans);
                swap(str, index, i);
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char a = arr[j];
        arr[j] = arr[i];
        arr[i] = a;
    }

}
