package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>And16</p>
 */
public class And16 {
    public static Signal[] input(Signal[] a, Signal[] b){
        Signal[] out = new Signal[16];
        for(int i =0 ; i< 16; i++){
            out[i] = And.input(a[i],b[i]);
        }
        return out;
    }
}
