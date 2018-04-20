package com.example.it.hdt;

import android.media.Image;

/**
 * Created by DELL on 4/20/2018.
 */

public class RowItem {
    private String proName;
    private int pic_id;
    private String status;
    private String contact;

    public RowItem(String proName, int pic_id, String status, String contact) {
        this.proName = proName;
        this.pic_id = pic_id;
        this.status = status;
        this.contact = contact;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getProName() {
        return proName;
    }

    public int getPic_id() {
        return pic_id;
    }

    public String getStatus() {
        return status;
    }

    public String getContact() {
        return contact;
    }
}
