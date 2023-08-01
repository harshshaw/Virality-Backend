package com.Virality.Application.Utility;

public interface StorageService {

    //saves the file in remote repo and returns url
    public String save(byte[] file);

    //fetches the file and puts it in server local storage for processing
    public byte[] get(String url);

    //deletes the file from remote
    public void delete(String url);

}
