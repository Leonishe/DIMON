import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
* Created by pret on 10/11/13.
*/
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

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
