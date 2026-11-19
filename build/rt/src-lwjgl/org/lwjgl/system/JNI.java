package org.lwjgl.system;

import org.lwjgl.web.WebFFI;
import static org.lwjgl.system.MemoryUtil.*;

/** lwjgl-web: generated. Every dynamic native call is routed to the JavaScript layer. */
public final class JNI {
    static { Library.initialize(); }
    private JNI() {}

    public static byte invokePB(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:B", new double[] {(double)param0});
        return (byte)(long)__r;
    }
    public static short invokeC(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":S", new double[] {});
        return (short)(long)__r;
    }
    public static short invokeC(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:S", new double[] {(double)param0});
        return (short)(long)__r;
    }
    public static short invokePC(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:S", new double[] {(double)param0});
        return (short)(long)__r;
    }
    public static short invokeCC(int param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IS:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static short invokeCC(short param0, boolean param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SZ:S", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
        return (short)(long)__r;
    }
    public static short invokePC(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static short invokeJC(int param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJ:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short invokeCUC(short param0, byte param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SB:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static short invokePCC(long param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JS:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static short invokeCCC(short param0, short param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SSZ:S", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return (short)(long)__r;
    }
    public static short invokePCC(int param0, long param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJS:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short invokePCC(long param0, int param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIS:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short invokeUPC(byte param0, long param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "BJZ:S", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return (short)(long)__r;
    }
    public static short invokePCC(long param0, int param1, int param2, short param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (short)(long)__r;
    }
    public static short invokeCJC(int param0, boolean param1, short param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IZSIJ:S", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)param4});
        return (short)(long)__r;
    }
    public static short invokeCPCC(short param0, long param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJS:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short invokeCPPC(short param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJJ:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short invokePPCC(long param0, long param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJS:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short invokeCCJC(short param0, short param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SSIJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (short)(long)__r;
    }
    public static short invokePCCC(long param0, short param1, short param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSII:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (short)(long)__r;
    }
    public static short invokeCCCCC(short param0, short param1, short param2, short param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SSSS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (short)(long)__r;
    }
    public static short invokePJUPC(long param0, long param1, byte param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJBJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (short)(long)__r;
    }
    public static short invokeCCJPC(short param0, boolean param1, short param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SZSIJJ:S", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)param4, (double)param5});
        return (short)(long)__r;
    }
    public static short invokePCCCCC(long param0, short param1, short param2, short param3, short param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSSS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (short)(long)__r;
    }
    public static short invokeCCCJPC(short param0, short param1, short param2, boolean param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SSSZIJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4, (double)param5, (double)param6});
        return (short)(long)__r;
    }
    public static short invokeCCCJPC(short param0, short param1, boolean param2, short param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SSZSIJJ:S", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)param3, (double)param4, (double)param5, (double)param6});
        return (short)(long)__r;
    }
    public static double invokeD(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":D", new double[] {});
        return __r;
    }
    public static double invokeD(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:D", new double[] {(double)param0});
        return __r;
    }
    public static double invokePD(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:D", new double[] {(double)param0});
        return __r;
    }
    public static double invokePD(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:D", new double[] {(double)param0, (double)param1});
        return __r;
    }
    public static double invokePD(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:D", new double[] {(double)param0, (double)param1, (double)param2});
        return __r;
    }
    public static double invokePPD(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:D", new double[] {(double)param0, (double)param1});
        return __r;
    }
    public static float invokeF(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":F", new double[] {});
        return (float)__r;
    }
    public static float invokeF(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:F", new double[] {(double)param0});
        return (float)__r;
    }
    public static float invokePF(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:F", new double[] {(double)param0});
        return (float)__r;
    }
    public static float invokePF(float param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "FJ:F", new double[] {(double)param0, (double)param1});
        return (float)__r;
    }
    public static float invokePF(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:F", new double[] {(double)param0, (double)param1});
        return (float)__r;
    }
    public static float invokePF(float param0, float param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "FFJ:F", new double[] {(double)param0, (double)param1, (double)param2});
        return (float)__r;
    }
    public static float invokePF(int param0, long param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJF:F", new double[] {(double)param0, (double)param1, (double)param2});
        return (float)__r;
    }
    public static float invokePF(long param0, float param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFF:F", new double[] {(double)param0, (double)param1, (double)param2});
        return (float)__r;
    }
    public static float invokePF(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:F", new double[] {(double)param0, (double)param1, (double)param2});
        return (float)__r;
    }
    public static float invokePPF(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:F", new double[] {(double)param0, (double)param1});
        return (float)__r;
    }
    public static float invokePPF(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:F", new double[] {(double)param0, (double)param1, (double)param2});
        return (float)__r;
    }
    public static float invokePPF(long param0, float param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFJI:F", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (float)__r;
    }
    public static int invokeI(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":I", new double[] {});
        return (int)(long)__r;
    }
    public static int invokeI(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:I", new double[] {(double)param0});
        return (int)(long)__r;
    }
    public static int invokeI(boolean param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "Z:I", new double[] {(double)(param0 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokeI(int param0, float param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IF:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokeI(int param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "II:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokeI(int param0, boolean param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IZ:I", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokeI(int param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "III:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokeI(int param0, int param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokeI(int param0, int param1, int param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokeI(int param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokeJI(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:I", new double[] {(double)param0});
        return (int)(long)__r;
    }
    public static int invokePI(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:I", new double[] {(double)param0});
        return (int)(long)__r;
    }
    public static int invokeCI(int param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IS:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokePI(int param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJ:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokePI(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokePI(long param0, boolean param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZ:I", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokeCI(int param0, short param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "ISZ:I", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokePI(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePI(long param0, int param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIZ:I", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokePI(long param0, int param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePI(long param0, int param1, int param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePI(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokeCPI(short param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJ:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokePCI(long param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JS:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokePJI(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokePNI(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int invokePJI(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePNI(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePNI(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPI(int param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, long param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJF:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, long param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJZ:I", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, boolean param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZJ:I", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, long param2, boolean param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJZ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, boolean param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIZJ:I", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, long param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, long param1, boolean param2, boolean param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJZZ:I", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)(param3 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, int param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, int param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, long param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPI(int param0, long param1, int param2, long param3, int param4, boolean param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJIJIZ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPI(long param0, int param1, int param2, int param3, int param4, long param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokeCPUI(short param0, long param1, byte param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJB:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokeJPPI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePCPI(long param0, short param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePNNI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePNPI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPCI(long param0, long param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJS:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPJI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPNI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int invokePNPI(long param0, long param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePNPI(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPNI(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPPI(int param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, long param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePNNI(long param0, long param1, long param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, long param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, long param1, int param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, long param1, int param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, long param1, long param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, long param2, int param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, long param1, int param2, long param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, long param1, long param2, int param3, boolean param4, float param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIZF:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0), (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, int param2, int param3, long param4, long param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPI(long param0, int param1, int param2, long param3, int param4, long param5, int param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJIJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePNPPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPNNI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPNPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPPNI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePUUUI(long param0, byte param1, byte param2, byte param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JBBB:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int invokePNNPI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPNI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, long param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, int param2, long param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, long param2, int param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, long param2, long param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, int param1, int param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, int param1, int param2, long param3, long param4, long param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, int param1, long param2, int param3, long param4, int param5, long param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, long param2, int param3, int param4, int param5, long param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, long param1, long param2, long param3, int param4, int param5, int param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPI(long param0, int param1, int param2, long param3, int param4, long param5, long param6, int param7, int param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJIJJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int invokePNNPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPNNPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPNNI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPPNI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePPUUUI(long param0, long param1, byte param2, byte param3, byte param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJBBB:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePUUUUI(long param0, byte param1, byte param2, byte param3, byte param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JBBBB:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int invokePJPPNI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPNPPI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPNPPI(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPNJI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPNNI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPNPI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPNI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPNI(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(int param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePNPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, int param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, int param2, long param3, int param4, long param5, int param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJIJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, int param2, long param3, long param4, int param5, int param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, long param2, int param3, long param4, int param5, int param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPPI(long param0, long param1, long param2, int param3, int param4, int param5, float param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIIFJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int invokePPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePPUUUUI(long param0, long param1, byte param2, byte param3, byte param4, byte param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJBBBB:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int invokePJJJJPI(long param0, long param1, long param2, long param3, long param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPNPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePNNPPPI(long param0, long param1, long param2, int param3, int param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPPPI(int param0, int param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int invokePPPPPPI(long param0, long param1, int param2, long param3, int param4, long param5, int param6, long param7, int param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJIJIJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (int)(long)__r;
    }
    public static int invokePPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int invokePPPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int invokePPPPPPPI(long param0, long param1, long param2, int param3, long param4, float param5, float param6, long param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJFFJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (int)(long)__r;
    }
    public static int invokePPPPPPPI(long param0, long param1, long param2, int param3, int param4, long param5, long param6, int param7, long param8, int param9, long param10, int param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIJJIJIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return (int)(long)__r;
    }
    public static int invokePPPPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (int)(long)__r;
    }
    public static long invokeJ(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":J", new double[] {});
        return (long)__r;
    }
    public static long invokeJ(int param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "II:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePJ(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long invokePJ(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePJ(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePJJ(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePPJ(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePJJ(int param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePJJ(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePJJ(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPJ(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokeNN(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long invokePN(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long invokePN(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokeNNN(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePPN(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokeNNNN(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePNPN(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePNPN(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPNN(long param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePNPNN(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePNPNPN(long param0, long param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, long param9, long param10, long param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIIIIIIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return (long)__r;
    }
    public static long invokeP(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":J", new double[] {});
        return (long)__r;
    }
    public static long invokeP(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long invokeP(boolean param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "Z:J", new double[] {(double)(param0 ? 1.0 : 0.0)});
        return (long)__r;
    }
    public static long invokeP(int param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "II:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokeP(int param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "III:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokeCP(short param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "S:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long invokeJP(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long invokePP(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long invokePP(int param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePP(long param0, double param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JD:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePP(long param0, float param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JF:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePP(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePP(long param0, boolean param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZ:J", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
        return (long)__r;
    }
    public static long invokePP(int param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePP(int param0, boolean param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IZJ:J", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2});
        return (long)__r;
    }
    public static long invokePP(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePP(int param0, int param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePP(long param0, int param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePP(int param0, int param1, int param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePP(long param0, float param1, int param2, float param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFIFI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePP(long param0, int param1, int param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePP(long param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokeCCP(short param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SS:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokeJPP(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePJP(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePNP(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePPP(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokePUP(long param0, byte param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JB:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long invokeCPP(int param0, short param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "ISJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePCP(long param0, short param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSZ:J", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return (long)__r;
    }
    public static long invokePJP(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePJP(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPP(int param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPP(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPP(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPP(long param0, long param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJZ:J", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return (long)__r;
    }
    public static long invokePJP(long param0, int param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPP(long param0, int param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPP(long param0, int param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPP(long param0, long param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPP(long param0, long param1, boolean param2, boolean param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJZZ:J", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)(param3 ? 1.0 : 0.0)});
        return (long)__r;
    }
    public static long invokePPP(long param0, boolean param1, boolean param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZZJ:J", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)(param2 ? 1.0 : 0.0), (double)param3});
        return (long)__r;
    }
    public static long invokePPP(long param0, int param1, int param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPP(long param0, int param1, long param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePJP(long param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPP(int param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPP(long param0, long param1, int param2, int param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePUP(long param0, int param1, byte param2, int param3, boolean param4, boolean param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIBIZZ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0), (double)(param5 ? 1.0 : 0.0)});
        return (long)__r;
    }
    public static long invokePPP(int param0, int param1, int param2, int param3, long param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIIJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokeCCPP(short param0, short param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SSJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokeCPCP(short param0, long param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJS:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePJJP(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPJP(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPUP(long param0, long param1, byte param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJB:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long invokePPPP(int param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPPP(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, boolean param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJZJ:J", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)param3});
        return (long)__r;
    }
    public static long invokePPUP(long param0, long param1, int param2, byte param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIB:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPPP(int param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPP(long param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, int param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, int param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, long param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokeJPPP(int param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPP(long param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, int param2, int param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPP(int param0, int param1, int param2, long param3, long param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPP(long param0, long param1, int param2, int param3, long param4, int param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePBPPP(long param0, byte param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JBJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePNNPP(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPJPP(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPNNP(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long invokePPPJP(int param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPJP(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, long param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePJPPP(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePJPPP(long param0, long param1, int param2, long param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPJP(long param0, long param1, long param2, long param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, long param2, int param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, long param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, long param2, int param3, long param4, int param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPP(long param0, long param1, long param2, long param3, int param4, int param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPP(int param0, int param1, int param2, long param3, long param4, long param5, int param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long invokePJPJPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePNNNPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPBPPP(long param0, long param1, byte param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJBJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokePPPPPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long invokeCCCUJP(short param0, short param1, short param2, byte param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SSSBIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPJPP(long param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPNP(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPPP(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPJPPP(long param0, long param1, long param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPPP(long param0, long param1, long param2, int param3, long param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, int param6, int param7, int param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (long)__r;
    }
    public static long invokePPJJPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePSSCCPP(long param0, short param1, short param2, short param3, short param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSSSJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, int param2, int param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, int param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, int param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, int param6, long param7, int param8, int param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJIJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (long)__r;
    }
    public static long invokePPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, int param8, int param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (long)__r;
    }
    public static long invokePPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long invokePPPPPJPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (long)__r;
    }
    public static long invokePPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, int param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (long)__r;
    }
    public static long invokePPPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (long)__r;
    }
    public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (long)__r;
    }
    public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, int param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (long)__r;
    }
    public static long invokePPPPJJPPP(long param0, long param1, long param2, long param3, int param4, long param5, int param6, long param7, int param8, long param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJIJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (long)__r;
    }
    public static long invokePPPPPJJPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (long)__r;
    }
    public static long invokePPPPPJPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (long)__r;
    }
    public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (long)__r;
    }
    public static long invokePPPPPJPPP(long param0, int param1, long param2, long param3, long param4, long param5, int param6, int param7, long param8, int param9, long param10, long param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJIIJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return (long)__r;
    }
    public static long invokePPPPPJPPP(long param0, int param1, long param2, long param3, long param4, long param5, int param6, int param7, long param8, int param9, int param10, long param11, long param12, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJIIJIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12});
        return (long)__r;
    }
    public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, int param9, int param10, int param11, int param12, int param13, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJIJIIIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13});
        return (long)__r;
    }
    public static long invokePPPPPJJJPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, long param7, long param8, int param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (long)__r;
    }
    public static long invokePPPPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, long param8, int param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (long)__r;
    }
    public static long invokePPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, int param9, long param10, int param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJIJIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return (long)__r;
    }
    public static long invokePPPPPJPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, int param8, long param9, int param10, int param11, long param12, long param13, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIIJIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13});
        return (long)__r;
    }
    public static long invokePPPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (long)__r;
    }
    public static long invokePPPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, int param9, long param10, long param11, int param12, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJIJIJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12});
        return (long)__r;
    }
    public static long invokePPPPPJPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, int param7, int param8, long param9, long param10, long param11, long param12, long param13, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJIIJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13});
        return (long)__r;
    }
    public static long invokePPPPPJPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, int param8, long param9, long param10, int param11, int param12, long param13, long param14, long param15, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIIJJIIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15});
        return (long)__r;
    }
    public static long invokePPPPPPPPPPPPP(long param0, int param1, long param2, long param3, long param4, int param5, long param6, long param7, int param8, long param9, long param10, int param11, int param12, int param13, int param14, long param15, long param16, long param17, long param18, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJIJJIJJIIIIJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15, (double)param16, (double)param17, (double)param18});
        return (long)__r;
    }
    public static long invokePPPPPJPPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, int param7, long param8, long param9, int param10, long param11, long param12, long param13, long param14, long param15, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJIJJIJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15});
        return (long)__r;
    }
    public static long invokePPPPPJJPPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long param10, long param11, int param12, long param13, long param14, long param15, long param16, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJIJIJJIJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15, (double)param16});
        return (long)__r;
    }
    public static short invokePS(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static byte invokeU(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:B", new double[] {(double)param0});
        return (byte)(long)__r;
    }
    public static byte invokePU(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:B", new double[] {(double)param0, (double)param1});
        return (byte)(long)__r;
    }
    public static byte invokeUPU(byte param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "BJ:B", new double[] {(double)param0, (double)param1});
        return (byte)(long)__r;
    }
    public static void invokeV(long __functionAddress) {
        WebFFI.call(__functionAddress, ":V", new double[] {});
    }
    public static void invokeV(double param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "D:V", new double[] {(double)param0});
    }
    public static void invokeV(float param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "F:V", new double[] {(double)param0});
    }
    public static void invokeV(int param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "I:V", new double[] {(double)param0});
    }
    public static void invokeV(boolean param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "Z:V", new double[] {(double)(param0 ? 1.0 : 0.0)});
    }
    public static void invokeV(int param0, float param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IF:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeV(int param0, int param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "II:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeV(int param0, boolean param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IZ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
    }
    public static void invokeV(int param0, int param1, double param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IID:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeV(int param0, int param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeV(int param0, int param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "III:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeV(int param0, float param1, float param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeV(int param0, int param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeV(int param0, int param1, double param2, double param3, double param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeV(int param0, int param1, float param2, float param3, float param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeV(int param0, int param1, int param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeCV(short param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "S:V", new double[] {(double)param0});
    }
    public static void invokeJV(long param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "J:V", new double[] {(double)param0});
    }
    public static void invokePV(long param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "J:V", new double[] {(double)param0});
    }
    public static void invokeUV(byte param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "B:V", new double[] {(double)param0});
    }
    public static void invokeCV(int param0, short param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IS:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeCV(short param0, int param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "SI:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeCV(short param0, boolean param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "SZ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
    }
    public static void invokeJV(int param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeJV(long param0, int param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JI:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePV(int param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePV(long param0, float param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JF:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePV(long param0, int param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JI:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePV(long param0, boolean param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JZ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
    }
    public static void invokeUV(byte param0, int param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "BI:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeUV(byte param0, boolean param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "BZ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
    }
    public static void invokeCV(short param0, int param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "SII:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeJV(int param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePV(int param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePV(int param0, long param1, boolean param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJZ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
    }
    public static void invokePV(long param0, double param1, double param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JDD:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePV(long param0, float param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JFF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePV(long param0, int param1, double param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JID:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePV(long param0, int param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePV(long param0, int param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JII:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePV(long param0, int param1, boolean param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIZ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
    }
    public static void invokePV(int param0, int param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePV(long param0, float param1, float param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePV(long param0, float param1, float param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JFFI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePV(long param0, int param1, int param2, double param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIID:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePV(long param0, int param1, int param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePV(long param0, int param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePV(int param0, int param1, long param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePV(long param0, int param1, float param2, float param3, float param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePV(long param0, int param1, int param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeUV(byte param0, float param1, float param2, float param3, float param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "BFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePV(int param0, int param1, int param2, int param3, long param4, boolean param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
    }
    public static void invokePV(long param0, int param1, int param2, double param3, double param4, double param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePV(long param0, int param1, int param2, float param3, float param4, float param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePV(long param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePV(long param0, int param1, int param2, int param3, int param4, boolean param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokeCCV(short param0, short param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "SS:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeCPV(short param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "SJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePCV(long param0, short param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JS:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePJV(long param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePNV(long param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePPV(long param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokePUV(long param0, byte param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JB:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeUPV(byte param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "BJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void invokeCPV(short param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "SIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeCPV(short param0, long param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "SJI:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePCV(long param0, int param1, short param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIS:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePCV(long param0, short param1, boolean param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSZ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
    }
    public static void invokePJV(int param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePJV(long param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePJV(long param0, long param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJI:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePPV(int param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePPV(long param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePPV(long param0, long param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePPV(long param0, long param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJI:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePPV(long param0, long param1, boolean param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJZ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
    }
    public static void invokeUCV(byte param0, short param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "BSI:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePBV(long param0, int param1, int param2, byte param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePCV(long param0, int param1, int param2, short param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePCV(long param0, short param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePJV(long param0, int param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPV(int param0, int param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPV(int param0, long param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPV(long param0, int param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPV(long param0, int param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPV(long param0, int param1, long param2, boolean param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0)});
    }
    public static void invokePPV(long param0, long param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePSV(long param0, int param1, int param2, short param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePUV(long param0, int param1, int param2, byte param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeUCV(byte param0, short param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "BSII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeUPV(byte param0, long param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "BJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePCV(long param0, short param1, int param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPV(int param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPV(long param0, float param1, long param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JFJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPV(long param0, int param1, int param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPV(long param0, long param1, int param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPV(int param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPV(long param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPV(long param0, int param1, int param2, long param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPV(long param0, long param1, float param2, float param3, float param4, float param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPV(int param0, int param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPV(long param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPV(long param0, int param1, int param2, int param3, int param4, long param5, boolean param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)(param6 ? 1.0 : 0.0)});
    }
    public static void invokePPV(long param0, long param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPV(long param0, long param1, float param2, float param3, float param4, float param5, float param6, float param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJFFFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void invokeCCPV(short param0, short param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeCPCV(short param0, long param1, short param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "SJS:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeCPPV(short param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "SJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeJPPV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePJPV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePNNV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePNPV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePPNV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokePPPV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void invokeCCCV(short param0, short param1, short param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeCCUV(short param0, short param1, int param2, byte param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePJPV(long param0, long param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPJV(long param0, int param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPPV(int param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPPV(long param0, int param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPPV(long param0, long param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPPV(long param0, long param1, long param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPPV(long param0, long param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPPV(long param0, long param1, long param2, boolean param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0)});
    }
    public static void invokePUCV(long param0, byte param1, short param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JBSI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeUCCV(byte param0, short param1, short param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "BSSI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeCCUV(short param0, short param1, int param2, float param3, byte param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSIFB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeJJJV(int param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePNNV(long param0, long param1, int param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPV(int param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPV(long param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPV(long param0, int param1, long param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPV(long param0, long param1, int param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPV(long param0, long param1, int param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPV(long param0, long param1, long param2, float param3, float param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPV(long param0, long param1, long param2, int param3, boolean param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0)});
    }
    public static void invokePPPV(long param0, long param1, long param2, boolean param3, boolean param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJZZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)(param4 ? 1.0 : 0.0)});
    }
    public static void invokePUCV(long param0, byte param1, short param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JBSII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePUPV(long param0, byte param1, long param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JBJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeUCCV(byte param0, short param1, int param2, int param3, short param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "BSIIS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeUCUV(byte param0, short param1, byte param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "BSBII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeUPCV(byte param0, long param1, int param2, int param3, short param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "BJIIS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeCCUV(short param0, short param1, int param2, int param3, int param4, byte param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSIIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPV(int param0, int param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPV(long param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPV(long param0, int param1, long param2, int param3, long param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPV(long param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPV(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPV(long param0, long param1, long param2, int param3, boolean param4, boolean param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIZZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0), (double)(param5 ? 1.0 : 0.0)});
    }
    public static void invokePPPV(long param0, boolean param1, int param2, long param3, long param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JZIJJI:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPV(long param0, int param1, int param2, long param3, int param4, long param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPV(long param0, int param1, long param2, int param3, long param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPV(long param0, long param1, float param2, float param3, float param4, float param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJFFFFJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPV(long param0, long param1, long param2, float param3, float param4, float param5, float param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPV(long param0, long param1, long param2, int param3, int param4, int param5, boolean param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIIIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)(param6 ? 1.0 : 0.0)});
    }
    public static void invokePPPV(long param0, long param1, int param2, int param3, int param4, long param5, int param6, boolean param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIIJIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)(param7 ? 1.0 : 0.0)});
    }
    public static void invokePPPV(long param0, long param1, float param2, float param3, float param4, float param5, float param6, float param7, long param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJFFFFFFJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void invokePPPV(long param0, long param1, long param2, float param3, float param4, float param5, float param6, float param7, float param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJFFFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void invokeCCPCV(short param0, short param1, long param2, short param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSJS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeCCUPV(short param0, short param1, byte param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSBJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePCPCV(long param0, short param1, long param2, short param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSJS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePNPPV(long param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokePPPPV(long param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void invokeCCCUV(short param0, short param1, short param2, int param3, byte param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePCCUV(long param0, short param1, short param2, int param3, byte param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSSIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePJJPV(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPCPV(long param0, long param1, short param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJSIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPCV(long param0, long param1, int param2, long param3, short param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPPV(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPPV(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPPV(long param0, long param1, long param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPPV(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPPV(long param0, long param1, long param2, long param3, boolean param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0)});
    }
    public static void invokePUCCV(long param0, byte param1, short param2, short param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JBSSI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeCCCUV(short param0, short param1, short param2, int param3, int param4, byte param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePJJJV(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPPV(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPPV(long param0, long param1, long param2, float param3, float param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJFFJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePUCCV(long param0, byte param1, short param2, int param3, int param4, short param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JBSIIS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePUCUV(long param0, byte param1, short param2, byte param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JBSBII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePUPCV(long param0, byte param1, long param2, int param3, int param4, short param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JBJIIS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokeCCCUV(short param0, short param1, short param2, int param3, int param4, int param5, byte param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSIIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePCCUV(long param0, short param1, short param2, int param3, int param4, int param5, byte param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSSIIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPPV(long param0, long param1, long param2, float param3, float param4, float param5, float param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJFFFFJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void invokePPPPV(long param0, long param1, long param2, int param3, int param4, int param5, float param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIIIFJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void invokePPPPV(long param0, long param1, long param2, float param3, float param4, float param5, float param6, float param7, float param8, long param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJFFFFFFJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void invokeCCCCCV(short param0, short param1, short param2, short param3, short param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSSS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokeCCUPPV(short param0, short param1, byte param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSBJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPCPPV(long param0, long param1, short param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJSJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePPPPPV(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void invokePCCCUV(long param0, short param1, short param2, short param3, int param4, byte param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSSSIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePJPPPV(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPPPV(int param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPPPV(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPPPV(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPPPV(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePCCCUV(long param0, short param1, short param2, short param3, int param4, int param5, byte param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSSSIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPPPV(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPPPV(long param0, long param1, long param2, long param3, int param4, long param5, boolean param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)(param6 ? 1.0 : 0.0)});
    }
    public static void invokePCCCCV(long param0, short param1, short param2, short param3, boolean param4, boolean param5, short param6, int param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSSSZZSI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0), (double)(param5 ? 1.0 : 0.0), (double)param6, (double)param7});
    }
    public static void invokePCCCUV(long param0, short param1, short param2, short param3, int param4, int param5, int param6, byte param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSSSIIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void invokePPPPPV(long param0, long param1, int param2, long param3, int param4, long param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void invokePPPPPV(long param0, long param1, int param2, long param3, long param4, int param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void invokeCCCCUV(short param0, short param1, short param2, int param3, short param4, int param5, int param6, int param7, byte param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSISIIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void invokePPPPPV(int param0, long param1, int param2, long param3, long param4, long param5, int param6, long param7, int param8, boolean param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIJJJIJIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)(param9 ? 1.0 : 0.0)});
    }
    public static void invokeCCCCPCV(short param0, short param1, short param2, short param3, long param4, short param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSSJS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePPPPPPV(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void invokePCCCCUV(long param0, short param1, int param2, short param3, short param4, short param5, byte param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSISSSB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPPPPV(int param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePCCCCUV(long param0, short param1, short param2, short param3, int param4, short param5, int param6, int param7, int param8, byte param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSSSISIIIB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void invokePPPPPPPV(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void invokePPPPPPPV(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void invokeCCUCCCCPCV(short param0, short param1, byte param2, short param3, short param4, short param5, short param6, long param7, short param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSBSSSSJS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void invokeCUCCCCCCPV(short param0, byte param1, short param2, short param3, short param4, short param5, short param6, short param7, long param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "SBSSSSSSJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void invokeCCUUCCCCPCV(short param0, short param1, byte param2, byte param3, short param4, short param5, short param6, short param7, long param8, short param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSBBSSSSJS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void invokeCCUUUUUUUUUV(short param0, short param1, float param2, byte param3, byte param4, byte param5, byte param6, byte param7, byte param8, byte param9, byte param10, byte param11, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSFBBBBBBBBB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
    }
    public static void invokeCCUCCCCUCCCCCCV(short param0, short param1, byte param2, short param3, short param4, short param5, short param6, byte param7, short param8, short param9, short param10, short param11, short param12, short param13, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSBSSSSBSSSSSS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13});
    }
    public static void invokePCCUCCCCUCCCCCCV(long param0, short param1, short param2, byte param3, short param4, short param5, short param6, short param7, byte param8, short param9, short param10, short param11, short param12, short param13, short param14, long __functionAddress) {
        WebFFI.call(__functionAddress, "JSSBSSSSBSSSSSS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14});
    }
    public static boolean invokeZ(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":Z", new double[] {});
        return __r != 0.0;
    }
    public static boolean invokeZ(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:Z", new double[] {(double)param0});
        return __r != 0.0;
    }
    public static boolean invokeZ(boolean param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "Z:Z", new double[] {(double)(param0 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokeZ(float param0, float param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "FF:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokeZ(int param0, float param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IF:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokeZ(int param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "II:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:Z", new double[] {(double)param0});
        return __r != 0.0;
    }
    public static boolean invokeJZ(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePZ(int param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJ:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, float param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JF:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, boolean param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZ:Z", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokeJZ(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePZ(int param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJ:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePZ(int param0, long param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJF:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePZ(int param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJI:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePZ(int param0, long param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJZ:Z", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, float param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFF:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, float param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFI:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, int param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIZ:Z", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, boolean param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZI:Z", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, float param1, float param2, float param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFFF:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, int param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIII:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, float param1, float param2, float param3, float param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFFFF:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePZ(int param0, int param1, int param2, float param3, boolean param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIFZJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0), (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, int param1, int param2, float param3, float param4, float param5, float param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIFFFF:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return __r != 0.0;
    }
    public static boolean invokePZ(long param0, int param1, int param2, boolean param3, float param4, float param5, float param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIZFFF:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4, (double)param5, (double)param6});
        return __r != 0.0;
    }
    public static boolean invokePBZ(long param0, byte param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JB:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePCZ(long param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JS:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePJZ(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePSZ(long param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JS:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokePUZ(long param0, byte param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JB:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokeUPZ(byte param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "BJ:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean invokeJPZ(long param0, long param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJZ:Z", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokePJZ(int param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJ:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePPZ(int param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJ:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, long param1, boolean param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJZ:Z", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokePSZ(long param0, int param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIS:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePUZ(long param0, int param1, byte param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIB:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, float param1, float param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFFJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, int param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, int param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, long param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJII:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, boolean param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZJI:Z", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPZ(long param0, long param1, int param2, int param3, float param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIF:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPZ(int param0, int param1, int param2, long param3, int param4, int param5, long param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJIIJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return __r != 0.0;
    }
    public static boolean invokePPZ(int param0, int param1, int param2, long param3, int param4, int param5, long param6, int param7, boolean param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJIIJIZ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)(param8 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokePPZ(int param0, int param1, int param2, int param3, int param4, long param5, int param6, int param7, int param8, int param9, long param10, int param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIIIJIIIIJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return __r != 0.0;
    }
    public static boolean invokePCCZ(long param0, short param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSS:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean invokePCCZ(long param0, short param1, short param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePJJZ(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePJPZ(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(int param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(long param0, long param1, long param2, boolean param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJZ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(long param0, boolean param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZJJ:Z", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePSSZ(long param0, int param1, short param2, short param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JISS:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokeCCJZ(short param0, boolean param1, short param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SZSIJ:Z", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePJPZ(long param0, int param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(long param0, float param1, float param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFFJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(long param0, long param1, long param2, boolean param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJZI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPZ(long param0, long param1, int param2, long param3, int param4, boolean param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJIZ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
        return __r != 0.0;
    }
    public static boolean invokePPPJZ(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePUUUZ(long param0, byte param1, byte param2, byte param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JBBB:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(int param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, long param2, float param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJFJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, boolean param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JZJJJ:Z", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePJPPZ(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, float param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJFIJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, long param2, int param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, long param2, float param3, float param4, float param5, float param6, float param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJFFFFFJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, int param2, int param3, int param4, int param5, float param6, int param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIIIFIJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return __r != 0.0;
    }
    public static boolean invokePPPPZ(long param0, long param1, long param2, float param3, float param4, float param5, float param6, float param7, long param8, float param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJFFFFFJF:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return __r != 0.0;
    }
    public static boolean invokePPPPPZ(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPUPZ(long param0, long param1, long param2, byte param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJBJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePUUUUZ(long param0, byte param1, byte param2, byte param3, byte param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JBBBB:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return __r != 0.0;
    }
    public static boolean invokePPPPPZ(int param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePPPPPZ(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePPPPPZ(long param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePPPPPZ(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return __r != 0.0;
    }
    public static boolean invokePPPPPZ(long param0, long param1, long param2, long param3, double param4, long param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJDJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return __r != 0.0;
    }
    public static boolean invokePPPPPZ(long param0, long param1, long param2, long param3, long param4, boolean param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJZI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0), (double)param6});
        return __r != 0.0;
    }
    public static boolean invokePUUUUZ(long param0, int param1, int param2, byte param3, byte param4, byte param5, byte param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIBBBB:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return __r != 0.0;
    }
    public static boolean invokePPPPPZ(long param0, long param1, long param2, int param3, long param4, int param5, long param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJIJI:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return __r != 0.0;
    }
    public static boolean invokePPJJPPZ(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePPPPPPZ(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return __r != 0.0;
    }
    public static boolean invokePPPPPPZ(long param0, long param1, long param2, int param3, long param4, int param5, long param6, int param7, int param8, long param9, int param10, int param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJIJIIJII:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return __r != 0.0;
    }
    public static short callC(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:S", new double[] {(double)param0});
        return (short)(long)__r;
    }
    public static float callF(int param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "III:F", new double[] {(double)param0, (double)param1, (double)param2});
        return (float)__r;
    }
    public static float callPF(long param0, float param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JF:F", new double[] {(double)param0, (double)param1});
        return (float)__r;
    }
    public static int callI(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":I", new double[] {});
        return (int)(long)__r;
    }
    public static int callI(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:I", new double[] {(double)param0});
        return (int)(long)__r;
    }
    public static int callI(int param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "II:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int callI(int param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "III:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPI(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:I", new double[] {(double)param0});
        return (int)(long)__r;
    }
    public static int callPI(int param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJ:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int callPI(long param0, float param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JF:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int callPI(int param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPI(int param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJI:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPI(long param0, float param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFF:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPI(long param0, float param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFI:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIF:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callJI(int param0, long param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPI(int param0, int param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPI(long param0, float param1, float param2, float param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFFF:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, float param2, float param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIFF:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, int param2, boolean param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIZ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int callPI(int param0, int param1, int param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, float param2, float param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIFFI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, int param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPI(int param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPI(int param0, long param1, int param2, int param3, float param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJIIFI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPI(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPI(int param0, int param1, long param2, int param3, int param4, int param5, int param6, float param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJIIIIF:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPI(long param0, float param1, float param2, float param3, float param4, float param5, float param6, float param7, float param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFFFFFFFF:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPJI(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:I", new double[] {(double)param0, (double)param1});
        return (int)(long)__r;
    }
    public static int callPJI(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPJI(long param0, long param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJF:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPJI(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPPI(int param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, float param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJF:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPPI(int param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, float param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIFJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, float param2, float param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJFF:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, float param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJFI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, float param2, float param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIFFJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, int param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, int param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, int param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, int param2, int param3, boolean param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIZ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0)});
        return (int)(long)__r;
    }
    public static int callPPI(int param0, long param1, int param2, int param3, float param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJIIFJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, float param2, float param3, float param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIFFFJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, long param1, int param2, int param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, float param2, float param3, float param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIFFFIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, float param2, float param3, float param4, float param5, int param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIFFFFIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPI(int param0, int param1, long param2, long param3, int param4, int param5, int param6, int param7, float param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJJIIIIF:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, float param2, float param3, float param4, float param5, float param6, int param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIFFFFFIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, int param2, float param3, float param4, float param5, float param6, float param7, int param8, long param9, int param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIFFFFFIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (int)(long)__r;
    }
    public static int callPPI(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIIIJIIIIIIIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15, (double)param16});
        return (int)(long)__r;
    }
    public static int callPJJI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPJPI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPPJI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)param2});
        return (int)(long)__r;
    }
    public static int callPJJI(long param0, long param1, long param2, float param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJF:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPJJI(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPJPI(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPJPI(long param0, long param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPJI(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPJI(long param0, long param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPNI(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPPI(int param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, long param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPJJI(long param0, long param1, int param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPJPI(long param0, int param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPJI(long param0, int param1, long param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPI(int param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, int param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, long param1, int param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, long param1, long param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, int param1, int param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, long param1, long param2, int param3, int param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, float param1, float param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JFFIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, int param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, int param1, long param2, long param3, int param4, int param5, int param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJIII:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPI(long param0, long param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callJPPI(int param0, int param1, int param2, int param3, int param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callJJPPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPJJJI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPJJPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPJPPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPJPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPNPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (int)(long)__r;
    }
    public static int callPJJJI(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPJPPI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, long param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPJPPI(long param0, long param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(int param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, int param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, int param1, long param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, int param1, long param2, long param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, long param2, int param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, long param2, int param3, long param4, int param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPJPPI(long param0, long param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, int param1, int param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, int param1, long param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPI(long param0, long param1, long param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPI(int param0, long param1, long param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, int param17, int param18, int param19, int param20, long param21, long param22, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJIIIIIIIIIIIIIIIIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15, (double)param16, (double)param17, (double)param18, (double)param19, (double)param20, (double)param21, (double)param22});
        return (int)(long)__r;
    }
    public static int callPJJPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPJPPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPJPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (int)(long)__r;
    }
    public static int callPJJJPI(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPJPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPJPPI(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPJPPI(long param0, long param1, int param2, long param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPPI(int param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, int param1, long param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callJPPPPI(int param0, int param1, long param2, long param3, int param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPJPPJI(long param0, long param1, int param2, int param3, long param4, long param5, long param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPI(long param0, int param1, long param2, int param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPJJJJPI(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPJPI(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (int)(long)__r;
    }
    public static int callPJJPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPJPPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPJPPI(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPPPPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (int)(long)__r;
    }
    public static int callPJPPPPI(long param0, int param1, long param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPJPPI(long param0, int param1, long param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPPI(int param0, int param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPPI(long param0, int param1, long param2, int param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPPI(long param0, int param1, long param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPPPI(long param0, long param1, long param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPPPPPPI(long param0, int param1, long param2, int param3, long param4, long param5, long param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPPPPPPPI(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJIJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, int param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPPPPPPPI(long param0, long param1, long param2, int param3, long param4, long param5, int param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPPPPPJPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (int)(long)__r;
    }
    public static int callPPJPPPPPI(long param0, long param1, long param2, long param3, long param4, int param5, long param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, int param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, long param6, int param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, int param7, long param8, long param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, int param6, long param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, int param8, long param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, long param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, int param8, long param9, long param10, long param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, int param8, long param9, long param10, long param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, int param10, long param11, long param12, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, int param11, long param12, long param13, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13});
        return (int)(long)__r;
    }
    public static int callPPPPPPPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, long param11, int param12, long param13, long param14, long param15, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15});
        return (int)(long)__r;
    }
    public static long callJ(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":J", new double[] {});
        return (long)__r;
    }
    public static long callJ(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long callJ(int param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "II:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callJ(int param0, int param1, boolean param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIZII:J", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPJ(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callPPJ(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callPJJ(long param0, long param1, int param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPJJJ(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPN(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long callP(long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, ":J", new double[] {});
        return (long)__r;
    }
    public static long callP(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long callP(int param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "II:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callP(int param0, float param1, float param2, float param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IFFF:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callJP(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long callPP(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)param0});
        return (long)__r;
    }
    public static long callPP(int param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callPP(long param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callPP(int param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPP(int param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJI:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPP(long param0, int param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JII:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPP(int param0, int param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callJJP(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callPNP(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callPPP(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)param1});
        return (long)__r;
    }
    public static long callPPP(int param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPPP(long param0, int param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPPP(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPPP(int param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPP(long param0, int param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPP(int param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPP(long param0, int param1, int param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPP(long param0, long param1, int param2, int param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIII:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPNP(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPPPP(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)param2});
        return (long)__r;
    }
    public static long callPJPP(long param0, long param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPJPP(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPPP(int param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPPP(long param0, int param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPPP(long param0, long param1, int param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPPP(long param0, long param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPPP(long param0, long param1, int param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPPP(long param0, long param1, int param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPJPP(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long callJJPPP(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPJPP(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPNPP(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPPPPP(long param0, long param1, long param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (long)__r;
    }
    public static long callPJPPP(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPJPPP(long param0, long param1, long param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPPPP(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPPPP(long param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPPPP(long param0, long param1, long param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPPPP(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJI:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPJPPP(long param0, long param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long callPJPPPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPPJPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (long)__r;
    }
    public static long callPPPPPP(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long callPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long callPPPPPP(long param0, int param1, int param2, long param3, int param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIIJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long callPJJPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long callPJPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long callPPJPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long callPPPJPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (long)__r;
    }
    public static long callPPPPPPP(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long callPPJPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long callPPPPJPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (long)__r;
    }
    public static long callPPPPPPPP(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJJIJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (long)__r;
    }
    public static long callPPPPPPPP(int param0, long param1, long param2, int param3, int param4, int param5, int param6, long param7, long param8, long param9, int param10, long param11, long param12, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJIIIIJJJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12});
        return (long)__r;
    }
    public static long callPJPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (long)__r;
    }
    public static long callPPJPPPPPP(long param0, long param1, int param2, long param3, long param4, long param5, int param6, long param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (long)__r;
    }
    public static long callPJPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (long)__r;
    }
    public static long callPPJPPPPPPPP(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, int param8, long param9, long param10, long param11, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
        return (long)__r;
    }
    public static short callS(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:S", new double[] {(double)param0});
        return (short)(long)__r;
    }
    public static short callPS(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:S", new double[] {(double)param0});
        return (short)(long)__r;
    }
    public static short callPCS(long param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JS:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static short callPPS(long param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJ:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static short callPSS(long param0, short param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JS:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static short callSPS(short param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJ:S", new double[] {(double)param0, (double)param1});
        return (short)(long)__r;
    }
    public static short callPPS(long param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJI:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short callPPS(long param0, int param1, long param2, int param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJI:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (short)(long)__r;
    }
    public static short callPCPS(long param0, short param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJ:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short callPPCS(long param0, long param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJS:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short callPPPS(long param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJ:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short callPPSS(long param0, long param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJS:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short callPSPS(long param0, short param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJ:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short callSPPS(short param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJJ:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short callSPSS(short param0, long param1, short param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJS:S", new double[] {(double)param0, (double)param1, (double)param2});
        return (short)(long)__r;
    }
    public static short callPPPS(long param0, int param1, long param2, int param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JIJIJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (short)(long)__r;
    }
    public static short callPJCCS(long param0, long param1, short param2, short param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJSS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (short)(long)__r;
    }
    public static short callPPSPS(long param0, long param1, short param2, long param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJSJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return (short)(long)__r;
    }
    public static short callPSSPS(long param0, short param1, short param2, long param3, int param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSJI:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (short)(long)__r;
    }
    public static short callPPPPS(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJIJIJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (short)(long)__r;
    }
    public static short callPCPPPS(long param0, short param1, long param2, long param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (short)(long)__r;
    }
    public static short callPCPSPS(long param0, short param1, long param2, short param3, long param4, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJSJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
        return (short)(long)__r;
    }
    public static short callPSSPPS(long param0, short param1, short param2, long param3, int param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSJIJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (short)(long)__r;
    }
    public static short callPCPPPPS(long param0, short param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJJJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (short)(long)__r;
    }
    public static short callPCSPPPS(long param0, short param1, short param2, long param3, long param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSJJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (short)(long)__r;
    }
    public static short callPPSPSPS(long param0, long param1, short param2, long param3, short param4, long param5, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJSJSJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
        return (short)(long)__r;
    }
    public static short callPCCPSPPS(long param0, short param1, short param2, long param3, short param4, long param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSJSJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (short)(long)__r;
    }
    public static short callPPSPSPSS(long param0, long param1, short param2, long param3, short param4, long param5, short param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJSJSJS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (short)(long)__r;
    }
    public static short callSPSSPSPS(short param0, long param1, short param2, short param3, long param4, short param5, long param6, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJSSJSJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
        return (short)(long)__r;
    }
    public static short callPCPSPPSPS(long param0, short param1, long param2, short param3, long param4, long param5, short param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJSJJSJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (short)(long)__r;
    }
    public static short callPPPSPSPCS(long param0, long param1, long param2, short param3, long param4, short param5, long param6, short param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJJSJSJS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (short)(long)__r;
    }
    public static short callSPSPPPSPS(short param0, long param1, short param2, long param3, long param4, long param5, short param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "SJSJJJSJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return (short)(long)__r;
    }
    public static short callPCPSPPPPPS(long param0, short param1, long param2, short param3, long param4, long param5, long param6, long param7, long param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJSJJJJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (short)(long)__r;
    }
    public static short callPPSPSPSCCS(long param0, long param1, short param2, long param3, short param4, long param5, short param6, short param7, short param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJSJSJSSS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (short)(long)__r;
    }
    public static short callPPSPSPSPSS(long param0, long param1, short param2, long param3, short param4, long param5, short param6, long param7, short param8, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJSJSJSJS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        return (short)(long)__r;
    }
    public static short callPCPSPSPSCCS(long param0, short param1, long param2, short param3, long param4, short param5, long param6, short param7, short param8, short param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJSJSJSSS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (short)(long)__r;
    }
    public static short callPCSSSPSPPPS(long param0, short param1, short param2, short param3, short param4, long param5, short param6, long param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSSSJSJJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (short)(long)__r;
    }
    public static short callPSSSPSSPPPS(long param0, short param1, short param2, short param3, long param4, short param5, short param6, long param7, long param8, long param9, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSSSJSSJJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
        return (short)(long)__r;
    }
    public static short callPSPSPPPPPPPS(long param0, short param1, long param2, short param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JSJSJJJJJJJ:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        return (short)(long)__r;
    }
    public static short callPPSPSPSPSPSPSS(long param0, long param1, short param2, long param3, short param4, long param5, short param6, long param7, short param8, long param9, short param10, long param11, short param12, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "JJSJSJSJSJSJS:S", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12});
        return (short)(long)__r;
    }
    public static void callV(long __functionAddress) {
        WebFFI.call(__functionAddress, ":V", new double[] {});
    }
    public static void callV(double param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "D:V", new double[] {(double)param0});
    }
    public static void callV(float param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "F:V", new double[] {(double)param0});
    }
    public static void callV(int param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "I:V", new double[] {(double)param0});
    }
    public static void callV(boolean param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "Z:V", new double[] {(double)(param0 ? 1.0 : 0.0)});
    }
    public static void callV(double param0, double param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "DD:V", new double[] {(double)param0, (double)param1});
    }
    public static void callV(float param0, float param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "FF:V", new double[] {(double)param0, (double)param1});
    }
    public static void callV(float param0, boolean param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "FZ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
    }
    public static void callV(int param0, double param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "ID:V", new double[] {(double)param0, (double)param1});
    }
    public static void callV(int param0, float param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IF:V", new double[] {(double)param0, (double)param1});
    }
    public static void callV(int param0, int param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "II:V", new double[] {(double)param0, (double)param1});
    }
    public static void callV(int param0, boolean param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IZ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0)});
    }
    public static void callV(double param0, double param1, double param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "DDD:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callV(float param0, float param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "FFF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callV(int param0, double param1, double param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IDD:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callV(int param0, float param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IFF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callV(int param0, int param1, double param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IID:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callV(int param0, int param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callV(int param0, int param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "III:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callV(int param0, int param1, boolean param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIZ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0)});
    }
    public static void callV(double param0, double param1, double param2, double param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "DDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(float param0, float param1, float param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "FFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, double param1, double param2, double param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, float param1, float param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, int param1, double param2, double param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, int param1, float param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, int param1, float param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIFI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, int param1, int param2, double param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIID:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, int param1, int param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, int param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callV(int param0, int param1, int param2, boolean param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0)});
    }
    public static void callV(int param0, int param1, boolean param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIZI:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)param3});
    }
    public static void callV(boolean param0, boolean param1, boolean param2, boolean param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "ZZZZ:V", new double[] {(double)(param0 ? 1.0 : 0.0), (double)(param1 ? 1.0 : 0.0), (double)(param2 ? 1.0 : 0.0), (double)(param3 ? 1.0 : 0.0)});
    }
    public static void callV(int param0, double param1, double param2, double param3, double param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IDDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callV(int param0, float param1, float param2, float param3, float param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callV(int param0, int param1, double param2, double param3, double param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callV(int param0, int param1, float param2, float param3, float param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callV(int param0, int param1, int param2, float param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIFI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callV(int param0, int param1, int param2, boolean param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIZI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4});
    }
    public static void callV(int param0, boolean param1, boolean param2, boolean param3, boolean param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IZZZZ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)(param2 ? 1.0 : 0.0), (double)(param3 ? 1.0 : 0.0), (double)(param4 ? 1.0 : 0.0)});
    }
    public static void callV(double param0, double param1, double param2, double param3, double param4, double param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "DDDDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callV(int param0, double param1, double param2, int param3, double param4, double param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IDDIDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callV(int param0, float param1, float param2, int param3, float param4, float param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IFFIFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callV(int param0, int param1, double param2, double param3, double param4, double param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIDDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callV(int param0, int param1, float param2, float param3, float param4, float param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, boolean param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
    }
    public static void callV(int param0, int param1, int param2, int param3, boolean param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIZI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0), (double)param5});
    }
    public static void callV(int param0, double param1, double param2, double param3, double param4, double param5, double param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IDDDDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callV(int param0, int param1, int param2, double param3, double param4, double param5, double param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIDDDD:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callV(int param0, int param1, int param2, float param3, float param4, float param5, float param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, boolean param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)(param6 ? 1.0 : 0.0)});
    }
    public static void callV(int param0, int param1, int param2, boolean param3, int param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIZIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4, (double)param5, (double)param6});
    }
    public static void callV(float param0, float param1, float param2, float param3, float param4, float param5, float param6, float param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "FFFFFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callV(int param0, int param1, int param2, float param3, float param4, float param5, float param6, float param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIFFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, boolean param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)(param7 ? 1.0 : 0.0)});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, boolean param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)(param8 ? 1.0 : 0.0)});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void callV(int param0, int param1, float param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, float param10, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIFFFFFFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIIIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14});
    }
    public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIIIIIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15, (double)param16});
    }
    public static void callJV(long param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "J:V", new double[] {(double)param0});
    }
    public static void callPV(long param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "J:V", new double[] {(double)param0});
    }
    public static void callSV(short param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "S:V", new double[] {(double)param0});
    }
    public static void callUV(byte param0, long __functionAddress) {
        WebFFI.call(__functionAddress, "B:V", new double[] {(double)param0});
    }
    public static void callCV(int param0, short param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IS:V", new double[] {(double)param0, (double)param1});
    }
    public static void callJV(int param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void callJV(long param0, int param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JI:V", new double[] {(double)param0, (double)param1});
    }
    public static void callPV(int param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void callPV(long param0, float param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JF:V", new double[] {(double)param0, (double)param1});
    }
    public static void callPV(long param0, int param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JI:V", new double[] {(double)param0, (double)param1});
    }
    public static void callSV(int param0, short param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "IS:V", new double[] {(double)param0, (double)param1});
    }
    public static void callJV(int param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPV(int param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPV(int param0, long param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJI:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPV(long param0, float param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JFF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPV(long param0, int param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JII:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callJV(int param0, long param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callNV(long param0, int param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPV(int param0, int param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPV(int param0, int param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPV(int param0, int param1, boolean param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIZJ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)param3});
    }
    public static void callPV(int param0, long param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPV(long param0, float param1, float param2, float param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPV(long param0, int param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPV(int param0, int param1, int param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPV(int param0, int param1, int param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPV(int param0, int param1, int param2, long param3, boolean param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0)});
    }
    public static void callPV(int param0, int param1, int param2, boolean param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIZJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4});
    }
    public static void callPV(int param0, int param1, long param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPV(int param0, long param1, int param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPV(int param0, boolean param1, int param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IZIIJ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)param4});
    }
    public static void callPV(long param0, int param1, int param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callJV(int param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPV(int param0, double param1, double param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IDDIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPV(int param0, float param1, float param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IFFIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPV(int param0, int param1, int param2, int param3, long param4, boolean param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
    }
    public static void callPV(int param0, int param1, int param2, long param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPV(int param0, int param1, int param2, boolean param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIZIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4, (double)param5});
    }
    public static void callPV(int param0, int param1, long param2, int param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPV(int param0, boolean param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IZIIIJ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPV(long param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callJV(int param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPV(int param0, int param1, float param2, float param3, float param4, float param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIFFFFJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, long param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPV(int param0, int param1, int param2, long param3, int param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPV(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callJV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callJV(int param0, int param1, int param2, int param3, int param4, boolean param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIZIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0), (double)param6, (double)param7});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, boolean param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIZIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0), (double)param6, (double)param7});
    }
    public static void callJV(int param0, int param1, int param2, int param3, int param4, int param5, boolean param6, int param7, long param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIZIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)(param6 ? 1.0 : 0.0), (double)param7, (double)param8});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, long param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void callPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, int param7, float param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIIIIIF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void callPV(int param0, double param1, double param2, int param3, int param4, double param5, double param6, int param7, int param8, long param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "IDDIIDDIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void callPV(int param0, float param1, float param2, int param3, int param4, float param5, float param6, int param7, int param8, long param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "IFFIIFFIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, long param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void callJV(long param0, int param1, float param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, float param10, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIFFFFFFFFF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, long param10, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
    }
    public static void callPV(long param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIIIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
    }
    public static void callJV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, long param10, boolean param11, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)(param11 ? 1.0 : 0.0)});
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, long param11, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11});
    }
    public static void callPJV(long param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void callPPV(long param0, long param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)param0, (double)param1});
    }
    public static void callSSV(short param0, short param1, long __functionAddress) {
        WebFFI.call(__functionAddress, "SS:V", new double[] {(double)param0, (double)param1});
    }
    public static void callJJV(int param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPCV(long param0, int param1, short param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIS:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPJV(long param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPJV(long param0, long param1, float param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJF:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPJV(long param0, long param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJI:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPPV(int param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPPV(long param0, int param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPPV(long param0, long param1, int param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJI:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callSSV(int param0, short param1, short param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "ISS:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callJJV(int param0, int param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callJPV(int param0, int param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callJPV(int param0, long param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJV(int param0, long param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJV(long param0, int param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJV(long param0, long param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPV(int param0, int param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPV(int param0, long param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPV(int param0, long param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPV(int param0, long param1, long param2, boolean param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0)});
    }
    public static void callPPV(long param0, int param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPV(long param0, long param1, int param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJV(long param0, long param1, int param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPV(int param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPV(int param0, int param1, long param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPV(int param0, int param1, long param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPV(int param0, long param1, int param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPV(int param0, long param1, long param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPV(long param0, int param1, int param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPV(int param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPV(int param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPV(int param0, long param1, long param2, int param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPV(long param0, int param1, long param2, int param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPV(int param0, int param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPV(int param0, int param1, int param2, long param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPV(int param0, int param1, long param2, long param3, int param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPV(int param0, int param1, int param2, int param3, int param4, int param5, long param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPV(int param0, int param1, int param2, int param3, long param4, int param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPV(int param0, int param1, int param2, long param3, int param4, float param5, float param6, int param7, long param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJIFFIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, int param7, long param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, long param6, int param7, int param8, float param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIIIJIIF:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void callBBBV(byte param0, byte param1, byte param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "BBB:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callCCCV(short param0, short param1, short param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSS:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPJJV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPJPV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPPNV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callPPPV(long param0, long param1, long param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callSSSV(short param0, short param1, short param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSS:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callUUUV(byte param0, byte param1, byte param2, long __functionAddress) {
        WebFFI.call(__functionAddress, "BBB:V", new double[] {(double)param0, (double)param1, (double)param2});
    }
    public static void callJJJV(int param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJJV(long param0, long param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJPV(long param0, long param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPPV(int param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPPV(long param0, int param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPPV(long param0, long param1, int param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPPV(long param0, long param1, long param2, int param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callSSSV(int param0, short param1, short param2, short param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "ISSS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callJJJV(int param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPJJV(long param0, int param1, long param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPJJV(long param0, long param1, long param2, int param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPV(int param0, long param1, int param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPV(int param0, long param1, long param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPV(int param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPV(long param0, int param1, int param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPV(long param0, int param1, long param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPJPV(long param0, int param1, long param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPJPV(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPJV(int param0, long param1, long param2, int param3, long param4, boolean param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
    }
    public static void callPPJV(long param0, int param1, long param2, int param3, long param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPPV(int param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPPV(int param0, int param1, long param2, int param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPPV(int param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPJJV(long param0, int param1, int param2, long param3, long param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPPV(int param0, int param1, int param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPPV(long param0, int param1, long param2, int param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPPV(int param0, int param1, int param2, int param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIIJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPPV(long param0, int param1, int param2, int param3, int param4, int param5, long param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPPV(long param0, long param1, int param2, int param3, int param4, int param5, int param6, int param7, long param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, int param17, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIIIIIJIIIIIIIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15, (double)param16, (double)param17});
    }
    public static void callBBBBV(byte param0, byte param1, byte param2, byte param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "BBBB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callCCCCV(short param0, short param1, short param2, short param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJJJV(long param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJJPV(long param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPJPPV(long param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPPNV(long param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callPPPPV(long param0, long param1, long param2, long param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callSSSSV(short param0, short param1, short param2, short param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "SSSS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callUUUUV(byte param0, byte param1, byte param2, byte param3, long __functionAddress) {
        WebFFI.call(__functionAddress, "BBBB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
    }
    public static void callJJJJV(int param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPJJJV(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPJJPV(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPJJPV(long param0, long param1, long param2, int param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPPV(long param0, int param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPPV(long param0, long param1, long param2, long param3, int param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callSSSSV(int param0, short param1, short param2, short param3, short param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "ISSSS:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callUUUUV(int param0, byte param1, byte param2, byte param3, byte param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "IBBBB:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callJJJJV(int param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPJJJV(long param0, long param1, long param2, long param3, int param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPJJPV(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPJJPV(long param0, long param1, long param2, int param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPJPPV(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPPPV(int param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPPPV(int param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "IJJJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPPPV(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPJJPV(long param0, long param1, int param2, int param3, long param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPJJPV(long param0, long param1, int param2, long param3, int param4, int param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPJPPV(long param0, int param1, long param2, int param3, int param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPPPV(int param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPPPV(int param0, int param1, long param2, long param3, long param4, long param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPJJPV(long param0, long param1, int param2, long param3, int param4, int param5, long param6, int param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIJIIJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPJPPV(long param0, int param1, long param2, int param3, int param4, long param5, int param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPPPV(long param0, int param1, int param2, int param3, int param4, long param5, int param6, long param7, int param8, long param9, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIIIJIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9});
    }
    public static void callPJJJPV(long param0, long param1, long param2, long param3, long param4, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4});
    }
    public static void callPPPPPV(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPJJJJV(long param0, long param1, long param2, long param3, long param4, int param5, int param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPPPPV(int param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPPPPPV(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6});
    }
    public static void callPJJJJV(long param0, long param1, int param2, int param3, long param4, long param5, long param6, int param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJIIJJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPJPPPV(long param0, int param1, int param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIIJJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPPPPV(long param0, long param1, long param2, long param3, long param4, int param5, int param6, int param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPPPPV(long param0, int param1, long param2, int param3, int param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) {
        WebFFI.call(__functionAddress, "JIJIIIJIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
    }
    public static void callPPPPPJV(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5});
    }
    public static void callPPPPPPV(long param0, long param1, long param2, int param3, int param4, long param5, long param6, long param7, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
    }
    public static void callPPPPPPPV(int param0, int param1, int param2, long param3, int param4, long param5, long param6, long param7, long param8, long param9, long param10, long __functionAddress) {
        WebFFI.call(__functionAddress, "IIIJIJJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
    }
    public static void callPPJJJJJJV(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, long param8, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
    }
    public static void callPJJJJJJJJJJJV(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, long param11, int param12, int param13, int param14, long __functionAddress) {
        WebFFI.call(__functionAddress, "JJJJJJJJJJJJIII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14});
    }
    public static boolean callZ(int param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "I:Z", new double[] {(double)param0});
        return __r != 0.0;
    }
    public static boolean callZ(int param0, int param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "II:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean callZ(int param0, float param1, float param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IFF:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean callZ(int param0, int param1, float param2, float param3, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIFF:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3});
        return __r != 0.0;
    }
    public static boolean callJZ(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:Z", new double[] {(double)param0});
        return __r != 0.0;
    }
    public static boolean callPZ(long param0, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "J:Z", new double[] {(double)param0});
        return __r != 0.0;
    }
    public static boolean callJZ(int param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJ:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean callPZ(int param0, long param1, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJ:Z", new double[] {(double)param0, (double)param1});
        return __r != 0.0;
    }
    public static boolean callJZ(int param0, long param1, int param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJI:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean callPPZ(int param0, long param1, long param2, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IJJ:Z", new double[] {(double)param0, (double)param1, (double)param2});
        return __r != 0.0;
    }
    public static boolean callPPPPZ(int param0, int param1, int param2, float param3, long param4, long param5, long param6, long param7, long __functionAddress) {
        double __r = WebFFI.call(__functionAddress, "IIIFJJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        return __r != 0.0;
    }
    public static short invokeUPC(byte param0, short[] param1, boolean param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "BJZ:S", new double[] {(double)param0, (double)_a_param1, (double)(param2 ? 1.0 : 0.0)});
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        return (short)(long)__r;
        }
    }
    public static short invokeCPCC(short param0, short[] param1, short param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "SJS:S", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        return (short)(long)__r;
        }
    }
    public static int invokeCPI(short param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "SJ:I", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int invokePCI(float[] param0, short param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memFloatBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JS:I", new double[] {(double)_a_param0, (double)param1});
        if (param0 != null) { memFloatBuffer(_a_param0, param0.length).get(param0); }
        return (int)(long)__r;
        }
    }
    public static int invokePPI(int param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "IJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int invokePPI(int param0, int[] param1, int param2, int[] param3, int param4, boolean param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "IJIJIZ:I", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)_a_param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int invokePPI(int param0, short[] param1, int param2, short[] param3, int param4, boolean param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 2); memShortBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "IJIJIZ:I", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)_a_param3, (double)param4, (double)(param5 ? 1.0 : 0.0)});
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        if (param3 != null) { memShortBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int invokeCPUI(short param0, float[] param1, byte param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "SJB:I", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int invokeCPUI(short param0, int[] param1, byte param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "SJB:I", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int invokeCPUI(short param0, short[] param1, byte param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "SJB:I", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int invokePPCI(long param0, float[] param1, short param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJS:I", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPI(int[] param0, long param1, long param2, int param3, boolean param4, float param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JJJIZF:I", new double[] {(double)_a_param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0), (double)param5});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPI(short[] param0, long param1, long param2, int param3, boolean param4, float param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 2); memShortBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JJJIZF:I", new double[] {(double)_a_param0, (double)param1, (double)param2, (double)param3, (double)(param4 ? 1.0 : 0.0), (double)param5});
        if (param0 != null) { memShortBuffer(_a_param0, param0.length).get(param0); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPPI(long param0, long param1, long param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPPI(long param0, long param1, int param2, int param3, float[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPPI(long param0, long param1, int param2, int param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPPPI(long param0, int[] param1, int[] param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)_a_param3, (double)param4});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int invokePNNPPPI(long param0, long param1, long param2, int param3, int param4, int[] param5, int[] param6, long param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JJJIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)_a_param6, (double)param7});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPPPPI(int param0, int param1, int[] param2, int[] param3, int[] param4, int[] param5, int[] param6, long param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "IIJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4, (double)_a_param5, (double)_a_param6, (double)param7});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPPPPPI(long param0, int param1, int param2, int[] param3, int[] param4, int[] param5, int[] param6, int[] param7, long param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JIIJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5, (double)_a_param6, (double)_a_param7, (double)param8});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        return (int)(long)__r;
        }
    }
    public static int invokePPPPPPPPI(long param0, int param1, int param2, long param3, int[] param4, int[] param5, float[] param6, int[] param7, int[] param8, int[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memFloatBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JIIJJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5, (double)_a_param6, (double)_a_param7, (double)_a_param8, (double)_a_param9});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memFloatBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (int)(long)__r;
        }
    }
    public static long invokePP(double[] param0, int param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 8); memDoubleBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)_a_param0, (double)param1});
        if (param0 != null) { memDoubleBuffer(_a_param0, param0.length).get(param0); }
        return (long)__r;
        }
    }
    public static long invokePP(float[] param0, int param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memFloatBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)_a_param0, (double)param1});
        if (param0 != null) { memFloatBuffer(_a_param0, param0.length).get(param0); }
        return (long)__r;
        }
    }
    public static long invokePP(int[] param0, int param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)_a_param0, (double)param1});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        return (long)__r;
        }
    }
    public static long invokePP(long[] param0, int param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 8); memLongBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)_a_param0, (double)param1});
        if (param0 != null) { memLongBuffer(_a_param0, param0.length).get(param0); }
        return (long)__r;
        }
    }
    public static long invokePP(short[] param0, int param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 2); memShortBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JI:J", new double[] {(double)_a_param0, (double)param1});
        if (param0 != null) { memShortBuffer(_a_param0, param0.length).get(param0); }
        return (long)__r;
        }
    }
    public static long invokePPP(long param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (long)__r;
        }
    }
    public static byte invokeUPU(byte param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "BJ:B", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (byte)(long)__r;
        }
    }
    public static void invokePV(int param0, double[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memDoubleBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memDoubleBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePV(int param0, float[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePV(int param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePV(int param0, int param1, double[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePV(int param0, int param1, float[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePV(int param0, int param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePV(int param0, int param1, long[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePV(int param0, int[] param1, boolean param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJZ:V", new double[] {(double)param0, (double)_a_param1, (double)(param2 ? 1.0 : 0.0)});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePV(int param0, int param1, float[] param2, int param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJII:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePV(int param0, int param1, int[] param2, int param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJII:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePV(int param0, int param1, short[] param2, int param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 2); memShortBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJII:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4});
        if (param2 != null) { memShortBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, double[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memDoubleBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memDoubleBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, float[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, short[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 2); memShortBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memShortBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int[] param4, boolean param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)(param5 ? 1.0 : 0.0)});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, int param5, double[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 8); memDoubleBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memDoubleBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, int param5, float[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memFloatBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memFloatBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, int param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void invokePV(int param0, int param1, int param2, int param3, int param4, int param5, short[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 2); memShortBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memShortBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void invokeUPV(byte param0, float[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "BJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePJV(int param0, int[] param1, long param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePPV(long param0, int param1, double[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPV(long param0, int param1, float[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPV(long param0, int param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPV(long param0, float[] param1, int param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJI:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePPV(long param0, int[] param1, int param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJI:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePPV(long param0, short[] param1, int param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJI:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokePPV(long param0, int param1, int param2, double[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memDoubleBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memDoubleBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPV(long param0, int param1, int param2, float[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPV(long param0, int param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPV(long param0, int param1, int param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPV(long param0, int param1, int[] param2, boolean param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJZ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)(param3 ? 1.0 : 0.0)});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPV(int param0, int param1, int param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPV(long param0, int param1, int param2, float[] param3, int param4, int param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIIJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4, (double)param5});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPV(long param0, int param1, int param2, int[] param3, int param4, int param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIIJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4, (double)param5});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPV(long param0, int param1, int param2, short[] param3, int param4, int param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 2); memShortBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIIJII:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4, (double)param5});
        if (param3 != null) { memShortBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPV(long param0, int param1, int param2, int param3, int param4, int[] param5, boolean param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JIIIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)(param6 ? 1.0 : 0.0)});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokeCCPV(short param0, short param1, short[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 2); memShortBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "SSJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memShortBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokeCPCV(short param0, double[] param1, short param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memDoubleBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "SJS:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memDoubleBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokeCPCV(short param0, float[] param1, short param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "SJS:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokeCPCV(short param0, int[] param1, short param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "SJS:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokeCPCV(short param0, long[] param1, short param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "SJS:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokeCPCV(short param0, short[] param1, short param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "SJS:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void invokeCPPV(short param0, float[] param1, float[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "SJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePNPV(long param0, long param1, short[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 2); memShortBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memShortBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPPV(long param0, double[] param1, double[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memDoubleBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memDoubleBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPPV(long param0, float[] param1, float[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPPV(long param0, int[] param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPPV(int[] param0, int[] param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)_a_param0, (double)_a_param1, (double)_a_param2});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPJV(long param0, int param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePPPV(int param0, float[] param1, float[] param2, float[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)_a_param3});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPPV(int param0, int[] param1, int[] param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)_a_param3});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPPV(int param0, int param1, double[] param2, double[] param3, double[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memDoubleBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memDoubleBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memDoubleBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memDoubleBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPV(int param0, int param1, float[] param2, float[] param3, float[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPV(int param0, int param1, int[] param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPV(int param0, int param1, long[] param2, long[] param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPV(float[] param0, int param1, long param2, long param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memFloatBuffer(_a_param0, param0.length).put(param0); }
        WebFFI.call(__functionAddress, "JIJJI:V", new double[] {(double)_a_param0, (double)param1, (double)param2, (double)param3, (double)param4});
        if (param0 != null) { memFloatBuffer(_a_param0, param0.length).get(param0); }
        }
    }
    public static void invokePPPV(long param0, int param1, int param2, int param3, int[] param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPV(float[] param0, boolean param1, int param2, long param3, long param4, int param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memFloatBuffer(_a_param0, param0.length).put(param0); }
        WebFFI.call(__functionAddress, "JZIJJI:V", new double[] {(double)_a_param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)param4, (double)param5});
        if (param0 != null) { memFloatBuffer(_a_param0, param0.length).get(param0); }
        }
    }
    public static void invokeCCPCV(short param0, short param1, double[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "SSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokeCCPCV(short param0, short param1, float[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "SSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokeCCPCV(short param0, short param1, int[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "SSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokeCCPCV(short param0, short param1, long[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "SSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokeCCPCV(short param0, short param1, short[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 2); memShortBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "SSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memShortBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePCPCV(long param0, short param1, double[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePCPCV(long param0, short param1, float[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePCPCV(long param0, short param1, int[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePCPCV(long param0, short param1, long[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePCPCV(long param0, short param1, short[] param2, short param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 2); memShortBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JSJS:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memShortBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void invokePNPPV(long param0, long param1, long param2, short[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 2); memShortBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memShortBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPPPV(long param0, int param1, float[] param2, float[] param3, float[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JIJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPPV(long param0, int param1, int[] param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JIJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPPV(long param0, int param1, int param2, double[] param3, double[] param4, double[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memDoubleBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memDoubleBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memDoubleBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5});
        if (param3 != null) { memDoubleBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memDoubleBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memDoubleBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokePPPPV(long param0, int param1, int param2, float[] param3, float[] param4, float[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokePPPPV(long param0, int param1, int param2, int[] param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokePPPPV(long param0, int param1, int param2, long[] param3, long[] param4, long[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memLongBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memLongBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void invokePPPPPV(long param0, long param1, long param2, float[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPPPPV(long param0, int[] param1, int[] param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPPPV(long param0, int param1, long param2, int[] param3, long param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4, (double)param5});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void invokePPPPPV(int param0, long param1, int param2, float[] param3, float[] param4, long param5, int param6, long param7, int param8, boolean param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IJIJJJIJIZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)(param9 ? 1.0 : 0.0)});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void invokePPPPPV(int param0, int[] param1, int param2, float[] param3, float[] param4, long param5, int param6, int[] param7, int param8, boolean param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IJIJJJIJIZ:V", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)param5, (double)param6, (double)_a_param7, (double)param8, (double)(param9 ? 1.0 : 0.0)});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void invokePPPPPV(int param0, short[] param1, int param2, float[] param3, float[] param4, long param5, int param6, short[] param7, int param8, boolean param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 2); memShortBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IJIJJJIJIZ:V", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)param5, (double)param6, (double)_a_param7, (double)param8, (double)(param9 ? 1.0 : 0.0)});
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param7 != null) { memShortBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static boolean invokePZ(int param0, int[] param1, boolean param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "IJZ:Z", new double[] {(double)param0, (double)_a_param1, (double)(param2 ? 1.0 : 0.0)});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return __r != 0.0;
        }
    }
    public static boolean invokePPZ(long param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJ:Z", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return __r != 0.0;
        }
    }
    public static boolean invokePPPZ(long param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:Z", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return __r != 0.0;
        }
    }
    public static int callPI(int[] param0, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "J:I", new double[] {(double)_a_param0});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        return (int)(long)__r;
        }
    }
    public static int callPI(int param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "IJ:I", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int callPI(int[] param0, int param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JI:I", new double[] {(double)_a_param0, (double)param1});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        return (int)(long)__r;
        }
    }
    public static int callPI(int param0, int param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "IIJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPI(int param0, int[] param1, int param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "IJI:I", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int callPI(int param0, int param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "IIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPI(int param0, int param1, int param2, int param3, float[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "IIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPI(int param0, int param1, int param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "IIIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJ:I", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, long[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJ:I", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(int[] param0, long param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "JJ:I", new double[] {(double)_a_param0, (double)param1});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(int param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "IJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, int param1, double[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, int param1, float[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, int param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, int param1, long[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, int param1, short[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 2); memShortBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memShortBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, long[] param1, int param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJI:I", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, int param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(long param0, int param1, int param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPI(int param0, long param1, int param2, int param3, float param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "IJIIFJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPJPI(long param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPJPI(long param0, long param1, long[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, long param1, long[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int[] param1, long param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int[] param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, long[] param1, long[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(int[] param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:I", new double[] {(double)_a_param0, (double)param1, (double)_a_param2});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPJPI(long param0, int param1, long param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPJPI(long param0, long param1, int param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(int param0, long param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "IJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, long param2, double[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memDoubleBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memDoubleBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, long param2, float[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, long param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, long param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, long param2, short[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 2); memShortBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memShortBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, int[] param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, int[] param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, long[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, long param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, long param1, int param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, long param1, int[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJI:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPJI(long param0, int param1, long[] param2, int param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJIJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, int param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, int param2, int param3, int[] param4, float[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPI(long param0, int param1, int param2, int param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, long param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, long param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, int[] param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, int[] param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPNPI(long param0, long param1, long param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, long param1, long param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, long param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, long param1, int[] param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, int param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, long param2, long param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, long param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, long param2, long[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, long param2, long[] param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, int[] param2, long param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, long param1, int param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, long param1, int param2, long[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, long param1, long param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int[] param1, long param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJIJ:I", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)_a_param4});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, long[] param1, int param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJIJJ:I", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)_a_param4});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, int param2, int param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, int param2, int param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, int param2, long param3, int[] param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, int param2, long param3, long[] param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)param5});
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, int param2, long[] param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JIIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPI(long param0, long param1, int param2, int param3, int param4, long param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JJIIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(long param0, int param1, long param2, int param3, int param4, long param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JIJIIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPI(int param0, int[] param1, long[] param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, int param17, int param18, int param19, int param20, int[] param21, long[] param22, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param21 = 0L; if (param21 != null) { _a_param21 = __s.nmalloc(8, param21.length * 4); memIntBuffer(_a_param21, param21.length).put(param21); }
        long _a_param22 = 0L; if (param22 != null) { _a_param22 = __s.nmalloc(8, param22.length * 8); memLongBuffer(_a_param22, param22.length).put(param22); }
        double __r = WebFFI.call(__functionAddress, "IJJIIIIIIIIIIIIIIIIIIJJ:I", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)param13, (double)param14, (double)param15, (double)param16, (double)param17, (double)param18, (double)param19, (double)param20, (double)_a_param21, (double)_a_param22});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param21 != null) { memIntBuffer(_a_param21, param21.length).get(param21); }
        if (param22 != null) { memLongBuffer(_a_param22, param22.length).get(param22); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPPI(long param0, long param1, long param2, long param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPJPPI(long param0, long param1, long param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, long param1, int[] param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, long param1, int[] param2, int[] param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, int[] param1, int[] param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:I", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)_a_param3, (double)param4});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPPI(long param0, long param1, int param2, long param3, long param4, long[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memLongBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memLongBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, long param1, int param2, long param3, int[] param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, long param1, int param2, long param3, long[] param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)param5});
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, long param1, long param2, int[] param3, int param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJIJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4, (double)_a_param5});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, int[] param1, float[] param2, int param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJIJJ:I", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(int param0, int param1, int[] param2, int[] param3, int[] param4, int[] param5, long param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "IIJJJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4, (double)_a_param5, (double)param6});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, int param1, long param2, long[] param3, int param4, long param5, long param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JIJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4, (double)param5, (double)param6});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPI(long param0, int param1, long[] param2, int param3, long param4, long param5, long param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPJI(long param0, long param1, int param2, int param3, long param4, int[] param5, long param6, int param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIIJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)param6, (double)param7});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPJPPJI(long param0, long param1, int param2, int param3, long param4, long[] param5, long param6, int param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memLongBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIIJJJI:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)param6, (double)param7});
        if (param5 != null) { memLongBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPJJJJPI(long param0, long param1, long param2, long param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPI(long param0, int[] param1, int[] param2, int[] param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:I", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)_a_param3, (double)_a_param4, (double)_a_param5});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPJJPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 8); memLongBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memLongBuffer(_a_param6, param6.length).get(param6); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPI(long param0, long param1, long[] param2, int param3, int[] param4, int[] param5, long param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)_a_param4, (double)_a_param5, (double)param6});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPI(int param0, int param1, int[] param2, int[] param3, int[] param4, int[] param5, int[] param6, long param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "IIJJJJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4, (double)_a_param5, (double)_a_param6, (double)param7});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, int[] param6, long param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6, (double)param7});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPI(long param0, long param1, float[] param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPI(long param0, long param1, int[] param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPI(long param0, long param1, int param2, long param3, long param4, double[] param5, int param6, long param7, long param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memDoubleBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)param6, (double)param7, (double)param8});
        if (param5 != null) { memDoubleBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPI(long param0, long param1, int param2, long param3, long param4, float[] param5, int param6, long param7, long param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)param6, (double)param7, (double)param8});
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPI(long param0, long param1, int param2, long param3, long param4, int[] param5, int param6, long param7, long param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)param6, (double)param7, (double)param8});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPI(long param0, long param1, int param2, long param3, long param4, short[] param5, int param6, long param7, long param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 2); memShortBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)param6, (double)param7, (double)param8});
        if (param5 != null) { memShortBuffer(_a_param5, param5.length).get(param5); }
        return (int)(long)__r;
        }
    }
    public static int callPPJPPPPPI(long param0, long[] param1, long param2, long param3, long param4, int param5, long param6, long param7, long param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJJJJIJJJ:I", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        return (int)(long)__r;
        }
    }
    public static int callPPJPPPPPI(long param0, long[] param1, long param2, long param3, long param4, int param5, long param6, int[] param7, long param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJJJJIJJJ:I", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7, (double)param8});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPI(long param0, long param1, long[] param2, long param3, long param4, long param5, int param6, int[] param7, int[] param8, long param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7, (double)_a_param8, (double)param9});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, double[] param7, int param8, long param9, long param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 8); memDoubleBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7, (double)param8, (double)param9, (double)param10});
        if (param7 != null) { memDoubleBuffer(_a_param7, param7.length).get(param7); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, float[] param7, int param8, long param9, long param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memFloatBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7, (double)param8, (double)param9, (double)param10});
        if (param7 != null) { memFloatBuffer(_a_param7, param7.length).get(param7); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, int[] param7, int param8, long param9, long param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7, (double)param8, (double)param9, (double)param10});
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, short[] param7, int param8, long param9, long param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 2); memShortBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7, (double)param8, (double)param9, (double)param10});
        if (param7 != null) { memShortBuffer(_a_param7, param7.length).get(param7); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPI(long param0, long param1, long[] param2, long param3, long param4, long param5, long param6, int param7, int[] param8, int[] param9, long param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8, (double)_a_param9, (double)param10});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPI(long param0, long param1, long[] param2, long param3, float[] param4, long param5, long param6, int param7, int[] param8, int[] param9, long param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)_a_param4, (double)param5, (double)param6, (double)param7, (double)_a_param8, (double)_a_param9, (double)param10});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPI(long param0, long param1, long[] param2, long param3, int[] param4, long param5, long param6, int param7, int[] param8, int[] param9, long param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)_a_param4, (double)param5, (double)param6, (double)param7, (double)_a_param8, (double)_a_param9, (double)param10});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPI(long param0, long param1, long[] param2, long param3, int param4, long param5, long param6, long param7, int param8, int[] param9, int[] param10, long param11, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 4); memIntBuffer(_a_param10, param10.length).put(param10); }
        double __r = WebFFI.call(__functionAddress, "JJJJIJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9, (double)_a_param10, (double)param11});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        if (param10 != null) { memIntBuffer(_a_param10, param10.length).get(param10); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPPI(long param0, long param1, long[] param2, long param3, long param4, long param5, long param6, long param7, int param8, int[] param9, int[] param10, long param11, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 4); memIntBuffer(_a_param10, param10.length).put(param10); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9, (double)_a_param10, (double)param11});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        if (param10 != null) { memIntBuffer(_a_param10, param10.length).get(param10); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, double[] param10, int param11, long param12, long param13, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 8); memDoubleBuffer(_a_param10, param10.length).put(param10); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)_a_param10, (double)param11, (double)param12, (double)param13});
        if (param10 != null) { memDoubleBuffer(_a_param10, param10.length).get(param10); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, float[] param10, int param11, long param12, long param13, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 4); memFloatBuffer(_a_param10, param10.length).put(param10); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)_a_param10, (double)param11, (double)param12, (double)param13});
        if (param10 != null) { memFloatBuffer(_a_param10, param10.length).get(param10); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, int[] param10, int param11, long param12, long param13, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 4); memIntBuffer(_a_param10, param10.length).put(param10); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)_a_param10, (double)param11, (double)param12, (double)param13});
        if (param10 != null) { memIntBuffer(_a_param10, param10.length).get(param10); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, short[] param10, int param11, long param12, long param13, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 2); memShortBuffer(_a_param10, param10.length).put(param10); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJJJJIJJ:I", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)_a_param10, (double)param11, (double)param12, (double)param13});
        if (param10 != null) { memShortBuffer(_a_param10, param10.length).get(param10); }
        return (int)(long)__r;
        }
    }
    public static int callPPPPPPPPPPPPPPPI(long param0, long param1, long[] param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, long param11, int param12, int[] param13, int[] param14, long param15, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param13 = 0L; if (param13 != null) { _a_param13 = __s.nmalloc(8, param13.length * 4); memIntBuffer(_a_param13, param13.length).put(param13); }
        long _a_param14 = 0L; if (param14 != null) { _a_param14 = __s.nmalloc(8, param14.length * 4); memIntBuffer(_a_param14, param14.length).put(param14); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJJJIJJJ:I", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)param11, (double)param12, (double)_a_param13, (double)_a_param14, (double)param15});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param13 != null) { memIntBuffer(_a_param13, param13.length).get(param13); }
        if (param14 != null) { memIntBuffer(_a_param14, param14.length).get(param14); }
        return (int)(long)__r;
        }
    }
    public static long callPP(int[] param0, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        double __r = WebFFI.call(__functionAddress, "J:J", new double[] {(double)_a_param0});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        return (long)__r;
        }
    }
    public static long callPPP(long param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "JJ:J", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return (long)__r;
        }
    }
    public static long callPPP(int param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "IJJ:J", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (long)__r;
        }
    }
    public static long callPPP(long param0, int param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJ:J", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (long)__r;
        }
    }
    public static long callPPP(int param0, int param1, int param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "IIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPPP(long param0, int param1, int param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JIIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPPPP(long param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (long)__r;
        }
    }
    public static long callPPPP(long param0, long[] param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JJJ:J", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (long)__r;
        }
    }
    public static long callPJPP(long param0, long param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (long)__r;
        }
    }
    public static long callPPPP(int param0, long param1, long[] param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "IJJJ:J", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (long)__r;
        }
    }
    public static long callPPPP(long param0, int param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        double __r = WebFFI.call(__functionAddress, "JIJJ:J", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        return (long)__r;
        }
    }
    public static long callPPPP(long param0, long param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (long)__r;
        }
    }
    public static long callPPPP(long param0, long param1, int param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPJPP(long param0, long param1, int param2, int param3, int param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIIIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPJPP(long param0, long param1, long param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (long)__r;
        }
    }
    public static long callPPNPP(long param0, long param1, long param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (long)__r;
        }
    }
    public static long callPPPPP(long param0, long param1, long param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (long)__r;
        }
    }
    public static long callPPPPP(long param0, long param1, long[] param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        double __r = WebFFI.call(__functionAddress, "JJJJ:J", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        return (long)__r;
        }
    }
    public static long callPJPPP(long param0, long param1, int param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPJPPP(long param0, long param1, int[] param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJIJ:J", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)_a_param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPPPPP(long param0, int param1, long param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPPPPP(long param0, long param1, int param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPPPPP(long param0, long param1, long param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJIJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPPPPP(long param0, long[] param1, long param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJIJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)_a_param4});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPJPPP(long param0, long param1, int param2, int param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJIIJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJPPPP(long param0, long param1, long param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPJPPPP(long param0, long param1, long param2, double[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memDoubleBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memDoubleBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPJPPPP(long param0, long param1, long param2, float[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPJPPPP(long param0, long param1, long param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPJPPPP(long param0, long param1, long param2, short[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 2); memShortBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        double __r = WebFFI.call(__functionAddress, "JJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memShortBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        return (long)__r;
        }
    }
    public static long callPPPPPP(long param0, int param1, long param2, long param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JIJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPPPPP(long param0, long param1, long[] param2, long param3, int param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJIJ:J", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)_a_param5});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPPPPP(long param0, int param1, int param2, long param3, int param4, long param5, long param6, int[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JIIJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        return (long)__r;
        }
    }
    public static long callPJJPPPP(long param0, long param1, long param2, long param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJJPPPP(long param0, long param1, long param2, long param3, double[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memDoubleBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memDoubleBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJJPPPP(long param0, long param1, long param2, long param3, float[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJJPPPP(long param0, long param1, long param2, long param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJJPPPP(long param0, long param1, long param2, long param3, short[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 2); memShortBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memShortBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJPPPPP(long param0, long param1, long param2, long param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJPPPPP(long param0, long param1, long param2, long param3, float[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJPPPPP(long param0, long param1, long param2, long param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPJPPPPP(long param0, long param1, long param2, long param3, short[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 2); memShortBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param4 != null) { memShortBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPJPPPP(long param0, long[] param1, long param2, long param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPJPPPP(long param0, long[] param1, long param2, long param3, double[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memDoubleBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param4 != null) { memDoubleBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPJPPPP(long param0, long[] param1, long param2, long param3, float[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPJPPPP(long param0, long[] param1, long param2, long param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPJPPPP(long param0, long[] param1, long param2, long param3, short[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 2); memShortBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param4 != null) { memShortBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPPJPPP(long param0, long param1, long param2, long param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        return (long)__r;
        }
    }
    public static long callPPPPPPP(long param0, int param1, long param2, long param3, long param4, int[] param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JIJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)_a_param6});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (long)__r;
        }
    }
    public static long callPPJPPPPP(long param0, long[] param1, long param2, long param3, long param4, long param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (long)__r;
        }
    }
    public static long callPPJPPPPP(long param0, long[] param1, long param2, long param3, long param4, float[] param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)_a_param6});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (long)__r;
        }
    }
    public static long callPPJPPPPP(long param0, long[] param1, long param2, long param3, long param4, int[] param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)_a_param6});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (long)__r;
        }
    }
    public static long callPPJPPPPP(long param0, long[] param1, long param2, long param3, long param4, short[] param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 2); memShortBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJ:J", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)_a_param6});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param5 != null) { memShortBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        return (long)__r;
        }
    }
    public static long callPPPPPPPP(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long param7, int[] param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        double __r = WebFFI.call(__functionAddress, "JIJJIJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8});
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        return (long)__r;
        }
    }
    public static long callPPPPPPPP(int param0, int[] param1, long[] param2, int param3, int param4, int param5, int param6, long param7, long param8, long param9, int param10, int[] param11, long[] param12, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        long _a_param11 = 0L; if (param11 != null) { _a_param11 = __s.nmalloc(8, param11.length * 4); memIntBuffer(_a_param11, param11.length).put(param11); }
        long _a_param12 = 0L; if (param12 != null) { _a_param12 = __s.nmalloc(8, param12.length * 8); memLongBuffer(_a_param12, param12.length).put(param12); }
        double __r = WebFFI.call(__functionAddress, "IJJIIIIJJJIJJ:J", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)_a_param11, (double)_a_param12});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        if (param11 != null) { memIntBuffer(_a_param11, param11.length).get(param11); }
        if (param12 != null) { memLongBuffer(_a_param12, param12.length).get(param12); }
        return (long)__r;
        }
    }
    public static long callPJPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        return (long)__r;
        }
    }
    public static long callPJPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, float[] param6, int[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memFloatBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6, (double)_a_param7});
        if (param6 != null) { memFloatBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        return (long)__r;
        }
    }
    public static long callPJPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, int[] param6, int[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6, (double)_a_param7});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        return (long)__r;
        }
    }
    public static long callPJPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, short[] param6, int[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 2); memShortBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6, (double)_a_param7});
        if (param6 != null) { memShortBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        return (long)__r;
        }
    }
    public static long callPPJPPPPPP(long param0, long param1, int param2, long param3, long param4, long param5, int param6, long param7, long param8, int[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9});
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (long)__r;
        }
    }
    public static long callPJPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, int[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9});
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (long)__r;
        }
    }
    public static long callPJPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, float[] param8, int[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memFloatBuffer(_a_param8, param8.length).put(param8); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8, (double)_a_param9});
        if (param8 != null) { memFloatBuffer(_a_param8, param8.length).get(param8); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (long)__r;
        }
    }
    public static long callPJPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, int[] param8, int[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8, (double)_a_param9});
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (long)__r;
        }
    }
    public static long callPJPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, short[] param8, int[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 2); memShortBuffer(_a_param8, param8.length).put(param8); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        double __r = WebFFI.call(__functionAddress, "JJJJJJJJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8, (double)_a_param9});
        if (param8 != null) { memShortBuffer(_a_param8, param8.length).get(param8); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        return (long)__r;
        }
    }
    public static long callPPJPPPPPPPP(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, int param8, long param9, long param10, int[] param11, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param11 = 0L; if (param11 != null) { _a_param11 = __s.nmalloc(8, param11.length * 4); memIntBuffer(_a_param11, param11.length).put(param11); }
        double __r = WebFFI.call(__functionAddress, "JJIJJJJJIJJJ:J", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)_a_param11});
        if (param11 != null) { memIntBuffer(_a_param11, param11.length).get(param11); }
        return (long)__r;
        }
    }
    public static void callPV(double[] param0, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 8); memDoubleBuffer(_a_param0, param0.length).put(param0); }
        WebFFI.call(__functionAddress, "J:V", new double[] {(double)_a_param0});
        if (param0 != null) { memDoubleBuffer(_a_param0, param0.length).get(param0); }
        }
    }
    public static void callPV(float[] param0, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memFloatBuffer(_a_param0, param0.length).put(param0); }
        WebFFI.call(__functionAddress, "J:V", new double[] {(double)_a_param0});
        if (param0 != null) { memFloatBuffer(_a_param0, param0.length).get(param0); }
        }
    }
    public static void callPV(int[] param0, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        WebFFI.call(__functionAddress, "J:V", new double[] {(double)_a_param0});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        }
    }
    public static void callPV(short[] param0, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 2); memShortBuffer(_a_param0, param0.length).put(param0); }
        WebFFI.call(__functionAddress, "J:V", new double[] {(double)_a_param0});
        if (param0 != null) { memShortBuffer(_a_param0, param0.length).get(param0); }
        }
    }
    public static void callPV(int param0, double[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memDoubleBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memDoubleBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPV(int param0, float[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPV(int param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPV(int param0, long[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPV(int param0, short[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPV(int param0, int param1, double[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPV(int param0, int param1, float[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPV(int param0, int param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPV(int param0, int param1, long[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPV(int param0, int param1, short[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 2); memShortBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memShortBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPV(int param0, int[] param1, int param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJI:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPV(int param0, int param1, int param2, double[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memDoubleBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memDoubleBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, int param2, float[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, int param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, int param2, short[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 2); memShortBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memShortBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, boolean param2, double[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memDoubleBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIZJ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)_a_param3});
        if (param3 != null) { memDoubleBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, boolean param2, float[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIZJ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)_a_param3});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, boolean param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIZJ:V", new double[] {(double)param0, (double)param1, (double)(param2 ? 1.0 : 0.0), (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, int[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJI:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPV(int param0, int[] param1, int param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJII:V", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, double[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memDoubleBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memDoubleBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, float[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, short[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 2); memShortBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memShortBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, int param1, int param2, boolean param3, double[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memDoubleBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIZJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)_a_param4});
        if (param4 != null) { memDoubleBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, int param1, int param2, boolean param3, float[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIZJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)_a_param4});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int[] param3, boolean param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)(param4 ? 1.0 : 0.0)});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPV(int param0, int param1, int[] param2, int param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJII:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPV(int param0, boolean param1, int param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IZIIJ:V", new double[] {(double)param0, (double)(param1 ? 1.0 : 0.0), (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, double param1, double param2, int param3, int param4, double[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memDoubleBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IDDIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memDoubleBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, float param1, float param2, int param3, int param4, float[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IFFIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, double[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memDoubleBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memDoubleBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, float[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, short[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 2); memShortBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memShortBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int[] param4, boolean param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIIJZ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)(param5 ? 1.0 : 0.0)});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPV(int param0, int param1, int param2, boolean param3, int param4, float[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIZIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4, (double)_a_param5});
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, int param1, int param2, boolean param3, int param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIZIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, int param1, int param2, boolean param3, int param4, short[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 2); memShortBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIZIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)(param3 ? 1.0 : 0.0), (double)param4, (double)_a_param5});
        if (param5 != null) { memShortBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, double[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 8); memDoubleBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memDoubleBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, float[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memFloatBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memFloatBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, short[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 2); memShortBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memShortBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPV(int param0, int param1, int[] param2, int param3, int param4, int param5, int param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJIIII:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, double[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 8); memDoubleBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memDoubleBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, float[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memFloatBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memFloatBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, short[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 2); memShortBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memShortBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, double[] param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 8); memDoubleBuffer(_a_param8, param8.length).put(param8); }
        WebFFI.call(__functionAddress, "IIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8});
        if (param8 != null) { memDoubleBuffer(_a_param8, param8.length).get(param8); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, float[] param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memFloatBuffer(_a_param8, param8.length).put(param8); }
        WebFFI.call(__functionAddress, "IIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8});
        if (param8 != null) { memFloatBuffer(_a_param8, param8.length).get(param8); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int[] param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        WebFFI.call(__functionAddress, "IIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8});
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, short[] param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 2); memShortBuffer(_a_param8, param8.length).put(param8); }
        WebFFI.call(__functionAddress, "IIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8});
        if (param8 != null) { memShortBuffer(_a_param8, param8.length).get(param8); }
        }
    }
    public static void callPV(int param0, double param1, double param2, int param3, int param4, double param5, double param6, int param7, int param8, double[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 8); memDoubleBuffer(_a_param9, param9.length).put(param9); }
        WebFFI.call(__functionAddress, "IDDIIDDIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9});
        if (param9 != null) { memDoubleBuffer(_a_param9, param9.length).get(param9); }
        }
    }
    public static void callPV(int param0, float param1, float param2, int param3, int param4, float param5, float param6, int param7, int param8, float[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memFloatBuffer(_a_param9, param9.length).put(param9); }
        WebFFI.call(__functionAddress, "IFFIIFFIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9});
        if (param9 != null) { memFloatBuffer(_a_param9, param9.length).get(param9); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, double[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 8); memDoubleBuffer(_a_param9, param9.length).put(param9); }
        WebFFI.call(__functionAddress, "IIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9});
        if (param9 != null) { memDoubleBuffer(_a_param9, param9.length).get(param9); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, float[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memFloatBuffer(_a_param9, param9.length).put(param9); }
        WebFFI.call(__functionAddress, "IIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9});
        if (param9 != null) { memFloatBuffer(_a_param9, param9.length).get(param9); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        WebFFI.call(__functionAddress, "IIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9});
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, short[] param9, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 2); memShortBuffer(_a_param9, param9.length).put(param9); }
        WebFFI.call(__functionAddress, "IIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)_a_param9});
        if (param9 != null) { memShortBuffer(_a_param9, param9.length).get(param9); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, double[] param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 8); memDoubleBuffer(_a_param10, param10.length).put(param10); }
        WebFFI.call(__functionAddress, "IIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)_a_param10});
        if (param10 != null) { memDoubleBuffer(_a_param10, param10.length).get(param10); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, float[] param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 4); memFloatBuffer(_a_param10, param10.length).put(param10); }
        WebFFI.call(__functionAddress, "IIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)_a_param10});
        if (param10 != null) { memFloatBuffer(_a_param10, param10.length).get(param10); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int[] param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 4); memIntBuffer(_a_param10, param10.length).put(param10); }
        WebFFI.call(__functionAddress, "IIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)_a_param10});
        if (param10 != null) { memIntBuffer(_a_param10, param10.length).get(param10); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, short[] param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 2); memShortBuffer(_a_param10, param10.length).put(param10); }
        WebFFI.call(__functionAddress, "IIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)_a_param10});
        if (param10 != null) { memShortBuffer(_a_param10, param10.length).get(param10); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, double[] param11, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param11 = 0L; if (param11 != null) { _a_param11 = __s.nmalloc(8, param11.length * 8); memDoubleBuffer(_a_param11, param11.length).put(param11); }
        WebFFI.call(__functionAddress, "IIIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)_a_param11});
        if (param11 != null) { memDoubleBuffer(_a_param11, param11.length).get(param11); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, float[] param11, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param11 = 0L; if (param11 != null) { _a_param11 = __s.nmalloc(8, param11.length * 4); memFloatBuffer(_a_param11, param11.length).put(param11); }
        WebFFI.call(__functionAddress, "IIIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)_a_param11});
        if (param11 != null) { memFloatBuffer(_a_param11, param11.length).get(param11); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int[] param11, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param11 = 0L; if (param11 != null) { _a_param11 = __s.nmalloc(8, param11.length * 4); memIntBuffer(_a_param11, param11.length).put(param11); }
        WebFFI.call(__functionAddress, "IIIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)_a_param11});
        if (param11 != null) { memIntBuffer(_a_param11, param11.length).get(param11); }
        }
    }
    public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, short[] param11, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param11 = 0L; if (param11 != null) { _a_param11 = __s.nmalloc(8, param11.length * 2); memShortBuffer(_a_param11, param11.length).put(param11); }
        WebFFI.call(__functionAddress, "IIIIIIIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10, (double)_a_param11});
        if (param11 != null) { memShortBuffer(_a_param11, param11.length).get(param11); }
        }
    }
    public static void callPPV(long param0, float[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPPV(long param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)param0, (double)_a_param1});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPPV(double[] param0, double[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 8); memDoubleBuffer(_a_param0, param0.length).put(param0); }
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memDoubleBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)_a_param0, (double)_a_param1});
        if (param0 != null) { memDoubleBuffer(_a_param0, param0.length).get(param0); }
        if (param1 != null) { memDoubleBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPPV(float[] param0, float[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memFloatBuffer(_a_param0, param0.length).put(param0); }
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memFloatBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)_a_param0, (double)_a_param1});
        if (param0 != null) { memFloatBuffer(_a_param0, param0.length).get(param0); }
        if (param1 != null) { memFloatBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPPV(int[] param0, int[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)_a_param0, (double)_a_param1});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPPV(short[] param0, short[] param1, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 2); memShortBuffer(_a_param0, param0.length).put(param0); }
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 2); memShortBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJ:V", new double[] {(double)_a_param0, (double)_a_param1});
        if (param0 != null) { memShortBuffer(_a_param0, param0.length).get(param0); }
        if (param1 != null) { memShortBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPPV(int param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, int[] param1, float[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, int[] param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, int[] param1, long[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(long param0, int param1, float[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(long param0, int param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int[] param0, int param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 4); memIntBuffer(_a_param0, param0.length).put(param0); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJ:V", new double[] {(double)_a_param0, (double)param1, (double)_a_param2});
        if (param0 != null) { memIntBuffer(_a_param0, param0.length).get(param0); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, int param1, long param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, int param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, int param1, int[] param2, float[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, int param1, int[] param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, int param1, int[] param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, long param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, long param1, double[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memDoubleBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memDoubleBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, long param1, float[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memFloatBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memFloatBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, long param1, int[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, long param1, long[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, long param1, short[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 2); memShortBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memShortBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, int[] param1, int[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)param3});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, long[] param1, int[] param2, int param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 8); memLongBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IJJI:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)param3});
        if (param1 != null) { memLongBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(long param0, int param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, int param1, int param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPV(int param0, int param1, int param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, int param1, int param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPV(int param0, int param1, long param2, int[] param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, int param1, int[] param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)_a_param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPV(int param0, int[] param1, int param2, long param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJIJI:V", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPPV(int param0, int[] param1, int param2, int[] param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJIJI:V", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)_a_param3, (double)param4});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPV(int param0, int[] param1, long param2, int param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "IJJII:V", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPPV(long param0, int param1, int param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPV(int param0, int param1, int param2, int param3, int[] param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)param5});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, float[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, short[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 2); memShortBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memShortBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPPV(int param0, int param1, int[] param2, long param3, int param4, int param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "IIJJII:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPV(int param0, int param1, int param2, long param3, int param4, int param5, float[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memFloatBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memFloatBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, float[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memFloatBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memFloatBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPV(int param0, int param1, int param2, int param3, long param4, int param5, int param6, float[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memFloatBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIIIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memFloatBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPPV(int param0, int param1, int param2, int param3, long param4, int param5, int param6, short[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 2); memShortBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIIIJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memShortBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, float[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memFloatBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIJIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)_a_param7});
        if (param7 != null) { memFloatBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPPV(int param0, int param1, int param2, long param3, int param4, float param5, float param6, int param7, float[] param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memFloatBuffer(_a_param8, param8.length).put(param8); }
        WebFFI.call(__functionAddress, "IIIJIFFIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8});
        if (param8 != null) { memFloatBuffer(_a_param8, param8.length).get(param8); }
        }
    }
    public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, int param7, float[] param8, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memFloatBuffer(_a_param8, param8.length).put(param8); }
        WebFFI.call(__functionAddress, "IIJIIIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)_a_param8});
        if (param8 != null) { memFloatBuffer(_a_param8, param8.length).get(param8); }
        }
    }
    public static void callPJPV(long param0, long param1, long[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPPV(long param0, long param1, int[] param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPPV(long param0, int[] param1, long param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        WebFFI.call(__functionAddress, "JJJ:V", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        }
    }
    public static void callPJPV(long param0, long param1, int param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, long param1, long param2, double[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memDoubleBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memDoubleBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, long param1, long param2, float[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memFloatBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memFloatBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, long param1, long param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, long param1, long param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, long param1, long param2, short[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 2); memShortBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memShortBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(long param0, int param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPPV(long param0, int param1, int[] param2, long[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(long param0, int param1, long[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPPV(long param0, long param1, int param2, int[] param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, double[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memDoubleBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memDoubleBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, float[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, short[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 2); memShortBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memShortBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPV(int param0, int param1, int[] param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)_a_param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPV(int param0, int param1, int[] param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)param4});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, long param1, int param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, long param1, int param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPV(int param0, int[] param1, int[] param2, int param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IJJIJ:V", new double[] {(double)param0, (double)_a_param1, (double)_a_param2, (double)param3, (double)_a_param4});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPV(long param0, int param1, int param2, int[] param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPV(long param0, int param1, int param2, long[] param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPJPV(long param0, long param1, int param2, int param3, int param4, double[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memDoubleBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memDoubleBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPJPV(long param0, long param1, int param2, int param3, int param4, float[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPJPV(long param0, long param1, int param2, int param3, int param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPJPV(long param0, long param1, int param2, int param3, int param4, long[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memLongBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memLongBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPJPV(long param0, long param1, int param2, int param3, int param4, short[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 2); memShortBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param5 != null) { memShortBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPPJV(long param0, int param1, long[] param2, int param3, long param4, int param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJIJI:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPPV(int param0, int param1, int param2, int[] param3, long param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "IIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4, (double)param5});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPV(int param0, int param1, int param2, int[] param3, long param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4, (double)_a_param5});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPPPV(int param0, int param1, int[] param2, int param3, int[] param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIJIJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)_a_param4, (double)_a_param5});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPPPV(int param0, int[] param1, int param2, long param3, int param4, int[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IJIJIJ:V", new double[] {(double)param0, (double)_a_param1, (double)param2, (double)param3, (double)param4, (double)_a_param5});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, int param4, int param5, float[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memFloatBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIJJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memFloatBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, int param4, int param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIJJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPPV(int param0, int param1, long param2, long param3, int param4, int param5, short[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 2); memShortBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIJJIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memShortBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPPV(long param0, int param1, long param2, int param3, int param4, int param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "JIJIIIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPPV(int param0, int param1, int param2, int param3, int[] param4, int param5, int[] param6, float[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memFloatBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIIIJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)param5, (double)_a_param6, (double)_a_param7});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memFloatBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPPPV(int param0, int param1, int param2, int param3, int[] param4, int param5, int[] param6, int[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "IIIIJIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)param5, (double)_a_param6, (double)_a_param7});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPPPV(long param0, int param1, int param2, int param3, int param4, int param5, int[] param6, long param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "JIIIIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6, (double)param7});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPJPPV(long param0, long param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPPPV(long param0, long param1, int[] param2, long param3, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JJJJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPJJPV(long param0, int param1, long param2, long param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPPV(long param0, int param1, long param2, int[] param3, long param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)param4});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPPV(long[] param0, int[] param1, int[] param2, int[] param3, int param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param0 = 0L; if (param0 != null) { _a_param0 = __s.nmalloc(8, param0.length * 8); memLongBuffer(_a_param0, param0.length).put(param0); }
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        WebFFI.call(__functionAddress, "JJJJI:V", new double[] {(double)_a_param0, (double)_a_param1, (double)_a_param2, (double)_a_param3, (double)param4});
        if (param0 != null) { memLongBuffer(_a_param0, param0.length).get(param0); }
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        }
    }
    public static void callPPPPV(int param0, long param1, int[] param2, int[] param3, int[] param4, int param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 4); memIntBuffer(_a_param2, param2.length).put(param2); }
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "IJJJJI:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)_a_param3, (double)_a_param4, (double)param5});
        if (param2 != null) { memIntBuffer(_a_param2, param2.length).get(param2); }
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPPV(long param0, int param1, int param2, long[] param3, long[] param4, long[] param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memLongBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "JIIJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memLongBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPJPPV(long param0, int param1, long param2, int param3, int param4, int[] param5, long[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 8); memLongBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "JIJIIJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)_a_param6});
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memLongBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPPPV(int param0, int param1, int param2, int[] param3, int[] param4, int[] param5, long param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5, (double)param6});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPPPPV(int param0, int param1, long param2, int[] param3, int[] param4, int[] param5, int param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        WebFFI.call(__functionAddress, "IIJJJJI:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5, (double)param6});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        }
    }
    public static void callPJPPV(long param0, int param1, long param2, int param3, int param4, long[] param5, int param6, int[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memLongBuffer(_a_param5, param5.length).put(param5); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        WebFFI.call(__functionAddress, "JIJIIJIJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)_a_param5, (double)param6, (double)_a_param7});
        if (param5 != null) { memLongBuffer(_a_param5, param5.length).get(param5); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        }
    }
    public static void callPJJJPV(long param0, long param1, long param2, long param3, double[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memDoubleBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memDoubleBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPJJJPV(long param0, long param1, long param2, long param3, float[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPJJJPV(long param0, long param1, long param2, long param3, int[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPJJJPV(long param0, long param1, long param2, long param3, long[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPJJJPV(long param0, long param1, long param2, long param3, short[] param4, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 2); memShortBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4});
        if (param4 != null) { memShortBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPPPV(long param0, int param1, long param2, long[] param3, int[] param4, long param5, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        WebFFI.call(__functionAddress, "JIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)param5});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        }
    }
    public static void callPPPPPV(int param0, int param1, long param2, int[] param3, int[] param4, int[] param5, int[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 4); memIntBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memIntBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memIntBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "IIJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5, (double)_a_param6});
        if (param3 != null) { memIntBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memIntBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memIntBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPPPPV(long param0, int param1, int param2, long[] param3, long[] param4, long[] param5, long[] param6, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param3 = 0L; if (param3 != null) { _a_param3 = __s.nmalloc(8, param3.length * 8); memLongBuffer(_a_param3, param3.length).put(param3); }
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 8); memLongBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 8); memLongBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 8); memLongBuffer(_a_param6, param6.length).put(param6); }
        WebFFI.call(__functionAddress, "JIIJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)_a_param3, (double)_a_param4, (double)_a_param5, (double)_a_param6});
        if (param3 != null) { memLongBuffer(_a_param3, param3.length).get(param3); }
        if (param4 != null) { memLongBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memLongBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memLongBuffer(_a_param6, param6.length).get(param6); }
        }
    }
    public static void callPPPPPV(long param0, int param1, long[] param2, int param3, int param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param2 = 0L; if (param2 != null) { _a_param2 = __s.nmalloc(8, param2.length * 8); memLongBuffer(_a_param2, param2.length).put(param2); }
        WebFFI.call(__functionAddress, "JIJIIIJIJIJ:V", new double[] {(double)param0, (double)param1, (double)_a_param2, (double)param3, (double)param4, (double)param5, (double)param6, (double)param7, (double)param8, (double)param9, (double)param10});
        if (param2 != null) { memLongBuffer(_a_param2, param2.length).get(param2); }
        }
    }
    public static void callPPPPPPPV(int param0, int param1, int param2, long param3, int param4, long param5, int[] param6, int[] param7, int[] param8, int[] param9, long[] param10, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memIntBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memIntBuffer(_a_param7, param7.length).put(param7); }
        long _a_param8 = 0L; if (param8 != null) { _a_param8 = __s.nmalloc(8, param8.length * 4); memIntBuffer(_a_param8, param8.length).put(param8); }
        long _a_param9 = 0L; if (param9 != null) { _a_param9 = __s.nmalloc(8, param9.length * 4); memIntBuffer(_a_param9, param9.length).put(param9); }
        long _a_param10 = 0L; if (param10 != null) { _a_param10 = __s.nmalloc(8, param10.length * 8); memLongBuffer(_a_param10, param10.length).put(param10); }
        WebFFI.call(__functionAddress, "IIIJIJJJJJJ:V", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)param4, (double)param5, (double)_a_param6, (double)_a_param7, (double)_a_param8, (double)_a_param9, (double)_a_param10});
        if (param6 != null) { memIntBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memIntBuffer(_a_param7, param7.length).get(param7); }
        if (param8 != null) { memIntBuffer(_a_param8, param8.length).get(param8); }
        if (param9 != null) { memIntBuffer(_a_param9, param9.length).get(param9); }
        if (param10 != null) { memLongBuffer(_a_param10, param10.length).get(param10); }
        }
    }
    public static boolean callPPZ(int param0, int[] param1, long param2, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param1 = 0L; if (param1 != null) { _a_param1 = __s.nmalloc(8, param1.length * 4); memIntBuffer(_a_param1, param1.length).put(param1); }
        double __r = WebFFI.call(__functionAddress, "IJJ:Z", new double[] {(double)param0, (double)_a_param1, (double)param2});
        if (param1 != null) { memIntBuffer(_a_param1, param1.length).get(param1); }
        return __r != 0.0;
        }
    }
    public static boolean callPPPPZ(int param0, int param1, int param2, float param3, float[] param4, float[] param5, float[] param6, float[] param7, long __functionAddress) {
        try (MemoryStack __s = MemoryStack.stackPush()) {
        long _a_param4 = 0L; if (param4 != null) { _a_param4 = __s.nmalloc(8, param4.length * 4); memFloatBuffer(_a_param4, param4.length).put(param4); }
        long _a_param5 = 0L; if (param5 != null) { _a_param5 = __s.nmalloc(8, param5.length * 4); memFloatBuffer(_a_param5, param5.length).put(param5); }
        long _a_param6 = 0L; if (param6 != null) { _a_param6 = __s.nmalloc(8, param6.length * 4); memFloatBuffer(_a_param6, param6.length).put(param6); }
        long _a_param7 = 0L; if (param7 != null) { _a_param7 = __s.nmalloc(8, param7.length * 4); memFloatBuffer(_a_param7, param7.length).put(param7); }
        double __r = WebFFI.call(__functionAddress, "IIIFJJJJ:Z", new double[] {(double)param0, (double)param1, (double)param2, (double)param3, (double)_a_param4, (double)_a_param5, (double)_a_param6, (double)_a_param7});
        if (param4 != null) { memFloatBuffer(_a_param4, param4.length).get(param4); }
        if (param5 != null) { memFloatBuffer(_a_param5, param5.length).get(param5); }
        if (param6 != null) { memFloatBuffer(_a_param6, param6.length).get(param6); }
        if (param7 != null) { memFloatBuffer(_a_param7, param7.length).get(param7); }
        return __r != 0.0;
        }
    }
}
