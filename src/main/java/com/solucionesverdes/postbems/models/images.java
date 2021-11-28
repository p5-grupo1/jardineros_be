package com.solucionesverdes.postbems.models;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class images {
    @Id
    private String id;
    private String name; // file name
    private Date createdtime; // upload time
    private Binary content; // file content
    private String contenttype; // file type
    private Long size; // file size
    // getter/setter
}