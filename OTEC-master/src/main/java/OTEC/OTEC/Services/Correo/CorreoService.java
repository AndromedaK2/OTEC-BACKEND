package OTEC.OTEC.Services.Correo;

import OTEC.OTEC.Models.Categorias.Categoria;
import OTEC.OTEC.Services.Calificaciones.ICalificacionService;
import org.springframework.stereotype.Service;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class CorreoService implements ICorreoService {

    public void EnvioEmail(int idBoleta, int montoPagado, String detalle,String formaPago, String nombres, String email){
        final String username = "pagosoteclab@gmail.com";
        final String password = "cghv ttcr trpt xiby";
        String toEmail = email;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            message.setSubject("Pago realizado");
            String cuerpoCorreo = this.getCuerpoCorreo();
            cuerpoCorreo = cuerpoCorreo.replace("##nombre", nombres);
            cuerpoCorreo = cuerpoCorreo.replace("##numeroBoleta", Integer.toString(idBoleta));
            cuerpoCorreo = cuerpoCorreo.replace("##detalle", detalle);
            cuerpoCorreo = cuerpoCorreo.replace("##formaPago", formaPago);
            cuerpoCorreo = cuerpoCorreo.replace("##montoPago", Integer.toString(montoPagado));
            message.setContent(cuerpoCorreo, "text/html");

            Transport.send(message);

            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCuerpoCorreo(){
        return " <!DOCTYPE html>\n" +
                " <html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "    <head>\n" +
                "      <meta charset=\"UTF-8\">\n" +
                "      <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "      <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "      <title></title>\n" +
                "      <style>\n" +
                "        table, td, div, h1, p \n" +
                "      </style>\n" +
                "    </head>\n" +
                "    <body style=\"margin:0;padding:0;\">\n" +
                "      <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "        <tr>\n" +
                "          <td align=\"center\" style=\"padding:0;\">\n" +
                "            <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "              <tr>\n" +
                "                <td align=\"center\" style=\"background:#EA7600;\">\n" +
                "                  <img src=\"https://www.psicologiausach.cl/wp-content/uploads/2023/04/Usach-S1.png\" alt=\"\" width=\"300\" style=\"height:auto;display:block;\" />\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td style=\"padding:36px 30px 42px 30px;\">\n" +
                "                  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                    <tr>\n" +
                "                      <td style=\"padding:0 0 36px 0;color:#153643;\">\n" +
                "                        <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">Estimado (a) ##nombre</h1>\n" +
                "                        <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\"> Hemos recibido su pago</p>\n" +
                "                        <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif; text-align:center; \"><strong> Numero boleta: </strong> ##numeroBoleta</p>\n" +
                "                        <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif; text-align:center; \"><strong> Detalle:</strong> ##detalle</p>\n" +
                "                         <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif; text-align:center; \"><strong> Forma pago: </strong> ##formaPago</p>\n" +
                "                          <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif; text-align:center; \"><strong> Monto pagado: </strong> ##montoPago</p>\n" +
                "                      </td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                      <td style=\"padding:0;\">\n" +
                "                        <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                    </tr>\n" +
                "                  </table>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td style=\"padding:30px;background:#EA7600;\">\n" +
                "                  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;font-size:9px;font-family:Arial,sans-serif;\">\n" +
                "                    <tr>\n" +
                "                      <td style=\"padding:0;width:70%;\" align=\"left\">\n" +
                "                        <p style=\"margin:0;font-size:14px;line-height:20px;font-family:Arial,sans-serif;color:#ffffff;\"> La información recopilada es de carácter confidencial.<br/>\n" +
                "                        </p>\n" +
                "                      </td>\n" +
                "                      <td style=\"padding:0;width:50%;\" align=\"right\">\n" +
                "                        <table role=\"presentation\" style=\"border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                          <tr>\n" +
                "                            <td style=\"padding:0 0 0 10px;width:38px;\">\n" +
                "                              \n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                    </tr>\n" +
                "                  </table>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </body>\n" +
                "  </html>";
    }
}
