package com.codegym.web_service.email;

import com.codegym.dao.entity.Account;
import com.codegym.dao.entity.Employee;
import com.codegym.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmail {
    @Autowired
    public JavaMailSender emailSender;

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
        helper.setTo("hieu57130154@gmail.com");
        helper.setSubject("CodeBakery - Thay đổi thông tin tài khoản");
        this.emailSender.send(message);
    }

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
        helper.setTo("");
        helper.setSubject("CodeBakery - Thay đổi thông tin tài khoản");
        this.emailSender.send(message);
    }
}
