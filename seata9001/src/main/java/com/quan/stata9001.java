package com.quan;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/4
 */
public class stata9001 {

    public static void main(String[] args) throws Exception {
        PdfReader reader = new PdfReader("d:\\xiexinquan2.pdf"); // 读取源文件
        Document document = new Document(); // 建立文档
        /*
        切勿将源文件和输出文件使用一个路径，否则会出现异常：
        Exception in thread "main" java.io.FileNotFoundException: d:\1.pdf
        (请求的操作无法在使用用户映射区域打开的文件上执行。)
        */
        PdfCopy p = new PdfSmartCopy(document,new FileOutputStream("d:\\xiexinquan3.pdf")); // 生成的目标PDF文件
        document.open();
        int n = reader.getNumberOfPages(); // 获取源文件的页数
        PdfDictionary pd;
        for(int j=1;j<=n;j++){
            pd = reader.getPageN(j);
            pd.put(PdfName.ROTATE, new PdfNumber(90)); // 顺时针旋转90°
        }
        for (int page = 0; page < n; ) {
            p.addPage(p.getImportedPage(reader, ++page));
        }
        document.close();
    }
}
