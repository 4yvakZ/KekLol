package exceptions;


public class MusicOffException extends Exception{
    public String getMessage(){
        return "Музыка выключена";
    }
}
