class p{
    public static int fn(int []coins, int amount){
        if(amount==0)return 0;
        int ans = Integer.MAX_VALUE;
        for(int j = 0;j<coins.length;j++){
            if(amount-coins[j]>=0){
                int c = fn(coins,amount-coins[j]);
                if(c!=Integer.MAX_VALUE && c+1 < ans){
                    ans = c+1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        int arr[] = {1,2,5};
        int t = 7;

        System.out.println(fn(arr,t));

    }
}