/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.task1.serverside.entity;

/**
 *
 * @author Admin
 */
public class SmsSettings {
    private String smsText; //bool
    private String daysBeforeEvent;
    private String activateSMS;
    private String serverIP;
    private String port;
    private String login;
    private String password;

    public String getSmsText() {
        return smsText;
    }

    public String getActivateSMS() {
        return activateSMS;
    }

    public String getDaysBeforeEvent() {
        return daysBeforeEvent;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setActivateSMS(String activateSMS) {
        this.activateSMS = activateSMS;
    }

    public void setDaysBeforeEvent(String daysBeforeEvent) {
        this.daysBeforeEvent = daysBeforeEvent;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }    

    @Override
    public String toString() {
        return "{"+"smsText:"+this.smsText+","+"daysBeforeEvent:"+this.daysBeforeEvent+","+
                "activateSMS:"+this.activateSMS+","+"serverIP:"+this.serverIP+","+
                "port:"+this.port+","+"login:"+this.login+","+"password:"+this.password+"}";
    }  
}