//package com.poi.org.work2html;// 引入poi相关的包
//
//import org.apache.poi.hwpf.HWPFDocumentCore;
//import org.apache.poi.hwpf.converter.WordToHtmlConverter;
//import org.apache.poi.hwpf.converter.WordToHtmlUtils;
//import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.w3c.dom.Document;
//import java.io.ByteArrayOutputStream;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.stream.StreamResult;
//
//// 定义RBQWordManager类
//// 定义RBQWordManager类
//public class RBQWordManager {
//
//    // 定义一个方法，将word文件转为html文件，并返回html文件的路径
//    public String wordToHtml(String wordFilePath, String htmlFilePath) {
//        try {
//            // 加载word文件
//            XWPFDocument wordDocument = new XWPFDocument(new FileInputStream(wordFilePath));
//
//            // 创建一个XWPFWordExtractor对象
//            XWPFWordExtractor wordExtractor = new XWPFWordExtractor(wordDocument);
//
//            // 获取word文档的内容
//            String wordContent = wordExtractor.getText();
//
//            // 创建一个文档构建器工厂
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//
//            // 创建一个文档构建器
//            DocumentBuilder db = dbf.newDocumentBuilder();
//
//            // 将wordContent转换为一个Document对象
//            Document doc = db.parse(new InputSource(new StringReader(wordContent)));
//
//            // 创建一个输出流
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//            // 创建一个DOM源，传入Document对象
//            DOMSource domSource = new DOMSource(doc);
//
//            // 创建一个流结果
//            StreamResult streamResult = new StreamResult(out);
//
//            // 创建一个转换器
//            TransformerFactory tf = TransformerFactory.newInstance();
//            Transformer serializer = tf.newTransformer();
//
//            // 设置转换器的属性
//            serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//            serializer.setOutputProperty(OutputKeys.METHOD, "html");
//
//            // 转换文档
//            serializer.transform(domSource, streamResult);
//
//            // 关闭输出流
//            out.close();
//
//            // 获取html字符串
//            String htmlString = new String(out.toByteArray());
//
//            // 创建一个文件输出流
//            FileOutputStream fos = new FileOutputStream(htmlFilePath);
//
//            // 将html字符串写入文件
//            fos.write(htmlString.getBytes());
//
//            // 关闭文件输出流
//            fos.close();
//
//            // 返回html文件的路径
//            return htmlFilePath;
//        } catch (Exception e) {
//            // 处理异常
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
//
