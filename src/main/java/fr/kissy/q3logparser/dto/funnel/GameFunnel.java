package fr.kissy.q3logparser.dto.funnel;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import fr.kissy.q3logparser.dto.Game;
import fr.kissy.q3logparser.dto.Player;

/**

 */
public class GameFunnel implements Funnel<Game> {
    public static final Funnel<Game> INSTANCE = new GameFunnel();

    @Override
    public void funnel(Game game, PrimitiveSink into) {
        into.putString(game.getType().name())
            .putString(game.getMap())
            .putInt(game.getDuration());
        for (Player player : game.getPlayers().values()) {
            into.putString(player.getTeam().name())
                .putString(player.getName())
                .putInt(player.getScore())
                .putInt(player.getStreak().getFrag())
                .putInt(player.getStreak().getDeath())
                .putInt(player.getFlag().getCaptured())
                .putInt(player.getFlag().getPickedUp())
                .putInt(player.getFlag().getReturned());
        }
    }
}