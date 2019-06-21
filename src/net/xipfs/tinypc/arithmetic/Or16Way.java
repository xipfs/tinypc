package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.gate.Or;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p> Or16Way </p>
 */
public class Or16Way {
    public static Signal input(Signal[] a){
        Signal o1 = Or.input(a[0],a[1]);
        Signal o2 = Or.input(o1,a[2]);
        Signal o3 = Or.input(o2,a[3]);
        Signal o4 = Or.input(o2,a[4]);
        Signal o5 = Or.input(o2,a[5]);
        Signal o6 = Or.input(o2,a[6]);
        Signal o7 = Or.input(o2,a[7]);
        Signal o8 = Or.input(o2,a[8]);
        Signal o9 = Or.input(o2,a[9]);
        Signal o10 = Or.input(o2,a[10]);
        Signal o11 = Or.input(o2,a[11]);
        Signal o12 = Or.input(o2,a[12]);
        Signal o13 = Or.input(o2,a[13]);
        Signal o14 = Or.input(o2,a[14]);
        Signal o15 = Or.input(o2,a[15]);
        return o15;
    }
}
