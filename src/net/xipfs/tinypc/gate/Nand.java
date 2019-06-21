package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>与非门</p>
 *
 */
public class Nand {
    public static Signal input(Signal a, Signal b){
        if(a == Signal.ONE){
            if( b == Signal.ONE){
                return Signal.ZERO;
            }
        }
        return Signal.ONE;
    }
}
