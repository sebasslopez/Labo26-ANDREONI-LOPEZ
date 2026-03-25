package UN0;

public class DivisibleFor_DivisibleWhile {
    public static void main(String[] args) {
        for(int i=1; i<101;i++){
            if(i % 3 == 0 && i % 2 ==0){
                System.out.println(i);

            }
        }
        int i =1;
        while(i < 101){
            if(i % 3 == 0 && i % 2 ==0){
                System.out.println(i);

            }
            i++;
        }
    }
}
