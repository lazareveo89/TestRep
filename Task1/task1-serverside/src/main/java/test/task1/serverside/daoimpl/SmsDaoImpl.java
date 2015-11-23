/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.task1.serverside.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import test.task1.serverside.dao.SmsDao;
import test.task1.serverside.entity.SmsSettings;

/**
 *
 * @author Admin
 */
public class SmsDaoImpl implements SmsDao{

    @Autowired
    @Qualifier (value="jdbcTemplateAdm")
    private JdbcTemplate jdbcTemplate ;
    private final String sqlQuery = "INSERT INTO sms ("
            + "login,daysBeforeEvent,activateSms,IPv4,prt,pass) VALUES "
            + "(?,?,?,?,?,?)";
    
    @Override
    public void addSms(SmsSettings smsSettings) {
        getJdbcTemplate().update(sqlQuery, smsSettings.getLogin(), smsSettings.getDaysBeforeEvent(),
                smsSettings.getActivateSMS(), smsSettings.getServerIP(), smsSettings.getPort(), smsSettings.getPassword());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
}
