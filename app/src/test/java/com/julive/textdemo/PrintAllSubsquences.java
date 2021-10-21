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
        List<String> subs = subs(content);
        System.out.println(subs.toString());
    }

    public List<String> subs(String s) {
        List<String> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        String path = "";
        process(str, 0, ans, path);
        return ans;
    }

    private void process(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        process(str, index + 1, ans, path);
        process(str, index + 1, ans, path + str[index]);
    }
}
