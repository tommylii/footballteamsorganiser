package core.services;

import core.model.Player;

import java.util.Collection;

/**
 * Created by tommylii on 04/12/2015.
 */
public interface PlayerService {

    Player createPlayer(String name);

    Collection<Player> getAllPlayers();

    Collection<Player> findPlayersByName(String name);
}
