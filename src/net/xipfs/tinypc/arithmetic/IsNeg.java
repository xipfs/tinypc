package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.gate.Or;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>IsNeg</p>
 */
public class IsNeg {

    public static Signal input(Signal[] a){
        return Or.input(a[15],Signal.ZERO);
    }
}
