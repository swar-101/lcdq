package com.leetcode.problem0165.v1;

public class Solution {
    public int compareVersion(String version1, String version2) {
        int sizeV1 = 1;
        for (int i = 0; i < version1.length(); i++) {
            if (version1.charAt(i) == '.') sizeV1++;
        }

        int sizeV2 = 1;
        for (int i = 0; i < version2.length(); i++) {
            if (version2.charAt(i) == '.') sizeV2++;
        }

        int[] arrV1 = new int[sizeV1];
        int[] arrV2 = new int[sizeV2];

        StringBuilder s = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < version1.length(); i++) {
            if (version1.charAt(i) == '.') {
                arrV1[idx++] = Integer.parseInt(s.toString());
                s = new StringBuilder();
                continue;
            }
            s.append(version1.charAt(i));
            if (i == version1.length() - 1)
                arrV1[idx++] = Integer.parseInt(s.toString());
        }

        s = new StringBuilder();
        idx = 0;
        for (int i = 0; i < version2.length(); i++) {
            if (version2.charAt(i) == '.') {
                arrV2[idx++] = Integer.parseInt(s.toString());
                s = new StringBuilder();
                continue;
            }
            s.append(version2.charAt(i));
            if (i == version2.length() - 1)
                arrV2[idx++] = Integer.parseInt(s.toString());
        }

        for (int i = 0; i < Math.min(sizeV1, sizeV2); i++) {
            if (arrV1[i] > arrV2[i]) return 1;
            else if (arrV1[i] < arrV2[i]) return -1;
        }

        if (sizeV1 - sizeV2 == 0) return 0;
        else if (sizeV1 > sizeV2) {
            for (int i = sizeV2; i < sizeV1; i++) {
                if (arrV1[i] != 0) return 1;
            }
            return 0;
        } else {
            for (int i = sizeV1; i < sizeV2; i++) {
                if (arrV2[i] != 0) return -1;
            }
            return 0;
        }
    }
}
