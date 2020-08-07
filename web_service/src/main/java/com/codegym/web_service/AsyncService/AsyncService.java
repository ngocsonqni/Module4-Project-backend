package com.codegym.web_service.AsyncService;

import com.codegym.dao.entity.Account;
import com.codegym.dao.entity.Employee;
import com.codegym.dao.entity.User;
import com.codegym.service.AccountService;
import com.codegym.service.EmployeeService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class AsyncService {
    @Autowired
    private AccountService accountService;
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    @Async
    public void deleteAccount(Account account) {
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountService.delete(account);
    }

    @Async
    public void sendEmailWithEmployee(Employee employee) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        String htmlMsg = "<html>"
                + "<meta charset='UTF-8'>"
                + "<body style='background:lightgray'>"
                + "<div style='width: 70%; height: auto;margin-left: 15%;background: white'>"
                + "<div>"
                + "<div>"
                + "<img width='80%' style='margin: 5% 10%;' src='https://www.upsieutoc.com/images/2020/07/22/logo9bd9eb6ca795c6dd.png'>"
                + "</div>"
                + "<div style='margin: 1% 20%'>"
                + "<h3 style='font-size: 30px;'>Xin chào " + employee.getName() + " !</h3>"
                + "<br>"
                + "<p style='font-size: 20px'>Thông tin tài khoản của bạn trên trang web CODEBAKERY vừa được thay đổi.</p>"
                + "<p style='font-size: 20px'>Vui lòng truy cập trang để biết thêm chi tiết.</p>"
                + "<a href='http://localhost:4200/'>"
                + "<button style='padding: 10px;border: none; background : rgb(238, 159, 31);border-radius: 15px;color: #581008; cursor: pointer'>"
                + "<h2>CODEBAKERY</h2>"
                + "</button>"
                + "</a>"
                + "</div>"
                + "</div>"
                + "<div style='background: rgb(238, 159, 31);text-align:center;padding:25px;font-size:20px;margin:10% 0'>"
                + "<p>©2020 Codebakery - Codegym Đà Nẵng - C0220G1</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
        message.setContent(htmlMsg, "text/html; charset=utf-8");
        helper.setTo(employee.getEmail());
        helper.setSubject("CodeBakery - Thay đổi thông tin tài khoản");
        this.emailSender.send(message);
    }

    @Async
    public void sendEmailWithUser(User user) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        String htmlMsg = "<html>"
                + "<meta charset='UTF-8'>"
                + "<body style='background:lightgray'>"
                + "<div style='width: 70%; height: auto;margin-left: 15%;background: white'>"
                + "<div>"
                + "<div>"
                + "<img width='80%' style='margin: 5% 10%;' src='https://www.upsieutoc.com/images/2020/07/22/logo9bd9eb6ca795c6dd.png'>"
                + "</div>"
                + "<div style='margin: 1% 20%'>"
                + "<h3 style='font-size: 30px;'>Xin chào " + user.getUserName() + " !</h3>"
                + "<br>"
                + "<p style='font-size: 20px'>Thông tin tài khoản của bạn trên trang web CODEBAKERY vừa được thay đổi.</p>"
                + "<p style='font-size: 20px'>Vui lòng truy cập trang để biết thêm chi tiết.</p>"
                + "<a href='http://localhost:4200/'>"
                + "<button style='padding: 10px;border: none; background : rgb(238, 159, 31);border-radius: 15px;color: #581008; cursor: pointer'>"
                + "<h2>CODEBAKERY</h2>"
                + "</button>"
                + "</a>"
                + "</div>"
                + "</div>"
                + "<div style='background: rgb(238, 159, 31);text-align:center;padding:25px;font-size:20px;margin:10% 0'>"
                + "<p>©2020 Codebakery - Codegym Đà Nẵng - C0220G1</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
        message.setContent(htmlMsg, "text/html; charset=utf-8");
        helper.setTo(user.getEmail());
        helper.setSubject("CodeBakery - Thay đổi thông tin tài khoản");
        this.emailSender.send(message);
    }

    @Async
    public void sendDeleteEmailWithEmployee(Employee employee) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        String htmlMsg = "<html>"
                + "<meta charset='UTF-8'>"
                + "<body style='background:lightgray'>"
                + "<div style='width: 70%; height: auto;margin-left: 15%;background: white'>"
                + "<div>"
                + "<div>"
                + "<img width='80%' style='margin: 5% 10%;' src='https://www.upsieutoc.com/images/2020/07/22/logo9bd9eb6ca795c6dd.png'>"
                + "</div>"
                + "<div style='margin: 1% 20%'>"
                + "<h3 style='font-size: 30px;'>Xin chào " + employee.getName() + " !</h3>"
                + "<br>"
                + "<p style='font-size: 20px'>Tài khoản " + employee.getAccount().getAccountName() + " của bạn trên trang web CODEBAKERY vừa bị xóa vì lí do: " + employee.getAccount().getReason() + " .</p>"
                + "<p style='font-size: 20px'>Vui lòng liên hệ trang để được hỗ trợ.</p>"
                + "<a href='http://localhost:4200/'>"
                + "<button style='padding: 10px;border: none; background : rgb(238, 159, 31);border-radius: 15px;color: #581008; cursor: pointer'>"
                + "<h2>CODEBAKERY</h2>"
                + "</button>"
                + "</a>"
                + "</div>"
                + "</div>"
                + "<div style='background: rgb(238, 159, 31);text-align:center;padding:25px;font-size:20px;margin:10% 0'>"
                + "<p>©2020 Codebakery - Codegym Đà Nẵng - C0220G1</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
        message.setContent(htmlMsg, "text/html; charset=utf-8");
        helper.setTo(employee.getEmail());
        helper.setSubject("CodeBakery - Xóa tài khoản");
        this.emailSender.send(message);
        Employee employeeDelete = employeeService.findByAccountId(employee.getAccount().getAccountId());
        employeeDelete.setAccount(null);
        employeeService.save(employeeDelete);
    }

    @Async
    public void sendDeleteEmailWithUser(User user) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        String htmlMsg = "<html>"
                + "<meta charset='UTF-8'>"
                + "<body style='background:lightgray'>"
                + "<div style='width: 70%; height: auto;margin-left: 15%;background: white'>"
                + "<div>"
                + "<div>"
                + "<img width='80%' style='margin: 5% 10%;' src='https://www.upsieutoc.com/images/2020/07/22/logo9bd9eb6ca795c6dd.png'>"
                + "</div>"
                + "<div style='margin: 1% 20%'>"
                + "<h3 style='font-size: 30px;'>Xin chào " + user.getUserName() + " !</h3>"
                + "<br>"
                + "<p style='font-size: 20px'>Tài khoản " + user.getAccount().getAccountName() + " của bạn trên trang web CODEBAKERY vừa bị xóa vì lí do: " + user.getAccount().getReason() + " .</p>"
                + "<p style='font-size: 20px'>Vui lòng liên hệ trang để được hỗ trợ.</p>"
                + "<a href='http://localhost:4200/'>"
                + "<button style='padding: 10px;border: none; background : rgb(238, 159, 31);border-radius: 15px;color: #581008; cursor: pointer'>"
                + "<h2>CODEBAKERY</h2>"
                + "</button>"
                + "</a>"
                + "</div>"
                + "</div>"
                + "<div style='background: rgb(238, 159, 31);text-align:center;padding:25px;font-size:20px;margin:10% 0'>"
                + "<p>©2020 Codebakery - Codegym Đà Nẵng - C0220G1</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
        message.setContent(htmlMsg, "text/html; charset=utf-8");
        helper.setTo(user.getEmail());
        helper.setSubject("CodeBakery - Xóa tài khoản");
        this.emailSender.send(message);
        User userDelete = userService.findUserByAccountId(user.getAccount().getAccountId());
        userDelete.setAccount(null);
        userService.save(userDelete);
    }
}
