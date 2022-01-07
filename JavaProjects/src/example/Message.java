package example;

public class Message {
    private Channel channel;
    private String title;
    private String content;

    public Message (Channel channel,String title,String content){//this 指针的一个应用
        System.out.println("Message constructor");
        this.channel = channel;
        this.title = title;
        this.content = content;
    }
    public void send(){
        if(this.channel.isConnect()){
            System.out.println("【消息发送】title="+this.title+",content="+this.content);
        }else{
            System.out.println("【ERROR】");
        }
    }

}

