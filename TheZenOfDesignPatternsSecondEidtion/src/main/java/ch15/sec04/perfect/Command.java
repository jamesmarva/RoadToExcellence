package ch15.sec04.perfect;

import ch15.sec02.Receiver;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.11 15:01
 */
public abstract class Command {

    protected final Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void exeecute();
}


