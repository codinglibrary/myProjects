package example;

import java.util.IdentityHashMap;

public class LambdaExample<T> {
    IAddable<T> character;
    LambdaExample(){
        this.character = null;
    }
    LambdaExample(IAddable a){
        this.character = a;
    }
    public void eat(IEatable eatable){
        System.out.println(eatable);
        eatable.taste();
    }

    public void drive(IFlyable flyable){
        System.out.println(flyable);
        System.out.println("我正在驾驶：" + flyable.toString());
        flyable.fly("「夏日晴天」");
    }
    public IAddable<T> calc(IAddable<T> addable){

        return (IAddable<T>) new LambdaExample<T>(character.add(addable));
    }

    @Override
    public String toString() {
        return "LambdaExample{" +
                "character=" + character +
                '}';
    }
}
