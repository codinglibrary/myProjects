package main.java.life.personal.example;

/**
 * @author David
 */
public class Main {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(IdGenerator.getInstance().getId());
        }
    }
}
