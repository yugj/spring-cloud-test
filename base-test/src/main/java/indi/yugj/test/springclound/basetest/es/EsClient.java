package indi.yugj.test.springclound.basetest.es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yugj
 * @date 18/11/27 23:44.
 */
public class EsClient {

    @Test
    public void testConnection() throws UnknownHostException {
        getClient();
    }

    private Client getClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                //集群名称
                .put("cluster.name", "elasticsearch_yugj")
                        //自动嗅探
                .put("client.transport.sniff", true)
                .put("discovery.type", "zen")
                .put("discovery.zen.minimum_master_nodes", 1)
                .put("discovery.zen.ping_timeout", "500ms")
                .put("discovery.initial_state_timeout", "500ms")
                .build();
        Client client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        return client;
    }

    @Test
    public void addData() throws UnknownHostException {

        Client client = getClient();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "yugj");
        map.put("age", 27);
        map.put("interests", new String[]{"reading", "film"});
        map.put("about", "hell");

        IndexResponse response = client.prepareIndex("sop-1", "sop", UUID.randomUUID().toString())
                .setSource(map).get();

        System.out.println("rs=" + response.status().getStatus() + "！id=" + response.getId());
    }

}
