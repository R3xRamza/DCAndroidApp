package com.example.dowchemicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class EmailSender extends AppCompatActivity {
    public static void sendEmailDev(MainActivity activity, String recipientEmail, String subject, String messageBody) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Set the host SMTP server
                    String host = "smtp.gmail.com";

                    // Set the email sender's username and password
                    String username = "rexramza@gmail.com";
                    String password = "Mebanddottie1";

                    // Set the email recipient
                    String to = recipientEmail;

                    // Set the email properties
                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", host);
                    props.put("mail.smtp.port", "587");

                    // Create a session with the email sender's credentials
                    Session session = Session.getInstance(props,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                }
                            });

                    // Create the email message
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    message.setSubject(subject);
                    message.setText(messageBody);

                    // Send the email message
                    Transport.send(message);

                    // Show a success message to the user
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity, "Email sent successfully!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (MessagingException e) {
                    // Show an error message to the user
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity, "Failed to send email. Please try again later.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void sendEmail(MainActivity activity, String recipientEmail, String subject, String messageBody){

        Bundle savedIS = new Bundle();
        savedIS.putString("recipientEmail", recipientEmail);
        savedIS.putString("messageBody", messageBody);
        savedIS.putString("subject", subject);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {savedInstanceState.getString("recipientEmail")});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, savedInstanceState.getString("subject"));
        emailIntent.putExtra(Intent.EXTRA_TEXT, savedInstanceState.getString("messageBody"));

        Intent chooser = Intent.createChooser(emailIntent, "Send message");
        startActivity(chooser);

        finish();

    }

}


