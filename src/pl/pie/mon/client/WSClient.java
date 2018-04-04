package pl.pie.mon.client;

import pl.pie.mon.server.ServerInfo;
import pl.pie.mon.server.ServerInfoService;

public class WSClient {

    public static void main(String[] args) throws Exception {

        ServerInfoService sis = new ServerInfoService();
        ServerInfo si = sis.getServerInfoPort();
        System.out.println(si.getServerName());

    }

}
