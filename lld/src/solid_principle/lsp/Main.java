package solid_principle.lsp;

class Notification{
    public void sendNotification() {
        System.out.println("Email service");
    }
}

class TextNotification extends Notification {
    @Override
    public void sendNotification() {
        System.out.println("Text service");
    }
}
public class Main {
    public static void main(String[] args){
        Notification notification = new Notification();
        notification.sendNotification();
    }
}
