/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.web.utils;
 
import Vista.Web.Dto.WsMessageDTO;
import com.google.gson.Gson;


/**
 *
 * @author emello
 */
public class MessageConverter {
    
    public static String toMessage(WsMessageDTO msg){
        Gson gson = new Gson();
        String message = gson.toJson(msg);
        return message;
    }
}
