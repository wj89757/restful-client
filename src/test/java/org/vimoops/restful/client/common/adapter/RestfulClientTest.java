package org.vimoops.restful.client.common.adapter;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.vimoops.host.common.adapter.restful.RestfulClient;
import org.vimoops.host.common.adapter.restful.RestfulResult;
import org.vimoops.host.common.adapter.restful.WebTargetSource;
import org.vimoops.host.common.adapter.restful.context.RestfulInvocationContext;
import org.vimoops.host.common.adapter.restful.invocation.RestfulInvocationPrepare;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

@ContextConfiguration("classpath:restful-client-test.xml")
public class RestfulClientTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private RestfulClient<JSONObject> restfulClient;
    @Resource
    private WebTargetSource           webTargetSource;

    @Test
    public void testPost() {
        // restfulClient.setWebTargetSource(webTargetSource);
        RestfulResult<JSONObject> result = restfulClient.doPost(new RestfulInvocationPrepare() {

            public void prepareInvocation(RestfulInvocationContext context) {
                context.url("http://120.26.73.227:8081/api/parent/login")
                       .param("mobile", "18768103064")
                       .param("password", "123456");
            }
        });

        System.out.println(result.getData());
    }

    @Test
    public void testGet() {
        RestfulResult<JSONObject> result = restfulClient.doGet(new RestfulInvocationPrepare() {

            public void prepareInvocation(RestfulInvocationContext context) {
                context.url("http://120.26.73.227:8081/api/parent/detail/81")
                       .cookie("cookie",
                               "ODE6MDp0cnVlOnRydWU6SGUrL3ZUenZ2NzAwWHUrL3ZWTEd1d1plZU8rL3ZUZFY6TnpjeE1XWmhOakl3T1dVd05UQmtPRFpqTW1JeFl6TTRNRFl3T0RCak1HTT06dHJ1ZQ==")
                       .cookie("auth",
                               "ODE6MDp0cnVlOnRydWU6SGUrL3ZUenZ2NzAwWHUrL3ZWTEd1d1plZU8rL3ZUZFY6TnpjeE1XWmhOakl3T1dVd05UQmtPRFpqTW1JeFl6TTRNRFl3T0RCak1HTT06dHJ1ZQ==");
            }
        });

        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testPost2() {
        RestfulResult<JSONObject> result = restfulClient.doPost(new RestfulInvocationPrepare() {

            public void prepareInvocation(RestfulInvocationContext context) {
                context.url("http://120.26.73.227:8081/api/parent/add")
                       .param("name", "张三")
                       .param("mobile", "13756784567")
                       .param("password", "123456")
                       .param("address", "测试地址")
                       .param("vcode", "8888")
                       .param("grade_id", "1")
                       .param("longitude", "-1")
                       .param("latitude", "-1");
            }
        });

        System.out.println(result.getData());
    }

    @Test
    public void testGetVCode() {
        RestfulResult<JSONObject> result = restfulClient.doGet(new RestfulInvocationPrepare() {

            public void prepareInvocation(RestfulInvocationContext context) {
                context.url(
                        "http://120.26.73.227:8081/api/sms/1/register/getcode")
                       .param("mobile", "13756784567")
                       .header("user-agent", "jiayouxueba");
            }
        });
        
        System.out.println(result.getData());
    }

    @Test
    public void test_one() {
        RestfulResult<JSONObject> result = restfulClient.doPost(new RestfulInvocationPrepare() {

            public void prepareInvocation(RestfulInvocationContext context) {
                context.url("https://api.baidu.com/json/sms/service/KRService/getKRCustom")
                        .header("opUsername", "<上**邻>")
                        .header("opPassword", "<6**D>")
                        .header("tgUsername", "<上**邻>")
                        .header("tgPassword", "<6**D>")
                        .header("tgSubname", "<上**邻>")
                        .header("bceUser", "<d**f>")
                        .param("id","3386777888")
                        .param("idType","5");
            }
        });
        System.out.println(new Date());
        System.out.println(System.currentTimeMillis());
        System.out.println(result.getData());
    }
}
