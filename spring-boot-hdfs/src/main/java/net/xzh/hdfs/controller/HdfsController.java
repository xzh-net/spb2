package net.xzh.hdfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.xzh.hdfs.config.HadoopTemplate;


@RestController
public class HdfsController {

    @Autowired
    private HadoopTemplate hadoopTemplate;

    /**
     * 将本地文件srcFile,上传到hdfs
     * @param srcFile
     * @return
     */
    @PostMapping("/upload")
    public String upload(String srcFile){
        hadoopTemplate.uploadFile(srcFile);
        return "copy";
    }

    @DeleteMapping("/delFile")
    public String del(@RequestParam String fileName){
        hadoopTemplate.delFile(fileName);
        return "delFile";
    }

    @GetMapping("/download")
    public String download(@RequestParam String fileName,@RequestParam String savePath){
        hadoopTemplate.download(fileName,savePath);
        return "download";
    }
}