package net.xipfs.tinypc.util;

import net.xipfs.tinypc.common.EndianModel;
import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 */
public class CommonUtils {

    /**
     * 以字符形式显示信号
     * @param input
     * @return
     */
    public static String signals2String(Signal[] input, EndianModel model){
        String str="";
        if(EndianModel.Big == model){
            for(Signal signal : input){
                if(signal == Signal.ZERO){
                    str +="0";
                }else if(signal == Signal.ONE){
                    str +="1";
                }else{

                }
            }
        }else{
            for(Signal signal : input){
                if(signal == Signal.ZERO){
                    str = "0"+str;
                }else if(signal == Signal.ONE){
                    str ="1" +str;
                }else{

                }
            }
        }


        return str;
    }

    /**
     * 大端模式
     * @param input
     * @return
     */
    public static Signal[] string2Signals(String input, EndianModel model){
        Signal[] out = new Signal[input.length()];
        if(EndianModel.Big == model){
            for(int i = 0 ; i<input.length(); i++) {
                if (input.charAt(i) == '0') {
                    out[i] = Signal.ZERO;
                } else if (input.charAt(i) == '1') {
                    out[i] = Signal.ONE;
                }
            }
        }else{
            for(int i = 0 ; i<input.length(); i++){
                int index= input.length()-1-i;
                if(input.charAt(i) == '0'){
                    out[index] = Signal.ZERO;
                }else if(input.charAt(i) == '1'){
                    out[index] = Signal.ONE;
                }
            }

        }
        return out;

    }

}
