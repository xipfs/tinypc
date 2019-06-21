package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;


/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>或门</p>
 *
 */
public class Or {
    public static Signal input(Signal a, Signal b){
        return Nand.input(Not.input(a),Not.input(b));
    }
}
