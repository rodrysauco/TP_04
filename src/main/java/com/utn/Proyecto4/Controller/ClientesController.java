package com.utn.Proyecto4.Controller;

import com.utn.Proyecto4.DAO.iDao;
import com.utn.Proyecto4.Models.Cliente;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@RestController
@RequestMapping("/cliente")
public class ClientesController {

    @Autowired
    private iDao daoCliente;

    private Cliente cliente;


    @RequestMapping(value = "/add")
    public String clienteAdd(@RequestHeader("User-Agent") String request){
        String resp = "Datos obtenidos";
        UserAgent userAgent = UserAgent.parseUserAgentString(request);
        String useragent = userAgent.toString();
        String[] agentes= useragent.split("-");
        //Dividimos el userAgent en So y Browser
        Cliente cliente = new Cliente();
        cliente.setSistemaOp(agentes[0]);
        cliente.setBrowser(agentes[1]);
        try{
            daoCliente.save(cliente);
        }catch(Exception a) {
            resp ="Error en la carga";
        }
        return resp;
    }

    @RequestMapping(value = "/getAll")
    public List<?> returnAllClientes(){
        List<?> rtn = daoCliente.findAll();
        return rtn;
    }

    @RequestMapping(value = "/getMostUsedBrowser")
    public List<?> mostUsedBrowser(){
        List<String> rtn = new ArrayList<>();
        List<Cliente> clientes = daoCliente.findAll();
        String resp = "Without Data";
        int i = 0;
        Map<String,Integer> browsers = new HashMap<>();
        for (Cliente a: clientes) {
            if (browsers.containsKey(a.getBrowser())) {
                browsers.put(a.getBrowser(), browsers.get(a.getBrowser()) + 1);
            } else {
                browsers.put(a.getBrowser(), 1);
            }
        }
        if(!browsers.isEmpty()){
            i = Collections.max(browsers.values());
            for(Map.Entry me : browsers.entrySet()){
                if((int)me.getValue() == i){
                    resp = "El navegador mas usado es "+me.getKey().toString()+", con "+me.getValue()+" veces.";
                    rtn.add(resp);
                }
            }
        }else {
            rtn.add(resp);
        }

        return rtn;
    }

    @RequestMapping("/getMostUsedOs")
    public List<?> mostUsedOSD(){
        List<String> rtn = new ArrayList<>();
        List<Cliente> clientes = daoCliente.findAll();
        Map<String,Integer> sistemaOP = new HashMap<>();
        String resp = "Without Data";
        int i = 0;
        for (Cliente a: clientes) {
            if (sistemaOP.containsKey(a.getSistemaOp())) {
                sistemaOP.put(a.getSistemaOp(), sistemaOP.get(a.getSistemaOp()) + 1);
            } else {
                sistemaOP.put(a.getSistemaOp(), 1);
            }
        }
        if(!sistemaOP.isEmpty()){
            i = Collections.max(sistemaOP.values());
            for(Map.Entry me : sistemaOP.entrySet()){
                if((int)me.getValue() == i){
                    resp = "El Sistema operativo mas usado es "+me.getKey().toString()+", con "+me.getValue()+" veces.";
                    rtn.add(resp);
                }
            }
        }else{
            rtn.add(resp);
        }
        return rtn;

    }

    @RequestMapping("/getComboBrowserOs")
    public List<?> comboBO(){
        String resp = "Without Data";
        List<Cliente> clientes = daoCliente.findAll();
        List<String> rtn = new ArrayList<>();
        List<Integer> i = new ArrayList<>();
        Integer maximo;
        Map<String,Map> externo = new HashMap<>();
        Map<String,Integer> interno;
        for(Cliente a : clientes){
            if(externo.containsKey(a.getSistemaOp())){  //Busca el So
                interno = externo.get(a.getSistemaOp());
                if (interno.containsKey(a.getBrowser())){   //Busca el browser
                    interno.put(a.getBrowser(),interno.get(a.getBrowser())+1);
                }else {
                    interno.put(a.getBrowser(), 1);
                }
            }else{  //Si no se encuentra cargado el SO
                interno = new HashMap<String,Integer>();
                interno.put(a.getBrowser(),1);
                externo.put(a.getSistemaOp(),interno);
            }
        }
        if (!externo.isEmpty()){
            for (Map.Entry map : externo.entrySet()){
                interno = (HashMap)map.getValue();
                i.add(Collections.max(interno.values()));
            }
            maximo = Collections.max(i);
            for (Map.Entry mapex : externo.entrySet()){
                interno = (HashMap)mapex.getValue();
                for (Map.Entry mine : interno.entrySet()){
                    if(maximo == mine.getValue()){
                        resp = "Lo que mas se uso fue "+mapex.getKey().toString()+" junto a "+mine.getKey().toString()+", " +
                                (int)maximo+" veces";
                        rtn.add(resp);
                    }
                }
            }
        }else {
            rtn.add(resp);
        }
        return rtn;
    }
}
