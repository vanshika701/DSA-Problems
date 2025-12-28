class Solution {
    public int beautySum(String s) {
        int k=0;
        int sum=0;
        for(int j=0;j<s.length();j++){
            int arr[]=new int[26];
            for(int p=j;p<s.length();p++){
            int max=0;
            int min=Integer.MAX_VALUE;
            //String st=s.substring(j,p);
            k=s.charAt(p)-'a';
            arr[k]+=1;
        for(int i=0;i<26;i++){
            if(max<arr[i])
            max=arr[i];
            if(min>arr[i]&&arr[i]!=0)
            min=arr[i];
        }
        sum=sum+(max-min);
        }
        }
        return sum;
    }
}