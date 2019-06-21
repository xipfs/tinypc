package net.xipfs.tinypc.memory;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>触发器</p>
 * A DFF (Data Flip-Flop)
 * out(t) = in(t-1)
 */
public class DFF {

    private Signal v = Signal.ZERO;
    public Signal input(Signal in){
       Signal preOut = v;
       v = in;
       return preOut;
    }

    public Signal getPreOut(){
        return v;
    }
}
