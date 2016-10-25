package medium_LongestAbsoluteFilePath;

import java.util.Stack;

public class Solution {
    public static int lengthLongestPath(String str) {
        if(str == null || str.length() == 0) {
			return 0;
		}
		String[] parseS = str.split("\n");
		//System.out.println(parseS.length);
		int prevLevel = 0;
		int prevLength = 0;
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < parseS.length; i++) {
			//System.out.println("prevLength = "+prevLength);
			
			int j = 0;
			int level = 0;
			for(j = 0; j < parseS[i].length(); j++) {
				if(parseS[i].charAt(j) != '\t') {
					break;
				}
				level++;
			}
// 			System.out.println("prevLevel = "+prevLevel);
// 			System.out.println("level = "+level);
// 			System.out.println("j = "+j);
			String dir = parseS[i].substring(j, parseS[i].length());
			//System.out.println(dir.length());
			while(level <= prevLevel && !stack.isEmpty()) {
				int m = stack.pop();
				prevLength -= m + 1;
				prevLevel -= 1;
				sb.delete(sb.length() - m - 1, sb.length());
			}
			
            if(isFile(dir)) {
				max = Math.max(max, prevLength + dir.length());
			}
			else {
				stack.push(dir.length());
				prevLength += dir.length() + 1;
				sb.append(dir+"\\");
				prevLevel = level;
			}

		}
		return max;
    }
    
    
    
    private static boolean isFile(String word) {
		if(word.length() == 0) {
			return false;
		}
		boolean hasDot = false;
		for(int i = word.length() - 1; i >= 0; i--) {
			if(word.charAt(i) == '.') {
				hasDot = true;
				break;
			}
		}
		return hasDot;
	}

	
	public static void main(String[] args) {
		String str = "dir1\n dir11\n  a.txt\n  b.jpg\n  c.png\n  dir111\n   s.png\n abcdefghijklmnopqrstuv.gif\naaa\n bbb\n  abcdefghijklmnopqrstuv.gif\nabcdefghijklmnopqrstuvwxyz1234567891011.png";
		System.out.println(str);
		System.out.println(lengthLongestPath(str));
		String str2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println("abcdefghijklmnopqrstuvwxyz1234567891011.png".length());
		System.out.println(lengthLongestPath(str2));
//		dir1/dir11/b.jpg
//		dir1/dir11/dir111/s.png
	}
}
