import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class Application {

    //define mock port
    private static final int PORT = 9090;

    //define the address of mock server
    private static final String LOCALHOST = "localhost";

    //define mapping
    private static final String MOCK_DIR = "mock";
    /*
    MOCK_DIR 的值设置为 Mock ，作用是告知 Mock 服务接口的
    mapping 文件和 response 文件放在项目目录的 resources
    下面的 Mock folder 内
     */


    //start mock server
    public static void main(String[] args) {
        //config mock
        final WireMockConfiguration config = wireMockConfig()
                .port(PORT)
                .usingFilesUnderClasspath(MOCK_DIR);

        //start server
        final WireMockServer WireMockServer = new WireMockServer(config) ;
        WireMockServer.start();
        WireMock.configureFor(LOCALHOST,PORT);
    }
}
