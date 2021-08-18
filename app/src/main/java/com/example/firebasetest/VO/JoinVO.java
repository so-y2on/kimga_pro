package com.example.firebasetest.VO;

public class JoinVO {

    String pat_id;
    String pat_pw;
    String pat_name;
    String birth;
    String pat_tel;
    String key_num;
    String pro_num;

    public JoinVO(){

    }

    public JoinVO(String pat_id, String pat_pw, String pat_name, String birth, String pat_tel, String key_num, String pro_num) {
        this.pat_id = pat_id;
        this.pat_pw = pat_pw;
        this.pat_name = pat_name;
        this.birth = birth;
        this.pat_tel = pat_tel;
        this.key_num = key_num;
        this.pro_num = pro_num;
    }



    public String getPat_id() {
        return pat_id;
    }

    public void setPat_id(String pat_id) {
        this.pat_id = pat_id;
    }

    public String getPat_pw() {
        return pat_pw;
    }

    public void setPat_pw(String pat_pw) {
        this.pat_pw = pat_pw;
    }

    public String getPat_name() {
        return pat_name;
    }

    public void setPat_name(String pat_name) {
        this.pat_name = pat_name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPat_tel() {
        return pat_tel;
    }

    public void setPat_tel(String pat_tel) {
        this.pat_tel = pat_tel;
    }

    public String getKey_num() {
        return key_num;
    }

    public void setKey_num(String key_num) {
        this.key_num = key_num;
    }

    public String getPro_num() {
        return pro_num;
    }

    public void setPro_num(String pro_num) {
        this.pro_num = pro_num;
    }


}
