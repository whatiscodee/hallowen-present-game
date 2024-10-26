package me.whatiscode.halloween.game.sql;

import me.whatiscode.halloween.game.presents.HalloweenPresent;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PresentsSql extends DatabaseUtil {

    static String CLAIM_PRESENT_QUERY = "INSERT INTO presents (player_name, present_key) VALUES (?, ?)";

    public static void claimPresent(Player player, HalloweenPresent present) throws SQLException {

        try (Connection connection = getBdConnection();
             PreparedStatement statement = connection.prepareStatement(CLAIM_PRESENT_QUERY)) {

            statement.setString(1, player.getName());
            statement.setString(2, present.getKey());
            statement.executeUpdate();
        }
    }

}
