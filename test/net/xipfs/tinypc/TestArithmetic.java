package net.xipfs.tinypc;

import me.xiehui.tinycomputer.arithmetic.*;
import net.xipfs.tinypc.common.EndianModel;
import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.util.CommonUtils;
import net.xipfs.tinypc.arithmetic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>Demo</p>
 */
public class TestArithmetic {
    @Test
    public void testHalfAdder(){
        HalfAdderResult out = HalfAdder.input(Signal.ZERO,Signal.ZERO);
        Assertions.assertEquals(out.getCarry(),Signal.ZERO);
        Assertions.assertEquals(out.getSum(),Signal.ZERO);

        out = HalfAdder.input(Signal.ZERO,Signal.ONE);
        Assertions.assertEquals(out.getCarry(),Signal.ZERO);
        Assertions.assertEquals(out.getSum(),Signal.ONE);


        out = HalfAdder.input(Signal.ONE,Signal.ONE);
        Assertions.assertEquals(out.getCarry(),Signal.ONE);
        Assertions.assertEquals(out.getSum(),Signal.ZERO);

    }

    @Test
    public void testFullAdder(){
        FullAdderResult out = FullAdder.input(Signal.ZERO,Signal.ZERO,Signal.ZERO);

        Assertions.assertEquals(out.getCarry(),Signal.ZERO);
        Assertions.assertEquals(out.getSum(),Signal.ZERO);

        out = FullAdder.input(Signal.ZERO,Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(out.getCarry(),Signal.ZERO);
        Assertions.assertEquals(out.getSum(),Signal.ONE);

        out = FullAdder.input(Signal.ZERO,Signal.ONE,Signal.ONE);
        Assertions.assertEquals(out.getCarry(),Signal.ONE);
        Assertions.assertEquals(out.getSum(),Signal.ZERO);

        out = FullAdder.input(Signal.ONE,Signal.ONE,Signal.ONE);
        Assertions.assertEquals(out.getCarry(),Signal.ONE);
        Assertions.assertEquals(out.getSum(),Signal.ONE);

    }

    @Test
    public void testAdd16(){
        String a = "0000000000000001";
        String b = "0000000000000010";
        Signal[] out = Add16.input(CommonUtils.string2Signals(a, EndianModel.Little),CommonUtils.string2Signals(b,EndianModel.Little));
        Assertions.assertEquals("0000000000000011", CommonUtils.signals2String(out,EndianModel.Little));

    }

    @Test
    public void testInc16(){
        String in = "0000000000000001";
        Signal[] out = Inc16.input(CommonUtils.string2Signals(in,EndianModel.Little));
        Assertions.assertEquals("0000000000000010", CommonUtils.signals2String(out,EndianModel.Little));

    }

    @Test
    public void testALU(){
        /*
         * if (zx == 1) set x = 0        // 16-bit constant
         * if (nx == 1) set x = !x       // bitwise not
         * if (zy == 1) set y = 0        // 16-bit constant
         * if (ny == 1) set y = !y       // bitwise not
         * if (f == 1)  set out = x + y  // integer 2's complement addition
         * if (f == 0)  set out = x & y  // bitwise and
         * if (no == 1) set out = !out   // bitwise not
         * if (out == 0) set zr = 1
         * if (out < 0) set ng = 1
         */
        String a = "0000000000000001";
        String b = "1111111111111111";
        Signal[] x = CommonUtils.string2Signals(a, EndianModel.Little);
        Signal[] y = CommonUtils.string2Signals(b, EndianModel.Little);

        Signal zx = Signal.ONE;
        Signal nx = Signal.ZERO;
        Signal zy = Signal.ZERO;
        Signal ny = Signal.ZERO;
        Signal f  = Signal.ZERO;
        Signal no = Signal.ZERO;

        ALUResult result = ALU.input(x,y,zx,nx,zy,ny,f,no);
        Assertions.assertEquals("0000000000000000",CommonUtils.signals2String(result.getOut(),EndianModel.Little));
        Assertions.assertEquals(Signal.ONE,result.getZr());

        zx = Signal.ZERO;
        nx = Signal.ONE;
        result = ALU.input(x,y,zx,nx,zy,ny,f,no);
        Assertions.assertEquals("1111111111111110",CommonUtils.signals2String(result.getOut(),EndianModel.Little));

        nx = Signal.ZERO;
        f = Signal.ONE;
        b = "0000000000000010";
        y = CommonUtils.string2Signals(b, EndianModel.Little);
        result = ALU.input(x,y,zx,nx,zy,ny,f,no);
        Assertions.assertEquals("0000000000000011",CommonUtils.signals2String(result.getOut(),EndianModel.Little));


    }
}
