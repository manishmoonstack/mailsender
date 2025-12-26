package com.mn.co;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailsenderjavaApplicationTests {

    @Autowired
    private EmailSender emailSender;
	@Test
	void emailSendTest( ) {
        System.out.println("Sending Email");
        emailSender.sendEmail("adityasinghraj0405@gmail.com","this is from mail sender testing ","Hii Aditya we are from moonstack ");
	}

    @Test
    void  sendHtml()
    {   String htmlContent =
            "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "  <meta charset='UTF-8'>" +
                    "  <title>Email</title>" +
                    "</head>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f6f8; padding: 20px;'>" +

                    "  <table width='100%' cellpadding='0' cellspacing='0'>" +
                    "    <tr>" +
                    "      <td align='center'>" +

                    "        <table width='600' cellpadding='20' cellspacing='0' style='background-color: #ffffff; border-radius: 8px;'>" +

                    "          <tr>" +
                    "            <td style='text-align: center; background-color: #4CAF50; color: white;'>" +
                    "              <h2>Moonstack</h2>" +
                    "            </td>" +
                    "          </tr>" +

                    "          <tr>" +
                    "            <td>" +
                    "              <h3>Hello Aditya 👋</h3>" +
                    "              <p>We are happy to inform you that your email service is working successfully.</p>" +
                    "              <p>This is a <b>test HTML email</b> sent from <b>Spring Boot</b>.</p>" +
                    "              <p>If you have any questions, feel free to contact us.</p>" +
                    "              <br/>" +
                    "              <p>Regards,<br/><b>Moonstack Team</b></p>" +
                    "            </td>" +
                    "          </tr>" +

                    "          <tr>" +
                    "            <td style='text-align:center; font-size:12px; color:#777;'>" +
                    "              © 2025 Moonstack. All rights reserved." +
                    "            </td>" +
                    "          </tr>" +

                    "        </table>" +

                    "      </td>" +
                    "    </tr>" +
                    "  </table>" +

                    "</body>" +
                    "</html>";

        emailSender.sendEmailWithHtml("adityasinghraj0405@gmail.com","this is from mail sender testing ",htmlContent);
    }
}
