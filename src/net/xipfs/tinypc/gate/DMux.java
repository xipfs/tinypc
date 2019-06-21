package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * Demultiplexor:
 * {a, b} = {in, 0} if sel == 0
 *          {0, in} if sel == 1
 */
public class DMux {
    public static Signal[] input(Signal in, Signal sel){
        Signal[] out = new Signal[2];
        out[0] = And.input(Not.input(sel),in);
        out[1] = And.input(sel,in);
        return out;
    }
}
