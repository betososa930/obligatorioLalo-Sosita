/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Web;

import Controlador.ControladorLogin;
import Controlador.Vistas.IVistaLogin;
import Modelo.Usuario;
import Vista.Web.Dto.DatosLoginDTO;
import Vista.Web.Dto.WsMessageDTO;
import com.google.gson.Gson;
import javax.websocket.Session;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import vista.web.utils.MessageConverter;
import vista.web.utils.WsSessionHandler;
import vista.web.utils.WsUtils;

/**
 *
 * @author Usuario
 */
@ServerEndpoint("/wslogin")
public class WsLogin implements IVistaLogin{

    private ControladorLogin controladorLogin;
    private Session session;
    private Gson gson;
    
    @OnOpen
    public void onOpen() {
        this.controladorLogin = new ControladorLogin(this);
        this.gson = new Gson();
        this.session = session;
        System.out.println("OnOpen");
    }

    @Override
    public void login(Usuario usuario) {
        System.out.println("Login");
        WsMessageDTO msgLogin = new WsMessageDTO(WsMessageDTO.TipoMensaje.TIPO_IR_MENU, usuario.getOid());
        String mensaje = MessageConverter.toMessage(msgLogin); 
        WsSessionHandler.setItem("usuario", usuario); 
        WsUtils.enviarMensajePorSocket(session, mensaje);
    }

    @Override
    public void error(String error) {
        WsMessageDTO msgLogin = new WsMessageDTO(WsMessageDTO.TipoMensaje.TIPO_ERROR, error);
        String mensaje = MessageConverter.toMessage(msgLogin);
        WsUtils.enviarMensajePorSocket(session, mensaje);
    }

    @OnError
    public void onError(Throwable t) {
        t.getStackTrace();
    }

    @OnClose
    public void onClose() {
    }

    @OnMessage
    public void onMessage(String mensaje) {
        System.out.println("onMessage");
        DatosLoginDTO datosLogin = gson.fromJson(mensaje, DatosLoginDTO.class);
        System.out.println(datosLogin.getPassword());
        System.out.println(datosLogin.getUsername());
        this.controladorLogin.login(datosLogin.getUsername(), datosLogin.getPassword());
    }
    
}
