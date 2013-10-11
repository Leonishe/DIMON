import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author mutagen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File file = new File("In.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Soft.class);
            Unmarshaller um = jaxbContext.createUnmarshaller();
            Soft soft = (Soft) um.unmarshal(file);

            for(Company company:soft.getCompany()){
                System.out.println("Company = "+company.getName());
                Integer sys=0;
                Integer ed=0;
                for (Product product:company.getSystem()){
                    sys+=product.getPrice();
                }

                for (Product product:company.getEditor()){
                    ed+=product.getPrice();
                }
                System.out.println("Summ system = "+sys);
                System.out.println("Summ editor = "+ed);
                System.out.println("All summ = "+(ed+sys));
            }

            System.out.println(soft);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}