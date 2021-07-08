package cn.wangsy;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangsy on 2021/7/7
 */
public class ApplicationTest2 {




    @DisplayName("测试1")
    @Test
    public void test01(){
        System.out.println("======== test01 ======");
    }


    @DisplayName("测试2")
    @Test
    public void test02(){
        System.out.println("======== test02 ======");
        Assertions.assertEquals(5, 2 + 3);

        Assertions.assertAll(() -> {
                                    Assertions.assertEquals(2, 2);
                                    Assertions.assertEquals(3, 4);
        });
    }

    @Disabled
    @DisplayName("测试3")
    @Test
    public void test03(){
        System.out.println("======== test03 ======");
    }


    @DisplayName("测试4")
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void test04() throws Exception{
        Thread.sleep(300);
        System.out.println("======== test04 ======");
    }


    @DisplayName("测试5=前置条件")
    @Test
    public void test05() throws Exception{
        System.out.println("======== test05 ======");
        Assumptions.assumeTrue(true);
        System.out.println("============");
    }

    @DisplayName("测试6")
    @ParameterizedTest
    @ValueSource(strings = {"11", "22"})
    public void test06(String param) throws Exception{
        System.out.println("======== test06 ======" + param);
    }


    @BeforeEach
    void testBeforeEach(){
        System.out.println("start to test");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("end to test");
    }


    @BeforeAll
    static void testBeforeAll(){
        System.out.println("start to all test");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("end to all test");
    }
}
