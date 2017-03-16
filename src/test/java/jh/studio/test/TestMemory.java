package jh.studio.test;

public class TestMemory {
    public static void main(String[] args) {

       System. out .println( " 内存信息 :" + toMemoryInfo ());

    }

    public static String toMemoryInfo() {

       Runtime currRuntime = Runtime.getRuntime ();

       int nFreeMemory = ( int ) (currRuntime.freeMemory() / 1024 / 
1024);

       int nTotalMemory = ( int ) (currRuntime.totalMemory() / 1024 / 
1024);

       return nFreeMemory + "M/" + nTotalMemory + "M(free/total)" ;
    
}
}