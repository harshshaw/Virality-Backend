package com.Virality.Application.Utility;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class LocalStorageService implements StorageService{
    public String getTempDir() {
        return tempDir;
    }

    public void setTempDir(String tempDir) {
        this.tempDir = tempDir;
    }

    public Map<String, byte[]> getLocalStorage() {
        return localStorage;
    }

    public void setLocalStorage(Map<String, byte[]> localStorage) {
        this.localStorage = localStorage;
    }

    String tempDir = System.getProperty("java.io.tmpdir");
    Map<String,byte[]> localStorage=new HashMap<>();

    @Override
    public String save(byte[] file) {
        String path=generatePath();
        localStorage.put(path,file);
        return path;
    }

    @Override
    public byte[] get(String url) {
    return localStorage.get(url);
    }

    @Override
    public void delete(String url) {
    localStorage.remove(url);
    }

    public String generatePath(){
        return UUID.randomUUID().toString();
    }
}
