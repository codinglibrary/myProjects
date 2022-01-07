package example;

public class Channel {
    private Message message;

    public Channel(String title,String content){
        System.out.println("Channel constructor");
        this.message = new Message(this,title,content);
        this.message.send();
    }
    public boolean isConnect(){
        return true;
    }
}
