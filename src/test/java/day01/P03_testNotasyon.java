package day01;

import org.junit.jupiter.api.*;

public class P03_testNotasyon {

    @BeforeAll
    public static void setup(){
        System.out.println("Test Süreci Başlatılıyor\n");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("test Süreci tamamlandı ...");
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("Sıradaki test çalıştırılacak\n");
    }
    @AfterEach
    public void afterTest(){
        System.out.println("Test Tamamlandı. Var ise sıradaki teste geçiliyor\n");
    }


    @Test
    public void test01(){
        System.out.println("Yiğit - QA Engineer\n");
    }

    @Test
    public void test02(){
        System.out.println("Nihad - QA Engineer\n");
    }

    @Test
    public void test03(){
        System.out.println("Yusuf - QA Engineer\n");
    }

}
