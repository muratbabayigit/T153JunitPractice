package day01;

import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class P01_Notasyon {



    @Test @Disabled
    @Order(1)
    public void Berkay(){
        System.out.println("Berkay");
    }

    @Test
    @Order(3)
    public void Nihad(){
        System.out.println("Nihad");
    }
    @Test
    @Order(4)
    public void Yigit(){
        System.out.println("Yiğit");
    }

    @Test
    @Order(2)
    public void Sude(){
        System.out.println("Sude");
    }


}
