package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>非门</p>
 *
 */
public class Not {
    public static Signal input(Signal a){
        return Nand.input(a,a);
    }
}
