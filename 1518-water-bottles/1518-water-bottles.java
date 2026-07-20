class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if(1 > numBottles ||numBottles >100||numExchange<2 ||numExchange>100 )
        {
            return 0;
        }
        int sum;
        int rem=numBottles%numExchange;
        int x=numBottles/numExchange;
        sum= x+numBottles;
        int a= rem+x;
        while(a>=numExchange)
        {
            rem= a%numExchange;
            a= a/numExchange;
            sum=sum+a;
            a= a+rem;
        }
        return sum;
    }
}