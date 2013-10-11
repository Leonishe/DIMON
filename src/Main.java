import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

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

    @XmlRootElement(name = "Soft")
    static class Soft {

        @XmlElement(name = "Company", required = true)
        private List<Company> company = new ArrayList<Company>();    //Получаем список компаний

        public List<Company> getCompany() {
            return this.company;
        }

        @Override
        public String toString() {
            return "Soft{" + "company=" + company + '}';
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static public class Company {

        @XmlAttribute
        protected String name;

        @XmlElementWrapper(name = "editor")
        @XmlElement(type = Product.class, name = "product")
        protected List<Product> system = new ArrayList();           //Получаем список продуктов в поле system
        @XmlElementWrapper(name = "system")
        @XmlElement(type = Product.class, name = "product")
        protected List<Product> editor = new ArrayList();           //Получаем список продуктов в поле editor

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Product> getSystem() {
            return this.system;
        }

        public List<Product> getEditor() {
            return this.editor;
        }

        @Override
        public String toString() {
            return "Company{" + "name=" + name + ", system=" + system + ", editor=" + editor + '}';
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Product {

        @XmlValue
        protected String value;    //Название софтины в поле ПРОДУКТ
        @XmlAttribute
        protected Integer price;      //Атрибут PRICE в поле Продукт
        @XmlAttribute
        protected Integer size;       //Атрибут SIZE в поле Продукт

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Product{" + "value=" + value + ", price=" + price + ", size=" + size + '}';
        }
    }
}