package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * 16-bit Not:
 * for i=0..15: out[i] = not in[i]
 *
 */
public class Not16 {
    public static Signal[] input(Signal[] in){
        Signal[] out = new Signal[16];
        for(int i=0 ; i<16;i++){
            out[i] = Not.input(in[i]);
        }
        return out;
    }
}
