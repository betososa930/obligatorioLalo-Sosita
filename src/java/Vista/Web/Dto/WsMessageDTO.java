/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Web.Dto;

/**
 *
 * @author emello
 */
public class WsMessageDTO {

    
    private TipoMensaje tipo;
    private Object valor;

    
    public WsMessageDTO(TipoMensaje tipo, Object valor){
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public static enum TipoMensaje {
        TIPO_IR_MENU, TIPO_ERROR, TIPO_CARGAR_TIPOS, TIPO_CARGAR_CONTACTOS, TIPO_ACTUALIZAR_AGENDAS;
    };
 
  
    
    public TipoMensaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensaje tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object mensaje) {
        this.valor = mensaje;
    }
    
    
}
