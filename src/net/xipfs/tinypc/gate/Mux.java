package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * Multiplexor:
 * out = a if sel == 0
 *       b otherwise
 */
public class Mux {

    public static Signal input(Signal a, Signal b, Signal sel){
        return Or.input(And.input(a,Not.input(sel)),And.input(b,sel));
    }
}
