package net.xipfs.tinypc.memory;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * 1-bit register:
 * If load[t] == 1 then out[t+1] = in[t]
 *                 else out does not change (out[t+1] = out[t])
 */
public class Bit {
    private DFF dff = new DFF();
    public Signal input(Signal in,Signal load){
        if(load == Signal.ONE){
            dff.input(in);
            return in;
        }else{
            return dff.getPreOut();
        }

    }
}
