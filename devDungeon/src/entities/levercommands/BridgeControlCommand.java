package entities.levercommands;

import core.level.utils.Coordinate;
import core.level.elements.ILevel;
import core.level.elements.tile.PitTile;
import utils.ICommand;
import core.Game; // Import für Game.currentLevel()

/**
 * The BridgeControlCommand class is responsible for controlling the bridge in the Bridge Guard
 * Riddle Level.
 *
 * <p>The bridge can be lowered and raised by executing and undoing this command.
 */
public class BridgeControlCommand implements ICommand {
    private final Coordinate topLeft;
    private final Coordinate bottomRight;

    /**
     * Creates a new BridgeControlCommand instance.
     *
     * @param topLeft The top left coordinate of the bridge.
     * @param bottomRight The bottom right coordinate of the bridge.
     */
    public BridgeControlCommand(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    /**
     * Raises the bridge. By opening the pits, the bridge is raised.
     *
     * @see core.level.elements.tile.PitTile#open() PitTile.open
     * @see core.level.elements.ILevel#tilesInArea(Coordinate, Coordinate) tilesInArea
     */
    @Override
    public void execute() {
        // TODO: Implement bridge raising
        ILevel level = Game.currentLevel();
        var tiles = level.tilesInArea(topLeft, bottomRight);
        for (var tile : tiles) {
            if (tile instanceof PitTile pitTile) {
                pitTile.open();
            }
        }
    }

    /**
     * Lowers the bridge. By closing the pits, the bridge is lowered.
     *
     * @see core.level.elements.tile.PitTile#close() PitTile.close
     * @see core.level.elements.ILevel#tilesInArea(Coordinate, Coordinate) tilesInArea
     */
    @Override
    public void undo() {
        // TODO: Implement bridge lowering
        ILevel level = Game.currentLevel();
        var tiles = level.tilesInArea(topLeft, bottomRight);
        for (var tile : tiles) {
            if (tile instanceof PitTile pitTile) {
                pitTile.close();
            }
        }
    }
}
