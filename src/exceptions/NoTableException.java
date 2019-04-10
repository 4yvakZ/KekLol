package exceptions;

public class NoTableException extends NullPointerException {
    public NoTableException(Throwable e){
        System.out.println("Поставь стол, а то будешь есть на полу!!!");
        initCause(e);
    }
}
