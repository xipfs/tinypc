package net.xipfs.tinypc;

import net.xipfs.tinypc.common.EndianModel;
import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.memory.Bit;
import net.xipfs.tinypc.memory.DFF;
import net.xipfs.tinypc.memory.RAM8;
import net.xipfs.tinypc.memory.Register;
import net.xipfs.tinypc.util.CommonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>Demo</p>
 */
public class TestMemory {

    @Test
    public void testDFF(){
        DFF dff = new DFF();
        Signal v = dff.input(Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,v);

        v = dff.input(Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,v);

        v = dff.input(Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,v);
    }

    @Test
    public void testBit(){
        Bit bit = new Bit();
        Signal v = bit.input(Signal.ONE,Signal.ONE);
        Assertions.assertEquals(Signal.ONE,v);
        v = bit.input(Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,v);
        v = bit.input(Signal.ZERO,Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,v);
        v = bit.input(Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(Signal.ZERO,v);
    }

    @Test
    public void testReg(){
        Register reg = new Register();
        Assertions.assertEquals(reg.toString(),"0000000000000000");
        Signal[] v = new Signal[]{
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE
        };
        reg.input(v,Signal.ONE);
        Assertions.assertEquals(reg.toString(),"1111111111111111");;
        v = new Signal[]{
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ZERO,Signal.ONE
        };
        reg.input(v,Signal.ONE);
        Assertions.assertEquals(reg.toString(),"1011111111111111");;
        v = new Signal[]{
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE,
                Signal.ONE,Signal.ONE,Signal.ONE,Signal.ONE
        };
        reg.input(v,Signal.ZERO);
        Assertions.assertEquals(reg.toString(),"1011111111111111");;

    }

    @Test
    public void testRAM8(){
        String v = "0000000000000001";
        String addr = "001";
        RAM8 r8 = new RAM8();
        Signal[] out = r8.input(CommonUtils.string2Signals(v, EndianModel.Little),Signal.ONE,CommonUtils.string2Signals(addr,EndianModel.Little));
        Assertions.assertEquals(CommonUtils.signals2String(out,EndianModel.Little),v);
        Signal[] zeros = new Signal[]{
                Signal.ZERO,Signal.ZERO,Signal.ZERO,Signal.ZERO,
                Signal.ZERO,Signal.ZERO,Signal.ZERO,Signal.ZERO,
                Signal.ZERO,Signal.ZERO,Signal.ZERO,Signal.ZERO,
                Signal.ZERO,Signal.ZERO,Signal.ZERO,Signal.ZERO
        };
        out = r8.input(zeros,Signal.ZERO,CommonUtils.string2Signals(addr,EndianModel.Little));
        Assertions.assertEquals(CommonUtils.signals2String(out,EndianModel.Little),v);
    }

}
