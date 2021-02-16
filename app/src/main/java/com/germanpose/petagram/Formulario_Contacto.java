package com.germanpose.petagram;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Formulario_Contacto extends AppCompatActivity {

    TextInputEditText edit_nombre;
    TextInputEditText edit_mail;
    TextInputEditText edit_mensaje;
    Button btn_enviar;

    String sEmail, sPassword;

    Session session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__contacto);

        edit_nombre = findViewById(R.id.TIEnombre);
        edit_mail = findViewById(R.id.TIEemail);
        edit_mensaje = findViewById(R.id.TIEmensaje);
        btn_enviar = findViewById(R.id.btn_enviarEmail);

        sEmail = "ejemplo@gmail.com";
        sPassword = "contraseña";

        btn_enviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

                try {

                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(sEmail, sPassword);
                        }
                    });

                    if (session!=null) {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(edit_mail.getText().toString().trim()));
                        message.setSubject(edit_nombre.getText().toString());
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sEmail.trim()));
                        message.setContent(edit_mensaje.getText().toString(), "text/html; charset=utf-8");

                        new SendMail().execute(message);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }




            }
        });


    }

    private class SendMail extends AsyncTask<Message, String, String>{

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(Formulario_Contacto.this,
                    "Espere por favor", "Enviando Mail...",
                    true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {

            try {
                Transport.send(messages[0]);
                return "Hecho";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if(s.equals("Hecho")){

                AlertDialog.Builder builder = new AlertDialog.Builder(Formulario_Contacto.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Hecho</font>"));
                builder.setMessage("Mail enviado con exito");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        edit_mail.setText("");
                        edit_nombre.setText("");
                        edit_mensaje.setText("");
                    }
                });

                builder.show();

            } else {
                Toast.makeText(getApplicationContext(), "Algo salió mal", Toast.LENGTH_LONG).show();
            }
        }
    }

}