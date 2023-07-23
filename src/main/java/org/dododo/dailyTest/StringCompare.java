package org.dododo.dailyTest;

public class StringCompare {
    private String str;
    private StringBuilder strBuilder;
    private StringBuffer strBuffer;

    /*
    String，少量字符串操作的情况
    StringBuffer，多线程中字符串缓冲区进行大量操作的情况
    StringBuild，单线程中字符串缓冲区进行大量操作的情况
     */
    public void UsageTest() {
        str = "StringTest";
        str = str.intern();

        String str1 = str + 1;
        String str2 = "StringTest1";
        System.out.println(str1.equals(str2));

        // StringBuilder
        strBuilder = new StringBuilder();
        strBuilder.append(str);
        System.out.println(strBuilder);

        // StringBuffer
        strBuffer = new StringBuffer();
        strBuffer.append(str);
        System.out.println(strBuffer);
    }
}
