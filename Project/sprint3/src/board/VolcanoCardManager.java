package board;

import board.BoardSetup;
import board.VolcanoCardBoard;
import components.GameComponent;
import components.VolcanoCard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code board.VolcanoCardManager} is a manager class to manage the {@code VolcanoCard}'s setup.
 *
 * Created by:
 * @author Tay Ming Hui
 *
 * Modified by:
 * @author Koe Rui En
 */
public class VolcanoCardManager {

    /**
     * an instance of board.BoardSetup
     */
    private BoardSetup boardSetup;

    /**
     * an instance of board.VolcanoCardBoard
     */
    private VolcanoCardBoard volcano;

    /**
     * a mapping of Integer to the VolcanoCard
     */
    private Map<Integer, VolcanoCard> volcanoIndexMap;

    /**
     * Constructor of the board.VolcanoCardManager class.
     *
     * @param boardSetup an instance of board.BoardSetup
     */
    public VolcanoCardManager(BoardSetup boardSetup){
        this.boardSetup = boardSetup;
        volcanoIndexMap = new HashMap<>();
    }

    /**
     * Configure the VolcanoCard on the game board.
     *
     */
    public void volcanoCardSetup() {
        volcano = new VolcanoCardBoard();
        // create animals on volcano cards
        volcano.setupVolcanoAnimals();
        int size = 53;
        int centerX = 1050 / 2;
        int centerY = 700 / 2;
        int radius = 230;
        int j = 23;
        // configure the volcano card's squares on the board
        for (int i = 0; i < volcano.getVolcanos().size(); i++) {
            double angle = 2 * Math.PI * i / 24;
            int x = centerX + (int) (radius * Math.sin(angle)) - size / 2;
            int y = centerY + (int) (radius * Math.cos(angle)) - size / 2;
            VolcanoCard vol = volcano.getVolcanos().get(i);
            // revert the index of volcano card to be stored
            volcanoIndexMap.put(j, vol);
            vol.setBounds(x, y, 53, 53);
            vol.setOpaque(false);
            this.getBoardSetup().getVolcanoCardPanel().add(vol);
            j--;
        }
    }


    /**
     * Return a list of paths of tokens on volcanoes.
     *
     * @param tokenNumber Token's ID
     * @return a list of paths of tokens on volcanoes.
     *
     */
    public ArrayList<GameComponent> getVolcanoPath(int tokenNumber) {
        // duplicate the map
        Map<Integer, VolcanoCard> duplicate = getVolcanoIndexMap();
        for (int k = 0; k < 24; k++) {
            duplicate.put(k + 24, getVolcanoIndexMap().get(k));
        }

        // create list of path for each token position
        ArrayList<GameComponent> volcanoPath = new ArrayList<>();
        if (tokenNumber == 0) {
            for (int a = 13; a < 13 + 25; a++) {
                volcanoPath.add(duplicate.get(a));
            }
        } else if (tokenNumber == 1) {
            for (int b = 19; b < 19 + 25; b++) {
                volcanoPath.add(duplicate.get(b));
            }
        } else if (tokenNumber == 2) {
            for (int c = 1; c < 1 + 25; c++) {
                volcanoPath.add(duplicate.get(c));
            }
        } else if (tokenNumber == 3) {
            for (int d = 7; d < 7 + 25; d++) {
                volcanoPath.add(duplicate.get(d));
            }
        }

        return volcanoPath;
    }

    /**
     * A getter to get a map of VolcanoCard with its index.
     *
     * @return return a map of VolcanoCard with its index
     */
    public Map<Integer, VolcanoCard> getVolcanoIndexMap() {
        return volcanoIndexMap;
    }

    /**
     * A getter to get the instance of board.BoardSetup.
     *
     * @return return the instance of board.BoardSetup
     */
    public BoardSetup getBoardSetup() {
        return this.boardSetup;
    }
}
