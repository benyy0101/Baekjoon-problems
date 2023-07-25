class Solution {
    public String solution(String s) {
        
        String[] temp = s.split("\\s+");
        int maxNum = -Integer.MAX_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length ; i++){
            int target = Integer.parseInt(temp[i]);
            if(target > maxNum){
                maxNum = target;
            }
            if(target < minNum){
                minNum = target;
            }
        }
        
        return String.valueOf(minNum) + " " + String.valueOf(maxNum);
    }
}