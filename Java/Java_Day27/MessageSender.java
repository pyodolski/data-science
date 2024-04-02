package Java_Day27;
class Message<T, E> {
    private T contents;
    private E elements;
    // E(element)는 그 의미로 요소라고 해석할 수 있다.
    // ArrayList는 요소들(오브젝트)를 배열처럼 저장 하기 때문에 E로 선언되어야 한다.

    public Message(T contents, E elements) {
        this.contents = contents;
        this.elements = elements;
    }

    public E getElements() {
        return elements;
    }

    public void setElements(E elements) {
        this.elements = elements;
    }

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }
}

public class MessageSender {
    public <T, E> void sendMsg(Message<T, E> message, String to) {
        T content = message.getContents();
        E element = message.getElements();

        System.out.println("Sending msg to" + content + element);
    }
}

class GenericMsgSystem {
    public static void main(String[] args) {
        Message<Integer, String> stringMessage = new Message<>(1000000, " ddddd");
        MessageSender sender = new MessageSender();
        sender.sendMsg(stringMessage, "kim");
    }
}
