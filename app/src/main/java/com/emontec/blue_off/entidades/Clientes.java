package com.emontec.blue_off.entidades;

import java.io.Serializable;

/**
 * Created by CHENAO on 7/05/2017.
 */

public class Clientes implements Serializable {

    private String cardCode;
    private String cardFName;
    private String cardName;
    private String listNum;
    private String email;
    private String memo;


    public Clientes(String  cardCode, String cardFName, String cardName, String listNum, String email, String memo) {
        this.cardCode = cardCode;
        this.cardFName = cardFName;
        this.cardName = cardName;
        this.listNum = listNum;
        this.email = email;
        this.memo = memo;
    }

    public Clientes(){

    }

    public String getCardCode() {
        return cardCode;
    }
    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardFName() {
        return cardFName;
    }
    public void setCardFName(String cardFName) {
        this.cardFName = cardFName;
    }

    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getListNum() { return listNum; }
    public void setListNum(String listNum) { this.listNum = listNum; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMemo() { return memo;  }
    public void setMemo(String memo) { this.memo = memo; }
}
