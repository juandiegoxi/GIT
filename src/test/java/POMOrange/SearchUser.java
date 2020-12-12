package POMOrange;

import Excel.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class SearchUser {
    //Creacion del robot
    static WebDriver Aleja;
    //Declaracion variable leer y obtener campos
    static ReadExcelFile leerArchivo;
    //Ruta de enlace para encontrar el excel
    static String rutaArchivoDeExcel = "C:\\Users\\house\\Downloads\\Orange\\orage.xlsx";
    //Declaracion de variables para asignar el dato
    static String textoABuscar;


    //Xpath
    static By newUser = By.id("searchSystemUser_userName");
    static By role = By.id("searchSystemUser_userType");
    static By name = By.id("searchSystemUser_employeeName_empName");
    static By status = By.id("searchSystemUser_status");
    static By btonSearch = By.id("searchBtn");
    static By user = By.id("txtUsername");
    static By password = By.id("txtPassword");
    static By login = By.id("btnLogin");
    static By btonAdmin = By.xpath("//b[contains(text(),'Admin')]");


    //Metodo para abrir el navegador en la pagina Orange
    public static void abrirPagina() {
        //Abre el driver del navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\house\\Downloads\\Orange\\chromedriver.exe");
        //Declara el robor
        Aleja = new ChromeDriver();
        //Enlace que se copia al abrir el navegador
        Aleja.get("http://automationpractice.com/index.php");
        //Maximixa la pagina
        Aleja.manage().window().maximize();
    }

    //Metodo para ingresar el usuario
    public static void ingresarUser() throws InterruptedException, IOException {
        //Declara la varia que sea igual a archivo externo de excel
        leerArchivo = new ReadExcelFile();
        Aleja.findElement(user).click();
        textoABuscar = leerArchivo.getCellValue("Login",rutaArchivoDeExcel , 1, 0);
        Aleja.findElement(user).sendKeys(textoABuscar);
        Aleja.findElement(password).click();
        textoABuscar = leerArchivo.getCellValue("Login",rutaArchivoDeExcel , 1, 1);
        Aleja.findElement(password).sendKeys(textoABuscar);
        Aleja.findElement(login).sendKeys(Keys.ENTER);
        Aleja.findElement(btonAdmin).click();
    }

    //Metodo para creaun un usuario
    public static void buscaruser() throws InterruptedException, IOException {
        Aleja.findElement(newUser).click();
        textoABuscar = leerArchivo.getCellValue("SearchUser",rutaArchivoDeExcel , 1, 0);
        Aleja.findElement(newUser).sendKeys(textoABuscar);
        leerArchivo = new ReadExcelFile();
        Aleja.findElement(role).click();
        textoABuscar = leerArchivo.getCellValue("SearchUser",rutaArchivoDeExcel , 1, 1);
        Aleja.findElement(role).sendKeys(textoABuscar);
        List<WebElement> listOfElements = Aleja.findElements (By.xpath ("//div[contains(@id, 'rand')]"));
        listOfElements.get(0).click();
        Aleja.findElement(name).click();
        textoABuscar = leerArchivo.getCellValue("SearchUser",rutaArchivoDeExcel , 1, 2);
        Aleja.findElement(name).sendKeys(textoABuscar);
        leerArchivo = new ReadExcelFile();
        Aleja.findElement(status).click();
        textoABuscar = leerArchivo.getCellValue("SearchUser",rutaArchivoDeExcel , 1, 3);
        Aleja.findElement(status).sendKeys(textoABuscar);
        List<WebElement> listOfElements1 = Aleja.findElements (By.xpath ("//div[contains(@id, 'rand')]"));
        listOfElements1.get(0).click();
        Aleja.findElement(btonSearch).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    //Metodo para cerrar el navegador
    public static void cerrarNavegador() {
        //Cierre del navegador
        Aleja.close();
    }
}
