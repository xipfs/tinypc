package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * 4-way 16-bit multiplexor:
 * out = a if sel == 00
 *       b if sel == 01
 *       c if sel == 10
 *       d if sel == 11
 */
public class Mux4Way16 {
    public static Signal[] input(Signal[] a, Signal[] b, Signal[] c, Signal[] d, Signal[] sel){
        Signal[] temp1 = Mux16.input(a,b,sel[0]);
        Signal[] temp2 = Mux16.input(c,d,sel[0]);
        Signal[] out = Mux16.input(temp1,temp2,sel[1]);
        return out;
    }
}
