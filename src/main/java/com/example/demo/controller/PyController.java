package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

@CrossOrigin
@RestController
public class PyController {
    public static void main(String[] args) throws IOException {
        String content="我是中国人 1";
        String gbk = new String(content.getBytes(),"GBK");
        System.out.println(gbk);
        //有则添加，无则新建.txt文件
        File file = new File("hello2.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        Writer w = new OutputStreamWriter(fos, "GBK");
        w.write("我是中国人1");
        w.flush();
        w.close();

    }

    @RequestMapping("/py/textUpload")
    public String returnObj(@RequestParam(value = "content") String content, @RequestParam(value = "code") String code, @RequestParam(value = "program") String program) {
        String filename = "/app/weblogic/response/wzys/02=应缴资金查询GBK响应.txt";
        System.out.println("program :" + program + " ,code " + code + ", content :" + content);
        try {
//            File f = new File(filename);
//            if (!f.exists()) {
//                f.createNewFile();
//            }
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file,false);
            Writer w = new OutputStreamWriter(fos, "GBK");
            w.write(content);

            w.flush();
            w.close();



            return "0000";
        } catch (Exception e) {
            e.printStackTrace();
            return "9999";
        }
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath))) {
//            bufferedWriter.write(textString);
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//
//        }

//        return "0000";
    }

    @RequestMapping("/py/textReader")
    public String returnReaderObj(@RequestParam(value = "content") String content, @RequestParam(value = "code") String code, @RequestParam(value = "program") String program) {
        String filename = "/app/weblogic/response/wzys/02=应缴资金查询GBK响应.txt";
        System.out.println("program :" + program + " ,code " + code + ", content :" + content);

        File file = new File(filename);
        if (null == file || 0 == file.length() || !file.exists()) {
            System.out.println("文件为空！");
            return "文件不存在或内容为空" + filename;
        }
        StringBuffer buffer = new StringBuffer();
        String line = null;
        try{
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filename),"GBK");
            BufferedReader reader = new BufferedReader(isr);
            while((line=reader.readLine())!=null){
                buffer.append(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = null;
        message = buffer.toString();
        System.out.println("文件内容：" + message);
        System.out.println("\n");
        return  message;
    }

//    @RequestMapping("/py/textUpload")
//    public String returnObj(@RequestParam(value = "content") String content, @RequestParam(value = "code") String code, @RequestParam(value = "program") String program) {
//        String filename = "/app/weblogic/response/wzys/02=应缴资金查询GBK响应.txt";
//        System.out.println("program :" + program + " ,code " + code + ", content :" + content);
//        try {
//            File f = new File(filename);
//            if (!f.exists()) {
//                f.createNewFile();
//            }
//            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f));
//            BufferedWriter writer = new BufferedWriter(write);
////            writer.write("123中");
//            System.out.println(content);
//            writer.write(content);
//            writer.flush();
//            write.close();
//            writer.close();
//            return "0000";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "9999";
//        }
//
//
//    }



//    @RequestMapping("/py/textReader")
//    public String returnReaderObj(@RequestParam(value = "content") String content, @RequestParam(value = "code") String code, @RequestParam(value = "program") String program) {
//        String filename = "/app/weblogic/response/wzys/02=应缴资金查询GBK响应.txt";
//        System.out.println("program :" + program + " ,code " + code + ", content :" + content);
//
//        // read file content from file
//        StringBuffer sb = new StringBuffer("");
//        sb.append("");
//        File file = new File(filename);
//        if (null == file || 0 == file.length() || !file.exists()) {
//            System.out.println("文件为空！");
//            return "文件不存在或内容为空";
//        }
//
//        FileReader reader = null;
//        try {
//            reader = new FileReader(filename);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        BufferedReader br = new BufferedReader(reader);
//        String str = null;
//
//        while (true) {
//            try {
//                if (!((str = br.readLine()) != null)) break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            sb.append(str + "\n");
//
//            System.out.println("文档内容：" + str);
//        }
//
//        try {
//            br.close();
//            reader.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return  sb.toString();
//    }

}
