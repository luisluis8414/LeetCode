package LeetCode.Easy.RomansToInteger;

public class SolutionRomanToInteger {
    public int romanToInt(String s) {
        int num=0;
        char[] roman = s.toCharArray();
        for(int i=0;i<roman.length;i++)
        {
            if(roman[i]=='I')
            {   
                num+=1;
                if(i!=roman.length-1){
                if(roman[i+1]=='V'||roman[i+1]=='X')
                {
                 num-=2;
                }
                }
            
                
            }
            if(roman[i]=='V')
            {
                num+=5;
            }
            if(roman[i]=='X')
            {
                num+=10;
                if(i!=roman.length-1)
                {
                if(roman[i+1]=='L'||roman[i+1]=='C')
                    {
                    num-=20;
                    }
                
                }
            }
            if(roman[i]=='L')
            {
                num+=50;
            }
            if(roman[i]=='C')
            {
                num+=100;
                if(i!=roman.length-1)
                {
                    if(roman[i+1]=='D'||roman[i+1]=='M')
                    {
                        num-=200;
                    }
                }
            }
            if(roman[i]=='D')
            {
                num+=500;
            }
            
            if(roman[i]=='M')
            {
                num+=1000;
            }
        }
        
        return num; 
    }
}
