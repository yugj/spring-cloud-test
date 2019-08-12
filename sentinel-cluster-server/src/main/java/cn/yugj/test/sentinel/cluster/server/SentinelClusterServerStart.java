package cn.yugj.test.sentinel.cluster.server;

import com.alibaba.csp.sentinel.cluster.server.ClusterTokenServer;
import com.alibaba.csp.sentinel.cluster.server.SentinelDefaultTokenServer;
import com.alibaba.csp.sentinel.cluster.server.config.ClusterServerConfigManager;
import com.alibaba.csp.sentinel.cluster.server.config.ServerTransportConfig;

import java.util.Collections;

/**
 * @author yugj
 * @date 2019/8/12 下午4:36.
 */
public class SentinelClusterServerStart {

    public static void main(String[] args) throws Exception {

        // Not embedded mode by default (alone mode).
        ClusterTokenServer tokenServer = new SentinelDefaultTokenServer();

        // A sample for manually load config for cluster server.
        // It's recommended to use dynamic data source to cluster manage config and rules.
        // See the sample in DemoClusterServerInitFunc for detail.
        ClusterServerConfigManager.loadGlobalTransportConfig(new ServerTransportConfig()
                .setIdleSeconds(600)
                .setPort(9018));
        ClusterServerConfigManager.loadServerNamespaceSet(Collections.singleton("sentinel-cluster-server"));

        // Start the server.
        tokenServer.start();
    }


}
