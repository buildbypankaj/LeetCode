class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1|| numRows >= s.length()){
            return  s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0;i < numRows;i++){
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;
        boolean goingDown = false;

        for(char ch : s.toCharArray()){
            rows[currentRow].append(ch);
            if(currentRow == 0 || currentRow == numRows -1){
                goingDown = !goingDown;
            }
            if(goingDown){
                currentRow++;
            }
            else{
                currentRow--;
            }
        }
        StringBuilder result = new StringBuilder();

        for(int i = 0;i<numRows;i++){
            result.append(rows[i]);
        }
        return result.toString();
    }
}