class Human {
    public String species = "sapiens";
    public int age;

    public Human(int age) {
        this.age=age;
    }
}

// Write a program that prints out the numbers 1 to 100 (inclusive). If the number is divisible by 3, print Crackle instead of the number. If it's divisible by 5, print Pop instead of the number. If it's divisible by both 3 and 5, print CracklePop instead of the number. You can use any language.

class Main {
    public static void main(String[] args) {
        for (int num=1;num<=100;num++){
            if(num%3==0 && num%5==0){
                // divisible by both
                System.out.println("CracklePop");
            }
            else if(num%3==0){
                System.out.println("Crackle");
            }
            else if(num%5==0){
                System.out.println("Pop");
            }
            else{
                System.out.println(num);
            }
        }
    }
}