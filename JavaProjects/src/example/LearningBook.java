package example;

import java.util.Date;

public class LearningBook extends Book implements Comparable<LearningBook>{

    private String name;
    private int size;
    private String category;
    private Date createDate;

    public LearningBook(){
        createDate = new Date();
    }
    public LearningBook(int size){
        this();
        setSize(size);
    }
    public LearningBook(String Name){
        this();
        setName(Name);
    }
    public LearningBook(String name, int size){
        this(name);
        setSize(size);
    }
    public LearningBook(String name, int size,String Category){
        this(name,size);
        setCategory(Category);
    }

    @Override
    boolean setCategory(String category){
        this.category = category;
        return true;
    }

    @Override
    String getCategory() {
        return category;
    }

    @Override
    boolean setName(String name) {
        this.name = name;
        return true;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    boolean setSize(int size) {
        this.size = size;
        return true;
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    public int compareTo(LearningBook book) {
        System.out.println(compare(this,book));
        return 0;
    }

    private String compare(LearningBook a,LearningBook b){
        String[] info = new String[]{"","","",""};
        if(a.category != b.category) info[0]="【category】Not the same category.\n";
        else info[0] = "【category】They are in the same category.\n";
        if(a.name != b.name) info[1]="【name】Not the same book.\n";
        if(a.size == b.size){
            int t = a.createDate.compareTo(b.createDate);
            if(t == 0 ) info[2] = "【createDate】Two books have the same size and identical createTime.\n";
            else if( t < 0 ) info[2] = "【createDate】Two books have the same size, and the '"+a.name+"' is more former.\n";
            else  info[2] = "【createDate】Two books have the same size, and the '"+b.name+"' is more former.\n";
        }
        else if(a.size > b.size)  info[3] = "【size】The '"+ a.name + "' is bigger.\n";
        else  info[3] = "【size】The '"+ b.name + "' is bigger.\n";
        return info[0]+info[1]+info[2]+info[3];
    }

}
