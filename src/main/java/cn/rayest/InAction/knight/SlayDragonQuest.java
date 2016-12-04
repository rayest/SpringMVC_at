package cn.rayest.InAction.knight;

import java.io.PrintStream;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
