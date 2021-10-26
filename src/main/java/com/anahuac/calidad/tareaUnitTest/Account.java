package com.anahuac.calidad.tareaUnitTest;

public class Account {
    int balance;
    int deposito;
    int zona;
    String holder;
    AlertListener alerts;

    public Account(String holder, int initialBalance,int initDeposito,int initzona, AlertListener alerts){
        this.holder = holder;
        this.balance = initialBalance;
        this.alerts = alerts;
        this.deposito = initDeposito;
        this.zona = initzona;
    }
    
    public int getBalance() {
        return this.balance;
    }
    public int getDeposito() {
        return this.deposito;
    }
    public int getZona() {
        return this.zona;
    }
    
    public String getHolder(){
        return this.holder;
    }
    
    
    
  

    void debit(int balance) {
        this.balance -= balance;
        if(this.balance < 100){
            this.alerts.sendAlert("your account balance is below 100");
        }
    }

    void credit(int balance) {
        this.balance += balance;
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }

}
