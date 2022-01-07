package example;

public abstract class Book {
    abstract boolean setCategory(String Category);
    abstract String getCategory();
    abstract boolean setName(String name);
    abstract String getName();
    abstract boolean setSize(int size);
    abstract int getSize();
    {//在抽象类里仍然可以执行一些代码
        int i =0;
        while(i>2){
            i++;
        }
    }
}
