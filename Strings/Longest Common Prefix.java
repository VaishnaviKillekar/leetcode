// Link to problem - https://leetcode.com/problems/longest-common-prefix/

/**
 * Intuition - Scan through the string of arrays from the 2nd string with 1st string set as initial prefix.
 * If the 'prefix' is longer than current string, then compare characters of both strings until there is no match using the 'shorter' string as reference.
 * An 'index' variable is used to track the longest common substring while comparing the two strings.
 * If prefix is empty at any point, return it immediately and terminate the program.
 *
 * Time complexity - O(mn) - where 'm' is average length of each string and 'n' is the number of strings.
 * Space complexity - O(1)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        for(int i=1; i<strs.length; i++) {
            if(prefix.length() > strs[i].length()) {
                prefix = getLongestPrefix(prefix, strs[i]);
            }
            else {
                prefix = getLongestPrefix(strs[i], prefix);
            }
            
            if(prefix == "") {
                return prefix;
            }
        }
        
        return prefix;
    }
    
    public String getLongestPrefix(String longer, String shorter) {
        if(shorter != "" && longer.substring(0, shorter.length()).equals(shorter)) {
            return shorter;
        }
        
        int index = -1;
        for(int i=0; i<shorter.length(); i++) {
            if(shorter.charAt(i) == longer.charAt(i)) {
                index++;
            }
            else {
                break;
            }
        }
        
        return index != -1 ? shorter.substring(0, index+1) : "";
    }
}
