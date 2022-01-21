package com.sarathe.expense.models;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public class WithMetaData {


    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "by",column = @Column(name = "created_by",insertable = false,updatable = false)),
            @AttributeOverride(name = "ts",column = @Column(name = "created_ts",insertable = false,updatable = false)),
    })
    private Metadata created;


    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "by",column = @Column(name = "last_upd_by",insertable = false,updatable = false)),
            @AttributeOverride(name = "ts",column = @Column(name = "last_upd_ts",insertable = false,updatable = false)),
    })
    private Metadata lastUpdated;

}
