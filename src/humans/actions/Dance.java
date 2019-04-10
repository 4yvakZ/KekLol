package humans.actions;

import exceptions.MusicOffException;
import street.Street;

//Для анонимного класса
public interface Dance {
    String danceToMusic(Street.Music music) throws MusicOffException;
}
