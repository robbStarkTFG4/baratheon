/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblPrestariosFacade;
import com.server.beans.staless.TblTipoprestariosFacade;
import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblTipoprestarios;
import com.util.TipoPrestarioDTO;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.naming.InitialContext;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author NORE
 */
@Named("reg")
@SessionScoped
public class RegisterPrestario implements Serializable {

    @Resource(lookup = "mail/mailProvider")
    private Session mailSession;

    @EJB
    TblTipoprestariosFacade tp;

    @EJB
    TblPrestariosFacade presi;

    List<TipoPrestarioDTO> types = null;
    TipoPrestarioDTO selectedPrestario = null;

    TblPrestarios pres = new TblPrestarios();

    @PostConstruct
    private void init() {
        types = tp.getTypes();
    }

    public List<TipoPrestarioDTO> getTypes() {
        return types;
    }

    public TipoPrestarioDTO getSelectedPrestario() {
        return selectedPrestario;
    }

    public void setSelectedPrestario(TipoPrestarioDTO selectedPrestario) {
        this.selectedPrestario = selectedPrestario;
    }

    public TblPrestarios getPres() {
        return pres;
    }

    public void setPres(TblPrestarios pres) {
        this.pres = pres;
    }

    public void transition() throws UnsupportedEncodingException, MessagingException {
        System.out.println("HOLA DESDE LA FORMA DE REGISTRO DE PRESTARIOS!!!!!!!!!!!!!");

        pres.setIdTipoprestarios(new TblTipoprestarios(selectedPrestario.getIdTipoprestarios()));
        
        if (presi.registerPrestario(pres)) {
            sendEmail(pres.getEmail(), "adsdas", "http://localhost:5478/alumnos/NewServlet?akkcveren=" + encode(pres.getUsuario()));
            System.out.println("CORREO DISQUE ENVIADO");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("se ha enviado un correo electronico con el link de activacion", "se ha enviado un correo electronico con el link de activacion"));
        }

        pres = null;
        pres = new TblPrestarios();

        selectedPrestario = null;
    }

    public void sendEmail(String senderId, String subject, String body) throws UnsupportedEncodingException, MessagingException {

        String myEmailId = "robbstarktfg@gmail.com";
        String myPassword = "marcoisaac";

        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(myEmailId, myPassword));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(myEmailId);
            email.setSubject("activacion cuenta");
            email.setMsg(body);
            email.addTo(senderId);
            email.setTLS(true);

            /* EmailAttachment attachment = new EmailAttachment();
             attachment.setPath("/Users/fahadparkar/Desktop/Fahim/tables.xlsx");
             attachment.setDisposition(EmailAttachment.ATTACHMENT);
             attachment.setDescription("Excel");
             attachment.setName("tables.xlsx");
             email.attach(attachment);*/
            email.send();
            System.out.println("Mail sent!");
        } catch (EmailException e) {
            System.out.println("Exception :: " + e);
        }

    }

    private String encode(String param2) {
        char[] array = param2.toCharArray();
        StringBuilder sb = new StringBuilder(20);
        //a=0, b=1,c=2,d=3,e=4,f=5,g=6,h=7, i=8,n=9
        for (char c : array) {
            if (c == '0') {
                sb.append("a");
            }

            if (c == '1') {
                sb.append("b");
            }
            if (c == '2') {
                sb.append("c");
            }
            if (c == '3') {
                sb.append("d");
            }
            if (c == '4') {
                sb.append("e");
            }
            if (c == '5') {
                sb.append("f");
            }
            if (c == '6') {
                sb.append("g");
            }
            if (c == '7') {
                sb.append("h");
            }
            if (c == '8') {
                sb.append("i");
            }
            if (c == '9') {
                sb.append("n");
            }

        }

        System.out.println("ENCODED STRRING: " + sb.toString());
        return sb.toString();
    }

}
