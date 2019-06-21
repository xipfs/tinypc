package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>异或门</p>
 *
 */
public class Xor {
    public static Signal input(Signal a, Signal b){
        //return And.input(Or.input(a,b),Not.input(And.input(a,b)));
        return Or.input(And.input(a,Not.input(b)),And.input(b,Not.input(a)));
    }
}
