package net.xipfs.tinypc.memory;

import net.xipfs.tinypc.common.EndianModel;
import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.util.CommonUtils;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * 16-bit register:
 * If load[t] == 1 then out[t+1] = in[t]
 * else out does not change
 */
public class Register {
    private Bit[]  bits = new Bit[]{
            new Bit(),new Bit(),new Bit(),new Bit(),
            new Bit(),new Bit(),new Bit(),new Bit(),
            new Bit(),new Bit(),new Bit(),new Bit(),
            new Bit(),new Bit(),new Bit(),new Bit()
    };
    public Signal[] input(Signal[] in , Signal load){
        Signal[] out = new Signal[16];
        out[0] = bits[0].input(in[0],load);
        out[1] = bits[1].input(in[1],load);
        out[2] = bits[2].input(in[2],load);
        out[3] = bits[3].input(in[3],load);
        out[4] = bits[4].input(in[4],load);
        out[5] = bits[5].input(in[5],load);
        out[6] = bits[6].input(in[6],load);
        out[7] = bits[7].input(in[7],load);
        out[8] = bits[8].input(in[8],load);
        out[9] = bits[9].input(in[9],load);
        out[10] = bits[10].input(in[10],load);
        out[11] = bits[11].input(in[11],load);
        out[12] = bits[12].input(in[12],load);
        out[13] = bits[13].input(in[13],load);
        out[14] = bits[14].input(in[14],load);
        out[15] = bits[15].input(in[15],load);
        return out;
    }

    public String toString(){
        Signal[] out = new Signal[16];
        for(int i = 0 ; i< 16 ; i++){
            out[i] = bits[i].input(Signal.ZERO,Signal.ZERO);
        }
        return CommonUtils.signals2String(out, EndianModel.Little);
    }
}
