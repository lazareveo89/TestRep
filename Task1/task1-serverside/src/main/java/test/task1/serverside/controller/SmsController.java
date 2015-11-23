/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.task1.serverside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import test.task1.serverside.entity.SmsSettings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.task1.serverside.dao.SmsDao;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value="/putSms")
public class SmsController {
    
    @Autowired
    @Qualifier("smsDao")
    private SmsDao smsDao;
    
    @RequestMapping(value="/sms", method = RequestMethod.POST, headers = {"Accept=application/json"})
    public @ResponseBody SmsSettings putSms(@RequestBody SmsSettings smsSettings) {
        try{
            getSmsDao().addSms(smsSettings);
        } catch(DataAccessException e){
            return new SmsSettings();
        }
        return smsSettings;
    }

    public SmsDao getSmsDao() {
        return smsDao;
    }
    
}