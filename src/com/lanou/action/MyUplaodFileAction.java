package com.lanou.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

/**
 * Created by dllo on 17/10/13.
 */
public class MyUplaodFileAction extends ActionSupport {
    private File photo; //表单提交过来的文件,名字与jsp页面的name同名
    private String photoFileName;  //提交的文件对应的文件名,例如:test.png
    private String photoContentType;//体检的文件对应的格式 ,例如:png
    /**
     * 单文件上传
     **/
    public String singleUpload(){
        /*获取当前项目下的files路径*/
        String path = ServletActionContext.getServletContext().getRealPath("files");
        System.out.println("文件路径:" + path);
        File desDirectoyr = new File(path);
        /*如果目的文件目录不存在,则需要创建一个该目录*/
        if (!desDirectoyr.exists()||!desDirectoyr.isDirectory()){
            desDirectoyr.mkdir();
        }
        //构建一个空的文件对象,用于存储上传的文件
        File file = new File(desDirectoyr,photoFileName);
        try {
            FileUtils.copyFile(photo,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }
}
