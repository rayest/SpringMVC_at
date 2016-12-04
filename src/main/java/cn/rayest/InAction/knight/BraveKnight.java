package cn.rayest.InAction.knight;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkQuest(){
        quest.embark();
    }
}
