import components.VolcanoCard;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VolcanoCardManager {

    //public ArrayList<VolcanoCard> volcanoCards;
    public BoardSetup boardSetup;
    public VolcanoCardBoard volcanoTop;
    public VolcanoCardBoard volcanoRight;
    public VolcanoCardBoard volcanoBottom;
    public VolcanoCardBoard volcanoLeft;

    public Map<Integer, VolcanoCard> volcanoIndexMap;

    public VolcanoCardManager(BoardSetup boardSetup){
        //this.volcanoCards = new ArrayList<>();
        this.boardSetup = boardSetup;
        volcanoIndexMap = new HashMap<>();
    }


    public void volcanoCardSetup(){
        volcanoTop = new VolcanoCardBoard();
        volcanoTop.createVolcanoTop();
        for (int i = 0; i < volcanoTop.getVolcanos().size(); i++){
            VolcanoCard volcano = volcanoTop.getVolcanos().get(i);
            volcano.setLayout(new BorderLayout());
            volcano.setBounds(0,0,60,60);
            volcano.setOpaque(false);
            boardSetup.getVolcanoCardPanelTop().add(volcano);
            volcanoIndexMap.put(i, volcano);
        }

        volcanoRight = new VolcanoCardBoard();
        volcanoRight.createVolcanoRight();
        for (int i = 0; i < volcanoRight.getVolcanos().size(); i++){
            VolcanoCard volcano = volcanoRight.getVolcanos().get(i);
            volcano.setLayout(new BorderLayout());
            volcano.setBounds(0,0,60,60);
            volcano.setOpaque(false);
            boardSetup.getVolcanoCardPanelRight().add(volcano);
            volcanoIndexMap.put(i+6, volcano);
        }

        volcanoBottom = new VolcanoCardBoard();
        volcanoBottom.createVolcanoBottom();
        for (int i = 0; i < volcanoBottom.getVolcanos().size(); i++){
            VolcanoCard volcano = volcanoBottom.getVolcanos().get(i);
            volcano.setLayout(new BorderLayout());
            volcano.setBounds(0,0,60,60);
            volcano.setOpaque(false);
            boardSetup.getVolcanoCardPanelBottom().add(volcano);
            volcanoIndexMap.put(i+12, volcano);
        }
        volcanoLeft = new VolcanoCardBoard();
        volcanoLeft.createVolcanoLeft();
        for (int i = 0; i < volcanoLeft.getVolcanos().size(); i++){
            VolcanoCard volcano = volcanoLeft.getVolcanos().get(i);
            volcano.setLayout(new BorderLayout());
            volcano.setBounds(0,0,60,60);
            volcano.setOpaque(false);
            boardSetup.getVolcanoCardPanelLeft().add(volcano);
            volcanoIndexMap.put(i+18, volcano);
        }
    }

    public BoardSetup getBoardSetup() {
        return this.boardSetup;
    }
}
