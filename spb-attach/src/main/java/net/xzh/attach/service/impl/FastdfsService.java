package net.xzh.attach.service.impl;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.xzh.attach.common.model.ObjectInfo;
import net.xzh.attach.common.properties.FileServerProperties;
import net.xzh.attach.common.template.FdfsTemplate;

/**
 * 
 * @author xzh
 */
@Service
@ConditionalOnProperty(prefix = net.xzh.attach.common.properties.FileServerProperties.PREFIX, name = "type", havingValue = FileServerProperties.TYPE_FDFS)
public class FastdfsService extends AbstractIFileService {
    @Resource
    private FdfsTemplate fdfsTemplate;

    @Override
    protected String fileType() {
        return FileServerProperties.TYPE_FDFS;
    }

    @Override
    protected ObjectInfo uploadFile(MultipartFile file) {
        return fdfsTemplate.upload(file);
    }

    @Override
    protected void deleteFile(String objectPath) {
        fdfsTemplate.delete(objectPath);
    }

}
